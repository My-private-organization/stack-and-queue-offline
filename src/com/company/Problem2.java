package com.company;

import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String oldString = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();

        MyQueue myQueue = new MyQueue();

        int[] letterCount = new int[26];
        int length = oldString.length();


        for(int i = 0; i < length; i++)
        {
            int position = oldString.charAt(i) - 97;

            letterCount[position] = letterCount[position] + 1;

            if(letterCount[position] == 1)
                myQueue.enQueue(oldString.charAt(i));

            while(!myQueue.isEmpty() && letterCount[myQueue.peek() - 97] > 1)
                myQueue.deQueue();

            if(myQueue.isEmpty())
                stringBuilder.append('#');
            else
                stringBuilder.append(myQueue.peek());
        }

        System.out.println(stringBuilder);
    }
}
