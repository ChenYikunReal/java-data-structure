package org.structures.sort;

public interface SortInterface {

    /**
     * 直接插入排序
     */
    void insertSort();

    /**
     * 希尔排序
     */
    void shellSort();

    /**
     * 冒泡排序
     */
    void bubbleSort();

    /**
     * 快速排序
     */
    void quickSort(int first, int end);

    /**
     * 简单选择排序
     */
    void selectSort();

    /**
     * 堆排序
     */
    void heapSort();

    /**
     * 归并排序递归算法
     */
    void mergeSort1(int first, int last);

    /**
     * 归并排序非递归算法
     */
    void mergeSort2();

    /**
     * 输出序列
     */
    void print();

}
