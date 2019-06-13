package hsnr.fb03.wpv1.classes;

import java.util.Map;

public class ZockerBank {
	private Map<String, ZockerKonto> kontoCollection;
	
	private String name;
	
	public String getBankname(){
		return name;
	}
	
	public ZockerBank(String bankName){
		this.name = bankName;
	}
	
	public ZockerKonto getKonto(int kontoNummer){
		String kontoNummerStr = String.format("%d", kontoNummer);
		if (!kontoCollection.isEmpty() && kontoCollection.containsKey(kontoNummerStr)) {
			return kontoCollection.get(kontoNummerStr);
		} else {
			return null;
		}
	}
	
	public ZockerKonto getKonto(String kontoInhaber){
		return null;
	}
	
	public ZockerKonto[] getKontos(){
		return null;
	}
	
	public void kontoHinzufuegen(ZockerKonto konto){
		
	}
}
