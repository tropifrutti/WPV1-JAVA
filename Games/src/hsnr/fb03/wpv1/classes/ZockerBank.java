package hsnr.fb03.wpv1.classes;

import java.util.HashMap;
import java.util.Map;

public class ZockerBank {
	private static int nextKontoIndex = 1;
	
	private final static int MAX_KONTO_INDEX = 99999999;
	
	private Map<String, ZockerKonto> kontoCollection;
	
	private String name;
	
	private double startBonus;
	
	public void setStartBonus(double value){
		if (value >= 0.0) {
			this.startBonus = value;
		}
	}
	
	public String getBankname(){
		return name;
	}
	
	public ZockerBank(String bankName){
		this.name = bankName;
		this.startBonus = 0.0;
		this.kontoCollection = new HashMap<String, ZockerKonto>();
	}
	
	public ZockerKonto getKonto(String kontoNummer){
		if (!kontoCollection.isEmpty() && kontoCollection.containsKey(kontoNummer)) {
			return kontoCollection.get(kontoNummer);
		} else {
			return null;
		}
	}
	
	public ZockerKonto[] getKontos(){
		return null;
	}
	
	public ZockerKonto kontoHinzufuegen(String kontoInhaber){
		if (ZockerBank.nextKontoIndex < MAX_KONTO_INDEX) {
			String newKontonummer = String.format("80150005%8d", ZockerBank.nextKontoIndex++);
			newKontonummer = newKontonummer.replaceAll(" ", "0");
			ZockerKonto newKonto = new ZockerKonto(startBonus, kontoInhaber);
			newKonto.setKontoNummer(newKontonummer);
			kontoCollection.putIfAbsent(newKonto.getKontoNummer(), newKonto);
			System.out.println(
					String.format("Neu Konto erzeugt:\n\tKontonummer: %s\n\tKontoinhaber: %s\n\tKontozustand: %.2f", 
					newKonto.getKontoNummer(), 
					newKonto.getKontoInhaber(), 
					newKonto.getKontoStand()));
			
			return newKonto;
		}
		else{
			return null;
		}
	}
}
