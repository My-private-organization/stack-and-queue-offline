package com.company.problem2;

import java.util.Scanner;

public class StringConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String oldString = scanner.nextLine();

        MyQueue myQueue = new MyQueue();

        int[] letterCount = new int[26];
        int length = oldString.length();

        char[] ans = new char[length];

        for(int i = 0; i < length; i++)
        {
            char c = oldString.charAt(i);

            letterCount[c - 'a']++;

            if(letterCount[c - 'a'] == 1)
                myQueue.enQueue(c);

            while(!myQueue.isEmpty() && letterCount[myQueue.peek() - 'a'] > 1)
                myQueue.deQueue();

            if(myQueue.isEmpty())
                ans[i] = '#';
            else
                ans[i] = myQueue.peek();
        }

        System.out.println(ans);
    }
}
