package com.zipcodewilmington.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        String actualB = mappTwo.delete("other");
        String actualC = mappThree.delete("other");
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actualB);
        Assert.assertEquals(expected, actualC);
    }

    @Test
    public void get() {
        String expected = "9";
        String actual = mapp.get("other");
        String actualB = mappTwo.get("other");
        String actualC = mappThree.get("other");
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actualB);
        Assert.assertEquals(expected, actualC);
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(mapp.isEmpty());
        Assert.assertFalse(mappTwo.isEmpty());
        Assert.assertFalse(mappThree.isEmpty());
    }

    @Test
    public void size() {
        Long expected = 123l;
        Long actual = mapp.size();
        Long actualB = mappTwo.size();
        Long actualC = mappThree.size();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actualB);
        Assert.assertEquals(expected, actualC);
    }

    @Test
    public void bucketSize() {
        Integer expected = 14;
        Integer expectedB = 9;
        Integer actual = mapp.bucketSize("a");
        Integer actualB = mappTwo.bucketSize("a");
        Integer actualC = mappThree.bucketSize("a");
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedB, actualB);
        Assert.assertEquals(expected, actualC);
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
