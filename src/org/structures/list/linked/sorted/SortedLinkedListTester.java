package org.structures.list.linked.sorted;

import org.structures.list.ListInterface;

public class SortedLinkedListTester {

    public static void main(String[] args) {
        String[] initialList = {"a", "c", "z", "f", "b", "c"};
        SortedLinkedListInterface<String> list = new SortedLinkedList<>(initialList);
        System.out.println("线性表长度" + list.length());
        System.out.println("当前线性表遍历结果：");
        list.printList();
        String list_2 = list.getElement(2);
        System.out.println("2号元素为：" + list_2);
        int locate_d = list.locate("c");
        System.out.println("元素d的逻辑位是：" + locate_d);
        System.out.println("插入k");
        list.insert("k");
        int locate_k = list.locate("k");
        System.out.println("元素k的逻辑位是：" + locate_k);
        System.out.println("线性表长度：" + list.length());
        System.out.println("当前线性表遍历结果：");
        list.printList();
        System.out.println("删除位置3的元素");
        String deleteElement = list.delete(3);
        System.out.println("删除的数据元素是：" + deleteElement);
        System.out.println("线性表长度：" + list.length());
        System.out.println("当前线性表遍历结果：");
        list.printList();
    }

}
