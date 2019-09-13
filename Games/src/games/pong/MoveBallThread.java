package games.pong;

import java.awt.Color;

import javax.swing.JFrame;

import games.basic.gameObjects.moveable.Ball;
import games.basic.gameObjects.moveable.Paddle;

public class MoveBallThread extends Thread {
	
	Ball ball;
	JFrame frame;
	int counter = 0;
	Paddle paddle1;
	Paddle paddle2;
	
	public MoveBallThread(Ball b, JFrame f, Paddle p1, Paddle p2) {
		ball = b;
		frame = f;
		paddle1 = p1;
		paddle2 = p2;
	}
	
	public void run() {
		while(true) {
			try {Thread.sleep(8);} 
			catch(InterruptedException e) {System.out.println(e);}
			
			//Ball hits GOALIE
			
			if (ball.touchesX(0) || ball.touchesX(frame.getWidth()-15)) {
				for (int i=0; i<2; i++) {
					try {Thread.sleep(50);} 
					catch(InterruptedException e) {System.out.println(e);}
					frame.setBackground(Color.RED);
					try {Thread.sleep(50);} 
					catch(InterruptedException e) {System.out.println(e);}
					frame.setBackground(Color.WHITE);
				}
				ball.reverseXDirection();
			}
				
			//Ball hits walls
			
			if (ball.touchesY(2) || ball.touchesY(frame.getHeight()-40))
				ball.reverseYDirection();
			
			//Ball hits paddles
			
			if (ball.touches(paddle1) || ball.touches(paddle2))
				ball.reverseXDirection();
			
			ball.move();
			frame.repaint();
		}
		
	}

}
