package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Attempts;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.model.NameParser;
import racingcar.model.NameValidator;
import racingcar.model.Winners;
import racingcar.model.MoveStrategy;
import racingcar.model.NumberGenerator;
import racingcar.View.ConsoleView;

public final class GameController {
    private final ConsoleView view;
    private final MoveStrategy strategy;
    private final NumberGenerator generator;

    public GameController(ConsoleView view, MoveStrategy strategy, NumberGenerator generator) {
        this.view = view;
        this.strategy = strategy;
        this.generator = generator;
    }

    public void run() {
        String namesInput = view.readNames();
        List<String> names = NameParser.parse(namesInput);
        names.forEach(NameValidator::validateLength);


        List<Car> carList = names.stream().map(Car::new).collect(Collectors.toList());
        Cars cars = new Cars(carList);


        String attemptsInput = view.readAttempts();
        Attempts attempts = new Attempts(attemptsInput);


        Game game = new Game(cars, strategy, generator);


        view.printExecutionHeader();
        for (int i = 0; i < attempts.value(); i++) {
            game.runOneRound();
            view.printRound(cars); // 각 라운드 결과
            view.printEmptyLine(); // 라운드 사이 빈 줄
        }

        view.printWinners(Winners.names(cars));
    }
}
