package com.zipcodewilmington.dashamaps;

public class GenericNode<K, V> {

    private K key;
    private V value;
    private GenericNode next;

    public GenericNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public GenericNode<K,V> getNext() {
        return next;
    }

    public void setNext(GenericNode next) {
        this.next = next;
    }

    public Boolean hasNext() {
        return this.next != null;
    }
}
