package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player {

	private final Game game;
	
	public double x,y,z;
	private double speed;
	
	public static final Model MODEL = Model.CUBE;
	
	Player(Game game) {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		
		this.speed = 100.0;
		
		this.game = game;
	}
	
	void update() {
		// TODO Jump?
		move();
	}
	
	// TODO Use in GameScreen.paint(+), implement in Entity Class
	public void paint(Graphics g) {
		// TODO Render player, minimal Calculations Projection
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
