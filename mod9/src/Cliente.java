import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Informe o código do cliente (número inteiro): ");
    int numero = scanner.nextInt();

    Integer numeroWrapper = numero;
    System.out.println("O código digitado foi "+numeroWrapper);

    scanner.close();
    }
}
