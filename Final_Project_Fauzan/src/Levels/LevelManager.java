package Levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Utils.LoadSave;
import main.Game;

public class LevelManager {
	private Game game;
	private BufferedImage[] LevelSprite;
	private Level levelOne;
	
	public LevelManager(Game game) {
		this.game = game;
//		LevelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		importLevelSprite();
		levelOne = new Level(LoadSave.GetLevelData());
	}
	
	private void importLevelSprite() {
		
		BufferedImage image = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		LevelSprite = new BufferedImage[48];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 12; j++) {
				int index = i * 12 + j;
				LevelSprite[index] = image.getSubimage(i * 16, j * 4, 32, 32);
			}
		}
		
	}

	public void Draw(Graphics g) {
		for(int i = 0; i < Game.TILES_HEIGHT; i++) {
			for(int j = 0; j < Game.TILES_WIDTH; j++) {
				int index = levelOne.GetSpriteIndex(j, i);
				g.drawImage(LevelSprite[index], Game.TILES_SIZE * j, Game.TILES_SIZE * i, Game.TILES_SIZE, Game.TILES_SIZE, null);
			}
		}
	}
	public void update() {
		
	}
}
