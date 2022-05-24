package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class GameScreen extends Canvas{

	private final Game GAME;
	
	public GameScreen(Game game){
		this.GAME = game;
		
		this.setSize(1280, 720);
		this.setBackground(Color.black);
		this.setFocusable(false);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.white);
		GAME.player.paint(g); // TODO Game.entities[i].paint(g), Player extends Entity
		// width = getWidth(), first pixel at 0, last pixel at getWidth() - 1
		
		// TODO Move to Player/Entity
		float centerX = (getWidth() - 1) / 2.0f;
		float centerY = (getHeight() - 1) / 2.0f;
		float aspectRatio = getHeight() / getWidth();
		
		for (double[][] triangle : Player.MODEL) {
			int[] xPoints = new int[3];
			// int[] yPoints 
				//{centerX + (triangle[0][0] * aspectRatio / triangle[0][2]) * getWidth() / 2.0
		}
		
		g.dispose();
	}
	
}
