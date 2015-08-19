package com.galvin.interview;

/**
 * This class implements an array-based Hash Table.
 * 
 * This implementation uses the following algorithm to store a key/value pair
 *     1. Generate the hashcode of the key
 *     2. If an Entry currently exists for that hashcode, replace it with a 
 *        new Entry
 *     3. If there is no Entry for that hashcode, create a new one and add
 *        it to the array.
 * 
 * The array does not need to be sorted. If the capacity of the array is
 * exceeded, it should be grown by a factor of MULTIPLIER, similar to an
 * Array List implementation.
 * 
 * The get algorithm:
 *     1. Calculate the hashcode of the key
 *     2. Loop over the values in the entries array, comparing the Entry's
 *        hashcode to the key's hashcode
 *     3. If the hashcodes match, return the Entry's value
 *     4. If no match is found, return null
 * 
 * The remove algorithm:
 *     1. Calculate the hashcode of the key
 *     2. Loop over the values in the entries array, comparing the Entry's
 *        hashcode to the key's hashcode
 *     3. If the hashcodes match:
 *         A. Loop over the remainder of the array, shifting each value
 *            one place to the left
 *         B. Set the last element in the array to null
 * 
 * Your task is to implement the put(), get(), and remove() methods.
 */
public class HashMap {
    private static final int DEFAULT_SIZE = 5;
    private static final int MULTIPLIER = 2;

    private Entry[] entries = new Entry[ DEFAULT_SIZE ];
    private int index = -1;

    public void put( Object key, Object value ) {
        int keyHash = key.hashCode();
        Entry entry = new Entry( keyHash, value );
        add( entry );
    }

    public Object get( Object key ) {
        int location = find( key.hashCode() );
        if( location >= 0 ) {
            return entries[location].getValue();
        }
        return null;
    }

    public void remove( Object key ) {
        int location = find( key.hashCode() );
        if( location >= 0 ) {
            entries[location] = null;
            index--;
            
            for( int i = location; i < entries.length - 1; i++ ) {
                entries[i] = entries[i + 1];
            }
            entries[entries.length - 1] = null;
        }
    }

    private void add( Entry entry ) {
        int keyHash = entry.getKeyHash();
        int location = find( keyHash );
        if( location >= 0 ) {
            entries[location] = entry;
        }
        else {
            index++;
            if( index >= entries.length ) {
                Entry[] tmp = new Entry[ entries.length * MULTIPLIER ];
                for( int i = 0; i < entries.length; i++ ) {
                    tmp[i] = entries[i];
                }
                entries = tmp;
                tmp = null;
            }

            entries[index] = entry;
        }
    }

    private int find( int keyHash ) {
        for( int i = 0; i <= index; i++ ) {
            if( entries[i] != null ) {
                if( entries[i].getKeyHash() == keyHash ) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * An Entry holds a key/value pair; this object is then added to our 
     * underlying array, allowing us to store the value and its key in an
     * easily searchable format.
     */
    private class Entry {
        private int keyHash;
        private Object value;

        public Entry( int keyHash, Object value ) {
            this.keyHash = keyHash;
            this.value = value;
        }

        public int getKeyHash() {
            return keyHash;
        }

        public Object getValue() {
            return value;
        }

        public String toString() {
            return keyHash + ": " + value;
        }

    }

}
