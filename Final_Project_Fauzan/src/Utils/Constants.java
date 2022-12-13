package Utils;

public class Constants {
	
	public static class PlayerConstants{
	public static final int IDLE = 0;
	public static final int RUNNING = 1;
	

	
	public static int GetSpriteAmount(int player_action) {
		switch(player_action) {
		case RUNNING:
		case IDLE:
			return 2;
			
		default:
			return 1;
			
		}
		}
	}
	public static class Directions{
		public static final int UP = 0;
		public static final int DOWN = 1;
		public static final int LEFT = 2;
		public static final int RIGHT = 3;
	}
	
	public static class Colors{
		public static final int GREEN = 0;
		public static final int BLUE = 2;
		public static final int PURPLE = 4;
		public static final int RED = 6;
		public static final int ORANGE = 8;
		public static final int YELLOW = 10;
		
		public static int getColorsAmount(int Color) {
			switch(Color) {
			case GREEN:
				return 0;
			case BLUE:
				return 2;
			case PURPLE:
				return 18;
			case RED:
				return 24;
			case ORANGE:
				return 30;
			case YELLOW:
				return 36;
				
				default:
					return 0;
			}
		}

	}
	
}
