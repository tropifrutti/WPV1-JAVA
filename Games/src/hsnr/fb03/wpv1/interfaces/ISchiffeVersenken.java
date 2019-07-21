/**
 * 
 */
package hsnr.fb03.wpv1.interfaces;

/**
 * @author douabalet
 *
 */
public interface ISchiffeVersenken {
	int eingabeTipp();
	boolean pruefeTipp(boolean[] feld, int tippPos);
	void run();
	String toString(boolean[] spielFeld);
}
