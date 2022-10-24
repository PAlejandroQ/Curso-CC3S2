package PruebasEspecificacion;

import org.junit.jupiter.api.Test;
import static PruebasEspecificacion.stringUtils.substringsBetween;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class stringUtilsTest {
    @Test
    void strlsNullOrEmpty(){
        assertThat(substringsBetween(null, "a", "b"))
                .isEqualTo(null);
        assertThat(substringsBetween("", "a", "b"))
                .isEqualTo(new String[]{});
    }

    @Test
    void openIsNullOrEmpty(){
        assertThat(substringsBetween("abc", null, "b"))
                .isEqualTo(null);
        assertThat(substringsBetween("abc", "a", ""))
                .isEqualTo(null);

    }
    @Test
    void closeIsNullOrEmpty() {
        assertThat(substringsBetween("abc", "a", null))
                .isEqualTo(null);

        assertThat(substringsBetween("abc", "a", ""))
                .isEqualTo(null);
    }


}