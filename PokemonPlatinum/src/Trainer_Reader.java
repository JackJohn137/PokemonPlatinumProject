import java.io.File;
import java.io.IOException;

public class Trainer_Reader {
	private Pokemon_Trainer trainer;
	public Trainer_Reader(String[] trainer_raw_data, Pokedex pokedex, Movelist movelist) throws IOException
	{
		int index = 4;
		trainer = new Pokemon_Trainer(trainer_raw_data[0], trainer_raw_data[1], Direction.valueOf(trainer_raw_data[2]), Integer.parseInt(trainer_raw_data[3]), Integer.parseInt(trainer_raw_data[4]));
		while (index < trainer_raw_data.length - 1)
		{
			trainer.getPokemon_storage().addPokemon(pokedex.getPokemon(trainer_raw_data[index + 1]));
			trainer.getPokemon_storage().getPokemon((index - 4) / 6).addMove(movelist.getMove(trainer_raw_data[index + 2]));
			trainer.getPokemon_storage().getPokemon((index - 4) / 6).addMove(movelist.getMove(trainer_raw_data[index + 3]));
			trainer.getPokemon_storage().getPokemon((index - 4) / 6).addMove(movelist.getMove(trainer_raw_data[index + 4]));
			trainer.getPokemon_storage().getPokemon((index - 4) / 6).addMove(movelist.getMove(trainer_raw_data[index + 5]));
			
			//trainer pokemons don't need to level up so they dont have exp total. also, this doesnt like exp total either 
			trainer.getPokemon_storage().getPokemon((index - 4) / 6).setPokemon_Level(new Pokemon_Level(Integer.parseInt(trainer_raw_data[index + 6])));
			
			System.out.println(trainer_raw_data[index + 1]);
			System.out.print(trainer_raw_data[index + 2] + " ");
			System.out.print(trainer_raw_data[index + 3] + " ");
			System.out.print(trainer_raw_data[index + 4] + " ");
			System.out.println(trainer_raw_data[index + 5]);
			System.out.println(trainer_raw_data[index + 6]);
			
			index +=6;
		}
	}
	
	public Pokemon_Trainer getTrainer()
	{
		return trainer;
	}
}