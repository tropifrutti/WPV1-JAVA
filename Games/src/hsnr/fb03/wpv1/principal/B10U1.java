package hsnr.fb03.wpv1.principal;

import hsnr.fb03.wpv1.classes.ZockerKonto;

public class B10U1 {

	public static void main(String[] args) {
		ZockerKonto kunde1 = new ZockerKonto(1250.0, "Gladis");
		try {
			kunde1.kontostandAendern(20);
			kunde1.kontostandAendern(-540);
			kunde1.kontostandAendern(-2000);
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
