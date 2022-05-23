package main;

import java.awt.event.KeyEvent;

public class Player {

	private Game gameEnv;
	
	public double x,y,z;
	private double speed;
	
	private static final double[/* triangle */][/* point */][/* x y z */] MODEL = {
			// south (front)
			{{0,0,0},  {0,1,0},  {1,1,0}},
			{{0,0,0},  {1,1,0},  {1,0,0}},
			// top (from south)
			{{0,1,0},  {0,1,1},  {1,1,1}},
			{{0,1,0},  {1,1,1},  {1,1,0}},
			// north (from top)
			{{0,1,1},  {0,0,1},  {1,0,1}},
			{{0,1,1},  {1,0,1},  {1,1,1}},
			// bottom (from north)
			{{0,0,1},  {0,0,0},  {1,0,0}},
			{{0,0,1},  {1,0,0},  {1,0,1}},
			// west (from south)
			{{0,0,1},  {0,1,1},  {0,1,0}},
			{{0,0,1},  {0,1,0},  {0,0,0}},
			// east (from south)
			{{1,0,0},  {1,1,0},  {1,1,1}},
			{{1,0,0},  {1,1,1},  {1,0,1}}
	};
	
	Player(Game game) {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		
		this.speed = 100.0;
		
		this.gameEnv = game;
	}
	
	void update() {
		// TODO Jump?
		move();
	}
	
	void move() {
		
		if (gameEnv.keysPressed.contains(KeyEvent.VK_W)) z += gameEnv.Hz * speed; // +/- Z Forward?
		if (gameEnv.keysPressed.contains(KeyEvent.VK_S)) z -= gameEnv.Hz * speed;
		if (gameEnv.keysPressed.contains(KeyEvent.VK_A)) x -= gameEnv.Hz * speed;
		if (gameEnv.keysPressed.contains(KeyEvent.VK_D)) x += gameEnv.Hz * speed;
		
		// TODO World
	}
	
	void printPlayerInfo() {
		System.out.println("X: " + this.x + " | Z: " + this.z + " | Y: " + this.y);
	}
	
}
