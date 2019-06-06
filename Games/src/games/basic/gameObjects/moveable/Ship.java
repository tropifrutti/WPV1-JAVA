package games.basic.gameObjects.moveable;
import java.awt.Graphics;

import games.basic.gameObjects.RectangularGameObject;
import games.basic.position.interfaces.Positionable;

public class Ship extends AbstractMoveableGameObject {

	private int size;
	private boolean isHorizontal;
	
	// Konstruktor
	// Beachte: Parameter Positionable 'deltaPos' fehlte im Aufgabenblatt
	public Ship(Positionable pos, int size, boolean isHorizontal, Positionable deltaPos) {
		super(pos, deltaPos);		// Aufruf: AbstractMoveableGameObject(deltaPos);
		this.size  = size;
		this.isHorizontal = isHorizontal;
	}
	
	// get-Methoden
	public int getSize() {
		return this.size;
	}
	public boolean isHorizontal() {
		return this.isHorizontal;
	}
	
	@Override
	public int getWidth() {
		// Berechne Breite
		if (this.isHorizontal)
			return this.size;
		else
			return 1;
	}

	@Override
	public int getHeight() {
		// Berechne Höhe
		if (this.isHorizontal)
			return 1;
		else
			return this.size;
	}
	
	public String toString() {
		// verwende toString-Methode aus Positionable
		return ("pos = " + this.getPos()
				+ ", size = " + this.getWidth() + " x " + this.getHeight()+ ")")
				+ ", direction = " + this.getDeltaPos();
	}
	
	public boolean equals(Object other) {
		if (other == null || !(other instanceof RectangularGameObject))
			return false;
		
		Ship otherShip = (Ship)other;
		Positionable thisPos  = this.getPos();
			// Beachte: this.pos funktioniert nicht, da Attribut pos in Oberklasse private ist!
			//		    --> getPos() funktioniert, egal ob Attribut pos hier oder in Oberklasse 
			//		  	 	definiert ist
		Positionable otherPos = otherShip.getPos();
		
		return  // vergleiche aktuelle Position
				//		verwende equals-Methode von Positionable
				thisPos.equals( otherPos )
				// vergleiche Größe/Richtung
				&& this.size == otherShip.size
				&& this.isHorizontal == otherShip.isHorizontal
				// vergleiche Bewegungsvektor
				&& this.getDeltaPos().equals( otherShip.getDeltaPos() );
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}