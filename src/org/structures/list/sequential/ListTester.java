package org.structures.list.sequential;

import org.structures.list.ListInterface;

public class ListTester {
    
    public static void main(String[] args) {
        String[] initialList = {"a", "b", "c", "d", "e", "f"};
        ListInterface<String> list = new SequentialList<>(initialList, 6);
        System.out.println("线性表长度" + list.length());
        System.out.println("当前线性表遍历结果：");
        list.printList();
        String list_2 = list.getElement(2);
        System.out.println("2号元素为：" + list_2);
        int locate_d = list.locate("d");
        System.out.println("数据元素d的逻辑位为" + locate_d);
        System.out.println("在位置3出插入k");
        list.insert(3, "k");
        String list_3 = list.getElement(3);
        System.out.println("3号元素为：" + list_3);
        System.out.println("线性表长度：" + list.length());
        System.out.println("当前线性表遍历结果：");
        list.printList();
        System.out.println("删除位置3元素");
        String deleteElement = list.delete(3);
        System.out.println("被删除的元素是：" + deleteElement);
        System.out.println("线性表的长度：" + list.length());
        System.out.println("当前线性表遍历结果：");
        list.printList();
    }

}
