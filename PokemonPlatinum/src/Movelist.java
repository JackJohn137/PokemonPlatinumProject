import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Movelist {
	private ArrayList<Pokemon_Move> Movelist;

	/**
	 * Takes Movelist_Reader and creates a ArrayList of Pokemon to store their basic/default information
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public Movelist() throws NumberFormatException, IOException {
		Movelist = new ArrayList<>();
		create_Movelist(new Movelist_Reader().getMovelist());
	}

	private void create_Movelist(ArrayList<String[]> Movelist_data) throws NumberFormatException, IOException {
		for (String [] Movelist_entry : Movelist_data)
		{
			Movelist.add(add_entry(Movelist_entry));
		}
	}

	private Pokemon_Move add_entry(String[] s) throws NumberFormatException, IOException
	{	
		return new Pokemon_Move (s[0], new Pokemon_Type(Pokemon_Type.Type.valueOf(s[1])), Integer.parseInt(s[2]), Boolean.parseBoolean(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5]));     
	}
	
	public ArrayList<Pokemon_Move> getMovelist()
	{
		return Movelist;
	}
	
	public Pokemon_Move getPokemon(String name)
	{
		for (Pokemon_Move move : Movelist)
		{
			if (name.equals(move.getMove_name()))
			{
				return move;
			}
		}
		return null;
	}

	public Pokemon_Move getMove(String move_name) {
		for (Pokemon_Move pm : Movelist)
		{
			if (pm.getMove_name().equals(move_name))
			{
				return pm;
			}
		}
		return null;
	}
}