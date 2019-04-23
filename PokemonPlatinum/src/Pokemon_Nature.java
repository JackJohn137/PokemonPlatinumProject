/**
 * @version 1.0
 * @author ningwang
 */
public class Pokemon_Nature {
	private final Nature nature;
	//private final int hp, atk, spAtk, def, spDef, spd;
	
	/**
	 * 
	 * @param nature
	 */
	public Pokemon_Nature(Nature nature)
	{
		this.nature = nature;
		switch (nature)
		{
				
			case HARDY: 
				//Neutral Nature
				break;
				
			case LONELY: 
				this.nature.atk = 1.1;
				this.nature.def = 0.9;
				break;
				
			case BRAVE: 
				this.nature.atk = 1.1;
				this.nature.spd = 0.9;
				break;
				
			case ADAMANT: 
				this.nature.atk = 1.1;
				this.nature.spAtk = 0.9;
				break;
				
			case NAUGHTY: 
				this.nature.atk = 1.1;
				this.nature.spDef = 0.9;
				break;
				
			case BOLD: 
				this.nature.atk = 0.9;
				this.nature.def = 1.1;
				break;
				
			case DOCILE: 
				//Neutral Nature
				break;
				
			case RELAXED: 
				this.nature.def = 1.1;
				this.nature.spd = 0.9;
				break;
				
			case IMPISH: 
				this.nature.spAtk = 0.9;
				this.nature.def = 1.1;
				break;
				
			case LAX: 
				this.nature.def = 1.1;
				this.nature.spDef = 0.9;
				break;
				
			case TIMID: 
				this.nature.atk = 0.9;
				this.nature.spd = 1.1;
				break;
				
			case HASTY: 
				this.nature.def = 0.9;
				this.nature.spd = 1.1;
				break;
				
			case SERIOUS: 
				//Neutral Nature
				break;
				
			case JOLLY: 
				this.nature.spAtk = 0.9;
				this.nature.spd = 1.1;
				break;
				
			case NAIVE: 
				this.nature.spDef = 0.9;
				this.nature.spd = 1.1;
				break;
				
			case MODEST: 
				this.nature.atk = 0.9;
				this.nature.spAtk = 1.1;
				break;
				
			case MILD: 
				this.nature.spAtk = 1.1;
				this.nature.def = 0.9;
				break;
				
			case QUIET: 
				this.nature.spAtk = 1.1;
				this.nature.spd = 0.9;
				break;
				
			case BASHFUL: 
				//Neutral Nature
				break;
				
			case RASH: 
				this.nature.spAtk = 1.1;
				this.nature.spDef = 0.9;
				break;
				
			case CALM: 
				this.nature.atk = 0.9;
				this.nature.spDef = 1.1;
				break;
				
			case GENTLE: 
				this.nature.def = 0.9;
				this.nature.spDef = 1.1;
				break;
				
			case SASSY: 
				this.nature.spDef = 1.1;
				this.nature.spd = 0.9;
				break;
				
			case CAREFUL: 
				this.nature.spAtk = 0.9;
				this.nature.spDef = 1.1;
				break;
				
			case QUIRKY: 
				//Neutral Nature
				break;
		}
		if (this.nature.atk == 0)
		{
			this.nature.atk ++;
		}
		if (this.nature.spAtk == 0)
		{
			this.nature.spAtk ++;
		}
		if (this.nature.def == 0)
		{
			this.nature.def ++;
		}
		if (this.nature.spDef == 0)
		{
			this.nature.spDef ++;
		}
		if (this.nature.spd == 0)
		{
			this.nature.spd ++;
		}
	}
	
	public Pokemon_Nature()
	{
		this(randomNature());
	}
	
	@Override
	public String toString()
	{
		return "Nature: " + nature;
	}
	
	private static Nature randomNature()
	{
		int r = (int) (Math.random() * 25);
		switch (r)
		{
			case 0: 
				return Nature.HARDY;
				
			case 1: 
				return  Nature.LONELY;
		
			case 2: 
				return Nature.BRAVE;
				
			case 3: 
				return Nature.ADAMANT;
			
			case 4: 
				return Nature.NAUGHTY;
			
			case 5: 
				return Nature.BOLD;
				
			case 6: 
				return Nature.DOCILE;
			
			case 7: 
				return Nature.RELAXED;
			
			case 8: 
				return Nature.IMPISH;
			
			case 9: 
				return Nature.LAX;
				
			case 10: 
				return Nature.TIMID;
				
			case 11: 
				return Nature.HASTY;
				
			case 12: 
				return Nature.SERIOUS;
				
			case 13: 
				return Nature.JOLLY;
				
			case 14: 
				return Nature.NAIVE;
				
			case 15:
				return Nature.MODEST;
				
			case 16: 
				return Nature.MILD;
				
			case 17: 
				return Nature.QUIET;
				
			case 18: 
				return Nature.BASHFUL;
				
			case 19: 
				return Nature.RASH;
				
			case 20: 
				return Nature.CALM;
				
			case 21: 
				return Nature.GENTLE;
				
			case 22: 
				return Nature.SASSY;
				
			case 23: 
				return Nature.CAREFUL;
				
			case 24: 
				return Nature.QUIRKY;
				
			default:
				System.out.println("ERROR: Nature Failed to Randomly Generate!");
				return null;
		}
	}
	
	public Nature getNature() {
		return nature;
	}
	
}
