import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Timer;

import javax.imageio.ImageIO;

public class Pokemon_Trainer_Movements implements Serializable{
	private String trainer_type;
	private transient final Image sprite_sheet;
	private Movement up;
	private Movement down;
	private Movement left;
	private Movement right;
	
	Pokemon_Trainer_Movements(String trainer_type) throws IOException
	{
		this.trainer_type = trainer_type;
		this.sprite_sheet = ImageIO.read(getClass().getResource("trainer_sprite/" + this.trainer_type + ".png"));       
		this.up = new Movement(Direction.UP);
		this.down = new Movement(Direction.DOWN);
		this.left = new Movement(Direction.LEFT);
		this.right = new Movement(Direction.RIGHT);
	}
	
	public Movement getUp() {
		return up;
	}

	public void setUp(Movement up) {
		this.up = up;
	}

	public Movement getDown() {
		return down;
	}

	public void setDown(Movement down) {
		this.down = down;
	}

	public Movement getLeft() {
		return left;
	}

	public void setLeft(Movement left) {
		this.left = left;
	}

	public Movement getRight() {
		return right;
	}

	public void setRight(Movement right) {
		this.right = right;
	}

	public class Movement implements Serializable
	{
		private final Direction direction;
		//private final Image sprite_sheet;
		private transient Timer timer;
		private transient final Image stop;
		private transient final Image move_1;
		private transient final Image move_2;
		Movement(Direction direction)
		{
			this.direction = direction;
			this.timer = new Timer();//TO MAKE
			switch (this.direction)
			{
				case UP:
					this.stop = ((BufferedImage)sprite_sheet).getSubimage(0, 0, 32, 32); 
					this.move_1 = ((BufferedImage)sprite_sheet).getSubimage(64, 0, 32, 32); 
					this.move_2 = ((BufferedImage)sprite_sheet).getSubimage(32, 96, 32, 32); 
					break;
					
				case DOWN:
					this.stop = ((BufferedImage)sprite_sheet).getSubimage(64, 32, 32, 32); 
					this.move_1 = ((BufferedImage)sprite_sheet).getSubimage(64, 96, 32, 32); 
					this.move_2 = ((BufferedImage)sprite_sheet).getSubimage(64, 64, 32, 32); 
					break;
					
				case LEFT:
					this.stop = ((BufferedImage)sprite_sheet).getSubimage(0, 64, 32, 32); 
					this.move_1 = ((BufferedImage)sprite_sheet).getSubimage(0, 32, 32, 32); 
					this.move_2 = ((BufferedImage)sprite_sheet).getSubimage(0, 96, 32, 32); 
					break;
					
				case RIGHT:
					this.stop = ((BufferedImage)sprite_sheet).getSubimage(32, 0, 32, 32); 
					this.move_1 = ((BufferedImage)sprite_sheet).getSubimage(32, 64, 32, 32); 
					this.move_2 = ((BufferedImage)sprite_sheet).getSubimage(32, 32, 32, 32); 
					break;
				
				default:
					this.stop = null;
					this.move_1 = null;
					this.move_2 = null;
					System.out.println("ERROR: Pokemon_Trainer_Movements: Movement: Get sprites from sprite sheet");
					break;
			}
		}
		public Image getStop() {
			return stop;
		}
		public Image getMove_1() {
			return move_1;
		}
		public Image getMove_2() {
			return move_2;
		}
	}
}
