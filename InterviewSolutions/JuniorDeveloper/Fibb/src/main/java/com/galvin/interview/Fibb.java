package com.galvin.interview;

/**
 * Write a function that returns the first 100 Fibonacci numbers.
 * 
 * Fibonacci is a sequence of integers. By definition, the first two Fibonacci
 * numbers are 0 and 1. Every subsequent Fibonacci number is the sum of the 
 * previous two.
 * 
 * For example:
 * 
 * Fibonacci 1:         0
 * Fibonacci 2:         1
 * Fibonacci 3: (0+1) = 1
 * Fibonacci 4: (1+1) = 2
 * Fibonacci 5: (2+1) = 3
 * Fibonacci 6: (2+3) = 5
 * Fibonacci 7: (3+5) = 8
 */
public class Fibb
{
    public static final int FIBB_COUNT = 100;
    public int[] fibb() {
        int[] result = new int[ FIBB_COUNT ];
        
        result[0] = 0;
        result[1] = 1;
        for( int i = 2; i < FIBB_COUNT; i++ ){
            result[i] = result[i-1] + result[i-2];
        }
        
        return result;
    }
}
