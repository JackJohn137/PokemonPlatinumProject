import java.io.Serializable;

/**
 * @version 1.0
 * @author ningwang
 *
 */
public class Pokemon_Level implements Serializable{
	private int level;
	private int exp_total;
	private Growth_Rate growth_rate;
	
	public Pokemon_Level(int level)
	{
		this.level = level;
	}
	
	public Pokemon_Level(Growth_Rate growth_rate, int level)
	{
		this.level = level;
		this.growth_rate = growth_rate;
		
		this.exp_total = new Exp_calc(this.growth_rate, this.level).getExp();
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
			while (this.exp_total + exp >= new Exp_calc(this.growth_rate, this.level + 1).getExp())
			{
				if (this.level < 100)
				{
					this.level ++;
				}
				else
				{
					this.exp_total = new Exp_calc(this.growth_rate, 100).getExp();
					exp = 0;
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
