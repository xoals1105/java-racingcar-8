package racingcar.model;

import racingcar.model.MoveStrategy;
import racingcar.model.NumberGenerator;

public final class Game {
    private final Cars cars;
    private final MoveStrategy strategy;
    private final NumberGenerator generator;

    public Game(Cars cars, MoveStrategy strategy, NumberGenerator generator) {
        this.cars = cars;
        this.strategy = strategy;
        this.generator = generator;
    }

    public void runOneRound() {
        cars.moveAll(strategy, generator);
    }

    public void runRounds(int attempts) {
        for (int i = 0; i < attempts; i++) {
            runOneRound();
        }
    }

    public Cars cars() { return cars; }
}