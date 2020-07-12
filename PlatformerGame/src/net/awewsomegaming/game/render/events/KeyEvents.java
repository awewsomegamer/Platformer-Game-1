package net.awewsomegaming.game.render.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEvents implements KeyListener{
	public boolean keyA = false;
	public boolean keyD = false;
	public boolean keySpace = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			keyA = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			keyD = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keySpace = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			keyA = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			keyD = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keySpace = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
