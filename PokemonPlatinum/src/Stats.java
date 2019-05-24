import java.io.Serializable;

/**
 * @version 1.0
 * @author ningwang
 *
 */
public class Stats implements Serializable{
	private int hp;
	private int max_hp;
	private int atk;
	private int spAtk;
	private int def;
	private int spDef;
	private int spd;

	/**
	 * 
	 * @param level
	 * @param pokemon_nature
	 * @param base_hp
	 * @param base_atk
	 * @param base_def
	 * @param base_spAtk
	 * @param base_spDef
	 * @param base_spd
	 * @param iv_hp
	 * @param iv_atk
	 * @param iv_def
	 * @param iv_spAtk
	 * @param iv_spDef
	 * @param iv_spd
	 */
	public Stats (int level, 
			Pokemon_Nature pokemon_nature, 
			int base_hp, 
			int base_atk, 
			int base_def, 
			int base_spAtk, 
			int base_spDef, 
			int base_spd, 
			int iv_hp, 
			int iv_atk, 
			int iv_spAtk, 
			int iv_def, 
			int iv_spDef, 
			int iv_spd)
	{
		this.hp = (2 * base_hp + iv_hp) * level / 100 + level + 10;
		this.max_hp = this.hp;
		this.atk = (int) (((2 * base_atk + iv_atk ) * level / 100 + 5) * pokemon_nature.getNature().atk);
		this.def = (int) (((2 * base_def + iv_def) * level / 100 + 5) * pokemon_nature.getNature().def);
		this.spAtk = (int) (((2 * base_spAtk + iv_spAtk) * level / 100 + 5) * pokemon_nature.getNature().spAtk);
		this.spDef = (int) (((2 * base_spDef + iv_spDef) * level / 100 + 5) * pokemon_nature.getNature().spDef);
		this.spd = (int) (((2 * base_spd + iv_spd) * level / 100 + 5) * pokemon_nature.getNature().spd);
	}

	public Stats(Pokemon p)
	{
		this.hp = (2 * p.getBase_stats().getBase_hp() + p.getIv().getIv_hp() + p.getEv().getEv_hp() / 4) * p.getPokemon_level().getLevel() / 100 + p.getPokemon_level().getLevel() + 10;
		this.max_hp = this.hp;
		this.atk = (int) (((2 * p.getBase_stats().getBase_atk() + p.getIv().getIv_atk() + p.getEv().getEv_atk() / 4) * p.getPokemon_level().getLevel() / 100 + 5) * p.getPokemon_nature().getNature().atk);
		this.def = (int) (((2 * p.getBase_stats().getBase_def() + p.getIv().getIv_def() + p.getEv().getEv_def() / 4) * p.getPokemon_level().getLevel() / 100 + 5) * p.getPokemon_nature().getNature().def);
		this.spAtk = (int) (((2 * p.getBase_stats().getBase_spAtk() + p.getIv().getIv_spAtk() + p.getEv().getEv_spAtk() / 4) * p.getPokemon_level().getLevel() / 100 + 5) * p.getPokemon_nature().getNature().spAtk);
		this.spDef = (int) (((2 * p.getBase_stats().getBase_spDef() + p.getIv().getIv_spDef() + p.getEv().getEv_spDef() / 4) * p.getPokemon_level().getLevel() / 100 + 5) * p.getPokemon_nature().getNature().spDef);
		this.spd = (int) (((2 * p.getBase_stats().getBase_spd() + p.getIv().getIv_spd() + p.getEv().getEv_spd() / 4) * p.getPokemon_level().getLevel() / 100 + 5) * p.getPokemon_nature().getNature().spd);
	}

	@Override
	public String toString()
	{
		return "HP: " + hp + " ATK: " + atk + " DEF: " + def + " SPATK: " + spAtk + " SPDEF " + spDef + " SPD: " + spd;
	}

	public void update_current_stats(Pokemon p)
	{
		this.hp = (2 * p.getBase_stats().getBase_hp() + p.getIv().getIv_hp() + p.getEv().getEv_hp() / 4) * p.getPokemon_level().getLevel() / 100 + p.getPokemon_level().getLevel() + 10;
		this.max_hp = this.hp;
		this.atk = (int) (((2 * p.getBase_stats().getBase_atk() + p.getIv().getIv_atk() + p.getEv().getEv_atk() / 4) * p.getPokemon_level().getLevel() / 100 + 5) * p.getPokemon_nature().getNature().atk);
		this.def = (int) (((2 * p.getBase_stats().getBase_def() + p.getIv().getIv_def() + p.getEv().getEv_def() / 4) * p.getPokemon_level().getLevel() / 100 + 5) * p.getPokemon_nature().getNature().def);
		this.spAtk = (int) (((2 * p.getBase_stats().getBase_spAtk() + p.getIv().getIv_spAtk() + p.getEv().getEv_spAtk() / 4) * p.getPokemon_level().getLevel() / 100 + 5) * p.getPokemon_nature().getNature().spAtk);
		this.spDef = (int) (((2 * p.getBase_stats().getBase_spDef() + p.getIv().getIv_spDef() + p.getEv().getEv_spDef() / 4) * p.getPokemon_level().getLevel() / 100 + 5) * p.getPokemon_nature().getNature().spDef);
		this.spd = (int) (((2 * p.getBase_stats().getBase_spd() + p.getIv().getIv_spd() + p.getEv().getEv_spd() / 4) * p.getPokemon_level().getLevel() / 100 + 5) * p.getPokemon_nature().getNature().spd);
	}

	public int getHp() {
		return hp;
	}

	public int getAtk() {
		return atk;
	}

	public int getSpAtk() {
		return spAtk;
	}

	public int getDef() {
		return def;
	}

	public int getspDef() {
		return spDef;
	}

	public int getSpd() {
		return spd;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void setSpAtk(int spAtk) {
		this.spAtk = spAtk;
	}


	public void setDef(int def) {
		this.def = def;
	}

	public void setspDef(int spDef) {
		this.spDef = spDef;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int getMax_Hp() {
		return max_hp;
	}

	public void setMax_Hp(int max_hp) {
		this.max_hp = max_hp;
	}
}
