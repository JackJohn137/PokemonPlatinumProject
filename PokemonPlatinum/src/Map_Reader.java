

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map_Reader {
	private Tile[][] grid;
	private int r;
	private int c;
	private File map_grid;
	private File map_warps;
	
	/**
	 * Takes Pokedex.txt and uses it to create pokedex
	 * @throws IOException 
	 */
	public Map_Reader (String map_name) throws IOException
	{
		this.map_grid = new File("src/map_file/" + map_name + ".txt");
		this.map_warps = new File("src/map_warp/" + map_name + ".txt");
		analyze_map_data();
		analyze_warp_data();
	}
	
	private void analyze_map_data () throws IOException
	{
		Scanner grid_y = new Scanner(map_grid);
		int r = 0;
		while (grid_y.hasNextLine())
		{
			r++;
			grid_y.nextLine();
		}
		this.r = r;
		grid_y.close();
		
		Scanner grid_x = new Scanner(map_grid);
		int c = grid_x.next().split("").length;
		grid_x.close();
		
		this.grid = new Tile[r][c];
		Scanner grid_scanner = new Scanner(map_grid);
		int index = 0;
		
		while (grid_scanner.hasNextLine())
		{
			String[] this_row = grid_scanner.nextLine().split("");
			for (int i = 0; i < grid[index].length; i++)
			{	
				int type = Integer.parseInt(this_row[i]);
				if (type != 9)
				{
					grid[index][i] = new Tile(type, index, i, 0, index, i);
				}
				else 
				{
					grid[index][i] = new Tile(type, index, i, 1, index + 5, i + 5);
				}
			}
			index++;
		}
		grid_scanner.close();
	}
	
	private void analyze_warp_data() throws IOException
	{
		Scanner warp_reader = new Scanner(map_warps);
		while (warp_reader.hasNextLine())
		{
			String entry = warp_reader.nextLine();
			
			for (int i = 0; i < entry.length(); i++)
			{
				if(entry.substring(i, i + 1).equals(" "))
				{
					entry = entry.substring(0, i) + entry.substring(i + 1);
					i--;
				}
			}
			
			String[] entry_array = entry.split("/");
			String map_name = entry_array[0];
			int initial_row = Integer.parseInt(entry_array[1]);
			int initial_col = Integer.parseInt(entry_array[2]);		
			int final_row = Integer.parseInt(entry_array[3]);	
			int final_col = Integer.parseInt(entry_array[4]);	
			grid[initial_row][initial_col].setWarp(map_name, final_row, final_col);
		}
		
		warp_reader.close();
	}
	
	public Tile[][] getGrid() {
		return grid;
	}
}
