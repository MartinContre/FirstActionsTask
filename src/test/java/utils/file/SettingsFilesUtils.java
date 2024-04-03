package utils.file;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class SettingsFilesUtils {
    private static final String CONFIG_PROPERTIES_JSON = "config_properties.json";
    private static final String TEST_DATA_FILE_NAME = "test_data.json";

    public static ISettingsFile getConfigPropertiesFile() {
        return new JsonSettingsFile(CONFIG_PROPERTIES_JSON);
    }

    public static ISettingsFile getTestDataFile() {
        return new JsonSettingsFile(TEST_DATA_FILE_NAME);
    }
}
