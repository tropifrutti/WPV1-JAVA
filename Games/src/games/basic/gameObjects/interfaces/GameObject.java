package games.basic.gameObjects.interfaces;

public interface GameObject extends SimpleGameObject, PaintableGameObject {

	public abstract boolean isLeftOf(GameObject other);
	public abstract boolean isRightOf(GameObject other);
	public abstract boolean isAboveOf(GameObject other);
	public abstract boolean isBelowOf(GameObject other);
	
	public abstract boolean touches(GameObject other);	
}