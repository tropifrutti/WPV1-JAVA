
public class Main {

	public static void main(String[] args) {
		Runnable dagobert = new BankKunde("Dagobert");
		Runnable donald = new BankKunde("Donald");
		
		Thread t1 = new Thread(dagobert);
		Thread t2 = new Thread(donald);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main Thread");

	}

}
