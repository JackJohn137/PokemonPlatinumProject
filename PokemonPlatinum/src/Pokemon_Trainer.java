import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pokemon_Trainer {
	private String name;
	private final String type;
	private Pokemon_Storage pokemon_storage;
	private final Image front;
	private final Image back;
	private final Pokemon_Trainer_Movements movements;
	private Direction direction;
	private int x_coord;
	private int y_coord;
	private int grid_x;
	private int grid_y;
	public Pokemon_Trainer(String name, String type, Direction direction, int x, int y) throws IOException{
		this.name = name;
		this.type = type;
		this.pokemon_storage = new Pokemon_Storage(6);
		this.front = ImageIO.read(getClass().getResource("trainer_front/Spr_Pt_Dawn.png"));
		this.back = ImageIO.read(getClass().getResource("trainer_back/Pt_Dawn_Back.png"));
		this.movements = new Pokemon_Trainer_Movements(type);
		this.direction = direction;
		this.grid_x = x;
		this.grid_y = y;
	}
	
	public void draw(Graphics g)
	{
		switch (direction)
		{
			case UP:
				g.drawImage(this.getMovements().getUp().getStop(), this.getX_coord(), this.getY_coord(), null);
				break;
				
			case DOWN:
				g.drawImage(this.getMovements().getDown().getStop(), this.getX_coord(), this.getY_coord(), null);
				break;
				
			case LEFT:
				g.drawImage(this.getMovements().getLeft().getStop(), this.getX_coord(), this.getY_coord(), null);
				break;
				
			case RIGHT:
				g.drawImage(this.getMovements().getRight().getStop(), this.getX_coord(), this.getY_coord(), null);
				break;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Pokemon_Storage getPokemon_storage() {
		return pokemon_storage;
	}
	
	public void setPokemon_storage(Pokemon_Storage pokedex_storage) {
		this.pokemon_storage = pokedex_storage;
	}

	public Image getFront() {
		return front;
	}

	public Image getBack() {
		return back;
	}

	public Pokemon_Trainer_Movements getMovements() {
		return movements;
	}

	public int getX_coord() {
		return this.grid_x * 16 - 8;
	}

	public int getY_coord() {
		return this.grid_y * 12 - 12;
	}

	public int getGrid_x() {
		return grid_x;
	}

	public void setGrid_x(int grid_x) {
		this.grid_x = grid_x;
	}

	public int getGrid_y() {
		return grid_y;
	}

	public void setGrid_y(int grid_y) {
		this.grid_y = grid_y;
	}

	public void setX_coord(int x_coord) {
		this.x_coord = x_coord;
	}
	
	public void setY_coord(int y_coord) {
		this.y_coord = y_coord;
	}
	
	public void setDirection(Direction s)
	{
		this.direction = s;
	}
	
	public Direction getDirection()
	{
		return this.direction;
	}
	
	public int getSlide_x()
	{
		return this.x_coord;
	}
	
	public int getSlide_y()
	{
		return this.y_coord;
	}
}
