package racingcar.View;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Cars;

public final class ConsoleView {
    private static final String MSG_INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MSG_INPUT_ATTEMPTS = "시도할 횟수는 몇 회인가요?";
    private static final String MSG_EXECUTION = "\n실행 결과";


    public String readNames() {
        System.out.println(MSG_INPUT_NAMES);
        return Console.readLine();
    }

    public String readAttempts() {
        System.out.println(MSG_INPUT_ATTEMPTS);
        return Console.readLine();
    }

    public void printExecutionHeader() {
        System.out.println(MSG_EXECUTION);
    }

    public void printRound(Cars cars) {
        System.out.println(ResultFormatter.formatRound(cars));
    }

    public void printWinners(List<String> winners) {
        System.out.println(ResultFormatter.formatWinners(winners));
    }

    public void printEmptyLine() {
        System.out.println();
    }
}