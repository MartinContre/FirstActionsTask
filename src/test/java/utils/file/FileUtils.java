package utils.file;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtils {
    private static final Logger logger = LogManager.getLogger(FileUtils.class);

    public static String getAbsolutPath(String filePath) {
        String path = System.getProperty("user.dir") + filePath;
        File file = new File(path);
        String absolutFilePath = file.getAbsolutePath();
        logger.info("Generate absolut file path: " + absolutFilePath);
        return absolutFilePath;
    }
}
