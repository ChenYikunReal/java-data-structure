package org.structures.queue.deque.doubledeque;

import org.structures.queue.QueueException;

public class DoubleDequeTester {

    public static void main(String[] args) {
        DoubleDequeInterface<String> deque = new DoubleDeque<>();
        System.out.println("双端队列" + (deque.isEmpty() ? "" : "不") + "为空");
        deque.enQueue("a");
        deque.enQueue("b");
        System.out.println("队头元素为：" + deque.getHead());
        System.out.println("双端队列" + (deque.isEmpty() ? "" : "不") + "为空");
        deque.enQueue("c");
        deque.enQueue("d");
        System.out.println("队头元素为：" + deque.getHead());
        System.out.println("双端队列" + (deque.isEmpty() ? "" : "不") + "为空");
        System.out.println("出队元素为：" + deque.deQueue());
        deque.deQueue();
        System.out.println("队头元素为：" + deque.getHead());
        System.out.println("双端队列" + (deque.isEmpty() ? "" : "不") + "为空");
        deque.enQueue("e");
        deque.deQueue();
        deque.deQueue();
        System.out.println("出队元素为：" + deque.deQueue());
        System.out.println("双端队列" + (deque.isEmpty() ? "" : "不") + "为空");
        System.out.println("-------------------------------");
        deque.headPush("1");
        deque.headPush("2");
        deque.headPush("3");
        System.out.println("队头栈顶元素为：" + deque.getHead());
        deque.headPush("4");
        System.out.println("队头出栈元素为：" + deque.headPop());
        deque.headPop();
        System.out.println("队头栈顶元素为：" + deque.getHead());
        System.out.println("双端队列" + (deque.isEmpty() ? "" : "不") + "为空");
        deque.headPop();
        deque.headPush("5");
        deque.headPush("6");
        deque.headPop();
        System.out.println("队头出栈元素为：" + deque.headPop());
        System.out.println("队头出栈元素为：" + deque.headPop());
        try {
            deque.headPop();
        } catch (QueueException e) {
            System.out.println("出栈异常");
        }
        System.out.println("双端队列" + (deque.isEmpty() ? "" : "不") + "为空");
        System.out.println("-------------------------------");
        deque.rearPush("A");
        deque.rearPush("B");
        deque.rearPush("C");
        System.out.println("队尾栈顶元素为：" + deque.getRear());
        deque.rearPush("D");
        System.out.println("队尾出栈元素为：" + deque.rearPop());
        deque.rearPop();
        System.out.println("队尾栈顶元素为：" + deque.getRear());
        deque.rearPop();
        deque.rearPush("E");
        deque.rearPush("F");
        deque.rearPop();
        System.out.println("队尾出栈元素为：" + deque.rearPop());
        System.out.println("队尾出栈元素为：" + deque.rearPop());
        System.out.println("双端队列" + (deque.isEmpty() ? "" : "不") + "为空");
    }

}
