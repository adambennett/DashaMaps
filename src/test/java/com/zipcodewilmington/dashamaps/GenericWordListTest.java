package com.zipcodewilmington.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GenericWordListTest {

    private GenericDashaMap<String, Integer> mapp;

    @Before
    public void setup() {
        mapp = new GenericDashaMap<String, Integer>();
        setupMaps();
    }

    @Test
    public void delete() {
        Integer expected = 9;
        Integer actual = mapp.delete("other");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
        Integer expected = 9;
        Integer actual = mapp.get("other");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(mapp.isEmpty());
    }

    @Test
    public void size() {
        Long expected = 123l;
        Long actual = mapp.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bucketSize() {
        Integer expected = 14;
        Integer actual = mapp.bucketSize("a");
        Assert.assertEquals(expected, actual);
    }


    private void setupMaps() {
        Class clazz = GenericWordListTest.class;
        InputStream stream = clazz.getResourceAsStream("/word-list.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splice = line.split(" ");
                if (splice.length == 2) {
                    try {
                        mapp.set(splice[0], Integer.parseInt(splice[1]));
                    } catch (NumberFormatException ex) { }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
