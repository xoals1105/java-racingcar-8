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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
