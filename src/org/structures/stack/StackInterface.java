package org.structures.stack;

public interface StackInterface<T> {
    
    /**
     * 入栈操作
     * 在栈顶插入一个元素element
     * @param element
     */
    void push(T element);
    
    /**
     * 出栈操作
     * 删除栈顶元素
     * @return
     */
    T pop();
    
    /**
     * 取栈顶元素
     * 读取当前的栈顶元素
     * @return
     */
    T getTop();
    
    /**
     * 判空操作
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

}
