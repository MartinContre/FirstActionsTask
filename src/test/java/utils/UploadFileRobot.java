package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.file.FileUtils;
import utils.file.reader.ConfigDataReader;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFileRobot {
    private static final Logger logger = LogManager.getLogger(UploadFileRobot.class);
    private static final Robot robot;
    private static final int DELAY_TIME = ConfigDataReader.getDelayTimeRobot();

    static {
        Robot tempRobot = null;
        try {
            tempRobot = new Robot();
        } catch (AWTException e) {
            logger.error("Error initializing robot: " + e.getMessage(), e);
        }
        robot = tempRobot;
    }

    public static void uploadFile(String filePath) {

        try {
            String absolutFilePath = FileUtils.getAbsolutPath(filePath);

            StringSelection stringSelection = new StringSelection(absolutFilePath);

            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            robot.delay(DELAY_TIME);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.delay(DELAY_TIME);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            logger.info("File uploaded successfully: " + absolutFilePath);
        } catch (Exception e) {
            logger.error("Error uploading file: " + e.getMessage(), e);
        }
    }
}
