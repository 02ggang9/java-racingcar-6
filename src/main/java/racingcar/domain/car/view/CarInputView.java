package racingcar.domain.car.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.domain.util.InputMessage.*;

public class CarInputView {

    public List<String> getCarNames() {
        printGameStart();
        String carNames = Console.readLine();
        return Arrays.stream(carNames.split(","))
                .filter(this::checkValidCarNameLength)
                .toList();
    }

    private void printGameStart() {
        System.out.println(RECEIVE_CAR_NAME.getMessage());
    }


    private boolean checkValidCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public int getTryCount() {
        printTryCount();
        String tryCount = Console.readLine();
        checkIsDigit(tryCount);
        return Integer.parseInt(tryCount);
    }

    private void checkIsDigit(String userInput) {
        if (isDigit(userInput)) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private boolean isDigit(String userInput) {
        return userInput.chars()
                .allMatch(Character::isDigit);
    }

    private void printTryCount() {
        System.out.println(RECEIVE_TRY_COUNT.getMessage());
    }
}
