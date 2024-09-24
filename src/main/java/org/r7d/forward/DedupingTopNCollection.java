package org.r7d.forward;

import java.util.function.Function;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

public class DedupingTopNCollection<K, E> {

    private final int maxCapacity;
    private final Comparator<E> comparator;
    private final Function<E,K> keyMapper;
    private final Map<K,E> keyToElementMap;
    private final PriorityQueue<E> minHeap;

    public DedupingTopNCollection(int maxCapacity, Comparator<E> comparator, Function<E, K> keyMapper) {
        this.maxCapacity=maxCapacity;
        this.comparator=comparator;
        this.keyMapper=keyMapper;
        this.keyToElementMap = new HashMap<>();
        this.minHeap=new PriorityQueue<>(comparator);
    }

    public void addMinHeap(E e) {
        try {
            minHeap.add(e);
        }catch(Exception ex) {
            System.out.print("unable to add in minheap");
        }
    }

    /**
     * Returns the elements in the collection in descending order.
     */


}