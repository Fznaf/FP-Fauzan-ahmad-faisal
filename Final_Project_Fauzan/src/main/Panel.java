package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Inputs.KeyboardInput;
import Inputs.MouseInput;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;

import static Utils.Constants.PlayerConstants.*;
import static Utils.Constants.Directions.*;

public class Panel extends JPanel{
	
	private MouseInput mouseInput;
	private Game game;
	
	public Panel(Game game) {
		
		mouseInput = new MouseInput(this);
		this.game = game;
		setPanelSize();
		addKeyListener(new KeyboardInput(this));
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
		
	}
	
	
	private void setPanelSize() {
		Dimension size = new Dimension(GAME_WIDTH ,GAME_HEIGHT);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		
	}
	
	
	
	
	public void updateGame() {

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		game.update();
		game.render(g);
	
		}
	public Game getGame() {
		return game;
	}

		
	}


