package pregunta3;
public class Main {
    public static void main(String[] args) {
        InvoiceBuilder invoiceBuilder = new InvoiceBuilder();
        Invoice invoice = invoiceBuilder.asCompany().withCountry("PE").withAValueOf(120).build();
        System.out.println("Value: " + invoice.getValue());
        System.out.println("Country: "+ invoice.getCountry());
        System.out.println("CustomerType: "+invoice.getCustomerType());
        System.out.println("Calculate: "+invoice.calculate());
        System.out.println("-------------------------------");

        InvoiceBuilder invoiceBuilder1 = new InvoiceBuilder();
        Invoice invoice1 = invoiceBuilder1.anyCompany();
        System.out.println("Value: " + invoice1.getValue());
        System.out.println("Country: "+ invoice1.getCountry());
        System.out.println("CustomerType: "+invoice1.getCustomerType());
        System.out.println("Calculate: "+invoice1.calculate());
        System.out.println("-------------------------------");

        InvoiceBuilder invoiceBuilder2 = new InvoiceBuilder();
        Invoice invoice2 = invoiceBuilder2.fromTheUS();
        System.out.println("Value: " + invoice2.getValue());
        System.out.println("Country: "+ invoice2.getCountry());
        System.out.println("CustomerType: "+invoice2.getCustomerType());
        System.out.println("Calculate: "+invoice2.calculate());
        System.out.println("-------------------------------");


    }
}
