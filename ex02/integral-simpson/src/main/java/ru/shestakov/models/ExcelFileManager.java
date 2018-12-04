package ru.shestakov.models;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFileManager extends FileManager {
    private static final String FILE_NAME = "integral-simpson-result.xlsx";

    @Override
    public void print(SquareManager sm) {
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
