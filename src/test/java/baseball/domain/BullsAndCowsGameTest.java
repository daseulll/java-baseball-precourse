package baseball.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BullsAndCowsGameTest {

    @Test
    @DisplayName("상대방과 같은 수 입력했을 때 strike 카운트")
    void countStrike() {
        List<Integer> opponentNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<Integer> inputNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

        BullsAndCowsGame game = new BullsAndCowsGame(opponentNumbers, inputNumbers);
        game.start();

        Assertions.assertThat(game.getStrikeCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("상대방과 같은 수, 다른 위치 입력했을 때 ball 카운트")
    void countBall() {
        List<Integer> opponentNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<Integer> inputNumbers = new ArrayList<Integer>(Arrays.asList(2, 4, 5));

        BullsAndCowsGame game = new BullsAndCowsGame(opponentNumbers, inputNumbers);
        game.start();

        Assertions.assertThat(game.getBallCount()).isEqualTo(1);
    }
}