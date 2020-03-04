package com.zipcodewilmington.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class WordListTest {

    private DashaMapOne mapp;
    private DashaMapTwo mappTwo;
    private DashaMapThree mappThree;

    @Before
    public void setup() {
        mapp = new DashaMapOne();
        mappTwo = new DashaMapTwo();
        mappThree = new DashaMapThree();
        setupMaps();
    }

    @Test
    public void delete() {
        String expected = "9";
        String actual = mapp.delete("other");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
        String expected = "9";
        String actual = mapp.get("other");
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
        Class clazz = WordListTest.class;
        InputStream stream = clazz.getResourceAsStream("/word-list.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splice = line.split(" ");
                if (splice.length == 2) {
                    mapp.set(splice[0], splice[1]);
                    mappTwo.set(splice[0], splice[1]);
                    mappThree.set(splice[0], splice[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
