package racingcar.model;
import racingcar.model.MoveStrategy;

public final class Car {
    private final String name;
    private int position;


    public Car(String name) {
        NameValidator.validateLength(name);
        this.name = name.trim();
        this.position = 0;
    }


    public void moveIf(MoveStrategy strategy, int number) {
        if (strategy.movable(number)) {
            position++;
        }
    }

    public String name() { return name; }
    public int position() { return position; }
}
