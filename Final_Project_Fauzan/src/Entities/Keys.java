package Entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import Utils.LoadSave;

public class Keys extends Entities{
	
	private Image KeyImage;
	public Keys(int x, int y) {
		super(x, y);
		try {
		KeyImage = LoadSave.GetSpriteAtlas(LoadSave.KEY_ATLAS);
		} catch (Exception e) {
		System.out.println("Failed to load KeyImage" + e.getMessage());
		KeyImage = null;
		}
	
	}
	
	public void render(Graphics g) {
		if(KeyImage != null) {
		g.drawImage(KeyImage, (int)x, (int)y, 64, 64, null);
		}	
	}
}
