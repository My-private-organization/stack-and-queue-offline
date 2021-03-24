package com.company.problem1;

import java.util.Scanner;

public class StackProblem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputExpression = scanner.nextLine();

        inputExpression = inputExpression.replaceAll(" ", "");

        try
        {
            MakeMathematicalExpressionFromString makeMathematicalExpressionFromString =
                    new MakeMathematicalExpressionFromString(inputExpression);

            System.out.println("Valid expression, Computed value: "+
                    makeMathematicalExpressionFromString.getValueOfExpression());
        }catch (Exception e)
        {
            System.out.println("Not valid.");
        }
    }
}
