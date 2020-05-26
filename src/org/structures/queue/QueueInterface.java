package org.structures.queue;

public interface QueueInterface<T> {
    
    /**
     * 入队
     * 在队尾插入指定数据元素
     * @param element
     */
    void enQueue(T element);
    
    /**
     * 出队
     * 删除并返回队头元素
     * @return
     */
    T deQueue();
    
    /**
     * 读取当前队头元素
     * @return
     */
    T getHead();
    
    /**
     * 判空操作
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

}
