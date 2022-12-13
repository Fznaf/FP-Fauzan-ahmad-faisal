package Entities;

import static Utils.Constants.Directions.DOWN;
import static Utils.Constants.Directions.LEFT;
import static Utils.Constants.Directions.RIGHT;
import static Utils.Constants.Directions.UP;
import static Utils.Constants.PlayerConstants.GetSpriteAmount;
import static Utils.Constants.PlayerConstants.IDLE;
import static Utils.Constants.PlayerConstants.RUNNING;
import static Utils.Constants.Colors.GREEN;
import static Utils.Constants.Colors.BLUE;
import static Utils.Constants.Colors.PURPLE;
import static Utils.Constants.Colors.RED;
import static Utils.Constants.Colors.ORANGE;
import static Utils.Constants.Colors.YELLOW;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Utils.LoadSave;

public class Player extends Entities{
	
	private BufferedImage[][] animations;
	private int AnimationTick, AnimationIndex, speed = 66;
	private int PlayerAction = IDLE;
	private boolean moving = false;
	private boolean left, up, right, down;
	private double MoveSpeed = 2.5;
	private int Colors = GREEN;
	private int colorNow = 0;
	private boolean red, orange, yellow, green, blue, purple;
	
	public Player(float x, float y) {
		super(x, y);
		loadAnimations();
	}
	
	
	
	public void update() {
		
		UpdatePos();
		updateAnimationTick();
		setAnimation();
		setColor();
	
		
	}
	private void setColor() {
		// TODO Auto-generated method stub
		if(purple) {
			Colors = PURPLE;
		}
		if(blue) {
			Colors = BLUE;
		}
		if(green) {
			Colors = GREEN;
		}
		if(red) {
			Colors = RED;
		}
		if(yellow) {
			Colors = YELLOW;
		}
		if(orange) {
			Colors = ORANGE;
		}
		
	}

	public void render(Graphics g) {
		g.drawImage(animations[AnimationIndex][PlayerAction + Colors], (int)x, (int)y, 64, 64, null);
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
		InputStream is = getClass().getResourceAsStream("/Player3.png");
		
		
		BufferedImage image = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
		
		animations = new BufferedImage[2][6];
		
		for(int i = 0; i < animations.length; i++) {
			for(int j = 0; j < animations[i].length; j++) {
			animations[i][j] = image.getSubimage(i * 32, (j+Colors) * 32, 32, 32);
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
	public boolean isBlue() {
		return blue;
	}
	public void setBlue(boolean blue) {
		this.blue = blue;
	}
	public boolean isGreen() {
		return green;
	}
	public void setGreen(boolean green) {
		this.green = green;
	}
	public boolean isRed() {
		return red;
	}
	public void setRed(boolean red) {
		this.red = red;
	}
	public boolean isOrange() {
		return orange;
	}
	public void setOrange(boolean orange) {
		this.orange = orange;
	}
	public boolean isYellow() {
		return yellow;
	}
	public void setYellow(boolean yellow) {
		this.yellow = yellow;
	}
	public boolean isPurple() {
		return purple;
	}
	public void setPurple(boolean purple) {
		this.purple = purple;
	}
	
}
