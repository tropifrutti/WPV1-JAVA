package hsnr.fb03.wpv1.principal;

public class B01U1 {

	public static void main(String[] args) {
		short s = 7;
		int i = -12;
		/*unsigned */int u = +12; // unsigned ist unbekannt
		long l = 123456789;
		float f = 3.1415F; // Typfehler: double statt float!
		double d = 3.1415;
		s = (short)i; // Typfehler: Kann man impliziert nicht ein short zu int umwandeln!
		System.out.println("Explizierte Umwandlung mit richtigen Wert: s = " + s + " genau wie " + i);
		i = s;
		s = (short)123456789; // Typfehler: int statt short, da die Zahl zu groß ist.
		System.out.println("Explizierte Umwandlung mit flaschen Wert: s = " + s + " anstatt 123456789");
		int i2 = (int) l;
		i = (int)12.4; // Typfehler: double statt int
		System.out.println("Explizierte Umwandlung mit flaschen Wert: i = " + i + " anstatt 12.4");
		i = (int)12L; // Typfehler: long statt int
		System.out.println("i = " + i + " genau wie 12L");
		i = (int) 12L;
		String str = "Hallo" + "Welt";
		try {
			str = args[-3]; //args[-3]; // Laufzeitfehler: ArrayIndexOutOfBoundsException
		} catch (Exception e) {
			e.printStackTrace();
		}
		str = "i = " + i;
		//str = str - i; // Operator - undefiniert für String x int
		boolean b = false;
		b = 12L == 12;
		System.out.println("b ist " + b);
	}

}
