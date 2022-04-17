package baseball.view;

import baseball.domain.BullsAndCowsGame;

public class ResultView {

    public static void showResult(BullsAndCowsGame game) {
        String resultStr = "";
        if (game.getBallCount() > 0) {
            resultStr += game.getBallCount() + "볼";
        }

        if (game.getStrikeCount() > 0) {
            resultStr += game.getStrikeCount() + "스트라이크";
        }

        if (game.getBallCount() == 0 && game.getStrikeCount() == 0) {
            resultStr = "낫싱";
        }

        System.out.println(resultStr);
    }
}
