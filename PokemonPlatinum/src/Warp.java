import java.io.IOException;

public class Warp {
	//private Pokemon_Map map_origin;
	private String warp_map_name;
	private int warp_index;
	//private int initial_row;
	//private int initial_col;
	private int final_row;
	private int final_col;
	
	public Warp(String warp_map_name, int final_row, int final_col) throws IOException
	{
		this.warp_map_name = warp_map_name;
		this.final_row = final_row;
		this.final_col = final_col;
	}
	
	public Warp(int warp_index, int final_row, int final_col) throws IOException
	{
		this.warp_index = warp_index;
		this.final_row = final_row;
		this.final_col = final_col;
	}

	public int getRow() {
		return final_row;
	}

	public void setRow(int final_row) {
		this.final_row = final_row;
	}

	public int getCol() {
		return final_col;
	}

	public void setCol(int final_col) {
		this.final_col = final_col;
	}

	public int getWarp_index() {
		return warp_index;
	}

	public void setWarp_index(int warp_index) {
		this.warp_index = warp_index;
	}

	public String getWarp_map_name() {
		return warp_map_name;
	}

	public void setWarp_map_name(String warp_map_name) {
		this.warp_map_name = warp_map_name;
	}
}
