package Contract;

public class TaxCalculator1 {
    // TaxCalculator with pre- and post-conditions implemented via asserts
    public double calculateTax(double value){
        assert value >= 0 : "El valor no puede ser negativo";
        double taxValue = 0;

        double ratio = 0.18;
        taxValue = value * ratio;


        assert taxValue >= 0 : "El valor calculado no puede ser negativo";

        return taxValue;

    }
}
