package org.structures.queue.deque.doubledeque;

import org.structures.queue.QueueInterface;

public interface DoubleDequeInterface<T> extends QueueInterface<T> {

    /**
     * 队首入栈操作
     * 在队首栈顶插入一个元素element
     * @param element
     */
    void headPush(T element);

    /**
     * 队首出栈操作
     * 删除队首栈顶元素
     * @return
     */
    T headPop();

    /**
     * 队尾入栈操作
     * 在队尾栈顶插入一个元素element
     * @param element
     */
    void rearPush(T element);

    /**
     * 队尾出栈操作
     * 删除队尾栈顶元素
     * @return
     */
    T rearPop();

    /**
     * 取队尾元素
     * 读取当前的队尾元素
     * @return
     */
    T getRear();

}
