package Inputs;

import java.awt.event.KeyEvent;

import static Utils.Constants.Colors.BLUE;
import static Utils.Constants.Directions.*;
import java.awt.event.KeyListener;

import main.Panel;

public class KeyboardInput implements KeyListener {
	
	private Panel panel;
	public KeyboardInput(Panel panel) {
		this.panel = panel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			panel.getGame().getPlayer().setUp(true);
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			panel.getGame().getPlayer().setDown(true);
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			panel.getGame().getPlayer().setLeft(true);
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			panel.getGame().getPlayer().setRight(true);
			break;
		case KeyEvent.VK_1:
			 panel.getGame().getPlayer().setBlue(true);
			 panel.getGame().getPlayer().setPurple(false);
			 panel.getGame().getPlayer().setGreen(false);
			 panel.getGame().getPlayer().setRed(false);
			 panel.getGame().getPlayer().setOrange(false);
			 panel.getGame().getPlayer().setYellow(false);
			  break;
		case KeyEvent.VK_2:
			panel.getGame().getPlayer().setPurple(true);
			panel.getGame().getPlayer().setBlue(false);
			panel.getGame().getPlayer().setGreen(false);
			panel.getGame().getPlayer().setRed(false);
			panel.getGame().getPlayer().setOrange(false);
			panel.getGame().getPlayer().setYellow(false);
			break;
		case KeyEvent.VK_3:
			panel.getGame().getPlayer().setPurple(false);
			panel.getGame().getPlayer().setBlue(false);
			panel.getGame().getPlayer().setGreen(true);
			panel.getGame().getPlayer().setRed(false);
			panel.getGame().getPlayer().setOrange(false);
			panel.getGame().getPlayer().setYellow(false);
			break;
		case KeyEvent.VK_4:
			panel.getGame().getPlayer().setPurple(false);
			panel.getGame().getPlayer().setBlue(false);
			panel.getGame().getPlayer().setGreen(false);
			panel.getGame().getPlayer().setRed(true);
			panel.getGame().getPlayer().setOrange(false);
			panel.getGame().getPlayer().setYellow(false);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
switch(e.getKeyCode()) {
		
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			panel.getGame().getPlayer().setUp(false);
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			panel.getGame().getPlayer().setDown(false);
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			panel.getGame().getPlayer().setLeft(false);
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			panel.getGame().getPlayer().setRight(false);
			break;
		
		}
	}
	

}
