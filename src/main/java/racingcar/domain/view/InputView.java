package racingcar.domain.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.util.InputMessage;

import static racingcar.domain.util.InputMessage.*;

public class InputView {

    public static void printGameStart() {
        System.out.println(RECEIVE_CAR_NAME.getMessage());
    }

    public static String receiveUserInput() {
        return Console.readLine();
    }

    public static void printTryCount() {
        System.out.println(RECEIVE_TRY_COUNT.getMessage());
    }

    public static void printGameEnd() {
        System.out.println();
    }
}
