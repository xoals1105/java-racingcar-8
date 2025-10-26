package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("빈 토큰(연속 쉼표)은 예외")
    void 빈토큰_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("이름 앞뒤 공백은 trim 처리 후 검증")
    void 이름_trim_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" pobi , woni ", "1");
                    assertThat(output()).contains("pobi :");
                    assertThat(output()).contains("woni :");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("시도 횟수 0/음수/숫자아님은 예외")
    void 시도횟수_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("경계값: 3은 정지, 4는 전진")
    void 경계값_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a", "2");
                    assertThat(output()).contains("a : "); // 1라운드(3): 정지
                    assertThat(output()).contains("a : -"); // 2라운드(4): 전진
                },
                STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
