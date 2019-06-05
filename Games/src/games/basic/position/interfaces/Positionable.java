package games.basic.position.interfaces;

public interface Positionable {

	public abstract int getX();
	public abstract int getY();

	public abstract void setX(int x);
	public abstract void setY(int y);

	public abstract void move(Positionable shift);
	public abstract void moveTo(Positionable pos);
	
	public abstract void scale(int factor);
	// Hinzugef�gt: Methoden scaleX, scaleY 
	//	(sinnvoll zur Skalierung von Bewegungsvektoren 
	//	(z.B. zur �nderung der Bewegungsrichtung bei Aufschlag auf eine Wand)
	public abstract void scaleX(int factor);
	public abstract void scaleY(int factor);
	
	// hinzugef�gt: Methoden toString, equals
	public abstract String toString();
	public abstract boolean equals(Object other);
}

