/**
 * @version 1.0
 * @author ningwang
 *
 */
public class Status {
	private final Effect effect;
	private Stat stat;
	private final double stat_multiplier;
	private boolean can_move;
	private int turn_duration;
	
	enum Effect 
	{
		NONE, BURN, FREEZE, PARALYSIS, POISON, SLEEP;
	}
	
	public Status(Effect effect) {
		this.effect = effect;
		switch (effect)
		{
			case BURN:
				this.stat = Stat.ATK;
				this.stat_multiplier = 0.5;
				this.can_move = true;
				this.turn_duration = -1;
				break;
				
			case FREEZE:
				this.stat = Stat.NONE;
				this.stat_multiplier = 1;
				this.can_move = false;
				int r = (int) (Math.random() * 5);
				if (r == 0)
				{
					this.can_move = true;
				}
				this.turn_duration = -1;
				break;
				
			case PARALYSIS:
				this.stat = Stat.SPD;
				this.stat_multiplier = 0.5;
				int r2 = (int) (Math.random() * 10);
				if (r2 == 0)
				{
					this.can_move = false;
				}
				this.turn_duration = -1;
				break;
				
			case POISON:
				this.stat = Stat.HP;
				this.stat_multiplier = 0.06125;
				this.can_move = true;
				this.turn_duration = -1;
				break;
			
			case SLEEP:
				this.stat = Stat.NONE;
				this.stat_multiplier = 1;
				this.can_move = false;
				this.turn_duration = 2 + (int) (Math.random() * 4);
				break;
				
			default:
				this.stat = Stat.NONE;
				this.stat_multiplier = 1;
				this.can_move = true;
				this.turn_duration = -1;
				break;
		}
	}
	
	public Stat getStat()
	{
		return this.stat;
	}
	
	public Effect getEffect()
	{
		return this.effect;
	}
	
	public double getStat_multiplier()
	{
		return this.getStat_multiplier();
	}

	public int getTurn_duration() {
		return turn_duration;
	}

	public void setTurn_duration(int turn_duration) {
		this.turn_duration = turn_duration;
	}
}
