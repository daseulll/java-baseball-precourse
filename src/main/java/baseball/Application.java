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
        new BullsAndCowsGame().start();
    }
}
