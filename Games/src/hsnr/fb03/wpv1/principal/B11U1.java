package hsnr.fb03.wpv1.principal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import hsnr.fb03.wpv1.classes.Adresse;
import hsnr.fb03.wpv1.classes.Student;

public class B11U1 {

	public static void main(String[] args) {
		// Aufgabe b 
		Student student1 = new Student("M001", "Mike", new Adresse(47799, "Krefeld", "Südstr. 1")); 
		Student student2 = new Student("M002", "Andreas", new Adresse(47798, "Krefeld", "Westwall 1")); 
		List<Student> bewerberliste = new ArrayList<Student>(); 

		bewerberliste.add(student1); 
		bewerberliste.add(student2); 

		// Aufgabe c 
		String bewerberFile = "students.dat"; 
		writeStudent(bewerberliste, bewerberFile); 

		// Aufgabe d 
		List<Student> studentList = readStudent(bewerberFile); 
		System.out.println("Liste von Students:"); 
		for (Student student : studentList) { 
			System.out.println(String.format("\t%s |  %s |  %s", student.getMatrikelnummer(), student.getName(), student.getAnschrift())); 
	
		}
	}

	private static List<Student> readStudent(String filename){ 
		List<Student> students = new ArrayList<Student>(); 

		try { 
			FileReader fileStreamReader = new FileReader(filename);
			BufferedReader in = new BufferedReader( fileStreamReader ); 
			
			String line;
			while ((line = in.readLine()) != null) {
				String dataDelimiters = "\\#";
				String[] objectData = line.split(dataDelimiters);
				String addr = objectData[2];
				String addrDelimiters = "[ ,]";
				String[] objectAdresse = addr.split(addrDelimiters);
				Adresse adrObj = new Adresse(
						Integer.parseInt(objectAdresse[0]), 
						objectAdresse[1], 
						String.format("%s %s", objectAdresse[3], objectAdresse[4]));
				Student tmp = new Student(objectData[0], objectData[1], adrObj); 
				students.add(tmp); 
			} 
 
			in.close(); 
		} 
		catch (Exception ex) { 
			System.out.println("Es Konnte keine Datei einlesen.");
			ex.printStackTrace(); 
		} 
		return students; 
	} 

	private static void writeStudent(List<Student> students, String filename){ 
		try { 
			FileWriter fileStreamWriter = new FileWriter(filename); 
			BufferedWriter os = new BufferedWriter(fileStreamWriter); 
 
			for (Student student : students) { 
				os.write(String.format("%s#%s#%s\n", 
						student.getMatrikelnummer(),
						student.getName(),
						student.getAnschrift().toString())); 
			} 
			
			os.close(); 
		} catch (IOException e) { 
			System.out.println("Es Konnte keine Datei erstellen.");
			e.printStackTrace(); 
		} 
	} 
}