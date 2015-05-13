package com.galvin.interview;

/**
 * The goal of this test is to take two arrays and merge them into one, 
 * alternating elements from each list.
 * 
 * For example, if you have an array [ 1, 2, 3 ] and another [ "a", "b", "c" ],
 * the merge method would return [ 1, "a", 2, "b", 3, "c" ].
 * 
 * You can assume that the arrays are the same size.
 */
public class ArrayMerge
{
    public Object[] merge( Object[] foo, Object[] bar ) {
        Object[] result = new Object[ foo.length + bar.length ];
        
        int index = 0;
        int fooIndex = 0;
        int barIndex = 0;
        while( index < result.length ){
            if( fooIndex < foo.length ){
                result[index] = foo[fooIndex];
                index++;
                fooIndex++;
            }
            
            if( barIndex < bar.length ){
                result[index] = bar[barIndex];
                index++;
                barIndex++;
            }
        }
        
        return result;
    }
}
