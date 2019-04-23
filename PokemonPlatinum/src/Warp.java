import java.io.IOException;

public class Warp {
	//private Pokemon_Map map_origin;
	private Pokemon_Map map_destination;
	//private int initial_row;
	//private int initial_col;
	private int final_row;
	private int final_col;
	
	public Warp(String map_destination_name, int final_row, int final_col) throws IOException
	{
		this.map_destination = new Pokemon_Map(map_destination_name);
		this.final_row = final_row;
		this.final_col = final_col;
	}
	
	public Warp(String map_origin_name, int initial_row, int initial_col, String map_destination_name, int final_row, int final_col) throws IOException
	{	
		//this.map_origin = new Pokemon_Map(map_origin_name);
		//this.initial_row = initial_row;
		//this.intitial_col = initial_col;
		this.map_destination = new Pokemon_Map(map_destination_name);
		this.final_row = final_row;
		this.final_col = final_col;
	}
	
	/*
	public Pokemon_Map getMap_origin() {
		return map_origin;
	}

	public void setMap_origin(Pokemon_Map map_origin) {
		this.map_origin = map_origin;
	}
	
	public int getInitial_row() {
		return initial_row;
	}

	public void setInitial_row(int initial_row) {
		this.initial_row = initial_row;
	}

	public int getInitial_col() {
		return initial_col;
	}

	public void setInitial_col(int initial_col) {
		this.initial_col = initial_col;
	}
	*/
	
	public Pokemon_Map getPm() {
		return map_destination;
	}

	public void setPm(Pokemon_Map pm) {
		this.map_destination = pm;
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
}
