import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Movelist_Reader implements Serializable{
	private  ArrayList<String[]> Movelist;
	private  File Movelist_raw_data;
	
	/**
	 * Takes Movelist.txt and uses it to create Movelist
	 * @throws FileNotFoundException
	 */
	public Movelist_Reader () throws FileNotFoundException
	{
		Movelist = new ArrayList<String[]>();
		this.Movelist_raw_data = new File("src/Movelist.txt");
		analyze_raw_data();
	}
	
	private void analyze_raw_data () throws FileNotFoundException
	{
		Scanner Movelist_scanner = new Scanner(Movelist_raw_data);
		while (Movelist_scanner.hasNextLine())
		{
			String Movelist_entry = Movelist_scanner.nextLine();
			for (int i = 0; i < Movelist_entry.length(); i++)
			{
				if (Movelist_entry.substring(i, i + 1).equals(" "))
				{
					Movelist_entry = Movelist_entry.substring(0, i) + Movelist_entry.substring(i + 1);
					i--;
				}
			}
			Movelist.add(Movelist_entry.split("/"));
		}
		Movelist_scanner.close();
	}
	
	
	public ArrayList<String[]> getMovelist() {
		return Movelist;
	}
}