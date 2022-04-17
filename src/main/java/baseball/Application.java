package baseball;

import baseball.domain.BullsAndCowsGame;
import baseball.view.EntryView;
import baseball.view.ResultView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BullsAndCowsGame bullsAndCowsGame = startGame();
        ResultView.showResult(bullsAndCowsGame);

        if (bullsAndCowsGame.getStrikeCount() == 3) {
            endGame(bullsAndCowsGame);
        }

        if (bullsAndCowsGame.getStrikeCount() < 3) {
            retryGame(bullsAndCowsGame);
        }
    }

    private static BullsAndCowsGame startGame() {
        List<Integer> opponentNumbers = pickUniqueNumbersInRange(1, 9, 3);

        String input = EntryView.scanInput();
        List<Integer> inputNumbers = toIntList(input);

        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame(opponentNumbers, inputNumbers);
        bullsAndCowsGame.start();
        return bullsAndCowsGame;
    }

    private static List<Integer> pickUniqueNumbersInRange(int min, int max, int count) {
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

    private static void endGame(BullsAndCowsGame game) {
        game.end();
        ResultView.showEnding(game);
        String answer = ResultView.AskRestartOrTerminate();

        if (answer.equals("1")) {
            main(new String[]{});
        }
    }

    private static void retryGame(BullsAndCowsGame game) {
        String input = EntryView.scanInput();
        List<Integer> inputNumbers = toIntList(input);
        game.retry(inputNumbers);
        ResultView.showResult(game);

        if (game.getStrikeCount() == 3) {
            endGame(game);
        }

        if (!game.isEnded()) {
            retryGame(game);
        }
    }

    private static List<Integer> toIntList(String input) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (String inputStr: input.split("")) {
            numbers.add(Integer.valueOf(inputStr));
        }
        return numbers;
    }
}
