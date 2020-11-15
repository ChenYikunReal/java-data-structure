package org.structures.queue.priority;

public class PriorityQueueTester {

    public static void main(String[] args) {
        QueueInterface<Integer> queue = new PriorityQueue<>();
        queue.enQueue(3);
        queue.enQueue(90);
        queue.enQueue(6);
        queue.enQueue(1);
        queue.enQueue(55);
        queue.enQueue(30);
        System.out.println("出队元素：" + queue.deQueue());
        System.out.println("出队元素：" + queue.deQueue());
        System.out.println("队首元素：" + queue.getHead());
    }

}
