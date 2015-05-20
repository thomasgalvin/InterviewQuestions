package com.galvin.interview;

import org.junit.Test;

public class ArrayListTest
{
     private ListFactory factory = new ListFactory() {
        @Override
        public List createList() {
            return new ArrayList();
        }
    };
    
    @Test
    public void testArrayList() throws Exception {
        ListTestHarness harness = new ListTestHarness( factory );
        harness.testAll();
    }
}
