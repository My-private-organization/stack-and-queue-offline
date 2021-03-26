package com.company;

public class MakeMathematicalExpressionFromString {

    private final MyStack<Integer> myIntegerStack;

    private final char[] validOperators = new char[]{'+', '-', '*', '/'};

    public MakeMathematicalExpressionFromString(String expression) throws Exception {

        this.myIntegerStack = new MyStack<>();
        MyStack<Character> operatorStack = new MyStack<>();

        boolean isOperatorUnary = true;

        for (int i = 0; i < expression.length(); i++)
        {
            if (expression.charAt(i) == '(')
            {
                operatorStack.push('(');
                isOperatorUnary = true;
            }
            else if (expression.charAt(i) == ')')
            {
                while (operatorStack.peek() != '(')
                {
                    char ch = operatorStack.pop();

                    if (ch =='#')
                    {
                        int top = myIntegerStack.pop();
                        myIntegerStack.push(-top);
                    }

                    else
                    {
                        int rightOperand = myIntegerStack.pop();
                        int leftOperand = myIntegerStack.pop();

                        switch (ch) {
                            case '+' -> myIntegerStack.push(leftOperand + rightOperand);
                            case '-' -> myIntegerStack.push(leftOperand - rightOperand);
                            case '*' -> myIntegerStack.push(leftOperand * rightOperand);
                            case '/' -> myIntegerStack.push(leftOperand / rightOperand);
                        }
                    }
                }

                operatorStack.pop();

                isOperatorUnary = false;
            }

            else if (expression.charAt(i) == validOperators[0] || expression.charAt(i) == validOperators[1] ||
                    expression.charAt(i) == validOperators[2] || expression.charAt(i) == validOperators[3])
            {
                char currentOperator = expression.charAt(i);

                if (isOperatorUnary && currentOperator == '-')
                    currentOperator = '#';

                while (!operatorStack.isEmpty() &&
                        (operatorPriorityCheck(operatorStack.peek()) >= operatorPriorityCheck(currentOperator)))
                {
                    char ch = operatorStack.pop();

                    if (ch =='#')
                    {
                        int top = myIntegerStack.pop();
                        myIntegerStack.push(-top);
                    }
                    else
                    {
                        int rightOperand = myIntegerStack.pop();
                        int leftOperand = myIntegerStack.pop();

                        switch (ch) {
                            case '+' -> myIntegerStack.push(leftOperand + rightOperand);
                            case '-' -> myIntegerStack.push(leftOperand - rightOperand);
                            case '*' -> myIntegerStack.push(leftOperand * rightOperand);
                            case '/' -> myIntegerStack.push(leftOperand / rightOperand);
                        }
                    }
                }

                operatorStack.push(currentOperator);

                isOperatorUnary = true;
            }
            else
            {
                int number = 0;

                while (i < expression.length() && Character.isLetterOrDigit(expression.charAt(i)))
                    number = number * 10 + expression.charAt(i++) - '0';

                i--;

                myIntegerStack.push(number);

                isOperatorUnary = false;
            }
        }

        while (!operatorStack.isEmpty())
        {
            char ch = operatorStack.pop();

            if (ch =='#')
            {
                int top = myIntegerStack.pop();
                myIntegerStack.push(-top);
            }

            else
            {
                int rightOperand = myIntegerStack.pop();
                int leftOperand = myIntegerStack.pop();

                switch (ch) {
                    case '+' -> myIntegerStack.push(leftOperand + rightOperand);
                    case '-' -> myIntegerStack.push(leftOperand - rightOperand);
                    case '*' -> myIntegerStack.push(leftOperand * rightOperand);
                    case '/' -> myIntegerStack.push(leftOperand / rightOperand);
                }
            }
        }
    }

    private int operatorPriorityCheck(char operator)
    {
        if(operator == '#')
            return OperatorPriority.Top_PRIORITY.getPriority();
        else if(operator == validOperators[2] || operator == validOperators[3])
            return OperatorPriority.MIDDLE_PRIORITY.getPriority();
        else if(operator == validOperators[0] || operator == validOperators[1])
            return OperatorPriority.LOWEST_PRIORITY.getPriority();
        else
            return OperatorPriority.DEFAULT_PRIORITY.getPriority();
    }

    public int getValueOfExpression() throws Exception {
        return myIntegerStack.pop();
    }
}
