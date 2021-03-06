package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class GameScreen extends Canvas{

	private final Game game;
	
	public GameScreen(Game game){
		this.game = game;
		
		this.setSize(1280, 720);
		this.setBackground(Color.black);
		this.setFocusable(false);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.white);
		
		game.player.paint(g);
		
		g.dispose();
	}
	
}
