package utils.file.reader;

import aquality.selenium.core.utilities.ISettingsFile;
import utils.file.SettingsFilesUtils;

public class ConfigDataReader {
    private static final ISettingsFile CONFIG_DATA = SettingsFilesUtils.getConfigPropertiesFile();

    public static int getDelayTimeRobot() {
        return Integer.parseInt(CONFIG_DATA.getValue("/delay_time_robot").toString());
    }
}
