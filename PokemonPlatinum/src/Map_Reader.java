

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map_Reader {
	private int[][] grid;
	private int r;
	private int c;
	private File map_grid;
	
	/**
	 * Takes Pokedex.txt and uses it to create pokedex
	 * @throws FileNotFoundException
	 */
	public Map_Reader (String map_name) throws FileNotFoundException
	{
		this.map_grid = new File("src/map_file/" + map_name + ".txt");
		analyze_raw_data();
	}
	
	private void analyze_raw_data () throws FileNotFoundException
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
		
		this.grid = new int[r][c];
		Scanner grid_scanner = new Scanner(map_grid);
		int index = 0;
		
		while (grid_scanner.hasNextLine())
		{
			String[] this_row = grid_scanner.nextLine().split("");
			for (int i = 0; i < grid[index].length; i++)
			{
				int type = Integer.parseInt(this_row[i]);
				grid[index][i] = type;
			}
			index++;
		}
		grid_scanner.close();
	}
	
	
	public int[][] getGrid() {
		return grid;
	}
}
