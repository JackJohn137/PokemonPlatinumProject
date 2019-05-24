import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Pokemon_Map implements Serializable{
	private transient Image pokemon_map;
	private final String map_name;
	private ArrayList<Pokemon_Trainer> trainers;
	private int r;
	private int c;
	private Tile[][] grid;
	private final Map_Reader mr;
	private transient Audio a;
	
	public Pokemon_Map (String map_name, int initial_x, int initial_y) throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		this.pokemon_map = ImageIO.read(getClass().getResource("pokemon_map/" + map_name + ".png"));
		this.map_name = map_name;
		this.mr = new Map_Reader(map_name);
		this.grid = mr.getGrid();
		this.r = initial_y;
		this.c = initial_x; 
		a = new Audio(map_name);
	}
	
	public Pokemon_Map (String map_name) throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{   
		System.out.println("Loading " + map_name + "...");
		this.pokemon_map = ImageIO.read(getClass().getResource("pokemon_map/" + map_name + "_Pt.png"));
		this.map_name = map_name;
		this.mr = new Map_Reader(map_name);
		this.grid = mr.getGrid();
		this.r = 0;
		this.c = 0;
		a=new Audio(map_name);
	}
	public Audio audio() {
		return a;
	}
	public Tile getTile(int row, int col)
	{
		return grid[row][col];
	}
	
	public Tile[][] getGrid()
	{
		return grid;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public Image getPokemon_map() {
		return pokemon_map;
	}
	
	public void setPokemon_map() throws IOException{
		this.pokemon_map = ImageIO.read(getClass().getResource("pokemon_map/" + map_name + ".png"));
	}
	
	public void setPokemon_map(String map_name) throws IOException{
		this.pokemon_map = ImageIO.read(getClass().getResource("pokemon_map/" + map_name + ".png"));
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(getPokemon_map(), 0, 0, null);
	}

	public String getMap_name() {
		return map_name;
	}
	
	public void setAudio(String map_name) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		this.a = new Audio(map_name);
	}
}

	

