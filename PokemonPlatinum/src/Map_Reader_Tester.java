
import java.io.FileNotFoundException;
import java.io.IOException;

public class Map_Reader_Tester {
	private Map_Reader mr;
	
	public Map_Reader_Tester(String map_name) throws IOException
	{
		mr = new Map_Reader(map_name);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	Map_Reader_Tester mrt = new Map_Reader_Tester("Twinleaf_Town");
	//	Tile[][] grid = mrt.getMap_Reader().getGrid();
	//	for (Tile[] r : grid)
	//	{
	//		for (Tile c : r)
	//		{
	//			System.out.print(c + " ");
	//		}
	//		System.out.println("");
	//	}
	}

	public Map_Reader getMap_Reader()
	{
		return mr;
	}
}
