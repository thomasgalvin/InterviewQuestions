package com.galvin.interview;

import com.galvin.interview.utils.ConsoleGrabber;
import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest
{
    public static final String UNEXPECTED_CONSOLE_OUTPUT = "Unexpected console output";
    
    @Test
    public void testFizzBuzz() throws Exception {
        
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.fizzBuzz();
        
        String result = ConsoleGrabber.releaseConsole().trim();
        String expected = getFizzBuzzOutput();
        
        String[] resultTokens = result.split( "\n" );
        String[] expectedTokens = expected.split( "\n" );
        
        Assert.assertEquals( UNEXPECTED_CONSOLE_OUTPUT, expectedTokens.length, resultTokens.length );
        for( int i = 0; i < resultTokens.length; i++ ){
            Assert.assertEquals( UNEXPECTED_CONSOLE_OUTPUT, expectedTokens[i].trim(), resultTokens[i].trim() );
        }
    }
    
    private String getFizzBuzzOutput(){
        StringBuilder result = new StringBuilder();
        for( int i = 1; i <= 100; i++ ){
            result.append( i );
            result.append( " " );
            
            if( i % 3 == 0 ) {
                result.append( "Fizz" );
            }
            
            if( i % 5 == 0 ) {
                result.append( "Buzz" );
            }
            
            result.append( "\n" );
        }
        return result.toString().trim();
    }
}
