package com.galvin.interview;

/**
 * This class finds the first 100 prime numbers.
 * 
 * A prime number is a number evenly divisible only by 1 and itself. 
 * 
 * By definition, neither 0 nor 1 are prime.
 * 
 * For example, 7 is prime because it can only be evenly divided by 1 and 7, 
 * but 33 is not prime, because it can be evenly divided by 3.
 */
public class FindPrimes
{
    public static final int PRIME_COUNT = 100;
    
    public int[] findPrimes(){
        int[] result = new int[ PRIME_COUNT ];
        
        int index = 0;
        int nextPrime = 2;
        while( index < PRIME_COUNT ){
            if( isPrime( nextPrime ) ){
                result[index] = nextPrime;
                index++;
            }
            nextPrime++;
        }
        
        return result;
    }
    
    private boolean isPrime( int value ){
        for( int i = 2; i <= value / 2; i++ ){
            if( value % i == 0 ){
                return false;
            }
        }
        return true;
    }
}
