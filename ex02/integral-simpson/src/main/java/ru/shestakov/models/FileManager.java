package ru.shestakov.models;

public interface FileManager {

    void deleteFileIsExists(String fileName);

    void print(String value);

    void print(SquareManager sm);
}
