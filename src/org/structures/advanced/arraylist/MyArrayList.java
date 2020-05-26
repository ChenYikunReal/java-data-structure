package org.structures.advanced.arraylist;

public class MyArrayList<T> implements Iterable<T> {

    /**
     * Construct an empty ArrayList.
     */
    public MyArrayList() {
        doClear();
    }
    
    /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size() {
        return theSize;
    }
    
    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
     * Returns the item at position idx.
     * @param index the index to search in.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public T get(int index) {
        if(index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + "; size " + size());
        }
        return theItems[index];
    }
        
    /**
     * Changes the item at position idx.
     * @param index the index to change.
     * @param newVal the new value.
     * @return the old value.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public T set(int index, T newVal) {
        if(index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + "; size " + size());
        }
        T old = theItems[index];
        theItems[index] = newVal;
        return old;    
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int newCapacity) {
        if(newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for(int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }
    
    /**
     * Adds an item to this collection, at the end.
     * @param x any object.
     * @return true.
     */
    public boolean add(T x) {
        add(size(), x);
        return true;            
    }
    
    /**
     * Adds an item to this collection, at the specified index.
     * @param index the index of the object.
     * @param x any object.
     * @return true.
     */
    public void add(int index, T x) {
        if(theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for(int i = theSize; i > index; i--) {
            theItems[i] = theItems[i-1];
        }
        theItems[index] = x;
        theSize++;  
    }
      
    /**
     * Removes an item from this collection.
     * @param index the index of the object.
     * @return the item was removed from the collection.
     */
    public T remove(int index) {
        T removedItem = theItems[index];
        for(int i = index; i < size() - 1; i++) {
            theItems[i] = theItems[i+1];
        }
        theSize--;
        return removedItem;
    }
    
    /**
     * Change the size of this collection to zero.
     */
    public void clear() {
        doClear();
    }
    
    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }
    
    /**
     * Obtains an Iterator object used to traverse the collection.
     * @return an iterator positioned prior to the first element.
     */
    public java.util.Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Returns a String representation of this collection.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for(T x : this) {
            sb.append(x).append(" ");
        }
        sb.append("]");
        return new String(sb);
    }
    
    /**
     * This is the implementation of the ArrayListIterator.
     * It maintains a notion of a current position and of
     * course the implicit reference to the MyArrayList.
     */
    private class ArrayListIterator implements java.util.Iterator<T> {
        private int current = 0;
        private boolean okToRemove = false;
        
        public boolean hasNext() {
            return current < size();
        }
        
        
        public T next() {
            if(!hasNext()) {
                throw new java.util.NoSuchElementException( );
            }
            okToRemove = true;    
            return theItems[current++];
        }
        
        public void remove() {
            if(!okToRemove) {
                throw new IllegalStateException();
            }
            MyArrayList.this.remove(--current);
            okToRemove = false;
        }
    }
    
    private static final int DEFAULT_CAPACITY = 10;
    
    private T[] theItems;
    private int theSize;
}

class ArrayListTest {
    public static void main(String [] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
        for(int i = 20; i < 30; i++) {
            list.add(0, i);
        }
        list.remove(0);
        list.remove(list.size()-1);
        System.out.println(list);
    }
}
