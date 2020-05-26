package org.structures.advanced.binomial_queue;// BinomialQueue class
//
// CONSTRUCTION: with no parameters or a single item
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// vod merge( rhs )       --> Absord rhs into this heap
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

import org.structures.advanced.treap.UnderflowException;

/**
 * Implements a binomial queue.
 * Note that all "matching" is based on the compareTo method.
 */
public final class BinomialQueue<T extends Comparable<? super T>> {

    /**
     * Construct the binomial queue.
     */
    @SuppressWarnings("unchecked")
    public BinomialQueue() {
        theTrees = new BinNode[DEFAULT_TREES];
        makeEmpty();
    }

    /**
     * Construct with a single item.
     */
    @SuppressWarnings("unchecked")
    public BinomialQueue(T item) {
        currentSize = 1;
        theTrees = new BinNode[1];
        theTrees[0] = new BinNode<>(item, null, null);
    }

    @SuppressWarnings("unchecked")
    private void expandTheTrees(int newNumTrees) {
        BinNode<T> [] old = theTrees;
        int oldNumTrees = theTrees.length;
        theTrees = new BinNode[newNumTrees];
        for(int i = 0; i < Math.min(oldNumTrees, newNumTrees); i++) {
            theTrees[i] = old[i];
        }
        for(int i = oldNumTrees; i < newNumTrees; i++) {
            theTrees[i] = null;
        }
    }
    
    /**
     * Merge rhs into the priority queue.
     * rhs becomes empty. rhs must be different from this.
     * @param rhs the other binomial queue.
     */
    public void merge(BinomialQueue<T> rhs) {
        // Avoid aliasing problems
        if(this == rhs) {
            return;
        }
        currentSize += rhs.currentSize;
        if(currentSize > capacity()) {
            int newNumTrees = Math.max(theTrees.length, rhs.theTrees.length) + 1;
            expandTheTrees(newNumTrees);
        }
        BinNode<T> carry = null;
        for(int i = 0, j = 1; j <= currentSize; i++, j *= 2) {
            BinNode<T> t1 = theTrees[i];
            BinNode<T> t2 = i < rhs.theTrees.length ? rhs.theTrees[i] : null;
            int whichCase = t1 == null ? 0 : 1;
            whichCase += t2 == null ? 0 : 2;
            whichCase += carry == null ? 0 : 4;
            switch(whichCase) {
              case 0: /* No trees */
              case 1: /* Only this */
                break;
              case 2: /* Only rhs */
                theTrees[i] = t2;
                rhs.theTrees[i] = null;
                break;
              case 4: /* Only carry */
                theTrees[i] = carry;
                carry = null;
                break;
              case 3: /* this and rhs */
                carry = combineTrees(t1, t2);
                theTrees[i] = rhs.theTrees[i] = null;
                break;
              case 5: /* this and carry */
                carry = combineTrees(t1, carry);
                theTrees[i] = null;
                break;
              case 6: /* rhs and carry */
                carry = combineTrees(t2, carry);
                rhs.theTrees[i] = null;
                break;
              case 7: /* All three */
                theTrees[i] = carry;
                carry = combineTrees(t1, t2);
                rhs.theTrees[i] = null;
                break;
            }
        }
        for(int k = 0; k < rhs.theTrees.length; k++) {
            rhs.theTrees[k] = null;
        }
        rhs.currentSize = 0;
    }        

    /**
     * Return the result of merging equal-sized t1 and t2.
     */
    private BinNode<T> combineTrees(BinNode<T> t1, BinNode<T> t2) {
        if(t1.element.compareTo(t2.element) > 0) {
            return combineTrees( t2, t1 );
        }
        t2.nextSibling = t1.leftChild;
        t1.leftChild = t2;
        return t1;
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * This implementation is not optimized for O(1) performance.
     * @param x the item to insert.
     */
    public void insert(T x) {
        merge(new BinomialQueue<>(x));
    }

    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or throw UnderflowException if empty.
     */
    public T findMin() {
        if(isEmpty()) {
            throw new UnderflowException();
        }
        return theTrees[findMinIndex()].element;
    }


    /**
     * Find index of tree containing the smallest item in the priority queue.
     * The priority queue must not be empty.
     * @return the index of tree containing the smallest item.
     */
    private int findMinIndex() {
        int i;
        int minIndex;
        for(i = 0; theTrees[i] == null; i++) {}
        for(minIndex = i; i < theTrees.length; i++) {
            if(theTrees[i] != null && theTrees[i].element.compareTo(theTrees[minIndex].element) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw UnderflowException if empty.
     */
    public T deleteMin() {
        if(isEmpty()) {
            throw new UnderflowException();
        }
        int minIndex = findMinIndex();
        T minItem = theTrees[minIndex].element;
        BinNode<T> deletedTree = theTrees[minIndex].leftChild;
        // Construct H''
        BinomialQueue<T> deletedQueue = new BinomialQueue<>();
        deletedQueue.expandTheTrees(minIndex);
        deletedQueue.currentSize = (1 << minIndex) - 1;
        for(int j = minIndex - 1; j >= 0; j--) {
            deletedQueue.theTrees[j] = deletedTree;
            deletedTree = deletedTree.nextSibling;
            deletedQueue.theTrees[j].nextSibling = null;
        }
        // Construct H'
        theTrees[minIndex] = null;
        currentSize -= deletedQueue.currentSize + 1;
        merge(deletedQueue);
        return minItem;
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
        for(int i = 0; i < theTrees.length; i++) {
            theTrees[i] = null;
        }
    }

    private static class BinNode<T> {
        @SuppressWarnings("unused")
        BinNode(T theElement) {
            this(theElement, null, null);
        }

        BinNode(T theElement, BinNode<T> lt, BinNode<T> nt) {
            element     = theElement;
            leftChild   = lt;
            nextSibling = nt;
        }

        T element;     // The data in the node
        BinNode<T> leftChild;   // Left child
        BinNode<T> nextSibling; // Right child
    }

    private static final int DEFAULT_TREES = 1;

    private int currentSize;                // # items in priority queue
    private BinNode<T> [] theTrees;  // An array of tree roots


    /**
     * Return the capacity.
     */
    private int capacity() {
        return (1 << theTrees.length) - 1;
    }

    public static void main(String [] args) {
        int numItems = 10000;
        BinomialQueue<Integer> h  = new BinomialQueue<>();
        BinomialQueue<Integer> h1 = new BinomialQueue<>();
        int i = 37;
        System.out.println( "Starting check." );
        for(i = 37; i != 0; i = ( i + 37 ) % numItems) {
            if(i % 2 == 0) {
                h1.insert(i);
            } else {
                h.insert(i);
            }
        }
        h.merge(h1);
        for(i = 1; i < numItems; i++) {
            if(h.deleteMin() != i) {
                System.out.println("Oops! " + i);
            }
        }
        System.out.println("Check done.");
    }
}
