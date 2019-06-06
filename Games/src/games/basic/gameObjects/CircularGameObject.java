package games.basic.gameObjects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import games.basic.position.interfaces.Positionable;

public class CircularGameObject extends AbstractGameObject {

	private int width;
	private int height;
	
	// Konstruktor
	// Beachte: Parameter Positionable 'pos' fehlte im Aufgabenblatt
	public CircularGameObject(Positionable pos, int diameter) {
		// Beachte: jetzt nicht this.pos setzen, sondern super.pos !
		super(pos);		// Aufruf: AbstractGameObject(pos);
		this.width = diameter;
		this.height = diameter;		
	}	
	
	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}
	
	public String toString() {
		// verwende toString-Methode aus Positionable
		return ("pos = " + this.getPos()
				+ ", diameter = " + this.width + ")");
	}
	
	public boolean equals(Object other) {
		if (other == null || !(other instanceof CircularGameObject))
			return false;
		
		CircularGameObject otherCirc = (CircularGameObject)other;
			// Beachte: this.pos funktioniert nicht, da Attribut pos in Oberklasse private ist!
			//		    --> getPos() funktioniert, egal ob Attribut pos hier oder in Oberklasse 
			//		  	 	definiert ist
		Positionable thisPos  = this.getPos();
		Positionable otherPos = otherCirc.getPos();
		
		return  // vergleiche aktuelle Position
				//		verwende equals-Methode von Positionable
				thisPos.equals( otherPos )
				// vergleiche Breite/Höhe
				&& this.width == otherCirc.width;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(4.5f));
		g.setColor(Color.blue);
		g.drawOval(this.getPos().getX(), this.getPos().getY(), width, height);				
	}
}