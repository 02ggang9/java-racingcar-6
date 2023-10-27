package racingcar.domain.gamemanager.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.Car;
import racingcar.domain.car.dao.CarRepository;
import racingcar.domain.view.InputView;
import racingcar.domain.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {

    private final CarRepository carRepository;

    public GameService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public void saveCars(String carNames) {
        List<Car> car = createCar(carNames);

        saveCar(car);
    }

    private void saveCar(List<Car> cars) {
        cars.forEach(carRepository::save);
    }

    private List<Car> createCar(String carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        Arrays.stream(carNames.split(","))
                .forEach(carName -> cars.add(new Car(carName)));

        return cars;
    }

    public void startGame(int tryCount) {
        OutputView.printRoundResult();
        for (int i = 0; i < tryCount; i++) {
//            int randomNumber = Randoms.pickNumberInRange(0, 9);
            List<Car> findCars = carRepository.findAll();

            findCars.forEach(car -> car.updatePosition(Randoms.pickNumberInRange(0, 9)));
            findCars.forEach(System.out::print);
            System.out.println();

        }
    }

    public List<String> getWinner() {
        List<Car> carWithMaxPosition = carRepository.findCarWithMaxPosition();

        ArrayList<String> winners = new ArrayList<>();
        carWithMaxPosition.forEach(car -> winners.add(car.getName()));

        return winners;
    }
}
