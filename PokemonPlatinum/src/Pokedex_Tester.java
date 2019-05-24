import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class Pokedex_Tester implements Serializable{

	public Pokedex_Tester() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns some basic info on pokemon
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		Pokedex pd = new Pokedex();
		Pokemon poke = pd.getPokedex().get(0);
		System.out.println(poke.getName());
		System.out.println(poke.getType_1().toString());
		System.out.println(poke.getPokemon_level().toString());
		System.out.println(poke.getPokemon_nature().toString());
		System.out.println(poke.getStats().toString());
		System.out.println(poke.getType_1().toString());
		System.out.println(poke.getType_2().toString());
		System.out.println(poke.getGrowth_rate().toString());
	}

}
