package ru.shestakov.models;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExcelFileManager {
    private static final String FILE_NAME = "runge-kutta-result.xlsx";

    public void deleteFileIsExists(String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void print(RKManager sm) {
        deleteFileIsExists(this.FILE_NAME);
        ScatterChart sc = new ScatterChart();
        sc.prepareData(sm);
        try (FileOutputStream fileOut = new FileOutputStream(this.FILE_NAME)) {
            sc.getWorkbook().write(fileOut);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
