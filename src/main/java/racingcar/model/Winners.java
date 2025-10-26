package racingcar.model;
import java.util.List;
import java.util.stream.Collectors;

public final class Winners {
    private Winners() {}

    public static List<String> names(Cars cars) {
        int max = cars.maxPosition();
        return cars.asList().stream()
                .filter(c -> c.position() == max)
                .map(Car::name)
                .collect(Collectors.toList());
    }
}
