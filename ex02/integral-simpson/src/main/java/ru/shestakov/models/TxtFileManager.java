package ru.shestakov.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileManager extends FileManager {
    private static final String FILE_NAME = "integral-simpson-result.txt";

    @Override
    public void print(String value) {
        deleteFileIsExists(this.FILE_NAME);
        writeValueToFile(value);
    }

    private void writeValueToFile(String value) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.FILE_NAME, false))) {
            writer.write(value);
            writer.flush();
            writer.close();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
