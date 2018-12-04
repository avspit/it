package ru.shestakov.models;

import org.junit.Assert;
import org.junit.Test;

public class DivisionManagerTest {

    @Test
    public void whenNumberIsDividibleThenReturnCorrectValue() {
        DivisionManager manager = new DivisionManager();
        Assert.assertEquals(manager.check("55"), "yes");
    }

    @Test
    public void whenNumberIsNoDividibleThenReturnCorrectValue() {
        DivisionManager manager = new DivisionManager();
        Assert.assertEquals(manager.check("56"), "no");
    }

}