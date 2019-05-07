
public class Exp_calc {
	private int exp;
	private int n; // n = level
	private Growth_Rate growth_rate;
	
	public Exp_calc(Growth_Rate growth_rate, int level)
	{
		this.growth_rate = growth_rate;
		this.n = level;
		this.exp = getExp();
	}
	
	public int getExp()
	{
		switch (growth_rate)
		{
			case ERRATIC:
				return getExp_erratic();
			
			case FAST:
				return getExp_fast();
				
			case MEDIUM_FAST:
				return getExp_medium_fast();
				
			case MEDIUM_SLOW:
				return getExp_medium_slow();
				
			case SLOW:
				return getExp_slow();
				
			case FLUCTUATING:
				return getExp_fluctuating();
			
			default:
				System.out.println("ERROR: Growth_Rate: getExp");
				return 999999999;
		}
	}
	
	private int getExp_erratic()
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
	
	private int getExp_fast()
	{
		return (int) (4 * n * n * n / 5);
	}
	
	private int getExp_medium_fast()
	{
		return (int) (n * n * n);
	}
	
	private int getExp_medium_slow()
	{
		return (int) (6 * n * n * n / 5 - 15 * n * n + 100 * n - 140);
	}
	
	private int getExp_slow()
	{
		return (int) (5 * n * n * n * n / 4);
	}
	
	private int getExp_fluctuating()
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
