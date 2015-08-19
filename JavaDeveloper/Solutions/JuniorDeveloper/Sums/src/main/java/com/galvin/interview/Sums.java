package com.galvin.interview;

/**
 * This program calculates the sum of the numbers in an array, but provides
 * three different methods of doing so; the first uses a for-loop, the second
 * a while-loop, and the third uses recursion.
 * 
 * Implement all three methods.
 */
public class Sums
{
    public double forLoopSum( double[] numbers ) {
        double result = 0;
        
        for( double number : numbers ){
            result += number;
        }
        
        return result;
    }
    
    public double whileLoopSum( double[] numbers ) {
        double result = 0;
        
        int index = 0;
        while( index < numbers.length ){
            result += numbers[index];
            index++;
        }
        
        return result;
    }
    
    public double recursiveSum( double[] numbers ) {
        return recursiveSum( numbers, 0 );
    }
    
    private double recursiveSum( double[] numbers, int index ) {
        double result = 0;
        
        if( index < numbers.length ){
            result += numbers[index];
            index++;
            result += recursiveSum( numbers, index );
        }
        
        return result;
    }
}
