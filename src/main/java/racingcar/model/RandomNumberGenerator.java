package racingcar.model;
import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int nextInt0to9() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
