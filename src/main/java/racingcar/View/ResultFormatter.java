package racingcar.View;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public final class ResultFormatter {
    private ResultFormatter() {}


    public static String formatRound(Cars cars) {
        return cars.asList().stream()
                .map(ResultFormatter::formatOne)
                .collect(Collectors.joining(System.lineSeparator()));

    }


    private static String formatOne(Car c) {
        return c.name() + " : " + "-".repeat(c.position());
    }


    public static String formatWinners(List<String> winners) {
        return "최종 우승자 : " + String.join(", ", winners);
    }
}
