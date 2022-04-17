package baseball.domain;

import baseball.view.EntryView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BullsAndCowsGame {

    public void start() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        User opponent = new User(uniqueNumbers);

        String input = EntryView.scanInput();
        List<Integer> inputNumbers = toIntList(input);

        User user = new User(inputNumbers);
        CompareNumbers(user, opponent);
    }

    private static List<Integer> toIntList(String input) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (String inputStr: input.split("")) {
            numbers.add(Integer.valueOf(inputStr));
        }
        return numbers;
    }

    private static void CompareNumbers(User user, User opponent) {
        System.out.println("user = " + user.getNumbers());
        System.out.println("opponent = " + opponent.getNumbers());
    }
}
