package csci235;

import java.util.List;

/**
 * A generic set
 * @param <T>
 */

public interface Set<T> {
    
    /**
     * Adds the given element to the set, if not already 
     * there, which is checked using the equals( ) method.  
     * Return true if the element was indeed inserted. 
     * @param value element to be added to the set
     * @return true if insertion took place 
     */

    public boolean add(T value);

    /**
     * Returns true if value 
     * occurs in the set, which is checked using the equals( ) method. 
     * 
     * @param value that is checked for in the set
     * @return true if value occurs in the set. 
     */
    public boolean contains(T t);

    /**
     * @return the number of elements in the set
     */
    public int getSize();
    
    /**
     * Removes all elements from the set
     */
    public void clear();

    /**
     * @return a list of all of the elements of the set
     */
    public List<T> toList();

    /**
     * @return a String representation of the set
     */
    @Override
    public String toString();
}

