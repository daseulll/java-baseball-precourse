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
    }

    private static BullsAndCowsGame startGame() {
        List<Integer> opponentNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        String input = EntryView.scanInput();
        List<Integer> inputNumbers = toIntList(input);

        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame(opponentNumbers, inputNumbers);
        bullsAndCowsGame.start();
        return bullsAndCowsGame;
    }

    private static BullsAndCowsGame endGame(BullsAndCowsGame game) {
        ResultView.showEnding(game);
        String answer = ResultView.AskRestartOrTerminate();

        if (answer.equals("1")) {
            main(new String[]{});
        }
        return game;
    }

    private static List<Integer> toIntList(String input) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (String inputStr: input.split("")) {
            numbers.add(Integer.valueOf(inputStr));
        }
        return numbers;
    }
}
