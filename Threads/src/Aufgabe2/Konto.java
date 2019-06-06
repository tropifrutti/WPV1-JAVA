package Aufgabe2;

public class Konto {   
	private int kontostand = 50; // Anfangsstand 50 Euro    
public int getKontoStand() {   
	return this.kontostand;  
	}    
public void abbuchen(int betrag) {   
	int kontostand = this.kontostand;   
	this.kontostand = kontostand - betrag;   
	} 
}
