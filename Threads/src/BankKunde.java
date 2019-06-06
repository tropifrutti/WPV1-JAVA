

public class BankKunde extends Kunde implements Runnable {

	
	public BankKunde(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		for(int i=0; i<50; i++) {
			System.out.println("Jetzt arbeitet "+this.name+" "+i+".te Mal");
		}
		
	}
	

}
