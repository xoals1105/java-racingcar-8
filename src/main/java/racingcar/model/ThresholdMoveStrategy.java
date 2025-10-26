package racingcar.model;
public final class ThresholdMoveStrategy implements MoveStrategy {
    private final int threshold;


    public ThresholdMoveStrategy() { this(4); }
    public ThresholdMoveStrategy(int threshold) { this.threshold = threshold; }


    @Override
    public boolean movable(int number) {
        return number >= threshold;
    }
}
