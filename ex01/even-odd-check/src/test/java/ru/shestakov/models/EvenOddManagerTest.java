package ru.shestakov.models;

import org.junit.Assert;
import org.junit.Test;

public class EvenOddManagerTest {

    @Test
    public void whenOddThenReturnCorrectValue() {
        EvenOddManager manager = new EvenOddManager();
        Assert.assertEquals(manager.check("10"), "even");
    }

    @Test
    public void whenEvenThenReturnCorrectValue() {
        EvenOddManager manager = new EvenOddManager();
        Assert.assertEquals(manager.check("11"), "odd");
    }

}