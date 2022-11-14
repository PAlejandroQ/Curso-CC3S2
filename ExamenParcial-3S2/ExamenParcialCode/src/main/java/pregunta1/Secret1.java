package pregunta1;

interface Secret {
    String magic(double d);
}
//class Secret1 implements Secret { // version previa con uso de clase.
class Secret1 {
    public String magic(double d) {
        return "Poof";
    }
    public static void main(String[] args) {
        Secret secret = (d -> "Poof");
        System.out.println(secret.magic(4));
    }
}