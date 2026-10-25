package Oblig2;

public class Cook extends Thread {

	private Brett brett;
	private String navn;
	
	public Cook(Brett brett, String navn) {
		this.brett=brett;
		this.navn = navn;
	}
	 @Override
	    public void run() {
	        try {
	            while (true) {
	                O2Hamburger burger = new O2Hamburger();
	                brett.addHam(burger, this);
	                Thread.sleep(1000);
	            }
	        } catch (InterruptedException e) {
	           e.printStackTrace();
	        }
	        
	    }
	public Brett getBrett() {
		return brett;
	}
	
	public String getNavn() {
		return navn;
	}

	}

