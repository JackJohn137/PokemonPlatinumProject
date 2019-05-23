import java.io.Serializable;

/**
 * @version 1.0
 * @TODO: Type matchups
 * @author ningwang
 * @type_1 = primary type;
 * @type_2 = secondary type, if none exists, same as type_1;
 * @enum Type: NORMAL, FIGHTING, FLYING, POISON, GROUND, ROCK, BUG, GHOST, STEEL, FIRE, WATER, GRASS, ELECTRIC, PSYCHIC, ICE, DRAGON, DARK, FAIRY;
 * 
 */
public class Pokemon_Type implements Serializable{
	private Type type;
	
	enum Type
	{
		NORMAL, FIGHTING, FLYING, POISON, GROUND, ROCK, BUG, GHOST, STEEL, FIRE, WATER, GRASS, ELECTRIC, PSYCHIC, ICE, DRAGON, DARK, FAIRY;
	}
	
	/**
	 * 
	 * @param type
	 */
	public Pokemon_Type(Type type)
	{
		this.type = type;
	}
	
	
	@Override
	public String toString()
	{
		return "Type: " + type;
	}

	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * Returns double: effectiveness of move against type
	 * @param move_type
	 * @param pokemon_type
	 * @return
	 */
	public double effectiveness_against(Type pokemon_type) {
		switch (this.type)
		{
			case NORMAL:
				switch (pokemon_type)
				{
					case ROCK:
						return 0.5;
						
					case GHOST:
						return 0;
						
					case STEEL:
						return 0.5;
							
					default:
						return 1;
				}
				
			case FIGHTING:
				switch (pokemon_type)
				{
					case NORMAL:
						return 2;
					
					case FLYING:
						return 0.5;
						
					case POISON:
						return 0.5;
					
					case ROCK:
						return 2;
						
					case BUG:
						return 0.5;
						
					case GHOST:
						return 0;
						
					case STEEL:
						return 2;
						
					case PSYCHIC:
						return 0.5;
						
					case ICE:
						return 2;
						
					case DARK:
						return 2;
						
					case FAIRY:
						return 0.5;
						
					default:
						return 1;
				}
				
			case FLYING:
				switch (pokemon_type)
				{
					case FIGHTING:
						return 2;
					
					case ROCK:
						return 0.5;
						
					case BUG:
						return 2;
					
					case STEEL:
						return 0.5;
						
					case GRASS:
						return 2;
						
					case ELECTRIC:
						return 0.5;
					
					default:
						return 1;
				}
				
			case POISON:
				switch (pokemon_type)
				{
					case POISON:
						return 0.5;
						
					case GROUND:
						return 0.5;
						
					case ROCK:
						return 0.5;
						
					case GHOST:
						return 0.5;
						
					case STEEL:
						return 0;
						
					case GRASS:
						return 2;
						
					case FAIRY:
						return 2;
						
					default:
						return 1;
				}
				
			case GROUND:
				switch (pokemon_type)
				{
					case FLYING:
						return 0;
						
					case POISON:
						return 2;
						
					case ROCK:
						return 2;
						
					case BUG:
						return 0.5;
						
					case STEEL:
						return 2;
						
					case FIRE:
						return 2;
						
					case GRASS:
						return 0.5;
						
					case ELECTRIC:
						return 2;
						
					default:
						return 1;
				}
				
			case ROCK:
				switch (pokemon_type)
				{
					case FIGHTING:
						return 0.5;
						
					case FLYING:
						return 2;
						
					case GROUND:
						return 0.5;
						
					case BUG:
						return 2;
						
					case STEEL:
						return 0.5;
						
					case FIRE:
						return 2;
					
					case ICE:
						return 2;
					
					default:
						return 1;
				}
				
			case BUG:
				switch (pokemon_type)
				{
					case FIGHTING:
						return 0.5;
						
					case FLYING:
						return 0.5;
						
					case POISON:
						return 0.5;
							
					case GHOST:
						return 0.5;
						
					case STEEL:
						return 0.5;
						
					case FIRE:
						return 0.5;
						
					case GRASS:
						return 2;
						
					case PSYCHIC:
						return 2;
						
					case DARK:
						return 2;
						
					case FAIRY:
						return 0.5;
						
					default:
						return 1;
				}
				
			case GHOST:
				switch (pokemon_type)
				{
					case NORMAL:
						return 0;
						
					case GHOST:
						return 2;
						
					case PSYCHIC:
						return 2;
						
					case DARK:
						return 0.5;
					
					default:
						return 1;
				}
				
			case STEEL:
				switch (pokemon_type)
				{
					case ROCK:
						return 2;
					
					case STEEL:
						return 0.5;
						
					case FIRE:
						return 0.5;
						
					case WATER:
						return 0.5;
						
					case ELECTRIC:
						return 0.5;
						
					case ICE:
						return 2;
						
					case FAIRY:
						return 2;
						
					default:
						return 1;
				}
				
			case FIRE:
				switch (pokemon_type)
				{
					case ROCK:
						return 0.5;
						
					case BUG:
						return 2;
						
					case STEEL:
						return 2;
						
					case FIRE:
						return 0.5;
						
					case WATER:
						return 0.5;
						
					case GRASS:
						return 2;
						
					case ICE:
						return 2;
						
					case DRAGON:
						return 0.5;
						
					default:
						return 1;
				}
				
			case WATER:
				switch (pokemon_type)
				{
					case GROUND:
						return 2;
						
					case ROCK:
						return 2;
						
					case FIRE:
						return 2;
						
					case WATER:
						return 0.5;
						
					case GRASS:
						return 0.5;
						
					case DRAGON:
						return 0.5;
						
					default:
						return 1;
				}
				
			case GRASS:
				switch (pokemon_type)
				{
					case FLYING:
						return 0.5;
						
					case POISON:
						return 0.5;
						
					case GROUND:
						return 2;
						
					case ROCK:
						return 2;
						
					case BUG:
						return 0.5;
						
					case STEEL:
						return 0.5;
						
					case FIRE:
						return 0.5;
						
					case WATER:
						return 2;
						
					case GRASS:
						return 0.5;
						
					case ELECTRIC:
						return 0.5;
						
					case DRAGON:
						return 0.5;
						
					default:
						return 1;
				}
				
			case ELECTRIC:
				switch (pokemon_type)
				{
					case FLYING:
						return 2;
						
					case GROUND:
						return 0;
						
					case STEEL:
						return 0.5;
						
					case WATER:
						return 2;
						
					case GRASS:
						return 0.5;
						
					case ELECTRIC:
						return 0.5;
					
					case DRAGON:
						return 0.5;
						
					default:
						return 1;
				}
				
			case PSYCHIC:
				switch (pokemon_type)
				{
					case FIGHTING:
						return 2;
						
					case POISON:
						return 2;
						
					case STEEL:
						return 2;
						
					case PSYCHIC:
						return 0.5;
						
					case DARK:
						return 0;
						
					default:
						return 1;
				}
				
			case ICE:
				switch (pokemon_type)
				{
					case FLYING:
						return 2;
						
					case GROUND:
						return 2;
						
					case STEEL:
						return 0.5;
						
					case FIRE:
						return 0.5;
						
					case WATER:
						return 0.5;
						
					case GRASS:
						return 2;
						
					case ICE:
						return 0.5;
						
					case DRAGON:
						return 2;
						
					default:
						return 1;
				}
				
			case DRAGON:
				switch (pokemon_type)
				{
					case STEEL:
						return 0.5;
						
					case DRAGON:
						return 2;
						
					case FAIRY:
						return 0;
						
					default:
						return 1;
				}
				
			case DARK:
				switch (pokemon_type)
				{
					case FIGHTING:
						return 0.5;
						
					case GHOST:
						return 2;
						
					case PSYCHIC:
						return 2;
						
					case DARK:
						return 0.5;
						
					case FAIRY:
						return 0.5;
						
					default:
						return 1;
				}
				
			case FAIRY:
				switch (pokemon_type)
				{
					case FIGHTING:
						return 2;
						
					case GROUND:
						return 0.5;
						
					case STEEL:
						return 0.5;
						
					case FIRE:
						return 0.5;
						
					case DRAGON:
						return 2;
						
					case DARK:
						return 2;
						
					default:
						return 1;
				}
				
			default:
				System.out.println("ERROR: POKEMON_TYPE: EFFECTIVENESS_AGAINST: MOVE_TYPE");
				return 1;
		}
	}
}
