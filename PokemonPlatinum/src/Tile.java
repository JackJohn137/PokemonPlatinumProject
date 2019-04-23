import java.io.IOException;

public class Tile {
	public final int REGULAR = 0;
	public final int TALL_GRASS = 1;
	public final int OBSTACLE = 2;
	public final int WATER = 3;
	public final int BIKE = 4;
	public final int ROCK_CLIMB = 5;
	public final int ROCK_SMASH = 6;
	public final int STRENGTH = 7;
	public final int WATERFALL = 8;
	public final int WARP = 9;
	
	private int type;
	private int row;
	private int col;
	private Warp warp;
	
	public Tile(int type, int row, int col, String warp_map, int warp_row, int warp_col) throws IOException
	{
		this.type = type;
		this.row = row;
		this.col = col;
		this.warp = new Warp(warp_map, warp_row, warp_col);
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
}