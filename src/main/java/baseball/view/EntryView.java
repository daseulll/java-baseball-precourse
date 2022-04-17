package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class EntryView {
    public static void showGuide() {
        System.out.println("숫자 야구 게임을 시작합니다. 게임규칙: 상대방이 갖고있는 1부터 9까지의 서로 다른 세자리 수를 맞추세요.");
        System.out.println("힌트정보: 같은 수, 같은 위치인 경우 '1스트라이크' / 같은 수, 다른 위치면 '1볼' / 아무것도 일치하지 않을 경우 '낫싱'");
    }

    public static String scanInput() {
        System.out.printf("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
