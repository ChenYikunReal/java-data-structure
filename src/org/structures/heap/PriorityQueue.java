package org.structures.heap;

public class PriorityQueue extends MaxArrayHeap {
    
    int rear = super.count;
    
    public void enQueue(int element) {
        super.addElement(element);
    }
    
    public int deQueue() {
        return super.removeMax();
    }

}
