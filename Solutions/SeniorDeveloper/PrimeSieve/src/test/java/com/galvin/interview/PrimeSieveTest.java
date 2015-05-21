package com.galvin.interview;

import org.junit.Assert;
import org.junit.Test;

public class PrimeSieveTest
{
    @Test
    public void testPrimes() throws Exception{
        int[] expected = findPrimes( 100 );
        int stop = expected[ expected.length - 1 ];
        stop++;
        
        PrimeSieve sieve = new PrimeSieve();
        int[] result = sieve.findPrimes( stop );
        
        Assert.assertArrayEquals( "Bad list of primes", expected, result );
    }
    
    private int[] findPrimes( int count ){
        int[] result = new int[ count ];
        
        int index = 0;
        int nextPrime = 2;
        while( index < count ){
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
