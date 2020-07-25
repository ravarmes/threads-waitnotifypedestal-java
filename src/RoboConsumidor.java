
class RoboConsumidor implements Runnable {

    Pedestal p;

    RoboConsumidor(Pedestal p) {
        this.p = p;
    }

    public void run() {
        while (true) {
            synchronized (p) {
                while (p.livre) {
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Peça retirada");
                p.livre = true;
                p.notifyAll();
            }
        }
    }
}
