package utils.file.reader;

import aquality.selenium.core.utilities.ISettingsFile;
import utils.file.SettingsFilesUtils;

import java.util.List;

public class TestDataReader {
    private static final ISettingsFile TEST_DATA = SettingsFilesUtils.getTestDataFile();

    public static String getBaseUrl() {
        return TEST_DATA.getValue("/base_url").toString();
    }

    public static int getEmailLength() {
        return Integer.parseInt(TEST_DATA.getValue("/email_length").toString());
    }

    public static int getPasswordLength() {
        return Integer.parseInt(TEST_DATA.getValue("/password_length").toString());
    }

    public static String getPathUploadImage() {
        return TEST_DATA.getValue("/path_upload_image").toString();
    }

    public static List<String> getDomainsList() {
        return TEST_DATA.getList("/email_domains");
    }
}
