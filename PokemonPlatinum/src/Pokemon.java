import java.awt.Image;
import java.util.ArrayList;

/**
 * @version 1.0
 * TODO: Moves and Abilities
 * @author ningwang
 *
 */
public class Pokemon{
	private boolean fainted;
	private final String name;
	private final int pokedex_number;
	private final Image front_image;
	private final Image back_image;
	private String nickname;
	private final String original_trainer;
	private boolean wild;
	private Growth_Rate growth_rate;
	private Pokemon_Level pokemon_level;
	private final Pokemon_Type type_1;
	private final Pokemon_Type type_2;
	private final Pokemon_Nature pokemon_nature;
	private Current_Stats current_stats;
	private Current_Stats max_current_stats;
	private final Base_Stats base_stats;
	private final Individual_Values iv;
	private Effort_Values ev;
	private final int exp_yield;
	private Growth_Rate growth_Rate;
	private Pokemon_Item held_item;
	private final Effort_Value_Drop ev_drop;

	private ArrayList<Pokemon_Move> moveSet;
	private ArrayList<Pokemon_Move> forgottenMoves;

	/**
	 * @param name
	 * @param pokedex_number
	 * @param front_image
	 * @param back_image
	 * @param nickname
	 * @param original_trainer
	 * @param wild
	 * @param pokemon_level
	 * @param type_1
	 * @param type_2
	 * @param pokemon_nature
	 * @param base_stats
	 * @param current_stats
	 * @param max_current_stats
	 * @param iv
	 * @param ev
	 * @param exp_yield
	 * @param held_item
	 * @param ev_drop_1
	 * @param ev_drop_2
	 */
	public Pokemon (String name, 
			int pokedex_number, 
			Image front_image, 
			Image back_image, 
			String nickname, 
			String original_trainer, 
			boolean wild, 
			Growth_Rate growth_rate,
			int level,
			Pokemon_Type type_1, 
			Pokemon_Type type_2, 
			Pokemon_Nature pokemon_nature, 
			Base_Stats base_stats,
			Individual_Values iv, 
			Effort_Values ev, 
			int exp_yield, 
			Pokemon_Item held_item, 
			Effort_Value_Drop ev_drop)
	{
		this.fainted = false;
		this.name = name;
		this.pokedex_number = pokedex_number;
		this.front_image = front_image;
		this.back_image = back_image;
		this.nickname = nickname;
		this.original_trainer = original_trainer;
		this.wild = wild;
		this.growth_rate = growth_rate;
		this.pokemon_level = new Pokemon_Level(growth_rate, level);
		this.type_1 = type_1;
		this.type_2 = type_2;
		this.pokemon_nature = pokemon_nature;
		this.base_stats = base_stats;
		this.iv = iv;
		this.ev = ev;
		this.current_stats = new Current_Stats (pokemon_level.getLevel(), 
				pokemon_nature, 
				base_stats.getBase_hp(), 
				base_stats.getBase_atk(), 
				base_stats.getBase_def(), 
				base_stats.getBase_spAtk(), 
				base_stats.getBase_spDef(), 
				base_stats.getBase_spd(),
				iv.getIv_hp(),
				iv.getIv_atk(),
				iv.getIv_def(),
				iv.getIv_spAtk(),
				iv.getIv_spDef(),
				iv.getIv_spd());
		this.max_current_stats = current_stats;
		this.exp_yield = exp_yield;
		this.held_item = held_item;
		this.ev_drop = ev_drop;
	}

	public Pokemon (Pokemon p, Individual_Values iv, Effort_Values ev)
	{
		this.fainted = false;
		this.name = p.getName();
		this.pokedex_number = p.getPokedex_number()	;
		this.front_image = p.getFront_image();
		this.back_image = p.getBack_image();
		this.nickname = p.getNickname();
		this.original_trainer = p.getOriginal_trainer();
		this.wild = p.isWild();
		this.growth_rate = p.getGrowth_Rate();
		this.pokemon_level = p.getPokemon_level();
		this.type_1 = p.getType_1();
		this.type_2 = p.getType_2();
		this.pokemon_nature = p.getPokemon_nature();
		this.base_stats = p.getBase_stats();
		this.current_stats = new Current_Stats (pokemon_level.getLevel(), 
				pokemon_nature, 
				base_stats.getBase_hp(), 
				base_stats.getBase_atk(), 
				base_stats.getBase_def(), 
				base_stats.getBase_spAtk(), 
				base_stats.getBase_spDef(), 
				base_stats.getBase_spd(),
				iv.getIv_hp(),
				iv.getIv_atk(),
				iv.getIv_def(),
				iv.getIv_spAtk(),
				iv.getIv_spDef(),
				iv.getIv_spd());
		this.max_current_stats = current_stats;
		this.iv = iv;
		this.ev = ev;
		this.exp_yield = p.getExp_yield();
		this.held_item = p.getHeld_item();
		this.ev_drop = p.getEv_Drop();
	}
	
	
	
	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getOriginal_trainer() {
		return original_trainer;
	}

	public int getPokedex_number() {
		return pokedex_number;
	}

	public Image getFront_image() {
		return front_image;
	}

	public Image getBack_image() {
		return back_image;
	}

	public Pokemon_Type getType_1() {
		return type_1;
	}

	public Pokemon_Type getType_2() {
		return type_2;
	}

	public Current_Stats getCurrent_stats() {
		return current_stats;
	}

	public void setCurrent_stats(Current_Stats current_stats) {
		this.current_stats = current_stats;
	}

	public Current_Stats getMax_current_stats() {
		return max_current_stats;
	}

	public void setMax_current_stats(Current_Stats max_current_stats) {
		this.max_current_stats = max_current_stats;
	}

	public Base_Stats getBase_stats() {
		return base_stats;
	}

	public Individual_Values getIv() {
		return iv;
	}

	public Effort_Values getEv() {
		return ev;
	}

	public void setEv(Effort_Values ev) {
		this.ev = ev;
	}

	public Pokemon_Nature getPokemon_nature() {
		return pokemon_nature;
	}

	public Pokemon_Level getPokemon_level() {
		return pokemon_level;
	}

	public void setPokemon_Level(Pokemon_Level pokemon_level) {
		this.pokemon_level = pokemon_level;
	}

	public boolean isWild() {
		return wild;
	}

	public void setWild(boolean wild) {
		this.wild = wild;
	}

	public int getExp_yield() {
		return exp_yield;
	}

	public Growth_Rate getGrowth_Rate() {
		return growth_Rate;
	}

	public void setGrowth_Rate(Growth_Rate growth_Rate) {
		this.growth_Rate = growth_Rate;
	}

	public Pokemon_Item getHeld_item() {
		return held_item;
	}

	public void setHeld_item(Pokemon_Item held_item) {
		this.held_item = held_item;
	}

	public Effort_Value_Drop getEv_Drop() {
		return ev_drop;
	}

	public boolean isFainted() {
		return fainted;
	}

	public void setFainted(boolean fainted) {
		this.fainted = fainted;
	}

	public void addMove(Pokemon_Move move)
	{
		this.moveSet.add(move);
	}

}
