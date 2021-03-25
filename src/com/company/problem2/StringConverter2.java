package com.company.problem2;

import java.util.Scanner;

public class StringConverter2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String oldString = scanner.nextLine();

        MyQueue myQueue = new MyQueue();

        for(Character ch : oldString.toCharArray())
        {
            myQueue.enQueue(ch);
        }

        for(int i=0; i< myQueue.size(); i++)
        {

        }

    }
}
