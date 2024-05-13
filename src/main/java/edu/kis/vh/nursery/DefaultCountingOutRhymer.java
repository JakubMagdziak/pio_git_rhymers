package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int EMPTY = -1;
    private static final int SIZE = 12;

    private static final int IF_EMPTY = -1;

    private final int[] numbers = new int[SIZE];

    public int total = EMPTY;

    protected void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    protected boolean callCheck() {
        return total == EMPTY;
    }

    protected boolean isFull() {
        return total == SIZE - 1;
    }

    protected int peekaboo() {
        if (callCheck())
            return IF_EMPTY;
        return numbers[total];
    }

    protected int countOut() {
        if (callCheck())
            return IF_EMPTY;
        return numbers[total--];
    }

}
