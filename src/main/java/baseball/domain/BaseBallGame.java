package baseball.domain;

import baseball.common.RandomNumGenerator;
import baseball.view.EntryView;
import baseball.view.ResultView;

import java.util.List;

public class BaseBallGame {
    private List<Integer> opponentNumbers;
    private List<Integer> inputNumbers;
    private int strikeCount = 0;
    private int ballCount = 0;

    public BaseBallGame(List<Integer> opponentNumbers, List<Integer> inputNumbers) {
        this.opponentNumbers = opponentNumbers;
        this.inputNumbers = inputNumbers;
    }

    public static void start() {
        List<Integer> opponentNumbers = RandomNumGenerator.generate(1, 9, 3);
        List<Integer> inputNumbers = EntryView.getInput();

        BaseBallGame baseBallGame = new BaseBallGame(opponentNumbers, inputNumbers);
        baseBallGame.play();
    }

    public void play() {
        CompareNumbers();
        ResultView.showResult(this);

        if (strikeCount == 3) {
            end();
            return;
        }

        if (strikeCount < 3) {
            retry();
        }
    }

    public void retry() {
        this.inputNumbers = EntryView.getInput();
        this.strikeCount = 0;
        this.ballCount = 0;
        play();
    }

    public void end() {
        ResultView.showEnding(this);
        String answer = ResultView.AskRestartOrTerminate();

        if (answer.equals("1")) {
            BaseBallGame.start();
        }
    }

    private void CompareNumbers() {
        for (int i = 0; i < opponentNumbers.size(); i++) {
            Integer opponentNumber = opponentNumbers.get(i);
            countStrikeOrBallTo(i, opponentNumber);
        }
    }

    private void countStrikeOrBallTo(int index, int opponentNumber) {
        if (inputNumbers.indexOf(opponentNumber) >= 0) {
            countStrike(index);
            countBall(index);
        }
    }

    private void countStrike(int index) {
        if (inputNumbers.get(index) == opponentNumbers.get(index)) {
            strikeCount += 1;
        }
    }
    private void countBall(int index) {
        if (inputNumbers.get(index) != opponentNumbers.get(index)) {
            ballCount += 1;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
