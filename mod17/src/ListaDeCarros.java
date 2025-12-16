import java.util.ArrayList;
import java.util.List;

public class ListaDeCarros<L extends Carro> {
    private List<L> carros;

    public ListaDeCarros() {
        carros = new ArrayList<>();
    }

    public void adicionaCarro(L carro) {
        carros.add(carro);
    }

    public void listarCarros() {
        for(L carro : carros) {
            System.out.println(carro);
        }
    }
}
