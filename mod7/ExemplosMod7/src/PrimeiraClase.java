public class PrimeiraClase {
    public static void main(String[] args) {
        System.out.println("Olá Guilherme");
        Cliente cliente = new Cliente();
        cliente.setNome("Guilherme");
        cliente.cadastrarEndereco("Rua teste");

        System.out.println(cliente.getEndereco());
        cliente.imprimirEndereco();

        String end = cliente.retornarNomeCliente();

        System.out.println(end);
        System.out.println(cliente.getValorTotal());
    }
}
