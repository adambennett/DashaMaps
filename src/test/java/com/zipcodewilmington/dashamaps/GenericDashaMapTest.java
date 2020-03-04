package com.zipcodewilmington.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GenericDashaMapTest {

    private GenericDashaMap<String, Integer> mapp;

    @Before
    public void setup(){
        mapp = new GenericDashaMap<String, Integer>();
        mapp.set("Adam", 1);
        mapp.set("Is", 2);
        mapp.set("A", 3);
        mapp.set("Cool", 4);
        mapp.set("Guy", 5);
    }

    @Test
    public void delete() {
        Integer expected = 1;
        Integer actual = mapp.delete("Adam");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
        Integer expected = 1;
        Integer actual = mapp.get("Adam");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmpty() {
        mapp.delete("Adam");
        mapp.delete("Is");
        mapp.delete("A");
        mapp.delete("Cool");
        Assert.assertFalse(mapp.isEmpty());
        mapp.delete("Guy");
        Assert.assertTrue(mapp.isEmpty());
    }

    @Test
    public void size() {
        Long expected = 5l;
        Long actual = mapp.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bucketSize() {
        Integer expected = 2;
        Integer actual = mapp.bucketSize("a");
        Assert.assertEquals(expected, actual);
    }
}