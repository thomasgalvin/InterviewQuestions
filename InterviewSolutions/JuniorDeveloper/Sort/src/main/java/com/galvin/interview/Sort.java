package com.galvin.interview;

/**
 * Sorting is one of the fundamental tasks in software engineering.
 * 
 * In this test, all you have to do is implement a method that copies and sorts 
 * an array of integers. 
 * 
 * You can choose whatever algorithm you want: it can be Bubble Sort, Merge
 * Sort, Quick Sort, or even Bogosort if you feel like burning CPU cycles.
 * 
 * All that matters is that the `sort( int[] target )` method returns the
 * expected output.
 */
public class Sort
{
    public int[] sort( int[] target ){
        int[] result = new int[ target.length ];
        System.arraycopy( target, 0, result, 0, target.length );
        
        boolean swap = true;
        int end = result.length - 1;
        while( swap ){
            swap = false;
            for( int i = 0; i < end; i++ ){
                if( result[i] > result[i+1] ){
                    int tmp = result[i];
                    result[i] = result[i+1];
                    result[i+1] = tmp;
                    swap = true;
                }
            }
        }
        
        return result;
    }
}
