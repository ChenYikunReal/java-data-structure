package org.structures.advanced.kd_tree;

/**
 * Quick illustration of a two-dimensional tree.
 */
public class KdTree<T extends Comparable<? super T>> {

    private static class KdNode<T> {
        T[]     data;
        KdNode<T> left;
        KdNode<T> right;

        @SuppressWarnings("unchecked")
        KdNode(T[] item) {
            data = (T[]) new Comparable[2];
            data[0] = item[0];
            data[1] = item[1];
            left = right = null;
        }
    }

    private KdNode<T> root;

    public KdTree() {
        root = null;
    }

    public void insert(T[] x) {
        root = insert(x, root, 0);
    }

    private KdNode<T> insert(T[] x, KdNode<T> t, int level) {
        if(t == null) {
            t = new KdNode<>(x);
        } else if( x[level].compareTo(t.data[level] ) < 0) {
            t.left = insert(x, t.left, 1 - level);
        } else {
            t.right = insert(x, t.right, 1 - level);
        }
        return t;
    }

    /**
     * Print items satisfying
     * low[0] <= x[0] <= high[0] and
     * low[1] <= x[1] <= high[1].
     */
    public void printRange(T[] low, T[] high) {
        printRange(low, high, root, 0);
    }

    private void printRange(T[] low, T[] high, KdNode<T> t, int level) {
        if(t != null) {
            if(low[0].compareTo(t.data[0]) <= 0 && low[1].compareTo(t.data[1] ) <= 0 &&
                       high[0].compareTo(t.data[0]) >= 0 && high[1].compareTo(t.data[1]) >= 0) {
                System.out.println("(" + t.data[ 0 ] + "," + t.data[ 1 ] + ")");
            }
            if(low[level].compareTo(t.data[level]) <= 0) {
                printRange(low, high, t.left, 1-level);
            }
            if(high[level].compareTo(t.data[level]) >= 0) {
                printRange(low, high, t.right, 1-level);
            }
        }
    }

    public static void main(String [] args) {
        KdTree<Integer> t = new KdTree<>();
        System.out.println("Starting program");
        for(int i = 300; i < 370; i++) {
            Integer [] it = new Integer[2];
            it[0] = i;
            it[1] = 2500-i;
            t.insert(it);
        }
        Integer [] low = {70, 2186};
        Integer [] high = {1200, 2200};
        t.printRange(low, high);
    }
}
