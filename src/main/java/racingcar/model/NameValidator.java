package racingcar.model;
public class NameValidator {
    private NameValidator() {}

    public static void validateLength(String name) {
        if (name == null) throw new IllegalArgumentException("이름 null");
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) throw new IllegalArgumentException("빈 이름");
        if (trimmedName.length() > 5) throw new IllegalArgumentException("이름은 1~5자만 허용");
    }
}
