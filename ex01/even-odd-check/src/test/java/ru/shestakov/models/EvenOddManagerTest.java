package ru.shestakov.models;

import org.junit.Assert;
import org.junit.Test;

public class EvenOddManagerTest {

    @Test
    public void whenEvenThenReturnTrue() {
        EvenOddManager manager = new EvenOddManager();
        Assert.assertTrue(manager.check("10"));
    }

    @Test
    public void whenOddThenReturnFalse() {
        EvenOddManager manager = new EvenOddManager();
        Assert.assertTrue(!manager.check("11"));
    }

}