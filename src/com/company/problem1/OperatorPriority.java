package com.company.problem1;

public enum OperatorPriority {

    Top_PRIORITY(15),
    MIDDLE_PRIORITY(10),
    LOWEST_PRIORITY(5),
    DEFAULT_PRIORITY(-1);

    private final int priority;

    OperatorPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
