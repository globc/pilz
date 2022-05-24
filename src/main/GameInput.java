package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameInput extends KeyAdapter{

	private final Game GAME;
	
	public GameInput(Game game) {
		this.GAME = game;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		GAME.addPressedKey(e.getKeyCode());
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		// Not on update
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER: // TODO Set to ESCAPE
			GAME.stop();
			break;
		case KeyEvent.VK_P: // Debug
			GAME.player.printPlayerInfo();
			break;
		}
		
		GAME.removePressedKey(e.getKeyCode());
	}
	
}
