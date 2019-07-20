package hsnr.fb03.wpv1.classes;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import hsnr.fb03.wpv1.interfaces.IStrange;

public class Strange1 implements IStrange, ActionListener {
	public void start() {
		JFrame frame = new JFrame("Hallo");
		JButton button = new JButton("Welt");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.add(button);
		frame.setSize(100, 100);
		frame.setLocation(400, 320);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}