package org.structures.advanced.memory_cell;

public class MemoryCellTest {
    public static void main(String [] args) {
        MemoryCell<Integer> m = new MemoryCell<>(7);
        System.out.println("Contents are: " + m.read());
        m.write(5);
        System.out.println("Contents are: " + m.read());
    }
}