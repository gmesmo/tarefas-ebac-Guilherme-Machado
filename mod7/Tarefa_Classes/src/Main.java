//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * @version 1.0
 */

public class Main {

    /**
     * classe principal
     * @param args
     */
    public static void main(String[] args) {
        Carros carro = new Carros();

        /**
         * @implNote  Define valores do carro.
         */
        carro.setId(1);
        carro.setModelo("HB20");
        carro.setMontadora("Hyundai");
        carro.setAno(2022);
        carro.setNumPortas(4);
        carro.setNumRodas();
        carro.setCilidradas(1.8F);

        /**
         * @implNote Imprime valores do carro
         */
        System.out.println(carro.getId());
        System.out.println(carro.getModelo());
        System.out.println(carro.getMontadora());
        System.out.println(carro.getAno());
        System.out.println(carro.getNumPortas());
        System.out.println(carro.getNumRodas());
        System.out.println(carro.getCilidradas());
    }
}