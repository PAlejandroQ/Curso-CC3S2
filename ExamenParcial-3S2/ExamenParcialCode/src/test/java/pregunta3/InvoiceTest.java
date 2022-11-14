package pregunta3;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InvoiceTest {
    @Test
    void test1() {
        Invoice invoice = new Invoice(2500,"NL",
                CustomerType.COMPANY);
        double v = invoice.calculate();
        assertThat(v).isEqualTo(250);
    }

    @Test
    void taxesForCompanyAreTaxRateMultipliedByAmount() {
        double invoiceValue = 2500.0;
        double tax = 0.1;
        Invoice invoice = new InvoiceBuilder()
                .asCompany()
                .withCountry("NL")
                .withAValueOf(invoiceValue)
                .build();
        double calculatedValue = invoice.calculate();
        assertThat(calculatedValue)
                .isEqualTo(invoiceValue * tax);
    }
}
