import java.util.*;

public class Colecoes2_2 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pessoas;

        System.out.println("Informe as pessoas separadas por vírgula, com sexo após o traço (Ex.: Guilherme-M,Judy-F): ");
        pessoas = scanner.nextLine();

        List<String> listaM = new ArrayList<>();
        List<String> listaF = new ArrayList<>();

        String[] ArrayPessoas = pessoas.split(",");

        for (int i = 0; i < ArrayPessoas.length; i++) {
            if (ArrayPessoas[i].endsWith("M")) {
                listaM.add(ArrayPessoas[i].substring(0, ArrayPessoas[i].length() - 2));
            } else if (ArrayPessoas[i].endsWith("F")) {
                listaF.add(ArrayPessoas[i].substring(0, ArrayPessoas[i].length() - 2));
            }
        }

        Collections.sort(listaM);
        Collections.sort(listaF);

        System.out.println("Homens\n");
        System.out.println(listaM);
        System.out.println("\n\nMulheres\n");
        System.out.println(listaF);
    }
}
