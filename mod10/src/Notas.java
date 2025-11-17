import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[4];
        double media = 0;

        for (int i = 0; i < 4; i++) {
            System.out.println("Digite a nota " + (i+1) + ": ");
            notas[i] = scanner.nextDouble();
            media = media + notas[i];
        }

        media = media / 4;

        if (media >= 7) {
            System.out.println("Aprovado!!");
        } else if (media >= 5) {
            System.out.println("Recuperação!");
        } else {
            System.out.println("Reprovado.");
        }

        scanner.close();
    }
}
