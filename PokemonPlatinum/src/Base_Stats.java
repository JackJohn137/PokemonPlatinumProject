/**
 * @version 1.0
 * @author ningwang
 *
 */
public class Base_Stats {
	private final int base_hp;
	private final int base_atk;
	private final int base_spAtk;
	private final int base_def;
	private final int base_spDef;
	private final int base_spd;
	
	/**
	 * 
	 * @param base_hp = Stat used for pokemon's base hp
	 * @param ase_atk = Stat used for pokemon's base atk
	 * @param base_def = Stat used for pokemon's base def
	 * @param base_spAtk = Stat used for pokemon's base spAtk
	 * @param base_spDef = Stat used for pokemon's base spDef
	 * @param base_spd = Stat used for pokemon's base spd		
	 */
	public Base_Stats (int base_hp, 
					   int base_atk, 
					   int base_def, 
					   int base_spAtk, 
					   int base_spDef, 
					   int base_spd)
	{
		this.base_hp = base_hp;
		this.base_atk = base_atk;
		this.base_spAtk = base_spAtk;
		this.base_def = base_def;
		this.base_spDef = base_spDef;
		this.base_spd = base_spd;
	}

	public int getBase_hp() {
		return base_hp;
	}

	public int getBase_atk() {
		return base_atk;
	}

	public int getBase_spAtk() {
		return base_spAtk;
	}

	public int getBase_def() {
		return base_def;
	}

	public int getBase_spDef() {
		return base_spDef;
	}
	
	public int getBase_spd() {
		return base_spd;
	}
	
}
