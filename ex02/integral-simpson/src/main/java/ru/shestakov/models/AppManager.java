package ru.shestakov.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class AppManager implements FileManager {
    private static final Logger LOG = LoggerFactory.getLogger(AppManager.class);

    public void deleteFileIfExists(String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void print(String value) {

    }

    @Override
    public void print(SquareManager sm) {

    }
}
