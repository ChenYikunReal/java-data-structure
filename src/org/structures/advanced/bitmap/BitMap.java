package org.structures.advanced.bitmap;

public class BitMap {

    // 每一个word是一个long类型元素，对应一个64位二进制元素
    private final long[] words;

    // BitMap的位数大小
    private final int size;

    public BitMap(int size) {
        this.size = size;
        this.words = new long[getWordIndex(size-1)+1];
    }

    /**
     * 判断BitMap某一位的状态
     * @param bitIndex 位图的第bitIndex位
     * @return
     */
    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size-1) {
            throw new IndexOutOfBoundsException("超出BitMap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    /**
     * 把BitMap某一位设置为true
     * @param bitIndex 位图的第bitIndex位
     */
    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size-1) {
            throw new IndexOutOfBoundsException("超出BitMap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    /**
     * 定位BitMap某一位所对应的word
     * @param bitIndex 位图的第bitIndex位
     * @return
     */
    private int getWordIndex(int bitIndex) {
        // 右移6bit 相当于除以64
        return bitIndex >> 6;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(128);
        bitMap.setBit(126);
        bitMap.setBit(75);
        System.out.println(bitMap.getBit(126));
        System.out.println(bitMap.getBit(75));
    }

}
