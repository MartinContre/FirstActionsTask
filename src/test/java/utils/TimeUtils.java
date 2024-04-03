package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeUtils {
    private static final Logger logger = LogManager.getLogger(TimeUtils.class);
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{2}:)(\\d{2}:)(\\d{2})");

    public static String deleteFirstChars(String time) {
        if (time == null || time.isEmpty()) {
            logger.error("Input string is null or empty");
            return "";
        }
        Matcher matcher = TIME_PATTERN.matcher(time);
        if (matcher.find()) {
            time = matcher.group(2) + matcher.group(3);
            logger.info("The new time string is: " + time);
        } else {
            logger.error("Time format is invalid: " + time);
        }
        return time;
    }
}
