
package csci235;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashTableSet<T> implements Set<T> 
{

    private List<T>[] buckets;
    private int size;

    public HashTableSet(int numBuckets) {
       size = 0;
       buckets = createBucketArray( numBuckets ); 
    }


    // Construct an array of buckets of neededSize, and initialize it.

    private List<T> [] createBucketArray( int neededSize )
    {
        if( neededSize < 1 )
           throw new IllegalArgumentException( "nrbuckets must be greater than zero" ); 

       // Seems that this problem is unfixable:

       @SuppressWarnings("unchecked" )

       List<T>[] arr = new List[ neededSize ];
 
       for( int i = 0; i != neededSize; ++ i )
           arr[i] = new ArrayList<T>( );

       return arr; 
    }

    public void rehash(int newNrBuckets) {
        buckets = createBucketArray(newNrBuckets);
    }

    private int getIndex(T val) {

        int index = val.hashCode() % buckets.length;
        return index;
    }

    @Override
    public boolean add(T value) {

        int index = getIndex(value);

        if(this.contains(value)) {
            return false;
        }

        buckets[index].add(value);
        size++;

        if(size > buckets.length * 4) {
            rehash(buckets.length * 2);
        }

        return true;
    }

    @Override
    public boolean contains(T t) {
        int index = getIndex(t);

        for(T item: buckets[index]) {
            if(item.equals(t)) {
                return true;
            }
       }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = createBucketArray(4);
        size = 0;
    }

    @Override
    public List<T> toList() {
        List<T> lst = new ArrayList<T>();

        for(List<T> items : buckets) {
            for(T item: items) {
                lst.add(item);
            }
        }

        return lst;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        List<T> lst = new ArrayList<T>();

        lst = this.toList();

        for(T item : lst) {
            str.append(item + " ");
        }

        return str.toString();
    }
}


