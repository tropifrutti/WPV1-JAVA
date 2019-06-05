package games.basic.gameObjects.moveable;
import games.basic.gameObjects.RectangularGameObject;
import games.basic.position.interfaces.Positionable;


public class MoveableGameObject extends AbstractMoveableGameObject {

	private int width;
	private int height;
	
	// Konstruktor
	// Beachte: Parameter Positionable 'deltaPos' fehlte im Aufgabenblatt
	public MoveableGameObject(Positionable pos, int width, int height, Positionable deltaPos) {
		super(pos, deltaPos);		// Aufruf: AbstractMoveableGameObject(pos, deltaPos);
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
				+ ", size = " + this.getWidth() + " x " + this.getHeight()+ ")")
				+ ", direction = " + this.getDeltaPos();
	}
	
	public boolean equals(Object other) {
		if (other == null || !(other instanceof RectangularGameObject))
			return false;
		
		MoveableGameObject otherMoveable = (MoveableGameObject)other;
		Positionable thisPos  = this.getPos();
			// Beachte: this.pos funktioniert nicht, da Attribut pos in Oberklasse private ist!
			//		    --> getPos() funktioniert, egal ob Attribut pos hier oder in Oberklasse 
			//		  	 	definiert ist
		Positionable otherPos = otherMoveable.getPos();
		
		return  // vergleiche aktuelle Position
				//		verwende equals-Methode von Positionable
				thisPos.equals( otherPos )
				// vergleiche Breite/Höhe
				&& this.getWidth() == otherMoveable.getWidth()
				&& this.getHeight() == otherMoveable.getHeight()
				// vergleiche Bewegungsvektor
				&& this.getDeltaPos().equals( otherMoveable.getDeltaPos() );
	}
}
