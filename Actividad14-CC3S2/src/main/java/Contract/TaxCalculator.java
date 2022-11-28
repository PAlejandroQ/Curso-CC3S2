package Contract;

public class TaxCalculator {
    /**
     * Calcula el impuesto de acuerdo con el 18% de algún valor nominal
     *
     * @param value el valor nominal para el cálculo de impuestos. value >= 0.
     * @return el impuesto calculado. taxValue >= 0.
     */
    public double calculateTax(double value) {
        if(value < 0) {
            throw new RuntimeException("Value has to be positive");
        }

        double taxValue = 0;

        // some complex business rule here...
        // final value goes to 'taxValue'
        double ratio = 0.18;
        taxValue = value * ratio;


        if(taxValue < 0) {
            throw new RuntimeException("Calculated tax cannot be negative");
        }
        return taxValue;
    }
}
