package com.zipcodewilmington.dashamaps;

public class GenericDashaMap<K, V> {

    private GenericNode<K,V>[] nodes;
    private Integer mapSize;

    public GenericDashaMap() {
        nodes = new GenericNode[26];
        mapSize = 0;
    }

    private String HashFunctionOne(K input) {
        String hash;
        if (input instanceof String) {
            hash = (String)input;
        } else {
            hash = input.toString();
        }
        if (hash.length() > 0) {
            return (String.valueOf(hash.charAt(0))).toLowerCase();
        }
        return null;
    }

    public void set(K key, V value) {
        String hashCode = HashFunctionOne(key);
        int index = hashCode.charAt(0) - 'a';
        try {
            GenericNode<K, V> newNode = new GenericNode(key, value);
            GenericNode<K, V> head = nodes[index];
            if (head == null) {
                nodes[index] = newNode;
            } else {
                while (head.hasNext()) {
                    head = head.getNext();
                }
                head.setNext(newNode);
            }
            mapSize++;
        } catch (NumberFormatException ex) { }
    }

    public V delete(K key) {
        String hashCode = HashFunctionOne(key);
        int index = hashCode.charAt(0) - 'a';
        GenericNode<K, V> head = nodes[index];
        V valueRemoved = null;

        if (head.getKey().equals(key)) {
            valueRemoved = head.getValue();
            nodes[index] = head.getNext();
        }

        while (head.hasNext()) {
            if (head.getNext().getKey().equals(key)) {
                valueRemoved = head.getNext().getValue();
                head.setNext(head.getNext().getNext());
                mapSize--;
                break;
            }
            head = head.getNext();
        }
        return valueRemoved;
    }

    public V get(K key) {
        String hashCode = HashFunctionOne(key);
        int index = hashCode.charAt(0) - 'a';
        GenericNode<K, V> head = nodes[index];

        if (head != null && head.getKey().equals(key)) {
            return head.getValue();
        }

        while (head != null && head.hasNext()) {
            if (head.getNext().getKey().equals(key)) {
                return head.getNext().getValue();
            }
            head = head.getNext();
        }
        return null;
    }


    public boolean isEmpty() {
        for (GenericNode node : nodes) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }


    public long size() {
        return mapSize;
    }


    public Integer bucketSize(K key) {
        String hashCode = HashFunctionOne(key);
        int index = hashCode.charAt(0) - 'a';
        GenericNode<K,V> head = nodes[index];
        Integer entries = 0;

        if (head != null) {
            entries++;
        }

        while (head.hasNext()) {
            entries++;
            head = head.getNext();
        }

        return entries;
    }
}
