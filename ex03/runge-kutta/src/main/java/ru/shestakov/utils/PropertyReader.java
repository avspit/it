package ru.shestakov.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static final Logger LOG = LoggerFactory.getLogger(PropertyReader.class);
    private static final String FILE_NAME = "app.properties";
    private Properties props = new Properties();

    private static class InstanceHolder {
        private static final PropertyReader instance = new PropertyReader();
    }

    public PropertyReader() {
        init();
    }

    public static PropertyReader getInstance() {
        return InstanceHolder.instance;
    }

    public void init() {
        try {
            this.props.load(getClass().getClassLoader().getResourceAsStream(this.FILE_NAME));
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage(), e);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public String getProperty(String name) {
        return props.getProperty(name);
    }
}
