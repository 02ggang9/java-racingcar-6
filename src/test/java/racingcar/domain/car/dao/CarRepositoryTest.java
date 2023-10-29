package racingcar.domain.car.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class CarRepositoryTest {

    // 1. save
    // 2. findAll
    // 3. findCarWithMaxPosition

    @Nested
    @DisplayName("Car 저장 테스트")
    class SaveCarRepositoryTest {

        @Test
        @DisplayName("Car 객체가 성공적으로 저장되어야 한다.")
        public void Car_객체가_성공적으로_저장되어야_한다() {
            CarRepository carRepository = new CarRepository();
            Car frirstCar = new Car("FirstCarName");
            Car secondCar = new Car("SecondCarName");

            carRepository.save(frirstCar);
            carRepository.save(secondCar);

            List<Car> cars = carRepository.findAll();

            assertThat(cars.get(0).getName()).isEqualTo("FirstCarName");
            assertThat(cars.get(1).getName()).isEqualTo("SecondCarName");

            assertThat(cars.get(0).getPosition()).isEqualTo(0);
            assertThat(cars.get(1).getPosition()).isEqualTo(0);
        }

    }

    @Nested
    @DisplayName("Car 읽기 테스트")
    class findCarRepositoryTest {

        @Test
        @DisplayName("Car 객체를 성공적으로 읽어와야 한다")
        public void Car_객체를_성공적으로_읽어와야_한다() {
            CarRepository carRepository = new CarRepository();
            Car firstCar = new Car("FirstCar");
            Car secondCar = new Car("SecondCar");

        }
    }


}
