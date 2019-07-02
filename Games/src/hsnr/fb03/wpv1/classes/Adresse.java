package hsnr.fb03.wpv1.classes;

public class Adresse { 
	
	public int PLZ; 
 
	public String Ort; 
 
	public String Strasse; 

	public Adresse(int plz, String ort, String str){ 
		PLZ = plz; 
		Ort = ort; 
		Strasse = str; 
	} 

	@Override 
	public String toString(){ 
		return String.format("%d %s, %s", PLZ, Ort, Strasse); 

	}
}