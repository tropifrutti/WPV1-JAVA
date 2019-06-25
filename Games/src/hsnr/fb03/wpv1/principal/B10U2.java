package hsnr.fb03.wpv1.principal;

import hsnr.fb03.wpv1.classes.Strange1;
import hsnr.fb03.wpv1.classes.Strange2;

public class B10U2 {

	public static void main(String[] args) throws InterruptedException {
		// Übung 2-a
		Strange1 u2a = new Strange1();
		u2a.start();
		
		// Übung 2-b
		Strange2 u2b = new Strange2();
		u2b.start();
		
		System.out.println("ende");
	}
}