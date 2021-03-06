import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @version 1.0
 * TODO: Moves and Abilities
 * @author ningwang
 *
 */
public class Pokemon implements Serializable{
	private boolean fainted;
	private final String name;
	private final int pokedex_number;
	private transient Image front_image;
	private transient Image back_image;
	private String nickname;
	private final String original_trainer;
	private boolean wild;
	private Growth_Rate growth_rate;
	private Pokemon_Level pokemon_level;
	private final Pokemon_Type type_1;
	private final Pokemon_Type type_2;
	private final Pokemon_Nature pokemon_nature;
	private Stats stats;
	private final Base_Stats base_stats;
	private final Individual_Values iv;
	private Effort_Values ev;
	private final int exp_yield;
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
		this.stats = new Stats (pokemon_level.getLevel(), 
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
		this.exp_yield = exp_yield;
		this.held_item = held_item;
		this.ev_drop = ev_drop;
		this.moveSet = new ArrayList<>();
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
		this.growth_rate = p.getGrowth_rate();
		this.pokemon_level = p.getPokemon_level();
		this.type_1 = p.getType_1();
		this.type_2 = p.getType_2();
		this.pokemon_nature = p.getPokemon_nature();
		this.base_stats = p.getBase_stats();
		this.stats = new Stats (pokemon_level.getLevel(), 
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
		this.iv = iv;
		this.ev = ev;
		this.exp_yield = p.getExp_yield();
		this.held_item = p.getHeld_item();
		this.ev_drop = p.getEv_Drop();
		this.moveSet = new ArrayList<>();
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

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
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
		this.stats = new Stats (pokemon_level.getLevel(), 
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

	public Growth_Rate getGrowth_rate() {
		return growth_rate;
	}

	public void setGrowth_rate(Growth_Rate growth_Rate) {
		this.growth_rate = growth_Rate;
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


		if(this.moveSet.size()==5) {
			this.deleteMovePrompt(move);

		}
	}

	private void deleteMovePrompt(Pokemon_Move move) {
		Pokemon_Move[] moves= new Pokemon_Move[5];
		for(int i=0;i<5;i++) {
			moves[i]=this.moveSet.get(i);
		}
		if(JOptionPane.showConfirmDialog(null,this.name+" has learned the maximum number of moves, forget a move to learn"+ move.getMove_name()+"?")==JOptionPane.YES_OPTION) {
			Pokemon_Move deleted =(Pokemon_Move) JOptionPane.showInputDialog(null,"which move will be forgotten", "delete move?", JOptionPane.PLAIN_MESSAGE,null, moves,moves[0]);
			if(deleted.equals(move)) {
				this.giveUP(move);
			}
			else{
				
			if(JOptionPane.showConfirmDialog(null, "are you sure?"+deleted.getMove_name()+"will be deleted")==JOptionPane.YES_OPTION) {
				if(deleted.equals(move)) {
					this.deleteMovePrompt(move);
				}
				else {
					this.moveSet.remove(move);
				}
			}
			}
			}
		else {
			this.giveUP(move);
  		}
   	}

   	private void giveUP(Pokemon_Move move) {
		if(JOptionPane.showConfirmDialog(null,"then give up on learning " +move.getMove_name()+"?")==JOptionPane.YES_OPTION) {
			moveSet.remove(move);
		}
		else {
			this.deleteMovePrompt(move);
      }
		
	}

	public ArrayList<Pokemon_Move> getMoveset()
	{
		return this.moveSet;
	}
	
	public void setFront_image(Image image)
	{
		this.front_image = image;
	}
	
	public void setBack_image(Image image)
	{
		this.back_image = image;
	}
}
