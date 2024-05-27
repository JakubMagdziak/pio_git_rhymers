package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    public static final int NUMBER_OF_RHYMERS = 3;
    public static final int NUMBER_OF_ELEMENTS = 15;
    public static final int BOUND = 20;
    public static final int HANOI_RHYMER = 3;
    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();


        testRhymers(factory);

    }

    private static void testRhymers(RhymersFactory factory) {
        DefaultCountingOutRhymer[] rhymers = { factory.GetStandardRhymer(), factory.GetFalseRhymer(),
                factory.GetFIFORhymer(), factory.GetHanoiRhymer()};

        for (int i = 1; i < NUMBER_OF_ELEMENTS; i++)
            for (int j = 0; j < NUMBER_OF_RHYMERS; j++)
                rhymers[j].countIn(i);

        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < NUMBER_OF_ELEMENTS; i++)
            rhymers[HANOI_RHYMER].countIn(rn.nextInt(BOUND));

        for (DefaultCountingOutRhymer rhymer : rhymers) {
            while (!rhymer.callCheck())
                System.out.print(rhymer.countOut() + "  ");
            System.out.println();
        }

        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[HANOI_RHYMER]).reportRejected());
    }

}