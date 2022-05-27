package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player {

	private final Game game;
	
	public double x,y,z;
	private double speed;
	
	public static final Mesh model = Mesh.getDefaultCube();
	
	Player(Game game) {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		
		this.speed = 1.25;
		
		this.game = game;
	}
	
	void update() {
		// TODO Jump?
		move();
	}
	
	// TODO Use in GameScreen.paint(+), implement in Entity Class
	public void paint(Graphics g) {
		
		Mesh modelCopy = model.copy();
		
		for (Triangle tri : modelCopy.tris) {
			tri.translate(x, y, z);
			tri.project(game.getScreenWidth() / 2, game.getScreenHeight() / 2);
			tri.paint(g);
			
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
