package org.structures.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class SortThread extends Thread {

    //待排序列
    private final List<Integer> array;

    //起始时间
    private final Date startTime;

    //排序次数
    private int sum;

    public SortThread(List<Integer> array, Date startTime, int sum) {
        this.array = array;
        this.startTime = startTime;
        this.sum = sum;
    }

    @Override
    public void run() {
        //使用默认随机源对列表进行置换，所有置换发生的可能性都是大致相等的(打乱重组)
        Collections.shuffle(array);
        //这个打印相当于toString()
        System.out.println(array);
        for (int i = 0; i < array.size()-1; i++) {
            if (array.get(i) >= array.get(i+1)) {
                sum++;
                new SortThread(array, startTime, sum).start();
                //结束当前线程
                return;
            }
        }
        System.out.println("花费" + (new Date().getTime() - startTime.getTime()) + "ms时间\n排序数组元素个数:" + array.size() + "\n共进行了" + sum + "次");
    }
}

public class BogoSort {

    public static void main(String[] args) {
        int[] data = {3, 15, 7, 777, 88};
        //int[] -> List<Integer>
        List<Integer> list = Arrays.stream(data).boxed().collect(Collectors.toList());
        int sum = 0;
        Date startTime = new Date();
        SortThread sortThread = new SortThread(list, startTime, sum);
        sortThread.start();
    }

}
