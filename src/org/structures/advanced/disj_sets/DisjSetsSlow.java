package org.structures.advanced.disj_sets;// DisjSets class
//
// CONSTRUCTION: with int representing initial number of sets
//
// ******************PUBLIC OPERATIONS*********************
// void union( root1, root2 ) --> Merge two sets
// int find( x )              --> Return set containing x
// ******************ERRORS********************************
// No error checking is performed

/**
 * Disjoint set class.
 * Does not use union heuristics or path compression.
 * Elements in the set are numbered starting at 0.
 */
class DisjSetsSlow {

    private int [] set;

    /**
     * Construct the disjoint sets object.
     * @param numElements the initial number of disjoint sets.
     */
    public DisjSetsSlow(int numElements) {
        set = new int [numElements];
        for(int i = 0; i < set.length; i++) {
            set[i] = -1;
        }
    }

    /**
     * Union two disjoint sets.
     * For simplicity, we assume root1 and root2 are distinct
     * and represent set names.
     * @param root1 the root of set 1.
     * @param root2 the root of set 2.
     */
    public void union(int root1, int root2) {
        set[root2] = root1;
    }

    /**
     * Perform a find.
     * Error checks omitted again for simplicity.
     * @param x the element being searched for.
     * @return the set containing x.
     */
    public int find(int x) {
        if(set[x] < 0) {
            return x;
        } else {
            return find(set[x]);
        }
    }

    public static void main(String [] args) {
        int NumElements = 128;
        int NumInSameSet = 16;
        DisjSetsSlow ds = new DisjSetsSlow(NumElements);
        int set1, set2;
        for(int k = 1; k < NumInSameSet; k *= 2) {
            for(int j = 0; j + k < NumElements; j += 2 * k) {
                set1 = ds.find(j);
                set2 = ds.find(j + k);
                ds.union(set1, set2);
            }
        }
        StringBuilder tempResult = new StringBuilder();
        for(int i = 0; i < NumElements; i++) {
            tempResult.append(ds.find(i)).append("~");
            if(i % NumInSameSet == NumInSameSet-1) {
                System.out.println(tempResult.substring(0, tempResult.length()-1));
                tempResult = new StringBuilder();
            }
        }
    }
}
