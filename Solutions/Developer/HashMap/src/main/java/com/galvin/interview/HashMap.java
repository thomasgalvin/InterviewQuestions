package com.galvin.interview;

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
        System.out.println( "Removing: " + key );
        int location = find( key.hashCode() );
        if( location >= 0 ) {
            System.out.println( "    Removing: " + key + " at " + key.hashCode() );
            print( "    Before:" );

            entries[location] = null;

            for( int i = location; i < entries.length - 1; i++ ) {
                entries[i] = entries[i + 1];
            }
            entries[entries.length - 1] = null;
            
            index--;

            print( "    After:" );
            System.out.println( "---" );
        }
        else {
            System.out.println( "    Not found" );
        }
    }

    private void print( String name ) {
        System.out.println( name );
        System.out.print( "    " );
        for( int i = 0; i < entries.length; i++ ) {
            System.out.print( entries[i] );
            System.out.print( " " );
        }
        System.out.println( "" );
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

    //TODO: sort and use binary search
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
