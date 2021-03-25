package com.company.problem2;

import java.util.Scanner;

public class StringConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String oldString = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();

        MyQueue myQueue = new MyQueue();

        int[] letterCount = new int[26];
        int length = oldString.length();


        for(int i = 0; i < length; i++)
        {
            char ch = oldString.charAt(i);

            letterCount[ch - 'a']++;

            if(letterCount[ch - 'a'] == 1)
                myQueue.enQueue(ch);

            while(!myQueue.isEmpty() && letterCount[myQueue.peek() - 'a'] > 1)
                myQueue.deQueue();

            if(myQueue.isEmpty())
                stringBuilder.append('#');
            else
                stringBuilder.append(myQueue.peek());
        }

        System.out.println(stringBuilder);
    }
}
