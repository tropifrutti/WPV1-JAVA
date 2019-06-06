package games.examples.ticTacToe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import games.basic.gameObjects.CircularGameObject;
import games.basic.gameObjects.CrossGameObject;
import games.basic.gameObjects.interfaces.GameObject;
import games.basic.position.Position;

public class TicPanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	ArrayList<GameObject> liste;
	JFrame frame;
	boolean kreis;


	public TicPanel(ArrayList<GameObject> liste2) {
		this.liste = liste2;
		addMouseListener(this);
		this.kreis = false;
	}

	public TicPanel(ArrayList<GameObject> liste, JFrame frame) {
		this.liste = liste;
		this.frame = frame;
		addMouseListener(this);
		this.kreis = false;
		
	}

	public void mouseClicked(MouseEvent event) {
		int x = (int) event.getPoint().getX() / (this.getWidth()/3);
		int y = (int) event.getPoint().getY() / (this.getHeight()/3);
		//String str = "x:" + x  + ", y:" + y;
		//JOptionPane.showMessageDialog(null, str);
		
		if (kreis) {
			liste.add(new CircularGameObject(new Position((this.getX()+this.getWidth()*x/3)+10, (this.getY()+this.getHeight()*y/3)+10), (this.getWidth()/3)-20));
			kreis = false;
		} else {
			liste.add(new CrossGameObject(new Position((this.getX()+this.getWidth()*x/3)+10, (this.getY()+this.getHeight()*y/3)+10), (this.getWidth()/3)-20, (this.getHeight()/3)-20));
			kreis = true;
		}
		
		frame.repaint();
		
		if (win()=="kreis") {
			JOptionPane.showMessageDialog(null, "Glückwunsh! Kreis hat gewonnen!");
			liste.clear();
		}
		
		if (liste.size()==9) {
			JOptionPane.showMessageDialog(null, "Niemand hat gewonnen");
			liste.clear();
		}
		
	
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) { 
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2.5f));
		g.setColor(Color.black);
		g.drawLine(this.getX()+this.getWidth()/3, this.getY(), this.getX()+this.getWidth()/3, this.getY()+this.getHeight());
		g.drawLine(this.getX()+this.getWidth()*2/3, this.getY(), this.getX()+this.getWidth()*2/3, this.getY()+this.getHeight());
		g.drawLine(this.getX(), this.getY()+this.getHeight()/3, this.getX()+this.getWidth(), this.getY()+this.getHeight()/3);
		g.drawLine(this.getX(), this.getY()+this.getHeight()*2/3, this.getX()+this.getWidth(), this.getY()+this.getHeight()*2/3);


		
		//also hier gehe ich durch die liste und rufe jeweils die paint components methode mit diesem g von hier als Übergabeparameter

		for (GameObject elem : liste) {
			elem.paintComponent(g);
		}
		
		
		//Um die Buttons genrisch zu zeichnen
		
		
	}
	
	public String win() {
		return "";
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
