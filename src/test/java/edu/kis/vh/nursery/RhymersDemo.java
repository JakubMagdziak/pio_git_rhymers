package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();

        final int NUMBER_OF_RHYMERS = 3;
        final int NUMBER_OF_ELEMENTS = 15;
        final int BOUND = 20;
        final int HANOI_RHYMER = 3;
        
        DefaultCountingOutRhymer[] rhymers = { factory.GetStandardRhymer(), factory.GetFalseRhymer(),
                factory.GetFIFORhymer(), factory.GetHanoiRhymer()};
        
        for (int i = 1; i < NUMBER_OF_ELEMENTS; i++)
            for (int j = 0; j < NUMBER_OF_RHYMERS; j++)
                rhymers[j].countIn(i);
        
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < NUMBER_OF_ELEMENTS; i++)
            rhymers[HANOI_RHYMER].countIn(rn.nextInt(BOUND));
        
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }
        
        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[HANOI_RHYMER]).reportRejected());
        
    }
    
}