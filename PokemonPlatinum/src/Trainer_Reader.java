import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Trainer_Reader implements Serializable{
	private Pokemon_Trainer trainer;
	public Trainer_Reader(String[] trainer_raw_data, Pokedex pokedex, Movelist movelist) throws IOException
	{
		int index = 4;
		trainer = new Pokemon_Trainer(trainer_raw_data[0], trainer_raw_data[1], Direction.valueOf(trainer_raw_data[2]), Integer.parseInt(trainer_raw_data[3]), Integer.parseInt(trainer_raw_data[4]));
		while (index < trainer_raw_data.length - 1)
		{
			trainer.getPokemon_storage().addPokemon(new Pokemon (pokedex.getPokemon(trainer_raw_data[index + 1]), pokedex.getPokemon(trainer_raw_data[index + 1]).getIv(), pokedex.getPokemon(trainer_raw_data[index + 1]).getEv()));
			trainer.getPokemon_storage().getPokemon_storage()[(index - 4) / 6].addMove(movelist.getMove(trainer_raw_data[index + 2]));
			trainer.getPokemon_storage().getPokemon_storage()[(index - 4) / 6].addMove(movelist.getMove(trainer_raw_data[index + 3]));
			trainer.getPokemon_storage().getPokemon_storage()[(index - 4) / 6].addMove(movelist.getMove(trainer_raw_data[index + 4]));
			trainer.getPokemon_storage().getPokemon_storage()[(index - 4) / 6].addMove(movelist.getMove(trainer_raw_data[index + 5]));
			
			//trainer pokemons don't need to level up so they dont have exp total. also, this doesnt like exp total either 
			trainer.getPokemon_storage().getPokemon_storage()[(index - 4) / 6].setPokemon_Level(new Pokemon_Level(Integer.parseInt(trainer_raw_data[index + 6])));
			
			index +=6;
		}
	}
	
	public Pokemon_Trainer getTrainer()
	{
		return trainer;
	}
}