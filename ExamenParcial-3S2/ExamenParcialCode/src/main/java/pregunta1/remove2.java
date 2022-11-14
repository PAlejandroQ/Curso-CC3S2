package pregunta1;
import java.util.ArrayList;
import java.util.List;
public class remove2 {
    public static void main(String[] args) {
        String string = "1a1d5g6a4ge7t8b";
        List<Character> lista = new ArrayList<Character>();
        for (char ct : string.toCharArray()) {
            lista.add(ct);
        }
        System.out.println(lista.toString());
        remove2 classRemove = new remove2();
        classRemove.remove(lista);
    }
    public void remove(List<Character> chars) {
        char end = 'z';
        chars.removeIf(c -> {
            char start = 'a';
            return start <= c && c <= end;
        });
        System.out.println(chars.toString());
    }

}
