package pregunta1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

//import static java.lang.constant.DynamicConstantDesc.of;
import static java.util.stream.Stream.of;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static pregunta1.LeftPadUtils.leftPad;

public class LeftPadTest {
    @ParameterizedTest
    @MethodSource("generator")
    void test(String originalStr, int size, String padString,
              String expectedStr) { // 1
        assertThat(leftPad(originalStr, size, padString))
                .isEqualTo(expectedStr);
    }
//    static Stream<Arguments> generator() { // 2
//        return Stream.of(
//                of(null, 10,"-", null), //T1
//                of("", 5,"-","-----"), //T2
//                of("abc", -1,"-","abc"), //t3
//                of("abc", 5, null," abc"), //T4
//                of("abc", 5,""," abc"), //T5
//                of("abc", 5,"-","--abc"), //T6
//                of("abc", 3,"-","abc"), //T7
//
//                of("abc", 0,"-","abc"), //T8
//                of("abc", 2,"-","abc") //T9
//    };
}
