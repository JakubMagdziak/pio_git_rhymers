package edu.kis.vh.nursery;

/**
 * The HanoiRhymer class extends DefaultCountingOutRhymer to implement a specific counting mechanism
 * used in the Tower of Hanoi game. It overrides the countIn method to reject numbers that do not
 * follow the Tower of Hanoi rules, specifically numbers that are larger than the current top number
 * in the stack.
 */
public class HanoiRhymer extends DefaultCountingOutRhymer {

    /**
     * The total number of rejected numbers.
     */
    int totalRejected = 0;

    /**
     * Reports the total number of rejected numbers.
     *
     * @return the total number of rejected numbers
     */
    protected int reportRejected() {
        return totalRejected;
    }

    /**
     * Overrides the countIn method to add a number to the stack if it is less than or equal
     * to the current top number. If the number is greater than the current top number, it increments
     * the totalRejected counter.
     *
     * @param in the number to be added to the stack
     */
    @Override
    protected void countIn(int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }
}
