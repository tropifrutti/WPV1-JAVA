package games.basic.gameObjects;
import games.basic.gameObjects.interfaces.GameObject;
import games.basic.position.Position;
import games.basic.position.interfaces.Positionable;


public abstract class AbstractGameObject implements GameObject {

	@Override
	public boolean isLeftOf(GameObject other) {
		if (other == null)
			return false;
		
		int myRightmostPos = this.getPos().getX() + this.getWidth();
		return (myRightmostPos < other.getPos().getX());
	}
	
	@Override
	public boolean isRightOf(GameObject other) {
		if (other == null)
			return false;
		
		return other.isLeftOf(this);
		/*//Alternative:
		 * int otherRightmostPos = other.getPos().getX() + other.getWidth();
		 * return (otherRightmostPos < this.getPos().getX());
		 */
	}

	@Override
	public boolean isAboveOf(GameObject other) {
		if (other == null)
			return false;
		
		int myLowestPos = this.getPos().getY() + this.getHeight();
		return (myLowestPos < other.getPos().getY());
	}

	@Override
	public boolean isBelowOf(GameObject other) {
		if (other == null)
			return false;
		
		return other.isAboveOf(this);
		/* //Alternative
		 * int otherLowestPos = other.getPos().getY() + other.getHeight();
		 * return (otherLowestPos < this.getPos().getY());
		 */
	}

	@Override
	public boolean touches(GameObject other) {
		if (other == null)
			return false;
		
		if (this.isLeftOf(other) 
				|| this.isRightOf(other)
				|| this.isAboveOf(other)
				|| this.isBelowOf(other)) {
			return false;
		} else {
			return true;
		}
	}

	
	// Beachte: Da alle abgeleiteten Klassen sinnvollerweise eine Position haben, 
	//		    können wir Position auch als Attribut hier definieren und damit 
	//		    auch bereits getPos() (sowie: setPos/setX/setY). 
	private Positionable pos;
	
	public AbstractGameObject(Positionable pos) {
		this.pos = pos;
	}
	
	@Override
	public Positionable getPos() {
		return this.pos;
	}
	
	@Override
	public void setPos(Positionable pos) {
		this.pos = pos;
	}
	@Override
	public void setPos(int x, int y) {
		// Aufpassen, dass pos nicht null ist
		if (this.pos == null)
			this.setPos(new Position(0, 0));
		
		this.setX( x );
		this.setY( y );
	}
	
	@Override
	public void setX(int x) {
		this.pos.setX( x );
	}
	@Override
	public void setY(int y) {
		this.pos.setY( y );
	}
	
	public boolean touchesX(int x) {
		int myRightmostPos = this.getPos().getX() + this.getWidth();
		if (this.getPos().getX() <= x && myRightmostPos >= x) 
			return true;
		return false;
	}
	
	public boolean touchesY(int y) {
		int myLowestPos = this.getPos().getY() + this.getHeight();
		if (this.getPos().getY() <= y && myLowestPos >= y) 
			return true;
		return false;
	}

	
	// noch abstract: getHeight(), getWidth()

}
