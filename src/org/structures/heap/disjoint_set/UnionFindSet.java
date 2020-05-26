package org.structures.heap.disjoint_set;

public class UnionFindSet {
    
    private static final int DEFAULT_CAPACITY = 100;
    
    protected UnionFindNode[] tree;

    public UnionFindSet() {
        super();
        this.tree = new UnionFindNode[DEFAULT_CAPACITY];
    }

    public UnionFindSet(UnionFindNode[] tree) {
        super();
        this.tree = tree;
    }

    public int find(int nodeIndex) {
        while (tree[nodeIndex].getParent() != -1) {
            nodeIndex = tree[nodeIndex].getParent();
        }
        return nodeIndex;
    }
    
    public void merge(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            tree[root2].setParent(root1);
        }
    }

}
