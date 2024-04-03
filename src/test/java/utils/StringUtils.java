package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.file.reader.TestDataReader;

import java.security.SecureRandom;

public class StringUtils {
    private static final Logger logger = LogManager.getLogger(StringUtils.class);
    private static final SecureRandom random = new SecureRandom();
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String CYRILLIC = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static String generateMail(int length) {
        StringBuilder email = new StringBuilder();

        String allowedChars = LETTERS;

        while (email.length() < length) {
            char character = allowedChars.charAt(random.nextInt(allowedChars.length()));
            email.append(character);
        }
        String generatedEmail = email.toString();
        logger.info("Generated email: " + generatedEmail);
        return generatedEmail;
    }

    public static String generatePassword(int length, String email) {
        if (length < 10) {
            logger.error("Password length is less than 10: " + length);
            return null;
        }

        String allowedChars = CAPS + LETTERS + NUMBERS + CYRILLIC;
        String password = RandomStringUtils.random(length, allowedChars);

        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasEmailLetter = false;
        boolean hasCyrillic = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (email.contains(String.valueOf(c))) {
                hasEmailLetter = true;
            } else if (c >= 'Ѐ' && c <= 'ӿ') {
                hasCyrillic = true;
            }
        }
        if (!hasUpperCase || !hasNumber || !hasEmailLetter || !hasCyrillic) {
            return generatePassword(length, email);
        }
        logger.info("Generated password: " + password);
        return password;
    }

    public static String getEmailDomain() {
        int i = random.nextInt(TestDataReader.getDomainsList().size());
        String domain = TestDataReader.getDomainsList().get(i);
        logger.info("Generated domain: " + domain);
        return domain;
    }
}
