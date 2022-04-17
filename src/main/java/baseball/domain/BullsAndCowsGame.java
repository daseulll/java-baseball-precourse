package baseball.domain;

import baseball.view.ResultView;

import java.util.List;

public class BullsAndCowsGame {
    private List<Integer> opponentNumbers;
    private List<Integer> inputNumbers;
    private int strikeCount = 0;
    private int ballCount = 0;
    private boolean isEnded = false;

    public BullsAndCowsGame(List<Integer> opponentNumbers, List<Integer> inputNumbers) {
        this.opponentNumbers = opponentNumbers;
        this.inputNumbers = inputNumbers;
    }

    public void start() {
        CompareNumbers();
    }

    public void retry(List<Integer> inputNumbers) {
        this.inputNumbers = inputNumbers;
        this.strikeCount = 0;
        this.ballCount = 0;
        this.isEnded = false;
        CompareNumbers();
    }

    public void end() {
        this.isEnded = true;
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

    public void setInputNumbers(List<Integer> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public boolean isEnded() {
        return this.isEnded;
    }
}
