package org.structures.sort;

public class Sort implements SortInterface {

    //定义待排序序列
    private final int[] record;

    //定义待排序序列长度
    private final int length;

    public Sort(int[] record, int n) {
        this.record = record;
        this.length = n;
    }

    @Override
    public void insertSort() {
        int temp, position;
        //排序进行length-1趟
        for (int i = 1; i < length; i++) {
            //暂存待插记录
            temp = record[i];
            //寻找插入位置
            for (position = i; position > 0 && temp < record[position-1] ; position--) {
                //符合循环条件的依次右移一位
                record[position] = record[position-1];
            }
            //插入元素
            record[position] = temp;
        }
    }

    @Override
    public void shellSort() {
        int temp, position;
        //增量为d时直接插入排序
        for (int d = length/2; d >= 1; d /= 2) {
            for (int i = d; i < length; i++) {
                //暂存待插记录
                temp = record[i];
                for (position = i; position - d >= 0 && temp < record[position-d]; position-= d) {
                    //记录后移d位
                    record[position] = record[position-d];
                }
                record[position] = temp;
            }
        }
    }

    @Override
    public void bubbleSort() {
        //第一趟冒泡排序的区间是r[0]~r[length-1]
        int exchange = length - 1;
        int position, bound, temp;
        //当上一趟排序有记录交换的时候
        while (exchange != 0) {
            bound = exchange;
            exchange = 0;
            for (position = 0; position < bound; position++) {
                if (record[position] > record[position+1]) {
                    temp = record[position];
                    record[position] = record[position+1];
                    record[position+1] = temp;
                    //记载每一次记录交换的位置
                    exchange = position;
                }
            }
        }
    }

    //一次划分的算法
    private int partition(int first, int last) {
        //初始化一次划分区间
        int i = first, j = last, temp;
        while (i < j) {
            //右侧扫描
            while (i < j && record[i] <= record[j]) {
                j--;
            }
            //将较小记录交换到前面
            if (i < j) {
                temp = record[i];
                record[i] = record[j];
                record[j] = temp;
                i++;
            }
            //左侧扫描
            while (i < j && record[i] <= record[j]) {
                i++;
            }
            //将较大记录交换到后面
            if (i < j) {
                temp = record[i];
                record[i] = record[j];
                record[j] = temp;
                j--;
            }
        }
        //i为轴值记录的最终位置
        return i;
    }

    @Override
    public void quickSort(int first, int end) {
        if (first < end) {
            //一次划分
            int pivot = partition(first, end);
            //对左侧子序列快速排序
            quickSort(first, pivot-1);
            //对右侧子序列快速排序
            quickSort(pivot+1, end);
        }
    }

    @Override
    public void selectSort() {
        int index, temp;
        //n-1趟的简单排序
        for (int i = 0; i < length; i++) {
            index = i;
            //在无序区查找最小记录，并置于新有序区最后一位
            for (int scan = i+1; scan < length; scan++) {
                if (record[scan] < record[index]) {
                    index = scan;
                }
            }
            if (index != 1) {
                temp = record[i];
                record[i] = record[index];
                record[index] = temp;
            }
        }
    }

    //左右子树都是大根堆，实现指定节点调整
    private void sift(int key, int last) {
        //暂存变量
        int temp;
        //siftNode为待调整结点
        int siftNode = key;
        //max初始化为siftNode的左孩子
        int max = 2 * siftNode + 1;
        while (max <= last) {
            //选取左右孩子较大者
            if (max < last && record[max] < record[max+1]) {
                max++;
            }
            //已经是堆
            if (record[siftNode] > record[max]) {
                break;
            } else {
                //待调整结点与max互换
                temp = record[siftNode];
                record[siftNode] = record[max];
                record[max] = temp;
                //siftNode、max重新赋值，准备下一趟调整
                siftNode = max;
                max = 2 * siftNode + 1;
            }
        }
    }

    @Override
    public void heapSort() {
        int temp = 0;
        //从最后一个分支节点至根结点
        for (int index = length/2-1; index >= 0; index--) {
            sift(index, length-1);
        }
        for (int i = 1; i < length; i++) {
            //暂存最大元素
            temp = record[0];
            //最右叶子放到根结点
            record[0] = record[length-i];
            record[length-i] = temp;
            //对 r[0]~r[length-i-1]建堆
            sift(0, length-i-1);
        }
    }

    private void merge(int first1, int last1, int last2) {
        //定义辅助数组temp
        int [] temp = new int[length];
        //设置两个待合并的起止区间
        int i = first1, j = last1 + 1, index = first1;
        //依次取两序列中小者放入temp
        while (i <= last1 && j <= last2) {
            if (record[i] <= record[j]) {
                temp[index++] = record[i++];
            } else {
                temp[index++] = record[j++];
            }
        }
        //对第一个子序列进行收尾处理
        while (i <= last1) {
            temp[index++] = record[i++];
        }
        //对第二个子序列进行收尾处理
        while (j <= last2) {
            temp[index++] = record[j++];
        }
        //将合并后的结果传回数组record
        for (index = first1; index <= last2; index++) {
            record[index] = temp[index];
        }
    }

    @Override
    public void mergeSort1(int first, int last) {
        //待排序的序列只有一条记录，递归结束
        if (first == last) {
            return;
        } else {
            int mid = (first + last)/2;
            //归并排序前半个序列
            mergeSort1(first, mid);
            //归并排序后半个序列
            mergeSort1(mid+1, last);
            //将已排序的两个序列合并
            merge(first, mid, last);
        }
    }

    private void mergePass(int h) {
        int i = 0;
        //有两个长度为h的子序列
        while (i <= length - 2*h + 1) {
            merge(i, i+h-1, i+2*h-1);
            i += 2*h;
        }
        //子序列有一个长度小于h
        if (i < length - h + 1) {
            merge(i, i+h-1, length-1);
        }
    }

    @Override
    public void mergeSort2() {
        //初始时子序列长度为1
        int h = 1;
        while (h < length) {
            //一趟排序
            mergePass(h);
            h*=2;
        }
    }

    @Override
    public void print() {
        for (int i : record) {
            System.out.print(i + " ");
        }
    }

}
