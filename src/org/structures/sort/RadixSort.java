package org.structures.sort;

class LinkedNode<T> {

    //定义结点泛型数据域
    private T data;

    //定义结点后继引用域
    private LinkedNode<T> next;

    //无参构造函数，构造空结点
    public LinkedNode() {
        data = null;
        next = null;
    }

    //构造数据域为element的结点
    public LinkedNode(T element) {
        data = element;
        next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T element) {
        this.data = element;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedNode<T> successor) {
        this.next = successor;
    }

}

public class RadixSort {

    /**
     * 基数排序算法
     * @param first
     * @param digit 记录的位数
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void radixSort(LinkedNode first, int digit) {
        //存储队头引用
        LinkedNode[] front = new LinkedNode[10];
        //存储队尾引用
        LinkedNode[] rear  = new LinkedNode[10];
        //首尾相接时引用队尾
        LinkedNode tail = new LinkedNode();
        //base为被除数
        int key, base = 1;
        for (int i = 1; i < digit; i++) {
            //清空队列
            for (int j = 0; j < 10; j++) {
                front[j] = rear[j] = null;
            }
            //将记录分配到队列中
            while (first != null) {
                key = ((Integer)first.getData() / base) % 10;
                if (front[key] == null) {
                    front[key] = rear[key] = first;
                } else {
                    rear[key].setNext(first);
                    rear[key] = first;
                }
                first = first.getNext();
            }
            //收集、将队列首尾相接
            for (int j = 0; j < 10; j++) {
                if (front[j] == null) {
                    continue;
                }
                if (first == null) {
                    first = front[j];
                } else {
                    tail.setNext(front[j]);
                }
                tail = rear[j];
            }
        }
    }

}
