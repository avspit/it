package ru.shestakov.models;

public interface FileManager {

    void deleteFileIfExists(String fileName);

    void print(String value);

    void print(SquareManager sm);
}
