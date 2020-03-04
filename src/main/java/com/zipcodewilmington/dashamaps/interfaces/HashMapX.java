package com.zipcodewilmington.dashamaps.interfaces;

public interface HashMapX {
    void set(String key, String value);
    String delete(String key);
    String get(String key);
    boolean isEmpty();
    long size();
    Integer bucketSize(String key);
}
