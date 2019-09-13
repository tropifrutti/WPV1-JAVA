package games.pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import games.basic.gameObjects.moveable.Ball;
import games.basic.gameObjects.moveable.Paddle;
import games.basic.position.Position;

public class Pong implements KeyListener {
	
	JFrame frame;
	PongPanel panel;
	Ball ball;
	Paddle paddle1;
	Paddle paddle2;
	int paddleSpeed = 50;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pong pongGame = new Pong();
		pongGame.run();
	}
	
	public void run() {
		frame = new JFrame("Pong Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
		
		Position testPosition = new Position(50,50);
		Position deltaPosition = new Position(2,2);
		
		ball = new Ball(testPosition, 5, 5, deltaPosition);
		
		Position paddle1Pos = new Position(5, ((frame.getHeight())/2)-50);
		Position paddle2Pos = new Position(frame.getWidth()-25, ((frame.getHeight())/2)-50);
		Position paddleDeltaPos =  new Position(0,2);
		
		paddle1 = new Paddle(paddle1Pos, 4, 65, paddleDeltaPos);
		paddle2 = new Paddle(paddle2Pos, 4, 65, paddleDeltaPos);
		
		panel = new PongPanel(ball, paddle1, paddle2);
		frame.addKeyListener(this);
		
		//panel.setPreferredSize(new Dimension(600, 400));
		
		frame.add(panel);
		frame.setVisible(true);
		
		MoveBallThread t1 = new MoveBallThread(ball, frame, paddle1, paddle2);
		t1.start();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		if (arg0.getKeyChar()=='y')
			paddle1.setY(paddle1.getPos().getY()+paddleSpeed);
		if (arg0.getKeyChar()=='s')
			paddle1.setY(paddle1.getPos().getY()-paddleSpeed);
		 
		if (arg0.getKeyChar()=='m')
			paddle2.setY(paddle2.getPos().getY()+paddleSpeed);
		if (arg0.getKeyChar()=='k')
			paddle2.setY(paddle2.getPos().getY()-paddleSpeed);
	    
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
