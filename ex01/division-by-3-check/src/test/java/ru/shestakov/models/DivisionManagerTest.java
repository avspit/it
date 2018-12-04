package ru.shestakov.models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionManagerTest {

    @Test
    public void whenNumberIsDividibleThenReturnCorrectValue() {
        DivisionManager manager = new DivisionManager();
        Assert.assertEquals(manager.check("9"), "yes");
    }

    @Test
    public void whenNumberIsNoDividibleThenReturnCorrectValue() {
        DivisionManager manager = new DivisionManager();
        Assert.assertEquals(manager.check("10"), "no");
    }

}