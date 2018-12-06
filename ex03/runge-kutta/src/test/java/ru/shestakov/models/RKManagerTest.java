package ru.shestakov.models;

import org.junit.Assert;
import org.junit.Test;
import ru.shestakov.utils.PropertyReader;

import java.io.File;

public class RKManagerTest {
    private static final PropertyReader PROPS = PropertyReader.getInstance();

    @Test
    public void whenUseDefaultParamsThenCalculated() {
        RKManager rk = new RKManager();
        rk.integrate("");
        Assert.assertTrue(!rk.getRungeKuttaCalculations().isEmpty());
    }

    @Test
    public void whenCalculatedThenExcelFileExists() {
        RKManager sm = new RKManager();
        sm.integrate(2, 5, 10, 24);
        new ExcelFileManager().print(sm);
        Assert.assertTrue(new File(this.PROPS.getProperty("RUNGE_KUTTA_EXCEL_FILENAME")).exists());
    }
}