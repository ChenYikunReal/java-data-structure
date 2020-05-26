package org.structures.advanced.memory_cell;
//  Object read( )         -->  Returns the stored value
//  void write( Object x ) -->  x is stored

public class MemoryCell<T> {

    private T storedValue;

    public MemoryCell() {}

    public MemoryCell(T storedValue) {
        this.storedValue = storedValue;
    }

    public T read() {
        return storedValue;
    }

    public void write(T x) {
        storedValue = x;
    }

}
