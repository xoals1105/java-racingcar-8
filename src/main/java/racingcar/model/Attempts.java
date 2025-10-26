package racingcar.model;

public class Attempts {
    private final int value;

    public Attempts(String input) {
        if (input == null) throw new IllegalArgumentException("시도 횟수 null");
        final String trimmedInput = input.trim();
        try {
            int parsedAttempts = Integer.parseInt(trimmedInput);
            if (parsedAttempts <= 0) throw new IllegalArgumentException("시도 횟수는 1 이상");
            this.value = parsedAttempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수만");
        }
    }


    public int value() { return value; }
}
