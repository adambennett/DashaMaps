package com.zipcodewilmington.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DashaMapTwoTest {

    private DashaMapTwo mapp;

    @Before
    public void setup(){
        mapp = new DashaMapTwo();
        mapp.set("Adam", "1");
        mapp.set("Is", "2");
        mapp.set("A", "3");
        mapp.set("Add", "6");
        mapp.set("Cool", "4");
        mapp.set("Guy", "5");
    }

    @Test
    public void delete() {
        String expected = "1";
        String actual = mapp.delete("Adam");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
        String expected = "1";
        String actual = mapp.get("Adam");
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
        mapp.delete("Add");
        Assert.assertTrue(mapp.isEmpty());
    }

    @Test
    public void size() {
        Long expected = 6l;
        Long actual = mapp.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bucketSize() {
        Integer expected = 2;
        Integer actual = mapp.bucketSize("d");
        Assert.assertEquals(expected, actual);
    }
}