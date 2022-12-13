package main;

import java.awt.Graphics;

import Entities.Player;
import Levels.LevelManager;

public class Game implements Runnable{
	
	private Window window;
	private Panel panel;
	private Thread thread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	
	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 2.0f;
	public static final int TILES_WIDTH = 26;
	public static final int TILES_HEIGHT = 14;
	public final static int TILES_SIZE = (int)(TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_HEIGHT;
	
	private LevelManager levelManager;
	
	private Player player;
	
	public Game() {
		initclasses();
		panel = new Panel(this);
		window = new Window(panel);
		panel.requestFocus();
		startLoop();
		
		
	}

	private void initclasses() {
		// TODO Auto-generated method stub
		player = new Player(100, 100);
		levelManager = new LevelManager(this);
		
	}

	private void startLoop() {
		thread = new Thread(this);
		thread.start();
	}
	
	public void update() {
		player.update();
		levelManager.update();
	}
	
	public void render(Graphics g) {
		levelManager.Draw(g);
		player.render(g);
	}
	
	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
	
		
		long previousTime = System.nanoTime();
		
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		
		double deltaU = 0;
		double deltaF = 0;
		
		
		while(true) {

			long currTime = System.nanoTime();
			
			deltaU += (currTime - previousTime) / timePerUpdate;
			deltaF += (currTime - previousTime) / timePerFrame;
			previousTime = currTime;
			
			if(deltaU >= 1) {
				updates++;
				deltaU--;
			}
			
			if(deltaF >= 1) {
				panel.repaint();
				deltaF--;
				frames++;
			}
			

			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + "|| UPS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		
	}
	public Player getPlayer() {
		return player;
	}

}
