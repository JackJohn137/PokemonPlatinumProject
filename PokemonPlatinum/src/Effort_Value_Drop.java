/**
 * @version 1.0
 * @author ningwang
 *
 */
public class Effort_Value_Drop {
	
	private final int quantity1;
	private final int quantity2;
	private final Stat stat1;
	private final Stat stat2;
	
	
	/**
	 * 
	 * @param quantity1
	 * @param stat1
	 * @param quantity2
	 * @param stat2
	 */
	public Effort_Value_Drop (int quantity1, Stat stat1, int quantity2, Stat stat2)
	{
		this.quantity1 = quantity1;
		this.quantity2 = quantity2;
		this.stat1 = stat1;
		this.stat2 = stat2;
	}

	public int getQuantity1() {
		return quantity1;
	}

	public Stat getStat1() {
		return stat1;
	}

	public int getQuantity2() {
		return quantity2;
	}

	public Stat getStat2() {
		return stat2;
	}
}
