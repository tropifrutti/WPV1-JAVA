package games.examples.ticTacToe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import games.basic.gameObjects.CircularGameObject;
import games.basic.gameObjects.CrossGameObject;
import games.basic.gameObjects.interfaces.GameObject;
import games.basic.position.Position;

public class TicTacToe {

	public static void main(String[] args) {
		
		ArrayList<GameObject> liste = new ArrayList<GameObject>();
		
		//nicht sicher warum ich hier dieses Objekt erzeugen muss aber Eclipse hat es verlangt
		TicTacToe obj = new TicTacToe();
		JFrame frame = new JFrame("TicTacToe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//hier muss ich die liste übergeben!!!
		TicPanel drawPanel = new TicPanel(liste, frame);
		drawPanel.setLayout(new BoxLayout(drawPanel, BoxLayout.Y_AXIS));
		
		
		//frame.setLayout(new FlowLayout());
		drawPanel.setPreferredSize(new Dimension(400, 400));
		
		frame.add(BorderLayout.PAGE_START, drawPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JButton button1 = new JButton("Neues Spiel");
		button1.addActionListener(obj.new Button1Listener(frame, liste));
		buttonPanel.add(button1);
		
		JButton button2 = new JButton("Ende");
		button2.addActionListener(obj.new Button2Listener(frame));
		buttonPanel.add(button2);
		
		frame.add(buttonPanel);
		
		frame.setSize(420, 480);
		frame.setVisible(true);
		
		//liste.add(new CircularGameObject(new Position((drawPanel.getX()+drawPanel.getWidth()*2/3)+10, drawPanel.getY()+10), (drawPanel.getWidth()/3)-20));
		//liste.add(new CrossGameObject(new Position((drawPanel.getX()+drawPanel.getWidth()/3)+10, drawPanel.getY()+10), (drawPanel.getWidth()/3)-20, (drawPanel.getWidth()/3)-20));

		//frame.repaint();

	}
	
	class Button1Listener implements ActionListener {
		ArrayList<GameObject> liste;
		JFrame frame;
		public Button1Listener (JFrame frame, ArrayList<GameObject> liste) {
			this.liste = liste;
			this.frame = frame;
		}
		public void actionPerformed(ActionEvent event) {
			this.liste.clear();
			this.frame.repaint();
		}
	}
	
	class Button2Listener implements ActionListener {
		JFrame frame;
		public Button2Listener(JFrame frame) {
			this.frame = frame;
		}
		public void actionPerformed(ActionEvent event) {
			this.frame.dispose();
		}
	}
}
