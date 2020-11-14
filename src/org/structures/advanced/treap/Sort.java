package org.structures.advanced.treap;

/**
 * A class that contains several sorting routines, implemented as static methods.
 * Arrays are rearranged with smallest item first, using compareTo.
 */
public final class Sort {

    private static final int NUM_ITEMS = 1000;

    private static int theSeed = 1;

    private static final int CUTOFF = 3;

    /**
     * Simple insertion sort.
     * @param a an array of Comparable items.
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        int j;
        for(int p = 1; p < a.length; p++) {
            T tmp = a[p];
            for(j = p; j > 0 && tmp.compareTo(a[j-1]) < 0; j--) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    /**
     * ShellSort, using Shell's (poor) increments.
     * @param a an array of Comparable items.
     */
    public static <T extends Comparable<? super T>> void shellSort(T[] a) {
        int j;
        for(int gap = a.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < a.length; i++) {
                T tmp = a[i];
                for(j = i; j >= gap && tmp.compareTo(a[j-gap]) < 0; j -= gap) {
                    a[j] = a[j-gap];
                }
                a[j] = tmp;
            }
        }
    }

    /**
     * Internal method for heapsort.
     * @param i the index of an item in the heap.
     * @return the index of the left child.
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Internal method for heapsort that is used in deleteMax and buildHeap.
     * @param a an array of Comparable items.
     * @index i the position from which to percolate down.
     * @int n the logical size of the binary heap.
     */
    private static <T extends Comparable<? super T>> void percDown(T[] a, int i, int n) {
        int child;
        T tmp;
        for(tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if(child != n-1 && a[child].compareTo(a[child+1]) < 0) {
                child++;
            }
            if(tmp.compareTo(a[child]) < 0) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = tmp;
    }

    /**
     * Standard heapsort.
     * @param a an array of Comparable items.
     */
    public static <T extends Comparable<? super T>> void heapsort(T[] a) {
        for(int i = a.length / 2 - 1; i >= 0; i--) {
            percDown( a, i, a.length );
        }
        for(int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0, i);
            percDown(a, 0, i);
        }
    }


    /**
     * Mergesort algorithm.
     * @param a an array of Comparable items.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
        T[] tmpArray = (T[]) new Comparable[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    /**
     * Internal method that makes recursive calls.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <T extends Comparable<? super T>> void mergeSort(T[ ] a, T[ ] tmpArray, int left, int right) {
        if(left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray.
     */
    private static <T extends Comparable<? super T>> void merge(T[] a, T[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos-1;
        int tmpPos = leftPos;
        int numElements = rightEnd-leftPos+1;
        // Main loop
        while(leftPos <= leftEnd && rightPos <= rightEnd) {
            if(a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }
        while (leftPos <= leftEnd) {   // Copy rest of first half
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while(rightPos <= rightEnd) {  // Copy rest of right half
            tmpArray[tmpPos++] = a[rightPos++];
        }
        // Copy tmpArray back
        for(int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    /**
     * Quicksort algorithm.
     * @param a an array of Comparable items.
     */
    public static <T extends Comparable<? super T>> void quicksort(T[] a) {
        quicksort(a, 0, a.length-1);
    }

    /**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static <T> void swapReferences(T[] a, int index1, int index2) {
        T tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     */
    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        int center = (left + right) / 2;
        if(a[center].compareTo(a[left]) < 0) {
            swapReferences(a, left, center);
        }
        if(a[right].compareTo(a[ left ] ) < 0) {
            swapReferences( a, left, right );
        }
        if(a[right].compareTo( a[ center ] ) < 0) {
            swapReferences(a, center, right);
        }
        // Place pivot at position right - 1
        swapReferences(a, center, right - 1);
        return a[right-1];
    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <T extends Comparable<? super T>> void quicksort(T[] a, int left, int right) {
        if(left + CUTOFF <= right) {
            T pivot = median3(a, left, right);
            // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; ) {
                while(a[++i].compareTo(pivot) < 0) { }
                while(a[--j].compareTo(pivot) > 0) { }
                if(i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }
            swapReferences(a, i, right-1);   // Restore pivot
            quicksort(a, left, i-1);    // Sort small elements
            quicksort(a, i+1, right);   // Sort large elements
        } else {  // Do an insertion sort on the subarray
            insertionSort(a, left, right);
        }
    }

    /**
     * Internal insertion sort routine for subarrays
     * that is used by quicksort.
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <T extends Comparable<? super T>> void insertionSort(T[ ] a, int left, int right) {
        for(int p = left + 1; p <= right; p++) {
            T tmp = a[p];
            int j;
            for(j = p; j > left && tmp.compareTo(a[j-1]) < 0; j--) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    /**
     * Quick selection algorithm.
     * Places the kth smallest item in a[k-1].
     * @param a an array of Comparable items.
     * @param k the desired rank (1 is minimum) in the entire array.
     */
    public static <T extends Comparable<? super T>> void quickSelect(T[] a, int k) {
        quickSelect(a, 0, a.length-1, k);
    }

    /**
     * Internal selection method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * Places the kth smallest item in a[k-1].
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     * @param k the desired index (1 is minimum) in the entire array.
     */
    private static <T extends Comparable<? super T>> void quickSelect(T[] a, int left, int right, int k) {
        if(left + CUTOFF <= right) {
            T pivot = median3(a, left, right);
            // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; ) {
                while( a[++i].compareTo(pivot) < 0) { }
                while( a[--j].compareTo(pivot) > 0) { }
                if(i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }
            swapReferences(a, i, right-1);   // Restore pivot
            if(k <= i) {
                quickSelect(a, left, i-1, k);
            } else if(k > i+1) {
                quickSelect(a, i+1, right, k);
            }
        } else {  // Do an insertion sort on the subarray
            insertionSort(a, left, right);
        }
    }

    private static void checkSort(Integer [] a) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] != i) {
                System.out.println("Error at " + i);
            }
        }
        System.out.println("Finished checksort");
    }

    public static void main(String [] args) {
        Integer [] a = new Integer[NUM_ITEMS];
        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for(theSeed = 0; theSeed < 20; theSeed++) {
            Random.permute(a);
            Sort.insertionSort(a);
            checkSort(a);
            Random.permute(a);
            Sort.heapsort(a);
            checkSort(a);
            Random.permute(a);
            Sort.shellSort(a);
            checkSort(a);
            Random.permute(a);
            Sort.mergeSort(a);
            checkSort(a);
            Random.permute(a);
            Sort.quicksort(a);
            checkSort(a);
            Random.permute(a);
            Sort.quickSelect(a, NUM_ITEMS/2);
            System.out.println(a[NUM_ITEMS/2-1] + " " + NUM_ITEMS/2);
        }
        Integer [] b = new Integer[10_000_000];
        for(int i = 0; i < b.length; i++) {
            b[i] = i;
        }
        Random.permute(b);
        long start = System.currentTimeMillis();
        Sort.quickSelect(b, b.length/2);
        long end = System.currentTimeMillis();
        System.out.println("Timing for Section 1.1 example: ");
        System.out.println("Selection for N = " + b.length + " takes " + (end - start) + "ms.");
        System.out.println(b[b.length/2-1] + " " + b.length/2);
    }

}

