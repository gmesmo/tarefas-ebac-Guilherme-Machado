import java.util.*;

public class Colecoes2_1 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pessoas;

        System.out.println("Informe as pessoas separadas por vírgula: ");
        pessoas = scanner.nextLine();

        List<String> listaPessoas = new ArrayList<>();

        String[] ArrayPessoas = pessoas.split(",");

        for (int i = 0; i < ArrayPessoas.length; i++) {
            listaPessoas.add(ArrayPessoas[i]);
        }

        Collections.sort(listaPessoas);

        System.out.println(listaPessoas);
    }
}
