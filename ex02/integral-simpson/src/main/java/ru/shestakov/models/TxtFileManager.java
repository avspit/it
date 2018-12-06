package ru.shestakov.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shestakov.utils.PropertyReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileManager extends AppManager {
    private static final Logger LOG = LoggerFactory.getLogger(TxtFileManager.class);
    private static final PropertyReader PROPS = PropertyReader.getInstance();

    @Override
    public void print(String value) {
        deleteFileIfExists(this.PROPS.getProperty("SIMPSON_TXT_FILENAME"));
        writeValueToFile(value);
    }

    private void writeValueToFile(String value) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.PROPS.getProperty("SIMPSON_TXT_FILENAME"), false))) {
            writer.write(value);
            writer.flush();
            writer.close();
        } catch(IOException e){
            LOG.error(e.getMessage(), e);
        }
    }

}
