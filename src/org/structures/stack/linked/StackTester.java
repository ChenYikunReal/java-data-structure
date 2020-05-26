package org.structures.stack.linked;

import org.structures.stack.StackInterface;

public class StackTester {
    
    public static void main(String[] args) {
        StackInterface<String> stack = new LinkedStack<>();
        //元素入栈
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        //读取栈顶元素
        System.out.println("栈顶元素为：" + stack.getTop());
        stack.pop();
        stack.pop();
        stack.push("e");
        System.out.println("栈顶元素为：" + stack.getTop());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("栈是否为空：" + stack.isEmpty());
    }

}
