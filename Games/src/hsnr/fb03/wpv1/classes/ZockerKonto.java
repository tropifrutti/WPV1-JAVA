package hsnr.fb03.wpv1.classes;

public class ZockerKonto {
	private String kontoNummer;
	private double kontoStand;
	private String inhaber;
	
	public String getKontoNummer(){
		return kontoNummer;
	}

	public void setKontoNummer(String value){
		kontoNummer = value;
	}

	public String getKontoInhaber(){
		return inhaber;
	}

	public double getKontoStand(){
		return kontoStand;
	}
	
	public ZockerKonto(double betrag, String inhaber){
		this.kontoStand = betrag;
		this.inhaber = inhaber;
	}

	public void kontostandAendern(double betrag) throws Exception{
		if (betrag == 0) {
			return;
		}
		
		if ((kontoStand + betrag) > 0) {
			kontoStand += betrag;
			if (betrag > 0) {
				System.out.println(String.format("%.2f wurde im Konto %s eingezahlt.\n\tNeu Kontostand: %.2f", betrag, kontoNummer, kontoStand));
			} else {
				System.out.println(String.format("%.2f wurde vom Konto %s ausgezahlt.\n\tNeu Kontostand: %.2f", betrag, kontoNummer, kontoStand));
			}
		} else {
			throw new Exception(String.format("Auszahlung von %.2f ist unmoglich!\n\tAktuelles Kontostand: %.2f", betrag, kontoStand));
		}	
	}
}
