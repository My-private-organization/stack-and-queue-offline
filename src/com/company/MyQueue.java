package com.company;

import java.util.LinkedList;

public class MyQueue{

    private final LinkedList<Character> queueElements;

    public MyQueue() {
        this.queueElements = new LinkedList<>();
    }

    public void enQueue(Character ch)
    {
        queueElements.add(ch);
    }

    public Character deQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("Queue is empty");
        }

        Character temp = queueElements.get(0);

        queueElements.remove(0);

        return temp;
    }

    public Character peek()
    {
        if(isEmpty())
        {
            throw new RuntimeException("No elements in the queue");
        }

        return queueElements.get(0);
    }

    public int size()
    {
        return queueElements.size();
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }
}
