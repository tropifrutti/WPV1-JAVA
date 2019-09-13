package games.basic.gameObjects.moveable;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import games.basic.position.interfaces.Positionable;

public class Paddle extends MoveableGameObject {
	
	public Paddle (Positionable pos, int width, int height, Positionable deltaPos) {
		super(pos, width, height, deltaPos);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(4.5f));
		g.setColor(Color.blue);
		g.drawRoundRect(this.getPos().getX(), this.getPos().getY(), width, height, 3, 1);
		//g.drawOval(this.getPos().getX(), this.getPos().getY(), width, height);
		
	}
	
}


