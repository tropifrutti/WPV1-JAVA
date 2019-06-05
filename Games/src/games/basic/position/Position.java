package games.basic.position;

import games.basic.position.interfaces.Positionable;


public class Position implements Positionable {

	// Attribute
	private int x;
	private int y;
	
	// Konstruktur
	public Position(int x, int y) {
		this.setX( x );
		this.setY( y );
	}
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void move(Positionable shift) {
		if (shift != null) {
			this.setX( this.getX() + shift.getX() );
			this.setY( this.getY() + shift.getY() );
		}
	}

	@Override
	public void moveTo(Positionable pos) {
		if (pos != null) {
			this.setX( pos.getX() );
			this.setY( pos.getY() );
		}
	}

	@Override
	public void scale(int factor) {
		// einfach scaleX/scaleY aufrufen
		scaleX(factor);
		scaleY(factor);
	}

	@Override
	public void scaleX(int factor) {
		// Skalierung nur in x-Richtung
		setX( getX() * factor );
	}
	@Override
	public void scaleY(int factor) {
		// Skalierung nur in y-Richtung
		setY( getY() * factor );
	}


	@Override
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Position))
			return false;
		
		Position otherPos = (Position)other;
		return (this.getX() == otherPos.getX()) && (this.getY() == otherPos.getY());
	}
}
