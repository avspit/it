package ru.shestakov.models;

import org.junit.Assert;
import org.junit.Test;
import ru.shestakov.utils.PropertyReader;

import java.io.File;

public class SquareManagerTest {
    private static final PropertyReader PROPS = PropertyReader.getInstance();

    @Test
    public void whenInputParamsThenReturnCorrectValue() {
        SquareManager sm = new SquareManager();
        Assert.assertEquals((int) sm.сalculate(2, 5, 10, 24), 291);
    }

    @Test
    public void whenCalculatedThenTxtFileExists() {
        new TxtFileManager().print(String.valueOf(new SquareManager().сalculate(2, 5, 10, 24)));
        Assert.assertTrue(new File(this.PROPS.getProperty("SIMPSON_TXT_FILENAME")).exists());
    }

    @Test
    public void whenCalculatedThenExcelFileExists() {
        SquareManager sm = new SquareManager();
        sm.сalculate(2, 5, 10, 24);
        new ExcelFileManager().print(sm);
        Assert.assertTrue(new File(this.PROPS.getProperty("SIMPSON_EXCEL_FILENAME")).exists());
    }
}