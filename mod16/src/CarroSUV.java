public class CarroEsportivo extends Carro{
    private int potencia;

    public CarroEsportivo(String marca, String modelo, int ano, String cor, int potencia) {
        super(marca, modelo, ano, cor);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Potência: " + potencia + "HP";
    }
}
