package baseball.common;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumGenerator {
    public static List<Integer> generate(int min, int max, int count) {
        List<Integer> uniqueNumbers = new ArrayList<>();

        while (uniqueNumbers.size() < count) {
            pickUniqueNumberInRange(uniqueNumbers, min, max);
        }
        return uniqueNumbers;
    }

    private static void pickUniqueNumberInRange(List<Integer> uniqueNumbers, int min, int max) {
        int num = Randoms.pickNumberInRange(min, max);
        while (!uniqueNumbers.contains(num)) {
            uniqueNumbers.add(num);
        }
    }
}
