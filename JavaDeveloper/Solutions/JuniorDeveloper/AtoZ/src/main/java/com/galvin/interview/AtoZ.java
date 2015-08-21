package com.galvin.interview;

/**
 * This class will tell you if a string starts with a letter between A and Z.
 * 
 * There are two methods here, one which only returns true if the string starts
 * with an uppercase letter, and the other, which returns true regardless
 * of case.
 * 
 * Implement both methods.
 * 
 * You may assume that the input will not be null.
 */
public class AtoZ
{
    private static final String CASE_PATTERN = "^[A-Z].*";
    private static final String CASELESS_PATTERN = "^[a-zA-Z].*";
    
    /**
     * Returns true if and only if target starts with an uppercase letter from 
     *     A to Z.
     * @param target the string to test
     * @return if the string starts with an uppercase letter A-Z
     */
    public boolean match(String target ) {
        return regex( target );
        //return charMath( target );
    }
    
    private boolean regex( String target ){
        return target.matches( CASE_PATTERN );
    }
    
    private boolean charMath( String target ){
        char firstChar = target.charAt( 0 );
        return firstChar >= 'A' && firstChar <= 'Z';
    }
    
    /**
     * Returns true if and only if target starts with a letter from A to Z, 
     *     ignoring case.
     * @param target the string to test
     * @return if the string starts with a letter A-Z, regardless of case
     */
    public boolean matchIgnoreCase(String target ) {
        return regexIgnoreCase( target );
        //return charMathIgnoreCase( target );
    }
    
    private boolean regexIgnoreCase( String target ){
        return target.matches( CASELESS_PATTERN );
    }
    
    private boolean charMathIgnoreCase( String target ){
        char firstChar = target.charAt( 0 );
        return (firstChar >= 'A' && firstChar <= 'Z') ||
               (firstChar >= 'a' && firstChar <= 'z');
    }
}
