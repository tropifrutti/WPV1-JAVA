package hsnr.fb03.wpv1.principal;

import hsnr.fb03.wpv1.classes.*;

public class B10U1 {

	public static void main(String[] args) {
		ZockerBank bank = new ZockerBank("Zockerbank");
		ZockerKonto kunde1 = bank.kontoHinzufuegen("Gladis");
		bank.setStartBonus(50);
		ZockerKonto kunde2 = bank.kontoHinzufuegen("Gladis");
		try {
			kunde1.kontostandAendern(712);
			kunde2.kontostandAendern(2725.49);
			kunde1.kontostandAendern(-540);
			kunde2.kontostandAendern(-540.75);
			kunde2.kontostandAendern(-2000);
			kunde1.kontostandAendern(-2000);
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
