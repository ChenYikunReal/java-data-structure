package org.structures.queue.priority;

import org.structures.queue.QueueException;

import java.util.Arrays;

public class PriorityQueue<T extends Comparable<? super T>> implements QueueInterface<T> {

    private T[] data;

    private int size;

    @SuppressWarnings("unchecked")
    public PriorityQueue() {
        // 注意这里的写法
        data = (T[]) new Comparable[32];
    }

    @Override
    public void enQueue(T element) {
        // 队列长度超出范围，扩容
        if (size >= data.length) {
            resize();
        }
        data[size++] = element;
        upAdjust();
    }

    @Override
    public T deQueue() {
        if (size <= 0) {
            throw new QueueException("队列空");
        }
        // 获取堆顶元素
        T head = data[0];
        // 让最后一个元素移动到堆顶
        data[0] = data[--size];
        downAdjust();
        return head;
    }

    @Override
    public T getHead() {
        return data[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void upAdjust() {
        int childIndex = size-1;
        int parentIndex = (childIndex-1)/2;
        // temp保存插入的叶子结点值，用于最后的赋值
        T temp = data[childIndex];
        while (childIndex > 0 && temp.compareTo(data[parentIndex]) > 0) {
            // 无须真正交换，单向赋值即可
            data[childIndex] = data[parentIndex];
            childIndex = parentIndex;
            parentIndex /= 2;
        }
        data[childIndex] = temp;
    }

    private void downAdjust() {
        // temp保存父结点的值，用于最后的赋值
        int parentIndex = 0;
        T temp = data[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            // 如果有右子树，且右子结点的值大于左结点的值，则定位到右子结点
            if (childIndex+1 < size && data[childIndex+1].compareTo(data[childIndex]) > 0) {
                childIndex++;
            }
            if (temp.compareTo(data[childIndex]) >= 0) {
                break;
            }
            // 无须真正交换，单向赋值即可
            data[parentIndex] = data[childIndex];
            parentIndex = childIndex;
            childIndex = 2*childIndex+1;
        }
        data[parentIndex] = temp;
    }

    private void resize() {
        int newSize = size * 2;
        data = Arrays.copyOf(data, newSize);
    }

}
