package hsnr.fb03.wpv1.classes;

public class ZockerKonto {
	private int nummer;
	private double kontoStand;
	private String inhaber;
	private static int nextKontoIndex = 498000001;
	
	public int getNummer(){
		return nummer;
	}

	public String getInhaber(){
		return inhaber;
	}

	public double getKontoStand(){
		return kontoStand;
	}
	
	public ZockerKonto(double betrag, String inhaber){
		this.kontoStand = betrag;
		this.inhaber = inhaber;
		this.nummer = ZockerKonto.nextKontoIndex++;
		System.out.println(String.format("Neu Konto erzeugt:\nKontonummer: %d\nKontoinhaber: %s\nKontozustand: %.2f", this.nummer, this.inhaber, this.kontoStand));
	}

	public void kontostandAendern(double betrag) throws Exception{
		if (betrag == 0) {
			return;
		}
		
		if ((kontoStand + betrag) > 0) {
			kontoStand += betrag;
			if (betrag > 0) {
				System.out.println(String.format("%.2f wurde im Konto %d eingezahlt.\nNeu Kontostand: %.2f", betrag, nummer, kontoStand));
			} else {
				System.out.println(String.format("%.2f wurde vom Konto %d ausgezahlt.\nNeu Kontostand: %.2f", betrag, nummer, kontoStand));
			}
		} else {
			throw new Exception(String.format("Auszahlung von %.2f ist unmoglich!\nAktuelles Kontostand: %.2f", betrag, kontoStand));
		}	
	}

}
