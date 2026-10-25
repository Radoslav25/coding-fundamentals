package Oblig2;

import javax.swing.JOptionPane;

public class Oppgave1 {

	public static volatile boolean running = true;
	public static volatile String melding = "Hello World!";
	
	public static void main(String[] args) {
	
		Thread print = new Thread (()->{
			while(running) {
				System.out.println(melding);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread bruker = new Thread(()-> {
			while(running) {
				String string = JOptionPane.showInputDialog("Enter \"quit\" to exit");
				if (string.equalsIgnoreCase("quit")) {
					running = false;
					System.out.println("Program avslutter");
				} else {
					melding = string;
					System.out.println(string);
				}			
			}
		});
		print.start();
		bruker.start();

		try {
			print.join();
			bruker.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
