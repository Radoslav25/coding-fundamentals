package Oblig2;

public class Waiter extends Thread {

	private Brett brett;
	public String navn;
	
	public Waiter(Brett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}
	public Brett getBrett() {
		return brett;
	}
	public String getNavn() {
		return navn;
	}
	
	public void run()	{
		try {
			while(true) {
				brett.taHam(this);
				Thread.sleep(1500);
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
