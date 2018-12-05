package ru.shestakov.models;

import org.junit.Assert;
import org.junit.Test;

public class SquareManagerTest {

    @Test
    public void whenInputParamsThenReturnCorrectValue() {
        SquareManager sm = new SquareManager();
        sm.loadParams(2, 5, 10, 24);
        Assert.assertEquals((int) sm.integrate(), 291);
    }
}