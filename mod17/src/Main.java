//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CarroEsportivo carroEsportivo = new CarroEsportivo("Porsche", "911", 2019, "amarelo", 401);
        CarroSUV carroSUV = new CarroSUV("Jeep", "Renegade", 2023, "preto", 360);

        ListaDeCarros<Carro> listaDeCarros = new ListaDeCarros<>();

        listaDeCarros.adicionaCarro(carroEsportivo);
        listaDeCarros.adicionaCarro(carroSUV);

        listaDeCarros.listarCarros();
    }
}