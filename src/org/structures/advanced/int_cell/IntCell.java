package org.structures.advanced.int_cell;

/**
 * A class for simulating an integer memory cell.
 * @author BlankSpace
 */
public class IntCell {

    private int storedValue;

    /**
     * Construct the IntCell.
     * Initial value is 0.
     */
    public IntCell() {
        this(0);
    }

    /**
     * Construct the IntCell.
     * @param initialValue the initial value.
     */
    public IntCell(int initialValue) {
        storedValue = initialValue;
    }

    /**
     * Get the stored value.
     * @return the stored value.
     */
    public int read() {
        return storedValue;
    }

    /**
     * Store a value
     * @param x the number to store.
     */
    public void write(int x) {
        storedValue = x;
    }

}
