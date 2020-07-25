
/**
 *
 * Demonstracao de wait/notify que sincronizam a
 * execucao verificando se o pedestal estah livre
 * ou ocupado.
 */
public class Main {

    public static void main(String[] args) {
        Pedestal p = new Pedestal();
        Thread prod = new Thread(new RoboProdutor(p), "Produtor");
        Thread cons = new Thread(new RoboConsumidor(p), "Consumidor");
        cons.start();
        prod.start();
    }
}
