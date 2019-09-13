package games.pong;

import java.awt.Graphics;

import javax.swing.*;

import games.basic.gameObjects.moveable.Ball;
import games.basic.gameObjects.moveable.Paddle;

public class PongPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Ball ball;
	Paddle paddle1;
	Paddle paddle2;
	
	public PongPanel (Ball b, Paddle p1, Paddle p2) {
		this.ball = b;
		this.paddle1 = p1;
		this.paddle2 = p2;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		ball.paintComponent(g);
		paddle1.paintComponent(g);
		paddle2.paintComponent(g);
	}
	
}
