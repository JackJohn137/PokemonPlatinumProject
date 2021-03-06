
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Map_Storage implements Serializable{
	private ArrayList<Pokemon_Map> map_storage;
	private ArrayList<String> map_names;
	
	
	public Map_Storage() throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		map_storage = new ArrayList<>();
		add_names();
		add_maps();
	}

	private void add_names() throws FileNotFoundException {
		this.map_names = new ArrayList<>();
		Scanner read_names = new Scanner(new File("src/map_names"));
		
		while (read_names.hasNextLine())
		{
			map_names.add(read_names.nextLine());
		}
		
		read_names.close();
	}

	private void add_maps() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		for (String map_name : map_names)
		{
			map_storage.add(new Pokemon_Map(map_name));
		}
		
	}
	
	public ArrayList<Pokemon_Map> getMap_storage()
	{
		return map_storage;
	}
	
	public Pokemon_Map getPokemon_map(String map_name)
	{
		for (Pokemon_Map pm : this.map_storage)
		{
			if (pm.getMap_name().equals(map_name))
			{
				return pm;
			}
		}
		
		return null;
		
	}
}