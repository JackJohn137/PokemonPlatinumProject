import java.io.Serializable;

/**
 * @version This only has direct attacks
 * no special effects included; 
 * no fixed damage included;
 * Priority Moves are considered.
 * Multi-hitting moves are considered.
 * @author ningwang
 *
 */
public class Pokemon_Move implements Serializable{
	private String move_name;
	private Pokemon_Type move_type;
	private int pp;
	private int power;
	private boolean physical;
	private int num_hit;
	private int priority;
	
	public Pokemon_Move (String move_name, Pokemon_Type move_type, int pp, int power, boolean physical, int num_hit, int priority){
		this.move_name = move_name;
		this.move_type = move_type;
		this.pp = pp;
		this.power = power;
		this.physical = physical;
		this.num_hit = num_hit;
		this.priority = priority;
	}

	public String getMove_name() {
		return move_name;
	}

	public void setMove_name(String move_name) {
		this.move_name = move_name;
	}

	public Pokemon_Type getMove_type() {
		return move_type;
	}

	public void setMove_type(Pokemon_Type move_type) {
		this.move_type = move_type;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isPhysical() {
		return physical;
	}

	public void setPhysical(boolean physical) {
		this.physical = physical;
	}

	public int getNum_hit() {
		return num_hit;
	}

	public void setNum_hit(int num_hit) {
		this.num_hit = num_hit;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public boolean getIsPhysical()
	{
		return this.physical;
	}
}
