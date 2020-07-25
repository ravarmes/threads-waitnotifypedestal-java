
class RoboProdutor implements Runnable {

    Pedestal p;

    RoboProdutor(Pedestal p) {
        this.p = p;
    }

    public void run() {
        while (true) {
            synchronized (p) {
                while (!p.livre) {
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Peça colocada");
                p.livre = false;
                p.notifyAll();
            }
        }
    }
}
