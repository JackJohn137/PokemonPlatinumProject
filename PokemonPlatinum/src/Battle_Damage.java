import java.io.Serializable;

public class Battle_Damage implements Serializable{
	private final Pokemon attacker;
	private final Pokemon defender;
	private final Pokemon_Move pokemon_move;
	private final int damage_dealt;
	
	public Battle_Damage (Pokemon attacker, Pokemon defender, Pokemon_Move pokemon_move)
	{
		this.attacker = attacker;
		this.defender = defender;
		this.pokemon_move = pokemon_move;
		this.damage_dealt = getDamage_dealt();
	}

	public Pokemon getAttacker()
	{
		return this.attacker;
	}
	
	public Pokemon getDefender()
	{
		return this.defender;
	}
	
	public Pokemon_Move getPokemon_move()
	{
		return this.pokemon_move;
	}
	
	public int getDamage_dealt()
	{
		double A, B, C, D, X, Y, Z;
		A = this.getAttacker().getPokemon_level().getLevel();
		C = this.getPokemon_move().getPower();
		
		if (this.pokemon_move.getIsPhysical())
		{
			B = this.getAttacker().getStats().getAtk();
			D = this.getDefender().getStats().getDef();
		}
		else
		{
			B = this.getAttacker().getStats().getSpAtk();
			D = this.getDefender().getStats().getspDef();
		}
		
		if (this.getAttacker().getType_1().equals(getPokemon_move().getMove_type()) || this.getAttacker().getType_2().equals(getPokemon_move().getMove_type()))
		{
			X = 1.5;
		}
		else
		{
			X = 1;
		}
		
		if (this.getDefender().getType_1().equals(this.getDefender().getType_2()))
		{
			Y = this.getPokemon_move().getMove_type().effectiveness_against(this.getDefender().getType_1().getType());
		}
		else
		{
			Y = this.getPokemon_move().getMove_type().effectiveness_against(this.getDefender().getType_1().getType()) 
			  * this.getPokemon_move().getMove_type().effectiveness_against(this.getDefender().getType_2().getType());
		}
		
		Z = 217 + (int) (Math.random() * 39);
		int damage = (int) ((((((2.0 * A / 5 + 2) * B * C) / D) / 50) + 2) * X * Y * Z / 255);
		return damage;
	}
}
