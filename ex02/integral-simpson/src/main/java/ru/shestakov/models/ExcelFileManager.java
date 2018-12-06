package ru.shestakov.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shestakov.utils.PropertyReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFileManager extends AppManager {
    private static final Logger LOG = LoggerFactory.getLogger(ExcelFileManager.class);
    private static final PropertyReader PROPS = PropertyReader.getInstance();

    @Override
    public void print(SquareManager sm) {
        String fileName = this.PROPS.getProperty("SIMPSON_EXCEL_FILENAME");
        deleteFileIfExists(fileName);
        ScatterChart sc = new ScatterChart();
        sc.prepareData(sm);
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            sc.getWorkbook().write(fileOut);
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage(), e);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
