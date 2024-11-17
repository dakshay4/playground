package org.r7d;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LruCache {


    private final Map<Object, CacheValue> cache;
    private final PriorityQueue<CacheValue> timeLruCache;




    private final int capacity;

    public LruCache( int capacity) {
        this.cache = new ConcurrentHashMap<>();
        this.capacity = capacity;
        this.timeLruCache = new PriorityQueue<>(new Comparator<CacheValue>() {
            @Override
            public int compare(CacheValue o1, CacheValue o2) {
                return 0;
            }
        });
    }



    public Object get(Object key) {
       CacheValue cacheValue = cache.get(key);
       return cacheValue!=null ? cacheValue.getValue() : null;
    }

    public boolean put(Object key, Object value, int expirationTime) {
        removeLRUCache();
        CacheValue cacheValue = new CacheValue(key, value, expirationTime);
        cache.put(key, cacheValue);
        timeLruCache.add(cacheValue);
        System.out.println("Successfully added in cache " + key);
        return true;
    }

    private void removeLRUCache() {
        if(timeLruCache.size()>=capacity){
            CacheValue cacheValue = timeLruCache.poll();
            cache.remove(cacheValue.getKey());
            System.out.println("Removing from cache as capacity is full " + cacheValue.getKey());
            removeLRUCache();
        }

    }


    public List<CacheResponse> display() {
        List<CacheResponse> cacheResponses = new ArrayList<>();
        cache.forEach((key,cacheValue) ->{
            if(cacheValue==null) return;
            CacheResponse cacheResponse = new CacheResponse(key, cacheValue.getValue());
            cacheResponses.add(cacheResponse);
        });
        return cacheResponses;
    }

    public static void main(String[] args) throws InterruptedException {
        LruCache lruCache = new LruCache(5);
        lruCache.put("Muthu", "1", 8000);
        Thread.sleep(1000);
        lruCache.put("Dakshay", "2", 1000);
        Thread.sleep(1000);
        lruCache.put("Swati", "3", 10000);
        Thread.sleep(1000);
        lruCache.put("Rahul", "4", 1000);
        lruCache.put("Ajay", "5", 3000);
        lruCache.put("ABC", "6", 3000);
        lruCache.put("PQR", "7", 3000);


        List<CacheResponse> cacheResponses = lruCache.display();
        cacheResponses.forEach(cacheResponse -> System.out.println(" key " + cacheResponse.getKey() + " value " +cacheResponse.getValue()));
    }
}
