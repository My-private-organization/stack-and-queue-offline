package com.company.problem1;

import java.util.Scanner;

public class StackProblem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputExpression = scanner.nextLine();

        ExpressionParser expressionParser = new ExpressionParser();

        try
        {
            System.out.println("Valid expression, Computed value: "+expressionParser.evaluate(inputExpression));
        }catch (Exception e)
        {
            System.out.println("Not valid.");
        }
    }
}
