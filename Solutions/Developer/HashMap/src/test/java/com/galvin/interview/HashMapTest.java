package com.galvin.interview;

import org.junit.Assert;
import org.junit.Test;

public class HashMapTest
{
    @Test
    public void testLinkedList() throws Exception {
        HashMap hashMap = new HashMap();
        String[][] entries = {
            { "A", "Alli" },
            { "B", "Briana" },
            { "C", "Charlotte" },
            { "D", "Denni" },
            { "E", "Elli" },
            { "F", "Faye" },
            { "G", "Grace" },
            { "H", "Helen" },
            { "I", "Imogen" },
            { "J", "Jessica" },
            { "K", "Kelly" },
            { "L", "Lenna" },
            { "M", "Mallory" },
            { "N", "Nichole" },
            { "O", "Ophelia" },
            { "P", "Paula" },
            { "Q", "Quora" },
            { "R", "Rachel" },
            { "S", "Sarah" },
            { "T", "Tamara" },
            { "U", "Uma" },
            { "V", "Veronica" },
            { "W", "Wendy" },
            { "X", "Xena" },
            { "Y", "Yuffi" },
            { "Z", "Zelda" },
        };
        
        for( String[] entry : entries ){
            hashMap.put( entry[0], entry[1] );
        }
        
        for( String[] entry : entries ){
            Object value = hashMap.get( entry[0] );
            Assert.assertEquals( "HashMap returned wrong value for " + entry[0], entry[1], value );
        }
    }
}
