import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pokedex_Reader {
	private  ArrayList<String[]> pokedex;
	private  File pokedex_raw_data;
	
	/**
	 * Takes Pokedex.txt and uses it to create pokedex
	 * @throws FileNotFoundException
	 */ 
	public Pokedex_Reader () throws FileNotFoundException
	{
		pokedex = new ArrayList<String[]>();
		this.pokedex_raw_data = new File("src/Pokedex.txt");
		analyze_raw_data();
	}
	
	private void analyze_raw_data () throws FileNotFoundException
	{
		Scanner pokedex_scanner = new Scanner(pokedex_raw_data);
		while (pokedex_scanner.hasNextLine())
		{
			String pokedex_entry = pokedex_scanner.nextLine();
			for (int i = 0; i < pokedex_entry.length(); i++)
			{
			
				if (pokedex_entry.substring(i, i + 1).equals(" "))
				{
					pokedex_entry = pokedex_entry.substring(0, i) + pokedex_entry.substring(i + 1);
					i--;
				}
			}
			pokedex.add(pokedex_entry.split("/"));
		}
		pokedex_scanner.close();
	}
	
	
	public ArrayList<String[]> getPokedex() {
		return pokedex;
	}
}
