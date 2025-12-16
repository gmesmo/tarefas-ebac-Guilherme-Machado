public class CarroSUV extends Carro{
    private int capacidadeCarga;

    public CarroSUV(String marca, String modelo, int ano, String cor, int capacidadeCarga) {
        super(marca, modelo, ano, cor);
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidade de carga: " + capacidadeCarga + "HP";
    }
}
