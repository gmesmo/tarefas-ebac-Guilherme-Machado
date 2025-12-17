import java.util.*;
import java.util.stream.Collectors;

public class Exercicio {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pessoas;

        System.out.println("Informe as pessoas separadas por vírgula, com sexo após o traço (Ex.: Guilherme-M,Judy-F): ");
        pessoas = scanner.nextLine();

        String[] ArrayPessoas = pessoas.split(",");

        List<String> listaM = Arrays.stream(ArrayPessoas)
                                    .filter(pessoa -> pessoa.endsWith("M"))
                                    .map(pessoa -> pessoa.substring(0, pessoa.length() -2))
                                    .sorted()
                                    .collect(Collectors.toList());

        List<String> listaF = Arrays.stream(ArrayPessoas)
                .filter(pessoa -> pessoa.endsWith("F"))
                .map(pessoa -> pessoa.substring(0, pessoa.length() -2))
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Homens\n");
        System.out.println(listaM);
        System.out.println("\n\nMulheres\n");
        System.out.println(listaF);
    }
}
