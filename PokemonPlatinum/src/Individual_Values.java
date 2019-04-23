/**
 * @version 1.0
 * @author ningwang
 *
 */
public class Individual_Values {
	private int iv_hp;
	private int iv_atk;
	private int iv_spAtk;
	private int iv_def;
	private int iv_spDef;
	private int iv_spd;

	/**
	 * 
	 * @param iv_hp = Stat used for pokemon's hidden hp bonus
	 * @param iv_atk = Stat used for pokemon's hidden atk bonus
	 * @param iv_spAtk = Stat used for pokemon's hidden spAtk bonus
	 * @param iv_def = Stat used for pokemon's hidden def bonus
	 * @param iv_spDef = Stat used for pokemon's hidden spDef bonus
	 * @param iv_spd = Stat used for pokemon's hidden spd bonus
	 */
	public Individual_Values(
			int iv_hp, 
			int iv_atk, 
			int iv_spAtk, 
			int iv_def, 
			int iv_spDef, 
			int iv_spd)
	{
		this.iv_hp = (iv_hp);
		this.iv_atk = iv_atk;
		this.iv_spAtk = iv_spAtk;
		this.iv_def = iv_def;
		this.iv_spDef = iv_spDef;
		this.iv_spd = iv_spd;
	}

	/**
	 * @param Randomizes all IV values
	 */
	public Individual_Values()
	{
		iv_hp = ((int) (Math.random() * 32));
		iv_atk = (int) (Math.random() * 32);
		iv_spAtk = (int) (Math.random() * 32);
		iv_def = (int) (Math.random() * 32);
		iv_spDef = (int) (Math.random() * 32);
		iv_spd = (int) (Math.random() * 32);
	}

	public int getIv_hp() {
		return iv_hp;
	}

	public void setIv_hp(int iv_hp) {
		this.iv_hp = iv_hp;
	}

	public int getIv_atk() {
		return iv_atk;
	}

	public void setIv_atk(int iv_atk) {
		this.iv_atk = iv_atk;
	}

	public int getIv_spAtk() {
		return iv_spAtk;
	}

	public void setIv_spAtk(int iv_spAtk) {
		this.iv_spAtk = iv_spAtk;
	}

	public int getIv_def() {
		return iv_def;
	}

	public void setIv_def(int iv_def) {
		this.iv_def = iv_def;
	}

	public int getIv_spDef() {
		return iv_spDef;
	}

	public void setIv_spDef(int iv_spDef) {
		this.iv_spDef = iv_spDef;
	}

	public int getIv_spd() {
		return iv_spd;
	}

	public void setIv_spd(int iv_spd) {
		this.iv_spd = iv_spd;
	}


}
