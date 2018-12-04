package ru.shestakov.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class FileManager {

    public void deleteFileIsExists(String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void print(String value) { }

    public void print(SquareManager sm) { }
}
