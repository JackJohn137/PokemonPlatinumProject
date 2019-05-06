
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trainer_Map_Storage {
	private ArrayList<Trainer_Map> trainer_map_storage;
	private ArrayList<String> trainer_map_names;
	private Pokedex pokedex;
	private Movelist movelist;
	
	
	public Trainer_Map_Storage(Pokedex pokedex, Movelist movelist) throws IOException
	{
		this.pokedex = pokedex;
		this.movelist = movelist;
		trainer_map_storage = new ArrayList<>();
		add_names();
		add_maps();
	}

	private void add_names() throws FileNotFoundException {
		this.trainer_map_names = new ArrayList<>();
		Scanner read_names = new Scanner(new File("src/map_names"));
		
		while (read_names.hasNextLine())
		{
			trainer_map_names.add(read_names.nextLine());
		}
		
		read_names.close();
	}

	private void add_maps() throws IOException {
		for (String map_name : trainer_map_names)
		{
			try
			{
				trainer_map_storage.add(new Trainer_Map(map_name, pokedex, movelist));
			}
			catch (IllegalArgumentException e)
			{
				System.out.println(map_name + " HAS NO TRAINERS");
			}
			
		}
		
	}
	
	public ArrayList<Trainer_Map> getTrainer_map_storage()
	{
		return trainer_map_storage;
	}
	
	public Trainer_Map getTrainer_map(String map_name)
	{
		for (Trainer_Map tm : this.trainer_map_storage)
		{
			if (tm.getMap_name().equals(map_name))
			{
				return tm;
			}
		}
		
		return null;
		
	}
}