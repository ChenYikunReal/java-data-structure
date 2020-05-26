package org.structures.stack.both;

import org.structures.stack.StackException;

public class BothStack<T> {
    
    //两栈共享存储空间的存储结构
    protected T[] bothStack;
    
    //储存容量
    private final static int STACK_SIZE = 100;
    
    //栈1的栈顶
    protected int top1;
    
    //栈2的栈顶
    protected int top2;
    
    @SuppressWarnings("unchecked")
    public BothStack() {
        bothStack = (T[])new Object[STACK_SIZE];
        top1 = -1;
        top2 = STACK_SIZE;
    }
    
    /**
     * 入栈操作
     * @param i 准备入栈的栈
     * @param element 准备插入的元素
     */
    public void push(int i, T element) {
        if (top1 == top2-1) {
            throw new StackException("栈满");
        } else if (i == 1) {
            //栈1入栈
            //特别要注意先++，而且默认栈1在左侧
            bothStack[++top1] = element;
        } else if (i == 2) {
            //栈2入栈
            //特别要注意先--，而且默认栈2在右侧
            bothStack[--top2] = element;
        } else {        //必要的拦截一下非法输入
            throw new StackException("输入非法");
        }
    }
    
    /**
     * 出栈操作
     * @param i 准备出栈的栈
     * @return 弹出的元素
     */
    public T pop(int i) {
        T result = null;
        if (i == 1) {
            if (top1 == -1) {       //栈1空
                throw new StackException("栈1空");
            }
            //先取元素出栈1再--
            result = bothStack[top1--];
        } else if (i == 2) {
            if (top2 == STACK_SIZE) {       //栈2空
                throw new StackException("栈2空");
            }
            //先取元素出栈2再++
            result = bothStack[top2++];
        } else {        //必要的拦截一下非法输入
            throw new StackException("输入非法");
        }
        return result;
    }

}
