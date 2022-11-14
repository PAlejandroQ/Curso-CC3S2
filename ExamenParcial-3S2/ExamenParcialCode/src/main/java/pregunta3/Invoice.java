package pregunta3;

public class Invoice {
    private final double value;
    private final String country;
    private final CustomerType customerType;
    public Invoice(double value, String country, CustomerType customerType) {
        this.value = value;
        this.country = country;
        this.customerType = customerType;
    }
    public double getValue(){
        return this.value;
    }
    public String getCountry(){
        return this.country;
    }
    public CustomerType getCustomerType(){
        return this.customerType;
    }
    public double calculate() {
        double ratio = 0.1;
        return value * ratio;
    }
}
