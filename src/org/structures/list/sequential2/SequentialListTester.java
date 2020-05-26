package org.structures.list.sequential2;

import org.structures.Person;

public class SequentialListTester {

    public static void main(String[] args) {
        
        //初始化
        Integer[] intArray = new Integer[4];
        intArray[0] = 100;
        intArray[1] = 200;
        intArray[2] = 1;
        intArray[3] = 133;
        ISequentialList<Integer> list = new SequentialList<>(intArray);
        
        System.out.println("初始化");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        System.out.println("末尾增加元素2000");
        list.add(2000);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        System.out.println("末尾增加线性表");
        list.addAll(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        System.out.println("删除首个元素200");
        Integer removeInt = Integer.parseInt("200");
        list.remove(removeInt);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        System.out.println("是否为空");
        System.out.println(list.isEmpty());
        
        System.out.println("是否包含200");
        System.out.println(list.contains(removeInt));
        
        System.out.println("长度");
        System.out.println(list.size());
        
        System.out.println("是否包含整体");
        ISequentialList<Integer> list2 = new SequentialList<>(intArray);
        System.out.println(list.containsAll(list2));
        
        System.out.println("指定位置增加线性表");
        list.addAll(4, list2);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        System.out.println("获取索引为5的元素");
        System.out.println(list.get(5));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        System.out.println("修改索引为5的元素");
        System.out.println(list.set(5, 10000));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.println("在索引5插入元素2");
        list.add(5, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        System.out.println("删除索引5元素");
        list.remove(5);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        System.out.println("元素1的首索引为");
        System.out.println(list.indexOf(1));
        
        System.out.println("元素1的尾索引为");
        System.out.println(list.lastIndexOf(1));
        
        System.out.println("索引3到7的子串（左闭右开）");
        ISequentialList<Integer> list3 = list.subList(3, 7);
        for (int i = 0; i < list3.size(); i++) {
            System.out.print(list3.get(i) + " ");
        }
        System.out.println();
        
        System.out.println("消除冗余空间");
        list.trimToSize();
        
        System.out.println("清空列表");
        list.clear();
        
        System.out.println("清空列表后的长度");
        System.out.println(list.size());
        
        System.out.println("清空列表后是否为空");
        System.out.println(list.isEmpty());
        
//**********************Person***********************************
        System.out.println("下面处理对象由Integer换成Person");
        Person[] personArray = new Person[3];
        personArray[0] = new Person("李华", 1);
        personArray[1] = new Person("李刚", 2);
        personArray[2] = new Person("李强", 3);
        ISequentialList<Person> personList = new SequentialList<>(personArray);
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
        
        System.out.println("添加新用户");
        personList.add(new Person("王明", 4));
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
        
        System.out.println("索引2添加新用户");
        personList.add(2, new Person("王冰", 5));
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
        
        System.out.println("删除指定用户");
        personList.remove(new Person("李刚", 2));
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
        
        System.out.println("删除指定0索引处用户");
        personList.remove(0);
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
        
        System.out.println("修改1索引处用户");
        personList.set(1, new Person("王莎", 6));
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
    }

}
