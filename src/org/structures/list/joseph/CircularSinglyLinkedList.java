package org.structures.list.joseph;

import org.structures.list.linked.LinkedNode;

public class CircularSinglyLinkedList {
    
    /**
     * 尾引用
     */
    protected LinkedNode<Integer> rear;
    
    /**
     * 头引用
     */
    protected LinkedNode<Integer> first;
    
    public CircularSinglyLinkedList() {
        rear = null;
    }
    
    public void joseph(int n, int m) {
        //createCircular函数初始化n个结点的约瑟夫环
        createCircular(n);
        //初始化pre为表尾
        LinkedNode<Integer> pre = rear;
        //初始化p为表头
        LinkedNode<Integer> p = rear.getNext();
        //初始化计数器count
        int count = 1;
        System.out.println("出环的顺序为：");
        //循环到环中只剩一个结点
        while (p.getNext() != p) {
            //计数器未累加到密码值
            if (count < m) {
                pre = p;
                p = p.getNext();
                count++;
            } else {    //累加器加到密码值
                System.out.print(p.getData() + " ");
                //删除p结点
                pre.setNext(p.getNext());
                //p赋为pre当前后继
                p = pre.getNext();
                //count赋值1，重新计数
                count = 1;
            }
        }
        //输出最后一个结点编号
        System.out.print(p.getData() + " ");
    }
    
    /**
     * 根据参数n生成循环单链表
     * @param n
     */
    protected void createCircular(int n) {
        //生成第一个结点，赋给尾引用
        rear = new LinkedNode<>(1);
        first = rear;
        //依次尾插入2、3、...、n新结点
        for (int i = 2; i <= n; i++) {
            LinkedNode<Integer> node = new LinkedNode<>(i);
            rear.setNext(node);
            rear = node;
        }
        //尾结点引用赋值为头结点，形成循环链表
        rear.setNext(first);
    }

}
