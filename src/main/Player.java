package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player {

	private final Game game;
	
	public double x,y,z;
	private double speed;
	
	public static final double[][] model = {
			// south (front)
			{0,0,0,  0,1,0,  1,1,0},
			{0,0,0,  1,1,0,  1,0,0},
			// top (from south)
			{0,1,0,  0,1,1,  1,1,1},
			{0,1,0,  1,1,1,  1,1,0},
			// north (from top)
			{0,1,1,  0,0,1,  1,0,1},
			{0,1,1,  1,0,1,  1,1,1},
			// bottom (from north)
			{0,0,1,  0,0,0,  1,0,0},
			{0,0,1,  1,0,0,  1,0,1},
			// west (from south)
			{0,0,1,  0,1,1,  0,1,0},
			{0,0,1,  0,1,0,  0,0,0},
			// east (from south)
			{1,0,0,  1,1,0,  1,1,1},
			{1,0,0,  1,1,1,  1,0,1}
	};
	
	Player(Game game) {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		
		this.speed = 5.0;
		
		this.game = game;
	}
	
	void update() {
		// TODO Jump?
		move();
	}
	
	// TODO Use in GameScreen.paint(+), implement in Entity Class
	public void paint(Graphics g) {
		
		double halfWidth = game.getScreenWidth() / 2;
		double halfHeight = game.getScreenHeight() / 2;
		
		double aspectRatio = game.getScreenHeight() * 1.0 / game.getScreenWidth();
		
		
		for (double[] triangle : model) {
			double[] xpoints = {triangle[0], triangle[3], triangle[6]};
			double[] ypoints = {triangle[1], triangle[4], triangle[7]};
			double[] zpoints = {triangle[2], triangle[5], triangle[8]};
			
			// Translate
			for (int i = 0; i < 3; i++) {
				xpoints[i] += x;
				ypoints[i] += y;
				zpoints[i] += z;
			}
			
			// Project
			for (int i = 0; i < 3; i++) { // TODO Fix for z < 0 and big x
				xpoints[i] = halfWidth + halfWidth * (xpoints[i] * aspectRatio / (zpoints[i] == 0 ? 1 : zpoints[i]));
				ypoints[i] = halfHeight + halfHeight * (ypoints[i] / (zpoints[i] == 0 ? 1 : zpoints[i]));
				// zpoints[i] = ...
			}
			
			int[] xpointsInt = {(int) xpoints[0], (int) xpoints[1], (int) xpoints[2]};
			int[] ypointsInt = {(int) ypoints[0], (int) ypoints[1], (int) ypoints[2]};
			
			g.drawPolygon(xpointsInt, ypointsInt, 3);
		}
	}
	
	void move() {
		
		// TODO Custom key mapping
		if (game.isPressed(KeyEvent.VK_W)) z += Game.Hz * speed; // +/- Z Forward?
		if (game.isPressed(KeyEvent.VK_A)) x -= Game.Hz * speed;
		if (game.isPressed(KeyEvent.VK_S)) z -= Game.Hz * speed;
		if (game.isPressed(KeyEvent.VK_D)) x += Game.Hz * speed;
		
		// TODO World
	}
	
	void printPlayerInfo() {
		System.out.println("X: " + this.x + " | Z: " + this.z + " | Y: " + this.y);
	}
	
}
