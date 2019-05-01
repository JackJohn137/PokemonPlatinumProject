import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trainer_Map {
	private String map_name;
	private File trainer_map;
	private ArrayList<Pokemon_Trainer> trainer_list;
	private Pokedex pokedex;
	private Movelist movelist;
	
	public Trainer_Map(String map_name, Pokedex pokedex, Movelist movelist) throws IOException
	{
		this.pokedex = pokedex;
		this.movelist = movelist;
		this.map_name = map_name;
		this.trainer_map = new File("src/trainer_map/" + map_name);
		this.trainer_list = new ArrayList<>();
		addTrainers();
	}

	private void addTrainers() throws IOException {
		Scanner trainer_reader = new Scanner(this.trainer_map);
		while (trainer_reader.hasNextLine())
		{
			String trainer_data = trainer_reader.nextLine();
			for (int i = 0; i < trainer_data.length(); i++)
			{
				if (trainer_data.substring(i, i + 1).equals(" "))
				{
					trainer_data = trainer_data.substring(0, i) + trainer_data.substring(i + 1);
					i--;
				}
			}
			String[] trainer_raw_data = trainer_data.split("/");
			Trainer_Reader temp = new Trainer_Reader(trainer_raw_data, this.pokedex, this.movelist);
			this.trainer_list.add(temp.getTrainer());
			
		}
		
		trainer_reader.close();
	}

	public String getMap_name() {
		return map_name;
	}

	public void setMap_name(String map_name) {
		this.map_name = map_name;
	}
}
