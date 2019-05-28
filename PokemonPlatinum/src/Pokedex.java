import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Pokedex implements Serializable{
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
		System.out.println(s[0]);
		return new Pokemon (
				s[0], 
				Integer.parseInt(s[1]), 
				ImageIO.read(getClass().getResource("pokemon_front/" + s[2])), 
				ImageIO.read(getClass().getResource("pokemon_back/" + s[3])), 
				s[4], 
				s[5], 
				Boolean.valueOf(s[6]), 
				Growth_Rate.valueOf(s[7]),
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
	
	public Pokemon getPokemon(String name)
	{
		for (Pokemon pokemon : pokedex)
		{
			if (name.equals(pokemon.getName()))
			{
				return pokemon;
			}
		}
		return null;
	}
	
	public void reloadPokedex() throws IOException
	{
		int burmy = 1, wormadam = 1, cherrim = 1, shellos = 1, gastrodon = 1, giratina = 1;
		String add = "";
		for (Pokemon pokemon : pokedex)
		{
			System.out.println(pokemon.getName());
			if (pokemon.getName().toLowerCase().equals("burmy"))
			{
				switch (burmy)
				{
					case 1: add = "_grass";
					burmy = 2;
					break;
					
					case 2: add = "_sand";
					burmy = 3;
					break;
					
					case 3: add = "_trash";
					burmy = 1;
					break;
				}
			}
			
			if (pokemon.getName().toLowerCase().equals("wormadam"))
			{
				switch (wormadam)
				{
					case 1: add = "_grass";
					wormadam = 2;
					break;
					
					case 2: add = "_sand";
					wormadam = 3;
					break;
					
					case 3: add = "_trash";
					wormadam = 1;
					break;
				}
			}
			
			if (pokemon.getName().toLowerCase().equals("cherrim"))
			{
				switch (cherrim)
				{
					case 1: add = "_overcast";
					cherrim = 2;
					break;
					
					case 2: add = "_sunshine";
					cherrim = 1;
					break;
				}
			}
			
			if (pokemon.getName().toLowerCase().equals("shellos"))
			{
				switch (shellos)
				{
					case 1: add = "_west";
					shellos = 2;
					break;
					
					case 2: add = "_east";
					shellos = 1;
					break;
				}
			}
			
			if (pokemon.getName().toLowerCase().equals("gastrodon"))
			{
				switch (gastrodon)
				{
					case 1: add = "_west";
					gastrodon = 2;
					break;
					
					case 2: add = "_east";
					gastrodon = 1;
					break;
				}
			}
			
			if (pokemon.getName().toLowerCase().equals("giratina"))
			{
				switch (giratina)
				{
					case 1: add = "_altered";
					giratina = 2;
					break;
					
					case 2: add = "_origin";
					giratina = 1;
					break;
				}
			}
			
			if (pokemon.getFront_image() == null)
			{
				pokemon.setFront_image(ImageIO.read(getClass().getResource("pokemon_front/" + pokemon.getName().toLowerCase() + add + ".front.png")));
			}
			
			if (pokemon.getBack_image() == null)
			{
				pokemon.setBack_image(ImageIO.read(getClass().getResource("pokemon_back/" + pokemon.getName().toLowerCase() + add + ".back.png")));
			}
			
			add = "";
		}
	}
}
