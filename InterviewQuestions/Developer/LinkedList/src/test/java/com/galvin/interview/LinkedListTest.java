package com.galvin.interview;

import org.junit.Test;

public class LinkedListTest
{
     private ListFactory factory = new ListFactory() {
        @Override
        public List createList() {
            return new LinkedList();
        }
    };
    
    @Test
    public void testLinkedList() throws Exception {
        ListTestHarness harness = new ListTestHarness( factory );
        harness.testAll();
    }
}
