package org.structures.advanced.binary_heap;// BinaryHeap class
//
// CONSTRUCTION: with optional capacity (that defaults to 100)
//               or an array containing initial items
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

import org.structures.advanced.treap.UnderflowException;

/**
 * Implements a binary heap.
 * Note that all "matching" is based on the compareTo method.
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    /**
     * Construct the binary heap.
     */
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Construct the binary heap.
     * @param capacity the capacity of the binary heap.
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity+1];
    }
    
    /**
     * Construct the binary heap given an array of items.
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap(T[] items) {
        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize+2)*11/10];
        int i = 1;
        for(T item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert(T x) {
        if(currentSize == array.length-1) {
            enlargeArray(array.length*2+1);
        }
        int hole = ++currentSize;
        for(array[0] = x; x.compareTo(array[hole/2]) < 0; hole/=2) {
            array[hole] = array[hole/2];
        }
        array[hole] = x;
    }

    @SuppressWarnings("unchecked")
    private void enlargeArray(int newSize) {
        T[] old = array;
        array = (T[]) new Comparable[newSize];
        for(int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }
    
    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public T findMin() {
        if(isEmpty()) {
            throw new UnderflowException();
        }
        return array[1];
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public T deleteMin() {
        if(isEmpty()) {
            throw new UnderflowException();
        }
        T minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap() {
        for(int i = currentSize/2; i > 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty() {
        currentSize = 0;
    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;      // Number of elements in heap
    private T[] array; // The heap array

    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown(int hole) {
        int child;
        T tmp = array[ hole ];
        for(; hole*2 <= currentSize; hole = child) {
            child = hole*2;
            if(child != currentSize && array[child+1].compareTo(array[child]) < 0) {
                child++;
            }
            if(array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

    public static void main(String [] args) {
        int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<>();
        int i;
        for(i = 37; i != 0; i = (i+37) % numItems) {
            h.insert(i);
        }
        for(i = 1; i < numItems; i++) {
            if(h.deleteMin() != i) {
                System.out.println("Oops! " + i);
            }
        }
    }
}
