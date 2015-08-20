package com.galvin.interview;

/**
 * This class calculates the area of a circle, given its radius.
 * 
 * The formula for a circle's area is "pi times the radius squared".
 * 
 * Implement this method.
 */
public class CircleArea
{
    
    /**
     * Calculates the area of a circle with the given radius
     * @param radius the radius of the circle
     * @return the area
     */
    public double area( double radius ){
        //this will also work with enough precision, but the actual code
        //  is the preferred method
        //return 3.1415 * radius * radius;
        
        return Math.PI * Math.pow( radius, 2 );
    }
}
