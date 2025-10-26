package racingcar.model;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public final class NameParser {
    private NameParser() {}


    public static List<String> parse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("이름 입력 null");
        }
        String[] tokens = input.split(",");
        List<String> names = Arrays.stream(tokens)
                .map(String::trim)
                .collect(Collectors.toList());
        if (names.isEmpty() || names.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("잘못된 이름 입력");
        }

        return names;
    }
}
