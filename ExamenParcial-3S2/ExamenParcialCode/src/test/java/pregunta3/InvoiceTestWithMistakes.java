package pregunta3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;

class InvoiceTestWithMistakes {

    @Test
    void test1() {
        Invoice invoice = new Invoice(new BigDecimal("2500").doubleValue(),"NL",
                CustomerType.COMPANY);
        double v = invoice.calculate();
        assertThat(v).isEqualTo(250);
    }

}