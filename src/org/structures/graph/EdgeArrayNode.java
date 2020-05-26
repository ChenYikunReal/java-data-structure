package org.structures.graph;

public class EdgeArrayNode {
    
    private int from;
    
    private int to;
    
    private int weight;

    public EdgeArrayNode(int from, int to, int weight) {
        super();
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
