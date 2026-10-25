package SendReceiveMsgCom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WithdrawTask implements Runnable {

	private BankAccount account;
	private int amount;
	public WithdrawTask (BankAccount account,int amount) {
		this.account=account;
		this.amount=amount;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	account.withdraw(amount);
	}
	
}
class BankAccount {
	private int balance;
	public BankAccount(int balance) {
		this.balance = balance;
	}
	public void withdraw(int amount) {
		synchronized(this) { //must be object type
		  if (balance >= amount) {
			  try {
	                Thread.sleep(10);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
			  
	           System.out.println(Thread.currentThread().getName() + " is about to withdraw");
	           balance = balance - amount;
	           System.out.println(Thread.currentThread().getName() + " completed the withdrawal, remaining balance: " + balance);
	        } else {
	            System.out.println(Thread.currentThread().getName() + " tried to withdraw, but insufficient funds");
	        }
		}
		  
	}
	public synchronized int getBalance() {
		return this.balance;
	}
}
public class Threads2 {

	
	
	 public static void main(String[] args) {
		 
		 
		 BankAccount account = new BankAccount(100);
		 
		 Thread t1 =new Thread(new WithdrawTask(account, 50), "Thread-1");
		 Thread t2 = new Thread (new WithdrawTask(account, 50), "Thread-2");
		 Thread t3 = new Thread (new WithdrawTask(account, 50), "Thread-3");
		 
		 
		 t1.start();
		 t2.start();
		 t3.start();
		 
		 try {
			 t1.join();
			 t2.join();
			 t3.join();
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
		/*
		 List<Integer> list = new ArrayList<>(Arrays.asList());
		 
		 
		 Thread task1 = new Thread(new Runnable() {
			 @Override
			 public void run() {
				 
				 for(int i = 1; i<5;i++) {
					 synchronized(list) {
					 list.add(i);
					 }
				 }
				 System.out.println(list.toString());
			 }
		 });
		 Thread task3 = new Thread(new Runnable() {
			 @Override
			 public void run() {
				 for(int i = 10; i<15;i++) {
					synchronized(list) {
						list.add(i);
					}
				 }
				 System.out.println(list.toString());
			 }
		 });
		 Thread task2 = new Thread(new Runnable() {
			 @Override
			 public void run() {
				 for(int i = 5; i<10;i++) {
					synchronized(list) {
						list.add(i);
					}
				 }
				 System.out.println(list.toString());
			 }
		 });
		 task1.start();
		 task2.start();
		 task3.start();
		 
		 try {
			task1.join();
			task2.join();
			task3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		 /*
		 Runnable downloadTask = () -> {
	            System.out.println("Nedlasting pågår...");
	            try {
	                Thread.sleep(3000); 
	                System.out.println("Nedlasting fullført!");
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        };
	        
	        Runnable processDataTask = () -> {
	        	try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	            System.out.println("Starter behandling av data...");
	            try {
	                Thread.sleep(2000);
	                System.out.println("Behandling fullført!");
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        };
	        
	        Thread downloadThread = new Thread(downloadTask);
	        
	        Thread processThread = new Thread(processDataTask);
	        
	        downloadThread.start();
	        try {
	        	downloadThread.join();
	        } catch(InterruptedException e) {
	        	e.printStackTrace();
	        }
	        processThread.start();
	       
	        */
		 /*
		 Melding melding = new Melding();
		 
		 Thread print1 = new Thread(new Runnable() {

				@Override
				public void run() {
					//thread sleeps 
					System.out.println(melding.getMelding());
				}
			   });
				 Thread tt1 = new Thread(new Runnable() {

					@Override
					public void run() {		
						melding.setMelding("Hallo");
					}
				 });
				 print1.start();
				 tt1.start();
				 
	   */
	   /*
	   Thread print1 = new Thread(new Runnable() {

		@Override
		public void run() {
		
			//busy thread loop keeps cpu busy
			//bad
			 
			while (melding == null) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(melding);
		}
		   
	   });
		 Thread tt1 = new Thread(new Runnable() {

			@Override
			public void run() {
				melding = "Hallo";
				
			}
			 
		 });
		 print1.start();
		 tt1.start();
	   */     
	 }
	
	 }
