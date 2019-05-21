import java.io.IOException;

public class Tile {
	public final int REGULAR = 0;
	public final int TALL_GRASS = 1;
	public final int OBSTACLE = 2;
	public final int SPECIAL = 3;
	public final int WARP = 9;
	public Pokemon_Trainer trainer;
	
	private int type;
	private int row;
	private int col;
	public Warp warp;
	
	public Tile(int type, int row, int col, int warp_index, int warp_row, int warp_col) throws IOException
	{
		this.type = type;
		this.row = row;
		this.col = col;
		this.warp = new Warp(warp_index, warp_row, warp_col);
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}

	public void setWarp(String map_name, int row, int col) throws IOException
	{
		this.warp = new Warp(map_name, row, col);
	}
	
	public Warp getWarp() {
		return warp;
	}
	
	public Pokemon_Trainer getPokemon_trainer()
	{
		return this.trainer;
	}
	
	public void setPokemon_trainer(Pokemon_Trainer pt)
	{
		this.trainer = pt;
	}

}