package Oblig2;

public class Cook3 extends Thread {

	private final Brett3 brett;
	
	public Cook3(Brett3 brett, String name) {
		super(name);
		this.brett = brett;
	}
	
	@Override
	public void run()	{
		try {
			while(true) {
				Hamburger3 hamb = new Hamburger3();
				brett.leggTilHamburger(hamb, this);
				Thread.sleep(2000 + (int)Math.random()*4000);
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
