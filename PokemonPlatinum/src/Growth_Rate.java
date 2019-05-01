/**
 * @version
 * @TODO: add growth formulas
 * @author ningwang
 */
public class Growth_Rate {
	private final Rate growth_rate;
	
	/**
	 * 
	 * @param growth_rate = how much exp needed to per level
	 */
	public Growth_Rate(Rate growth_rate)
	{
		switch (growth_rate)
		{
			case ERRATIC: 
				this.growth_rate = growth_rate;
				break;
			case FAST: 
				this.growth_rate = growth_rate;
				break;
			case MEDIUM_FAST:
				this.growth_rate = growth_rate;
				break;
			case MEDIUM_SLOW:
				this.growth_rate = growth_rate;
				break;
			case SLOW: 
				this.growth_rate = growth_rate;
				break;
			case FLUCTUATING:
				this.growth_rate = growth_rate;
				break;
			default: 
				this.growth_rate = growth_rate;
		}
	}
	
	public Rate getGrowth_rate() {
		return growth_rate;
	}
	
	/**
	 * 
	 * @param growth_rate
	 * @param level
	 * @return
	 */
	public int getExp(int level)
	{
		switch (growth_rate)
		{
			case ERRATIC:
				return getExp_erratic(level);
			
			case FAST:
				return getExp_fast(level);
				
			case MEDIUM_FAST:
				return getExp_medium_fast(level);
				
			case MEDIUM_SLOW:
				return getExp_medium_slow(level);
				
			case SLOW:
				return getExp_slow(level);
				
			case FLUCTUATING:
				return getExp_fluctuating(level);
			
			default:
				System.out.println("ERROR: Growth_Rate: getExp");
				return 999999999;
		}
	}
	
	private int getExp_erratic(int n)
	{	
		if (n <= 50)
		{
			return (int) (n * n * n * (100 - n) / 50);
		}
		else if (n <= 68)
		{
			return (int) (n * n * n * (150 - n) / 100);
		}
		else if (n <= 98)
		{
			return (int) (n * n * n * ((1911 - 10 * n) / 3) / 500);
		}
		else 
		{
			return (int) (n * n * n * (160 - n) / 500);
		}
	}
	
	private int getExp_fast(int n)
	{
		return (int) (4 * n * n * n / 5);
	}
	
	private int getExp_medium_fast(int n)
	{
		return (int) (n * n * n);
	}
	
	private int getExp_medium_slow(int n)
	{
		return (int) (6 * n * n * n / 5 - 15 * n * n + 100 * n - 140);
	}
	
	private int getExp_slow(int n)
	{
		return (int) (5 * n * n * n * n / 4);
	}
	
	private int getExp_fluctuating(int n)
	{
		if (n <= 15)
		{
			return (int) (n * n * n * ((n + 1) / 3 + 24) / 50);
		}
		else if (n <= 36)
		{
			return (int) (n * n * n * (n + 14) / 50);
		}
		else 
		{
			return (int) (n * n * n * (n / 2 + 32) / 50);
		}
	}
}
