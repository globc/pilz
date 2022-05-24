package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player {

	private final Game GAME;
	
	public double x,y,z;
	private double speed;
	
	public static final double[/* triangle */][/* point */][/* x y z */] MODEL = {
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
		
		this.GAME = game;
	}
	
	void update() {
		// TODO Jump?
		move();
	}
	
	public void paint(Graphics g) {
		// TODO Render player, minimal Calculations Projection
	}
	
	void move() {
		
		// TODO Custom key mapping
		if (GAME.isPressed(KeyEvent.VK_W)) z += Game.Hz * speed; // +/- Z Forward?
		if (GAME.isPressed(KeyEvent.VK_A)) x -= Game.Hz * speed;
		if (GAME.isPressed(KeyEvent.VK_S)) z -= Game.Hz * speed;
		if (GAME.isPressed(KeyEvent.VK_D)) x += Game.Hz * speed;
		
		// TODO World
	}
	
	void printPlayerInfo() {
		System.out.println("X: " + this.x + " | Z: " + this.z + " | Y: " + this.y);
	}
	
}
