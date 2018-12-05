package ru.shestakov.models;

import org.junit.Assert;
import org.junit.Test;

public class RKManagerTest {

    @Test
    public void whenUseDefaultParamsThenCalculated() {
        RKManager rk = new RKManager();
        rk.loadParams("");
        rk.calculate();
        Assert.assertTrue(!rk.getRungeKuttaCalculations().isEmpty());
    }

}