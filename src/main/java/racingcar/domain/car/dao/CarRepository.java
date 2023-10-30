package racingcar.domain.car.dao;

import racingcar.domain.car.Car;
import racingcar.domain.util.ErrorMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racingcar.domain.util.ErrorMessage.*;

public class CarRepository {

    private static Long CarId = 0L;
    private static Map<Long, Car> carDatabase = new HashMap<>();

    public void save(Car car) {
        carDatabase.put(CarId, car);
        CarId++;
    }

    public List<Car> findAll() {
        return carDatabase.values()
                .stream()
                .toList();
    }

    public List<Car> findAllCarsWithMaxPosition() {
        int maxPosition = carDatabase.values()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(CAR_NOT_EXIST.getErrorMessage()));

        return carDatabase.values()
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public void clear() {
        carDatabase.clear();
        CarId = 0L;
    }
}
