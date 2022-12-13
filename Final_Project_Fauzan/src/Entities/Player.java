package Entities;

import static Utils.Constants.Directions.DOWN;
import static Utils.Constants.Directions.LEFT;
import static Utils.Constants.Directions.RIGHT;
import static Utils.Constants.Directions.UP;
import static Utils.Constants.PlayerConstants.GetSpriteAmount;
import static Utils.Constants.PlayerConstants.IDLE;
import static Utils.Constants.PlayerConstants.RUNNING;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Utils.LoadSave;

public class Player extends Entities{
	
	private BufferedImage[][] animations;
	private int AnimationTick, AnimationIndex, speed = 40;
	private int PlayerAction = IDLE;
	private boolean moving = false;
	private boolean left, up, right, down;
	private double MoveSpeed = 4.5;
	
	
	public Player(float x, float y) {
		super(x, y);
		loadAnimations();
	}
	
	public void update() {
		
		UpdatePos();
		updateAnimationTick();
		setAnimation();
		
	}
	public void render(Graphics g) {
		g.drawImage(animations[AnimationIndex][PlayerAction], (int)x, (int)y, 64, 64, null);
	}
	

	private void UpdatePos() {
		// TODO Auto-generated method stub
		moving = false;
		
		if(left && !right) {
			x -= (int)MoveSpeed;
			moving = true;
		}
		else if(right && !left) {
			x += (int)MoveSpeed;
			moving = true;
		}
		
		if(up && !down) {
			y -= (int)MoveSpeed;
			moving = true;
		}
		else if(down && !up) {
			y += (int)MoveSpeed;
			moving = true;
		}
	}

	private void setAnimation() {
		// TODO Auto-generated method stub
		if(moving)
			PlayerAction = RUNNING;
		else
			PlayerAction = IDLE;
	}

	private void updateAnimationTick() {
		AnimationTick++;
		if(AnimationTick >= speed) {
			AnimationTick = 0;
			AnimationIndex++;
			if(AnimationIndex >= GetSpriteAmount(PlayerAction)) {
				AnimationIndex = 0;
			}
		}
		
	}
	
	private void loadAnimations() {
		InputStream is = getClass().getResourceAsStream("/Player2.png");
		
		
		BufferedImage image = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
		
		animations = new BufferedImage[2][2];
		
		for(int i = 0; i < animations.length; i++) {
			for(int j = 0; j < animations[i].length; j++) {
			animations[i][j] = image.getSubimage(i * 32, j * 32, 32, 32);
			}
		}
		
		
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}
	
}
