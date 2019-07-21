package hsnr.fb03.wpv1.principal;

import hsnr.fb03.wpv1.classes.SchiffeVersenken1D;
import hsnr.fb03.wpv1.interfaces.ISchiffeVersenken;

public class B01U4 {

	public static void main(String[] args) {
		ISchiffeVersenken spiel = new SchiffeVersenken1D();
		spiel.run();
	}

}