package racingcar.domain.gamemanager.controller;

import racingcar.domain.gamemanager.service.GameService;
import racingcar.domain.view.InputView;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        InputView.printGameStart();
        String carNames = InputView.receiveUserInput();
        gameService.saveCars(carNames);
    }

    public void receiveTryCount() {
        InputView.printTryCount();
        String userInput = InputView.receiveUserInput();
    }
}
