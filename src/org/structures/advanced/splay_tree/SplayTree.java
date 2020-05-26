package org.structures.advanced.splay_tree;

// SplayTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert(x)       → Insert x
// void remove(x)       → Remove x
// boolean contains(x)  → Return true if x is found
// Comparable findMin()  → Return smallest item
// Comparable findMax()  → Return largest item
// boolean isEmpty()     → Return true if empty; else false
// void makeEmpty()      → Remove all items
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

import org.structures.advanced.treap.UnderflowException;

/**
 * Implements a top-down splay tree.
 * Note that all "matching" is based on the compareTo method.
 */
public class SplayTree<T extends Comparable<? super T>> {

    /**
     * Construct the tree.
     */
    public SplayTree() {
        nullNode = new BinaryNode<T>(null);
        nullNode.left = nullNode.right = nullNode;
        root = nullNode;
    }

    private BinaryNode<T> newNode = null;  // Used between different inserts

    /**
     * Insert into the tree.
     * @param x the item to insert.
     */
    public void insert(T x) {
        if(newNode == null) {
            newNode = new BinaryNode<T>(null);
        }
        newNode.element = x;
        if(root == nullNode) {
            newNode.left = newNode.right = nullNode;
            root = newNode;
        } else {
            root = splay(x, root);
            int compareResult = x.compareTo(root.element);
            if(compareResult < 0) {
                newNode.left = root.left;
                newNode.right = root;
                root.left = nullNode;
                root = newNode;
            } else if(compareResult > 0) {
                newNode.right = root.right;
                newNode.left = root;
                root.right = nullNode;
                root = newNode;
            } else {
                return;   // No duplicates
            }
        }
        newNode = null;   // So next insert will call new
    }

    /**
     * Remove from the tree.
     * @param x the item to remove.
     */
    public void remove(T x) {
        if(!contains(x)) {
            return;
        }
        BinaryNode<T> newTree;
        // If x is found, it will be splayed to the root by contains
        if(root.left == nullNode) {
            newTree = root.right;
        } else {
            // Find the maximum in the left subtree
            // Splay it to the root; and then attach right child
            newTree = root.left;
            newTree = splay(x, newTree);
            newTree.right = root.right;
        }
        root = newTree;
    }

    /**
     * Find the smallest item in the tree.
     * Not the most efficient implementation (uses two passes), but has correct amortized behavior.
     * A good alternative is to first call find with parameter smaller than any item in the tree, then call findMin.
     * @return the smallest item or throw UnderflowException if empty.
     */
    public T findMin() {
        if(isEmpty()) {
            throw new UnderflowException();
        }
        BinaryNode<T> ptr = root;
        while(ptr.left != nullNode) {
            ptr = ptr.left;
        }
        root = splay(ptr.element, root);
        return ptr.element;
    }

    /**
     * Find the largest item in the tree.
     * Not the most efficient implementation (uses two passes), but has correct amortized behavior.
     * A good alternative is to first call find with parameter larger than any item in the tree, then call findMax.
     * @return the largest item or throw UnderflowException if empty.
     */
    public T findMax() {
        if(isEmpty()) {
            throw new UnderflowException();
        }
        BinaryNode<T> ptr = root;
        while(ptr.right != nullNode) {
            ptr = ptr.right;
        }
        root = splay(ptr.element, root);
        return ptr.element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if x is found; otherwise false.
     */
    public boolean contains(T x) {
        if(isEmpty()) {
            return false;
        }
        root = splay(x, root);
        return root.element.compareTo(x) == 0;
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = nullNode;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == nullNode;
    }

    private BinaryNode<T> header = new BinaryNode<T>(null); // For splay

    /**
     * Internal method to perform a top-down splay.
     * The last accessed node becomes the new root.
     * @param x the target item to splay around.
     * @param t the root of the subtree to splay.
     * @return the subtree after the splay.
     */
    private BinaryNode<T> splay(T x, BinaryNode<T> t) {
        BinaryNode<T> leftTreeMax, rightTreeMin;
        header.left = header.right = nullNode;
        leftTreeMax = rightTreeMin = header;
        nullNode.element = x;   // Guarantee a match
        while (true) {
            int compareResult = x.compareTo(t.element);
            if(compareResult < 0) {
                if( x.compareTo(t.left.element) < 0) {
                    t = rotateWithLeftChild(t);
                }
                if(t.left == nullNode) {
                    break;
                }
                // Link Right
                rightTreeMin.left = t;
                rightTreeMin = t;
                t = t.left;
            } else if(compareResult > 0) {
                if( x.compareTo(t.right.element) > 0) {
                    t = rotateWithRightChild(t);
                }
                if(t.right == nullNode) {
                    break;
                }
                // Link Left
                leftTreeMax.right = t;
                leftTreeMax = t;
                t = t.right;
            } else {
                break;
            }
        }

        leftTreeMax.right = t.left;
        rightTreeMin.left = t.right;
        t.left = header.right;
        t.right = header.left;
        return t;
    }

    /**
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1.
     */
    private static <T> BinaryNode<T> rotateWithLeftChild(BinaryNode<T> k2) {
        BinaryNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4.
     */
    private static <T> BinaryNode<T> rotateWithRightChild(BinaryNode<T> k1 ) {
        BinaryNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<T> {
        BinaryNode(T theElement) {
            this(theElement, null, null);
        }

        BinaryNode(T theElement, BinaryNode<T> lt, BinaryNode<T> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }

        T element;            // The data in the node
        BinaryNode<T> left;   // Left child
        BinaryNode<T> right;  // Right child
    }

    private BinaryNode<T> root;
    private BinaryNode<T> nullNode;


    // Test program; should print min and max and nothing else
    public static void main(String [] args) {
        SplayTree<Integer> t = new SplayTree<>();
        final int NUMS = 40000;
        final int GAP = 307;
        System.out.println("Checking... (no bad output means success)");
        for(int i = GAP; i != 0; i = (i+GAP) % NUMS) {
            t.insert(i);
        }
        System.out.println("Insert completely");
        for(int i = 1; i < NUMS; i += 2) {
            t.remove(i);
        }
        System.out.println("Remove completely");
        if(t.findMin() != 2 || t.findMax() != NUMS-2) {
            System.out.println("FindMin or FindMax error!");
        }
        for(int i = 2; i < NUMS; i += 2) {
            if(!t.contains(i)) {
                System.out.println("Error: find fails for " + i);
            }
        }
        for(int i = 1; i < NUMS; i += 2) {
            if(t.contains(i)) {
                System.out.println("Error: Found deleted item " + i);
            }
        }
    }

}

