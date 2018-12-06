package ru.shestakov.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shestakov.utils.PropertyReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExcelFileManager {
    private static final Logger LOG = LoggerFactory.getLogger(ExcelFileManager.class);
    private static final PropertyReader PROPS = PropertyReader.getInstance();

    public void deleteFileIsExists(String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    public void print(RKManager sm) {
        String fileName = this.PROPS.getProperty("RUNGE_KUTTA_EXCEL_FILENAME");
        deleteFileIsExists(fileName);
        ScatterChart sc = new ScatterChart();
        sc.prepareData(sm);
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            sc.getWorkbook().write(fileOut);
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

}
