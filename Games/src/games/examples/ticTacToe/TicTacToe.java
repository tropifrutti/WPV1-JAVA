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
		
		drawPanel.setPreferredSize(new Dimension(400, 400));
		
		frame.add(BorderLayout.NORTH, drawPanel);
		
		JPanel buttonPanel = new JPanel();
		//buttonPanel.setLayout(new FlowLayout()); //Default für JPanel ist schon FlowLayout
		
		JButton button1 = new JButton("Neues Spiel");
		button1.addActionListener(event -> {
				liste.clear();
				frame.repaint();
			}
		);
		buttonPanel.add(button1);
		
		JButton button2 = new JButton("Ende");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
			}
		});
		buttonPanel.add(button2);
		
		frame.add(buttonPanel);
		
		frame.setSize(420, 480);
		frame.setVisible(true);
	}
	
}
