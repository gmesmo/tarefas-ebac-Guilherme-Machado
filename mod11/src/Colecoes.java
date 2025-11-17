import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Colecoes {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> grupoM = new ArrayList<>();
        List<String> grupoF = new ArrayList<>();

        String nome;
        String sexo;

        System.out.println("Quantas pessoas quer cadastrar?");
        int pessoas = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < pessoas; i++) {
            System.out.print("Digite o nome da pessoa: ");
            nome = scanner.nextLine();

            System.out.print("Digite o sexo da pessoa (M/F): ");
            sexo = scanner.nextLine().toUpperCase();

            if (sexo.equals("M")) {
                grupoM.add(nome);
            } else if (sexo.equals("F")) {
                grupoF.add(nome);
            } else {
                System.out.println("Sexo informado não reconhecido, por favor informe nome e sexo novamente dessa pessoa");
                i = i--;
            }
        }

        System.out.println("Grupos");
        System.out.println("\n\nMasculino");
        System.out.println(grupoM);
        System.out.println("\n\nFeminino");
        System.out.println(grupoF);

        scanner.close();
    }
}
