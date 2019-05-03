import java.util.ArrayList;

/**
 * @version 1.0 
 * @author ningwang
 *
 */
public class Pokemon_Storage {
	private Pokemon[] pokemon_storage;
	private int current_size;
	
	/**
	 * Creates an Array of Pokemon with size of int size
	 * @param size
	 */
	public Pokemon_Storage(int size) {
		this.pokemon_storage = new Pokemon[size];
		this.current_size = 0;
	}
	
	public Pokemon[] getPokemon_storage()
	{
		return this.pokemon_storage;
	}
	
	public Pokemon getPokemon(int index)
	{
		for (Pokemon p : pokemon_storage)
		{
			if (index == p.getPokedex_number())
			{
				return pokemon_storage[index];
			}
		}
		return null;
	}
	
	public void addPokemon (Pokemon pokemon)
	{
		if (this.current_size < this.pokemon_storage.length)
		{
			this.pokemon_storage[this.current_size] = pokemon;
			this.current_size ++;
		}
	}
	
	public void removePokemon(int index)
	{
		if (this.pokemon_storage[index] != null)
		{
			for (int i = index; i < this.pokemon_storage.length - 1; i++)
			{
				this.pokemon_storage[index] = this.pokemon_storage[index + 1];
			}
			
			this.pokemon_storage[this.pokemon_storage.length - 1] = null;
		}
	}
	
	public void switchPokemon(int index1, int index2)
	{
		if (-1 < index1 && index1 < this.pokemon_storage.length && -1 < index2 && index2 < this.pokemon_storage.length)
		{
			Pokemon temp = this.pokemon_storage[index1];
			this.pokemon_storage[index1] = this.pokemon_storage[index2];
			this.pokemon_storage[index2] = temp;
		}
	}
}
