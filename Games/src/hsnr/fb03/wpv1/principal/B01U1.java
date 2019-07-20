package hsnr.fb03.wpv1.principal;

public class B01U1 {

	public static void main(String[] args) {
		short s = 7;
		int i = -12;
		unsigned int u = +12;
		long l = 123456789;
		float f = 3.1415;
		double d = 3.1415;
		s = i;
		i = s;
		s = 123456789;
		int i2 = (int) l;
		i = 12.4;
		i = 12L;
		i = (int) 12L;
		String str = "Hallo" + "Welt";
		str = args[-3];
		str = "i = " + i;
		str = str - i;
		boolean b = false;
		b = 12L == 12;
	}

}
