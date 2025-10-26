package racingcar;

import racingcar.controller.GameController;
import racingcar.model.ThresholdMoveStrategy;
import racingcar.model.RandomNumberGenerator;
import racingcar.View.ConsoleView;

public class Application {
    public static void main(String[] args) {

        GameController controller = new GameController(
                new ConsoleView(),
                new ThresholdMoveStrategy(),
                new RandomNumberGenerator()
        );
        controller.run();
    }
}