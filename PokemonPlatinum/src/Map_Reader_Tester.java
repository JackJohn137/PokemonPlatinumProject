
import java.io.FileNotFoundException;

public class Map_Reader_Tester {
	private Map_Reader mr;
	
	public Map_Reader_Tester(String map_name) throws FileNotFoundException
	{
		mr = new Map_Reader(map_name);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Map_Reader_Tester mrt = new Map_Reader_Tester("Twinleaf_Town");
		int[][] grid = mrt.getMap_Reader().getGrid();
		for (int[] r : grid)
		{
			for (int c : r)
			{
				System.out.print(c + " ");
			}
			System.out.println("");
		}
	}

	public Map_Reader getMap_Reader()
	{
		return mr;
	}
}
