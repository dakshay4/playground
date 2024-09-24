package org.r7d;

public class CacheResponse {

    private final Object key;
    private final Object value;


    public CacheResponse(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
