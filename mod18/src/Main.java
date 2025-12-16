//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Class<Cliente> classe = Cliente.class;

        if(classe.isAnnotationPresent(Tabela.class)) {
            Tabela tabela = classe.getAnnotation(Tabela.class);
            String nomeTabela = tabela.value();

            System.out.println("Nome tabela: " + nomeTabela);
        }
    }
}