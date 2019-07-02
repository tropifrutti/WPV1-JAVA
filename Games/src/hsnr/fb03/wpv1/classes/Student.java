package hsnr.fb03.wpv1.classes;

import java.io.Serializable;

public class Student implements Serializable {
	/** 
	 *  
	 */ 
	private static final long serialVersionUID = 4749681474690039853L; 

	private String name; 

	private String matrikelnummer; 

	private Adresse anschrift;
	
	public String getName(){ 
		return name;
	} 

	public String getMatrikelnummer(){ 
		return matrikelnummer; 
	} 

	public String getAnschrift(){ 
		return anschrift.toString(); 
	} 

	public void setAnschrift(Adresse anschrift){ 
		this.anschrift = anschrift; 
	} 

	public void setAnschrift(int plz, String ort, String str){ 
		this.anschrift = new Adresse(plz, ort, str); 
	} 

	public Student(String matrikel, String fullName, Adresse anschrift){ 
		matrikelnummer = matrikel; 
		name = fullName; 
		this.anschrift = anschrift; 
	} 
}