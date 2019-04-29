import java.io.File;
import java.io.IOException;

public class Trainer_Reader {
	private Pokemon_Trainer trainer;
	public Trainer_Reader(String[] trainer_raw_data) throws IOException
	{
		trainer = new Pokemon_Trainer(trainer_raw_data[0], trainer_raw_data[1], Direction.valueOf(trainer_raw_data[2]));
		trainer.setName(trainer_raw_data[0]);
		trainer.getPokemon_storage().addPokemon(new Pokemon(Pokedex.class.getrainer_raw_data[0], null, null));;
	}
}
