package Oblig2;

public class Waiter3 extends Thread{

    private final Brett3 brett;

    public Waiter3(Brett3 brett, String name) {
        super(name);
        this.brett = brett;
    }

    @Override
    public void run() {
        try {
            while (true) {
                brett.taUtHamburger(this);
                Thread.sleep(2000 + (int) (Math.random() * 4000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
