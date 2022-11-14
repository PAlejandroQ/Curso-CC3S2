package pregunta1;
import java.util.ArrayList;
import java.util.List;
public class ClassRemove {
    public void remove(List<Character> chars) {
        char end = 'z';
        chars.removeIf(c -> {
            char start = 'a';
            return start <= c && c <= end;
        });
        System.out.println(chars.toString());
    }

    public static void main(String[] args) {
        String string = "aAbBcCdDeEfFgGzZ1234";
        List<Character> lista = new ArrayList<Character>();
        for (char ct : string.toCharArray()) {
            lista.add(ct);
        }
        System.out.println(lista.toString());
        ClassRemove classRemove = new ClassRemove();
        classRemove.remove(lista);
    }
}
