import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * @Version working on
 * @author ningwang
 *
 */
public class Player extends Pokemon_Trainer implements Serializable{
	private boolean can_move;
	private ArrayList<Badge> badge_case;
	private String nickname;
	private int money;
	public Player(String name, String type, Direction direction) throws IOException{
		super(name, type, direction, 0, 0);
		this.can_move = true;
		this.badge_case = new ArrayList<Badge>();
		this.money = 0;
		this.nickname = "";
	}
	
	public boolean isCan_move() {
		return can_move;
	}
	public void setCan_move(boolean can_move) {
		this.can_move = can_move;
	}
} 
