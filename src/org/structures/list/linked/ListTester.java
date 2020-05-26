package org.structures.list.linked;

import org.structures.Person;
import org.structures.list.ListInterface;

public class ListTester {
    
    public static void main(String[] args) {
        String[] initialList = {"a", "b", "c", "d", "e", "f"};
        ListInterface<String> list = new LinkedList<>(initialList);
        System.out.println("线性表长度" + list.length());
        System.out.println("当前线性表遍历结果：");
        list.printList();
        String list_2 = list.getElement(2);
        System.out.println("2号元素为：" + list_2);
        int locate_d = list.locate("d");
        System.out.println("元素d的逻辑位是：" + locate_d);
        System.out.println("在位置3处插入k");
        list.insert(3, "k");
        String list_3 = list.getElement(3);
        System.out.println("3号元素为：" + list_3);
        System.out.println("线性表长度：" + list.length());
        System.out.println("当前线性表遍历结果：");
        list.printList();
        System.out.println("删除位置3的元素");
        String deleteElement = list.delete(3);
        System.out.println("删除的数据元素是：" + deleteElement);
        System.out.println("线性表长度：" + list.length());
        System.out.println("当前线性表遍历结果：");
        list.printList();
        
        //**********************Person***********************************
        System.out.println("下面处理对象由Integer换成Person");
        Person[] personArray = new Person[3];
        personArray[0] = new Person("李华", 1);
        personArray[1] = new Person("李刚", 2);
        personArray[2] = new Person("李强", 3);
        ListInterface<Person> personList = new LinkedList<>(personArray);
        personList.printList();
        
        System.out.println("添加新用户");
        personList.insert(personList.length()+1, new Person("王明", 4));
        personList.printList();
        
        System.out.println("位置2添加新用户");
        personList.insert(2, new Person("王冰", 5));
        personList.printList();
        
        System.out.println("删除指定0索引处用户");
        personList.delete(0);
        personList.printList();
    }

}
