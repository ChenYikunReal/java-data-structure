package org.structures.advanced.int_cell;

public class IntCellTest {
    public static void main(String [] args) {
        IntCell cell = new IntCell(7);
        System.out.println("Cell contents: " + cell.read());
        cell.write(5);
        System.out.println("Cell contents: " + cell.read());
    }
}
