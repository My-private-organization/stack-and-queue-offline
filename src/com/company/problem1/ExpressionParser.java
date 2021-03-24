package com.company.problem1;

public class ExpressionParser {

    private final MyStack<Integer> myIntegerStack;
    private final MyStack<Character> operatorStack;

    public ExpressionParser() {
        this.myIntegerStack = new MyStack<>();
        this.operatorStack = new MyStack<>();
    }

    private boolean spaceRemover(char ch)
    {
        return ch == ' ';
    }

    private boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private boolean isUnaryMinusChecker(char ch)
    {
        return ch == '-';
    }

    private int priority(char operator)
    {
        return switch (operator) {
            case '#' -> 3;
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    private void processOperator(char op)
    {
        if (op =='#')
        {
            int top = myIntegerStack.pop();
            myIntegerStack.push(-top);
        }

        else
        {
            int rightOperand = myIntegerStack.pop();

            int leftOperand = myIntegerStack.pop();

            switch (op) {
                case '+' -> myIntegerStack.push(leftOperand + rightOperand);
                case '-' -> myIntegerStack.push(leftOperand - rightOperand);
                case '*' -> myIntegerStack.push(leftOperand * rightOperand);
                case '/' -> myIntegerStack.push(leftOperand / rightOperand);
            }
        }
    }

    public int evaluate(String expression)
    {
        boolean unaryChecker = true;

        for (int i = 0; i < expression.length(); i++)
        {

            if (spaceRemover(expression.charAt(i)))
                continue;

            if (expression.charAt(i) == '(')
            {
                operatorStack.push('(');
                unaryChecker = true;
            }
            else if (expression.charAt(i) == ')')
            {
                while (operatorStack.peek() != '(')
                {
                    processOperator(operatorStack.pop());
                }

                operatorStack.pop();

                unaryChecker = false;
            }

            else if (isOperator(expression.charAt(i)))
            {
                char currentOperator = expression.charAt(i);

                if (unaryChecker && isUnaryMinusChecker(currentOperator))
                    currentOperator = '#';

                while (!operatorStack.isEmpty() &&
                        (priority(operatorStack.peek()) >= priority(currentOperator)))
                {
                    processOperator(operatorStack.pop());
                }

                operatorStack.push(currentOperator);

                unaryChecker = true;
            }
            else
            {
                int number = 0;

                while (i < expression.length() && Character.isLetterOrDigit(expression.charAt(i)))
                    number = number * 10 + expression.charAt(i++) - '0';

                --i;

                myIntegerStack.push(number);

                unaryChecker = false;
            }
        }

        while (!operatorStack.isEmpty())
        {
            processOperator(operatorStack.pop());
        }

        return myIntegerStack.peek();
    }
}
