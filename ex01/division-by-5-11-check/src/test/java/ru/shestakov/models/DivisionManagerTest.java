package ru.shestakov.models;

import org.junit.Assert;
import org.junit.Test;

public class DivisionManagerTest {

    @Test
    public void whenNumberIsDividibleThenReturnTrue() {
        DivisionManager manager = new DivisionManager();
        Assert.assertTrue(manager.check("55"));
    }

    @Test
    public void whenNumberIsNoDividibleThenReturnFalse() {
        DivisionManager manager = new DivisionManager();
        Assert.assertTrue(!manager.check("56"));
    }

}