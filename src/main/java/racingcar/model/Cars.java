package racingcar.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.MoveStrategy;
import racingcar.model.NumberGenerator;


public final class Cars {
    private final List<Car> list;


    public Cars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 없습니다");
        }

        this.list = Collections.unmodifiableList(new ArrayList<>(cars));
    }

    public void moveAll(MoveStrategy strategy, NumberGenerator gen) {
        for (Car c : list) {
            c.moveIf(strategy, gen.nextInt0to9());
        }
    }

    public int maxPosition() {
        int max = 0;
        for (Car car : list) {
            if (car.position() > max) max = car.position();
        }
        return max;
    }

    public List<String> names() {
        return list.stream().map(Car::name).collect(Collectors.toList());
    }


    public List<Car> asList() { return list; }
}