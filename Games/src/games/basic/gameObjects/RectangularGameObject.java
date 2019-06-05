package games.basic.gameObjects;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import games.basic.position.interfaces.Positionable;


public class RectangularGameObject extends AbstractGameObject {

	private int width;
	private int height;
	
	
	// Konstruktor
	// Beachte: Parameter Positionable 'pos' fehlte im Aufgabenblatt
	public RectangularGameObject(Positionable pos, int width, int height) {
		// Beachte: jetzt nicht this.pos setzen, sondern super.pos !
		super(pos);		// Aufruf: AbstractGameObject(pos);
		this.width  = width;
		this.height = height;
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
				+ ", size = " + this.getWidth() + " x " + this.getHeight()+ ")");
	}
	
	public boolean equals(Object other) {
		if (other == null || !(other instanceof RectangularGameObject))
			return false;
		
		RectangularGameObject otherRect = (RectangularGameObject)other;
		Positionable thisPos  = this.getPos();
			// Beachte: this.pos funktioniert nicht, da Attribut pos in Oberklasse private ist!
			//		    --> getPos() funktioniert, egal ob Attribut pos hier oder in Oberklasse 
			//		  	 	definiert ist
		Positionable otherPos = otherRect.getPos();
		
		return  // vergleiche aktuelle Position
				//		verwende equals-Methode von Positionable
				thisPos.equals( otherPos )
				// vergleiche Breite/Höhe
				&& this.getWidth() == otherRect.getWidth()
				&& this.getHeight() == otherRect.getHeight();
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(4.5f));
		g.setColor(Color.black);
		g.drawRect(this.getPos().getX(), this.getPos().getY(), width, height);
		
	}
	
	
}
