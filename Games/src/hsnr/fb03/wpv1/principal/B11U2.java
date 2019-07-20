package hsnr.fb03.wpv1.principal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import hsnr.fb03.wpv1.classes.Adresse;
import hsnr.fb03.wpv1.classes.Student;

public class B11U2 {

	public static void main(String[] args) {
		// Aufgabe a 
		Student student1 = new Student("M001", "Mike", new Adresse(47799, "Krefeld", "Südstr. 1")); 
		Student student2 = new Student("M002", "Andreas", new Adresse(47798, "Krefeld", "Westwall 1")); 
		List<Student> bewerberliste = new ArrayList<Student>(); 

		bewerberliste.add(student1); 
		bewerberliste.add(student2); 

		String bewerberFile = "..\\data\\students-2.dat"; 
		writeBin(bewerberliste, bewerberFile); 

		// Aufgabe b
		List<Student> studentList = readBin(bewerberFile); 
		System.out.println("Liste von Students:"); 
		for (Student student : studentList) { 
			System.out.println(String.format("\t%s |  %s |  %s", student.getMatrikelnummer(), student.getName(), student.getAnschrift())); 
	
		}
	}

	private static List<Student> readBin(String filename){ 
		List<Student> students = new ArrayList<Student>(); 

		try { 
			FileInputStream fileStreamReader = new FileInputStream(filename); 
			ObjectInputStream os = new ObjectInputStream( fileStreamReader ); 
			Student tmp = (Student)os.readObject(); 

			while (tmp != null) { 
				students.add(tmp); 
				
				try{ 
					tmp = (Student)os.readObject(); 
				} 
				catch (Exception ex){ 
					tmp = null;
				}
			} 

			os.close(); 
		} 
		catch (Exception ex) { 
			System.out.println("Es Konnte keine Datei einlesen."); 
			ex.printStackTrace();
		} 

		return students; 
	} 

	private static void writeBin(List<Student> students, String filename){ 
		try { 
			FileOutputStream fileStreamWriter = new FileOutputStream(filename);
			ObjectOutputStream os = new ObjectOutputStream(fileStreamWriter); 

			for (Student student : students) { 
				os.writeObject(student); 
			} 

			os.close(); 
		} catch (IOException e) { 
			System.out.println("Es Konnte keine Datei erstellen.");
			e.printStackTrace(); 
		} 
	} 
}