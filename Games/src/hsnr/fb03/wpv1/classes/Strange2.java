package hsnr.fb03.wpv1.classes;

import hsnr.fb03.wpv1.interfaces.IStrange;

public class Strange2 implements IStrange, Runnable {
	public void start() {
		Runnable r = new Strange2();
		Thread t = new Thread(r);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("in start");
	}
}