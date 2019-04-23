/**
 * @version 1.0
 * @author ningwang
 *
 */
public class Pokemon_Level {
	private int level;
	private int exp_total;
	
	public Pokemon_Level(Growth_Rate growth_rate, int level)
	{
		this.exp_total = growth_rate.getExp(growth_rate.getGrowth_rate(), level);
		this.setLevel(level);
	}

	@Override
	public String toString()
	{
		return "Level: " + level;
	}
	
	public void gain_exp(Pokemon pokemon, int exp, int num_pokes)
	{
		double multiplier = 1 / (7 * num_pokes);
		
		if (!pokemon.isWild())
		{
			multiplier *= 1.5;
		}
		
		if (pokemon.getHeld_item().getItem_name().name().equals(Pokemon_Item.Item_Name.LUCKY_EGG.name()))
		{
			multiplier *= 1.5;
		}
		
		if (this.level < 100)
		{
			exp = (int) (exp * multiplier);
			while (this.exp_total + exp >= pokemon.getGrowth_Rate().getExp(pokemon.getGrowth_Rate().getGrowth_rate(), pokemon.getPokemon_level().getLevel() + 1))
			{
				if (this.level < 100)
				{
					this.level ++;
				}
				else
				{
					this.exp_total = pokemon.getGrowth_Rate().getExp(pokemon.getGrowth_Rate().getGrowth_rate(),100);
					break;
				}
			}
			this.exp_total += exp;
		}
		
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp_total() {
		return exp_total;
	}

	public void setExp_total(int exp_total) {
		this.exp_total = exp_total;
	}
}
