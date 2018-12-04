package ru.shestakov.models;

import org.junit.Assert;
import org.junit.Test;

public class SquareManagerTest {

    @Test
    public void whenInputParamsThenReturnCorrectValue() {
        SquareManager sm = new SquareManager();
        Assert.assertEquals((int) sm.calculateAtMidpoint(2, 5, 10, 24), 291);
    }

}