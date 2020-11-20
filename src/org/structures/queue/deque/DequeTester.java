package org.structures.queue.deque;

import org.structures.queue.QueueInterface;
import org.structures.stack.StackInterface;

public class DequeTester {

    public static void main(String[] args) {
        System.out.println("-------------------------------");
        // 将双端队列当做队列使用
        QueueInterface<String> queue = new Deque<>();
        // 元素入队
        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        queue.enQueue("d");
        // 读取队首元素
        System.out.println("队头元素为：" + queue.getHead());
        // 元素出队
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        System.out.println("队头元素为：" + queue.getHead());
        System.out.println("队列" + (queue.isEmpty() ? "" : "不") + "为空");
        queue.enQueue("e");
        queue.deQueue();
        System.out.println("队头元素为：" + queue.getHead());
        queue.deQueue();
        System.out.println("队列" + (queue.isEmpty() ? "" : "不") + "为空");
        System.out.println("-------------------------------");
        // 将双端队列当做栈使用
        StackInterface<String> stack = new Deque<>();
        // 元素入栈
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        // 读取栈顶元素
        System.out.println("栈顶元素为：" + stack.getTop());
        // 元素出栈
        stack.pop();
        System.out.println("出栈元素为：" + stack.pop());
        System.out.println("栈" + (stack.isEmpty() ? "" : "不") + "为空");
        stack.push("e");
        System.out.println("栈顶元素为：" + stack.getTop());
        stack.pop();
        System.out.println("栈顶元素为：" + stack.getTop());
        stack.pop();
        System.out.println("出栈元素为：" + stack.pop());
        System.out.println("栈" + (stack.isEmpty() ? "" : "不") + "为空");
    }

}
