package com.galvin.interview;

/**
 * This class reverses a String.
 * 
 * For example:
 * Input:  "Hello, world!"
 * Result: "!dlrow ,olleH"
 */
public class StringReverse
{
    public String reverse( String input ){
        StringBuilder result = new StringBuilder();
        for( int i = input.length() - 1; i >=0; i-- ){
            result.append( input.charAt( i) );
        }
        return result.toString();
    }
}
