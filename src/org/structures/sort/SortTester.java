package org.structures.sort;

import java.util.Scanner;

public class SortTester {

    public static void main(String[] args) {
        int[] record = {2, 5, 1, 7, 9, 4, 3, 6, 5, 8};
        SortInterface sort = new Sort(record, record.length);
        System.out.print("1.直接插入排序\n"
                + "2.希尔排序\n"
                + "3.冒泡排序\n"
                + "4.快速排序\n"
                + "5.简单选择排序\n"
                + "6.堆排序\n"
                + "7.二路归并递归排序\n"
                + "8.二路归并非递归排序\n"
                + "请选择使用的排序技术编号>");
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 1 :
                sort.insertSort();
                break;
            case 2:
                sort.shellSort();
                break;
            case 3:
                sort.bubbleSort();
                break;
            case 4:
                sort.quickSort(0, record.length-1);
                break;
            case 5:
                sort.selectSort();
                break;
            case 6:
                sort.heapSort();
                break;
            case 7:
                sort.mergeSort1(0, record.length-1);
                break;
            case 8:
                sort.mergeSort2();
                break;
            default :
                System.out.println("输入错误!");
        }
        sort.print();
        scanner.close();
    }

}
