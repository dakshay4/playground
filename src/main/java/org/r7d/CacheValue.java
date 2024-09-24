package org.r7d;


public class CacheValue {


    private final Object key;
    private final Object value;
    private final long validityInMillis;
    private Long lastUsedTime;

    public static class Pair {
        public String element;
        public Integer index;

        public String getElement() {
            return element;
        }

        public void setElement(String element) {
            this.element = element;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
    }

    public CacheValue(Object key, Object value, long validityInMillis) {
        this.key = key;
        this.value = value;
        this.validityInMillis = validityInMillis;
        this.lastUsedTime = System.currentTimeMillis();
    }
    public CacheValue(Object key, Object value) {
        this.key = key;
        this.value = value;
        this.validityInMillis = 365 * 24 * 60 * 60 * 50; // 50 Years Default;
        this.lastUsedTime = System.currentTimeMillis();
    }

    public Object getKey() {
        this.lastUsedTime = System.currentTimeMillis();
        return key;
    }

    public Object getValue() {
        return value;
    }

    public double getValidityInMillis() {
        return validityInMillis;
    }

    public Long getExpiryEpoch(){
        return this.lastUsedTime + this.validityInMillis;
    }

}
