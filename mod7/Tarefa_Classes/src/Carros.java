public class Carros {

    private int id;
    private String modelo;
    private String montadora;
    private int ano;
    private int numPortas;
    private int numRodas;
    private float cilidradas;

    /**
     *
     * @return ID do carro
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * define id do carro
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     * define modelo do carro
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @return montadora
     */
    public String getMontadora() {
        return montadora;
    }

    /**
     *
     * @param montadora
     * define montadora do carro
     */
    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    /**
     *
     * @return ano
     */
    public int getAno() {
        return ano;
    }

    /**
     *
     * @param ano
     * define ano do carro
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     *
     * @return numero de portas do carro
     */
    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    /**
     *
     * @return número de rodas do carro
     */
    public int getNumRodas() {
        return numRodas;
    }

    /**
     * define número de rodas do carro para 4
     */
    public void setNumRodas() {
        this.numRodas = 4;
    }

    /**
     *
     * @return cilindradas do carro
     */
    public float getCilidradas() {
        return cilidradas;
    }

    /**
     *
     * @param cilidradas
     * define cilindradas do carro
     */
    public void setCilidradas(float cilidradas) {
        this.cilidradas = cilidradas;
    }
}
