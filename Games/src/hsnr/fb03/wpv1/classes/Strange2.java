package hsnr.fb03.wpv1.classes;

public class Strange2 implements Runnable {

	public static void main(String[] args) {
		Runnable r = new Strange2();
		Thread t = new Thread(r);
		t.start();
	}

	@Override
	public void run() {
		System.out.println("in start");
	}
}