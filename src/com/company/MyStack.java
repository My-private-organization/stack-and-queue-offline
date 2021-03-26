package com.company;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

    private final List<T> myArrayList;

    public MyStack() {
        this.myArrayList = new ArrayList<>();

    }

    public void push(T element)
    {
        myArrayList.add(element);
    }

    public T pop() throws Exception {
        if(myArrayList.isEmpty())
        {
            throw new Exception("Stack is empty");
        }

        T lastElement = myArrayList.get(size() - 1);
        myArrayList.remove(size() - 1);
        return lastElement;
    }

    public T peek()
    {
        return myArrayList.get(size() - 1);
    }

    public int size()
    {
        return myArrayList.size();
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }
}
