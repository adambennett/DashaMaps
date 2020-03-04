package com.zipcodewilmington.dashamaps;

import com.zipcodewilmington.dashamaps.interfaces.HashMapX;

public class DashaMapOne implements HashMapX {

    private Node[] nodes;
    private Integer mapSize;

    public DashaMapOne() {
        nodes = new Node[26];
        mapSize = 0;
    }

    private String HashFunctionOne(String input) {
        if (input.length() > 0) {
            return (String.valueOf(input.charAt(0))).toLowerCase();
        }
        return null;
    }

    @Override
    public void set(String key, String value) {
        String hashCode = HashFunctionOne(key);
        int index = hashCode.charAt(0) - 'a';
        try {
            Node newNode = new Node(key, Integer.parseInt(value));
            Node head = nodes[index];
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

    @Override
    public String delete(String key) {
        String hashCode = HashFunctionOne(key);
        int index = hashCode.charAt(0) - 'a';
        Node head = nodes[index];
        String valueRemoved = "";

        if (head.getKey().equals(key)) {
            valueRemoved = head.getValue().toString();
            nodes[index] = head.getNext();
        }

        while (head.hasNext()) {
            if (head.getNext().getKey().equals(key)) {
                valueRemoved = head.getNext().getValue().toString();
                head.setNext(head.getNext().getNext());
                mapSize--;
                break;
            }
            head = head.getNext();
        }
        return valueRemoved;
    }

    @Override
    public String get(String key) {
        String hashCode = HashFunctionOne(key);
        int index = hashCode.charAt(0) - 'a';
        Node head = nodes[index];

        if (head != null && head.getKey().equals(key)) {
            return head.getValue().toString();
        }

        while (head != null && head.hasNext()) {
            if (head.getNext().getKey().equals(key)) {
                return head.getNext().getValue().toString();
            }
            head = head.getNext();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        for (Node node : nodes) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long size() {
        return mapSize;
    }

    @Override
    public Integer bucketSize(String key) {
        String hashCode = HashFunctionOne(key);
        int index = hashCode.charAt(0) - 'a';
        Node head = nodes[index];
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
