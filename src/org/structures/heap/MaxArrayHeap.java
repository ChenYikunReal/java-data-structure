package org.structures.heap;

public class MaxArrayHeap {
    
    private static final int DEFAULT_CAPACITY = 100;
    
    protected int[] tree;
    
    protected int count;
    
    public MaxArrayHeap() {
        this.tree = new int[DEFAULT_CAPACITY];
        this.count = 0;
    }
    
    /**
     * 大根堆添加新元素
     * @param element
     */
    public void addElement(int element) {
        if (count == tree.length-1) {
            throw new TreeException("堆满，无法添加新结点");
        }
        //新增结点设置为最优叶子
        tree[++count] = element;
        //新增结点调整到正确位置
        if (count > 1) {
            int next = count;
            int temp = tree[count];
            //新增结点大于双亲
            while(next != 0 && temp > tree[next/2]) {
                tree[next] = tree[next/2];
                next = next/2;
            }
            if (next == 0) {
                next++;
            }
            tree[next] = temp;
        }
    }
    
    public int removeMax() {
        if (count == 0) {
            throw new TreeException("堆空，无法移除根结点");
        }
      //暂存最大元素
        int maxNode = tree[1];
        //最右叶子放到根结点
        tree[1] = tree[count];
        //调整当前完全二叉树为大根堆
        sift(tree, 1, count--);
        return maxNode;
    }

    private void sift(int[] data, int key, int count) {
        //暂存变量
        int temp;
        //待筛选结点
        int siftNode = key;
        //初始化为待筛选结点左孩子
        int maxChild = 2 * siftNode;
        while (maxChild <= count) {
            //选取左右孩子较大者
            if (maxChild < count && data[maxChild] < data[maxChild+1]) {
                maxChild++;
            }
            //待筛选结点大于左右孩子
            if (data[siftNode] > data[maxChild]) {
                return;
            } else {
                //待筛选结点与maxChild互换
                temp = data[siftNode];
                data[siftNode] = data[maxChild];
                data[maxChild] = temp;
                //siftNode、maxChild重新赋值
                siftNode = maxChild;
                maxChild = 2 * siftNode;
            }
        }
    }

}
