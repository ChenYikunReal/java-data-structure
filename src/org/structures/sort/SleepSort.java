package org.structures.sort;

/**
 * 玄学的开始——构造线程子类
 */
class SleepSortThread extends Thread {
    //待排序的数
    private int data = 0;

    public SleepSortThread(int data){
        this.data = data;
    }

    @Override
    public void run(){
        try {
            //睡眠指定的时间为数值的10倍再加上10
            sleep(data * 10 + 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //输出该数
        System.out.println(data);
    }
}

public class SleepSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 100, 30};
        //创建指定长度的线程数组
        SleepSortThread[] threadList = new SleepSortThread[array.length];
        //指定线程数组中每个线程的值data
        for (int i = 0; i < threadList.length; i++) {
            threadList[i] = new SleepSortThread(array[i]);
        }
        //开启每个线程
        for (SleepSortThread thread : threadList) {
            thread.start();
        }
    }

}
