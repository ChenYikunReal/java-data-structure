package org.structures.queue.stackqueue;

import org.structures.queue.QueueInterface;

public class StackQueueTester {

    public static void main(String[] args) {
        QueueInterface<String> queue = new StackQueue<>();
        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        queue.enQueue("d");
        System.out.println("队头元素为：" + queue.getHead());
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        System.out.println("队头元素为：" + queue.getHead());
        queue.enQueue("e");
        queue.deQueue();
        System.out.println("队头元素为：" + queue.getHead());
        queue.deQueue();
        System.out.println("队列是否为空：" + queue.isEmpty());
    }

}
