package baseball.view;

import baseball.domain.BullsAndCowsGame;
import camp.nextstep.edu.missionutils.Console;

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

    public static void showEnding(BullsAndCowsGame game) {
        System.out.println(game.getStrikeCount() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static String AskRestartOrTerminate() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
