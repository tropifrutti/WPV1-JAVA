package hsnr.fb03.wpv1.classes;

import java.util.Scanner;

import hsnr.fb03.wpv1.interfaces.ISchiffeVersenken;

public class SchiffeVersenken1D implements ISchiffeVersenken {

	@Override
	public int eingabeTipp() {
		System.out.print("Raten Sie die Position des Schiifes ein: ");
		Scanner scanner = new Scanner(System.in);
		int eingabe = scanner.nextInt();
		//scanner.close();
		return eingabe;
	}

	@Override
	public void run() {
		final int SCHIFFS_GROESSE = 3;
		boolean[] feld = { false, false, true, true, true, false, false, false, false, false };
		int anzahlVersuche = 0;
		int anzahlTreffer = 0;
		boolean lebt = true; // Spiel noch "am Leben"?
		
		while (lebt == true) {
			int tipp = eingabeTipp();
			anzahlVersuche++;
			boolean ergebnis = pruefeTipp(feld, tipp);
			String ausgabe = "Vorbei";
			if (ergebnis == true) {
				ausgabe = "Treffer";
				anzahlTreffer++;
				feld[tipp] = false;
				if (anzahlTreffer == SCHIFFS_GROESSE) {
					ausgabe = "Versenkt";
					lebt = false; // Ende
				}
			}
			System.out.println(ausgabe);
		}
		System.out.println("Sie haben " + anzahlVersuche + " Versuche benötigt.");
		System.out.println("Spielfeld: " + toString(feld));
	}

	@Override
	public String toString(boolean[] spielFeld) {
		String ausgabe = "";
		for (int i = 0; i < spielFeld.length; i++) {
			String c;
			if (spielFeld[i])
				c = "o"; // Schiff
			else
				c = "_"; // Wasser
			ausgabe += c + ' ';
		}
		return ausgabe;
	}
	
	@Override
	public boolean pruefeTipp(boolean[] feld, int tippPos) {
		// Test auf falsche Eingabe
		if (feld == null)
			return false;
		
		if (tippPos < 0 || tippPos > feld.length)
			return false;
		
		return feld[tippPos];
	}

}
