import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Pokedex {
	private ArrayList<Pokemon> pokedex;

	/**
	 * Takes Pokedex_Reader and creates a ArrayList of Pokemon to store their basic/default information
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public Pokedex() throws NumberFormatException, IOException {
		pokedex = new ArrayList<>();
		create_pokedex(new Pokedex_Reader().getPokedex());
	}

	private void create_pokedex(ArrayList<String[]> pokedex_data) throws NumberFormatException, IOException {
		for (String [] pokedex_entry : pokedex_data)
		{
			pokedex.add(add_entry(pokedex_entry));
		}
	}

	private Pokemon add_entry(String[] s) throws NumberFormatException, IOException
	{	
		return new Pokemon (
				s[0], 
				Integer.parseInt(s[1]), 
				ImageIO.read(getClass().getResource("pokemon_front/" + s[2])), 
				ImageIO.read(getClass().getResource("pokemon_back/" + s[3])), 
				s[4], 
				s[5], 
				Boolean.valueOf(s[6]), 
				new Growth_Rate(Rate.valueOf(s[7])),
				Integer.parseInt(s[8]), 
				new Pokemon_Type(Pokemon_Type.Type.valueOf(s[9])), 
				new Pokemon_Type(Pokemon_Type.Type.valueOf(s[10])), 
				new Pokemon_Nature(Nature.valueOf(s[11])), 
				new Base_Stats(
						Integer.parseInt(s[12]), 
						Integer.parseInt(s[13]), 
						Integer.parseInt(s[14]), 
						Integer.parseInt(s[15]), 
						Integer.parseInt(s[16]), 
						Integer.parseInt(s[17])),         
				new Individual_Values(0, 0, 0, 0, 0, 0), 
				new Effort_Values(0, 0, 0, 0, 0, 0), 
				Integer.parseInt(s[18]), 
				new Pokemon_Item(Pokemon_Item.Item_Name.NONE, Pokemon_Item.Item_Pocket.NONE, Pokemon_Item.Item_Type.NONE, false, false),     
				new Effort_Value_Drop(
						Integer.parseInt(s[19]), 
						Stat.valueOf(s[20]), 
						Integer.parseInt(s[21]), 
						Stat.valueOf(s[22])));
	}
	
	public ArrayList<Pokemon> getPokedex()
	{
		return pokedex;
	}
}
