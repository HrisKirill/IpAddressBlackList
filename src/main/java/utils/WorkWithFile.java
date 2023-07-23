package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public final class WorkWithFile {
    private static String lastModified = "";
    private static final Logger LOGGER = LogManager.getLogger(WorkWithFile.class);

    public static String readFromFile(String fileName) {
        try {
            File file = new File(System.getProperty("user.dir") + File.separator + fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            Path path = file.toPath();

            if (isFileModified(file)) {
                return new String(Files.readAllBytes(path));
            } else {
                return "";
            }

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Properties readProperties(String propertyFile) {
        Properties properties = new Properties();
        try (InputStream resource = WorkWithFile.class.getClassLoader().getResourceAsStream(propertyFile)) {
            properties.load(resource);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static boolean isFileModified(File file) {
        if (lastModified.equals(String.valueOf(file.lastModified()))) {
            return false;
        }

        lastModified = String.valueOf(file.lastModified());
        return true;
    }

}
