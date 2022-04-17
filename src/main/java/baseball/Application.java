package baseball;

import baseball.domain.BullsAndCowsGame;
import baseball.domain.User;
import baseball.view.EntryView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> opponentNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        String input = EntryView.scanInput();
        List<Integer> inputNumbers = toIntList(input);

        new BullsAndCowsGame(opponentNumbers, inputNumbers).start();
    }

    private static List<Integer> toIntList(String input) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (String inputStr: input.split("")) {
            numbers.add(Integer.valueOf(inputStr));
        }
        return numbers;
    }
}
