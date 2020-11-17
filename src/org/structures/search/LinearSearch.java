package org.structures.search;

public class LinearSearch {
    
    /**
     * 定义查找记录集合
     */
    private final int[] record;
    
    /**
     * 查找集合元素个数
     */
    private final int length;

    public LinearSearch(int[] record, int length) {
        super();
        this.record = record;
        this.length = length;
    }
    
    public int seqSearch(int[] r, int n, int k) {
        int i = n;
        r[0] = k;
        while (r[i] != k) {
            i--;
        }
        return i;
    }
    
    /**
     * 二分查找非递归实现
     * 待查集合储存在r[0]~r[length-1]
     * 应用二分查找的集合必须是有序的
     * @param k
     * @return
     */
    public int binSearch1(int k) {
        //初始查找区间[0, n-1]
        int mid, low = 0, high = length-1;
        //确保区间存在
        while (low <= high) {
            mid = high + (low - high)/2;
            if (k < record[mid]) {
                high = mid - 1;
            } else if (k > record[mid]) {
                low = mid+1;
            } else {
                //查找成功返回元素序号
                return mid;
            }
        }
        //查找失败
        return -1;
    }
    
    /**
     * 二分查找递归实现
     * @param low
     * @param high
     * @param k
     * @return
     */
    public int binSearch2(int low, int high, int k) {
        int mid;
        if (low > high) {   //递归边界条件
            return -1;
        } else {
            mid = high + (low - high)/2;
            if (k < record[mid]) {
                return binSearch2(low, mid-1, k);
            } else if (k > record[mid]) {
                return binSearch2(mid+1, high, k);
            } else {
                //查找成功，返回元素序号
                return mid;
            }
        }
    }

}
