package org.r7d.misc;

public class Direction {

    private int capacity;
    private Integer from;
    private Integer to;

    public Direction(int capacity, Integer from, Integer to) {
        this.capacity = capacity;
        this.from = from;
        this.to = to;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "capacity=" + capacity +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
