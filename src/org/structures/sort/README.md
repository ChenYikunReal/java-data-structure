# 内排序

[整理的笔记](https://blog.csdn.net/weixin_43896318/article/details/102472394)

## 鸡尾酒排序
```text
public static void sort(int[] array) {
    int tmp = 0;
    for (int i = 0; i < array.length/2; i++) {
        //有序标记，每一轮初始值都是true
        boolean isSorted = true;
        //奇数轮，从左向右比较和交换
        for (int j = i; j < array.length-i-1; j++) {
            if (array[j] > array[j+1]) {
                tmp = array[j];
                array[j] = array[j+1];
                array[j+1] = tmp;
                //所有元素交换，所以不是有序的，标记变为false
                isSorted = false;
            }
        }
        if (isSorted) {
            break;
        }
        //在偶数轮之前，将isSorted重新标记为true
        isSorted = true;
        //偶数轮，从右向左比较和交换
        for (int j = array.length-i-1; j > i; j--) {
            if (array[j] < array[j-1]) {
                tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = tmp;
                //因为有元素进行交换，所以不是有序的，标记变为false
                isSorted = false;
            }
        }
        if (isSorted) {
            break;
        }
    }
}
```

## 计数排序
```text
public static int[] countSort(int[] array) {
    //得到数组的最大值和最小值，并计算出差值d
    int max = array[0];
    int min = array[1];
    for (int i = 1; i < array.length; i++) {
        if (array[i] > max) {
            max = array[i];
        }
        if (array[i] < min) {
            min = array[i];
        }
    }
    int d = max - min;
    //创建数组
    int[] countArray = new int[d+1];
    //遍历数组，填充统计数组
    for (int i = 0; i < array.length; i++) {
        countArray[array[i]-min]++;
    }
    //统计数组做变形，后面的元素等于前面的元素之和
    for (int i = 1; i < countArray.length; i++) {
        countArray[i] += countArray[i-1];
    }
    //倒序遍历原始数组，从统计数组找到正确的位置，输出结果到数组
    int sortedArray = new int[array.length];
    for (int i = array,length-1; i >= 0; i--) {
        for (int j = 0; j < countArray[i]; j++) {
            sortedArray[countArray[array[i]-min]-1] = array[i];
            countArray[array[i]-min]--;
        }
    }
    return sortedArray;
}
```

## 桶排序
```text
public static double[] bucketSort(double[] array) {
    //得到数组的最大值和最小值并计算出差值
    double max = array[0];
    double min = array[0];
    for (int i = 1; i < array.length; i++) {
        if (array[i] > max) {
            max = array[i];
        }
        if (array[i] < min) {
            min = array[i];
        }
    }
    double d = max - min;
    //初始化桶
    int bucketNum = array.length;
    ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
    for (int i = 0; i < bucketNum; i++) {
        bucketList.add(new LinkedList<Double>());
    }
    //遍历原始数组，将每个元素放入桶中
    for (int i = 0; i < array.length; i++) {
        int num = (int)((array[i]-min) * (bucketNum-1) / d);
        bucketList.get(num).add(array[i]);
    }
    //对每个桶内部的元素进行排序
    for (int i = 0; i < bucketList.size(); i++) {
        //JDK底层采用了归并排序或者归并排序的优化版本
        Collections.sort(bucketList.get(i));
    }
    //输出全部元素
    double[] sortedArray = new double[array.length];
    int index = 0;
    for (LinkedList<Double> list : bucketList) {
        for (double element : list) {
            sortedArray[index] = element;
            index++;
        }
    }
    return sortedArray;
}
```
