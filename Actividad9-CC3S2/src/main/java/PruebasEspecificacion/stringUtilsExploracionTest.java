package PruebasEspecificacion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



class stringUtilsExploracionTest {

    @Test
    void simpleCase(){
        assertThat(
                stringUtils.substringsBetween("abcd", "a", "d")
        ).isEqualTo(new String[] { "bc" });
    }
    @Test
    void manyStrings(){
        assertThat(
                stringUtils.substringsBetween("abcdabcdab", "a", "d")
        ).isEqualTo(new String[] { "bc", "bc" });
    }
    @Test
    void openAndCloseTagsThatAreLongerThan1Char(){
        assertThat(
                stringUtils.substringsBetween("aabcddaabfddaab", "aa", "dd")
        ).isEqualTo(new String[] { "bc", "bf" });

    }

}
