package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomSelector {
    private static final Logger logger = LogManager.getLogger(RandomSelector.class);

    public static List<Integer> selectRandomIndexes(int n, int numItems) {
        Random random = new Random();

        logger.info("Selecting " + n + " random indexes from " + numItems + " items");

        List<Integer> selectedIndexes = new ArrayList<>();
        Set<Integer> selectedSet = new HashSet<>();

        while (selectedSet.size() < n) {
            int randomIndex = random.nextInt(numItems);

            if (selectedSet.add(randomIndex)) {
                selectedIndexes.add(randomIndex);
            }
        }

        logger.info("Selected indexes: " + selectedIndexes);

        return selectedIndexes;
    }
}
