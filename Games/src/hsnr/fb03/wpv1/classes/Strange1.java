package hsnr.fb03.wpv1.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Strange1 implements ActionListener {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hallo");
		JButton button = new JButton("Welt");
		button.addActionListener(null);
		frame.add(button);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}