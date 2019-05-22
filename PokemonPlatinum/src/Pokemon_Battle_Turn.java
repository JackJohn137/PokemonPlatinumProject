
public class Pokemon_Battle_Turn{
	private Pokemon you;
	private Pokemon opponent;
	private Pokemon_Move you_move;
	private Pokemon_Move opponent_move;
	
	public Pokemon_Battle_Turn(Pokemon you, Pokemon opponent, Pokemon_Move you_move, Pokemon_Move opponent_move)
	{
		this.you = you;
		this.opponent = opponent;
		this.you_move = you_move;
		this.opponent_move = opponent_move;
		battle();
	}

	private void battle() {
		
		if(this.you.getCurrent_stats().getSpd() > this.opponent.getCurrent_stats().getSpd())
		{
			this.opponent.getCurrent_stats().setHp(this.opponent.getCurrent_stats().getHp() - new Battle_Damage(this.you, this.opponent, this.you_move).getDamage_dealt());
			System.out.println("You dealt damage:" + new Battle_Damage(this.you, this.opponent, this.you_move).getDamage_dealt());
			if (this.opponent.getCurrent_stats().getHp() > 0)
			{
				this.you.getCurrent_stats().setHp(this.you.getCurrent_stats().getHp() - new Battle_Damage(this.opponent, this.you, this.opponent_move).getDamage_dealt());
				System.out.println("They dealt damage:" + new Battle_Damage(this.opponent, this.you, this.opponent_move).getDamage_dealt());
			}
		} 
		else
		{
			this.you.getCurrent_stats().setHp(this.you.getCurrent_stats().getHp() - new Battle_Damage(this.opponent, this.you, this.opponent_move).getDamage_dealt());
			System.out.println("They dealt damage:" + new Battle_Damage(this.opponent, this.you, this.opponent_move).getDamage_dealt());
			if (this.you.getCurrent_stats().getHp() > 0)
			{
				this.opponent.getCurrent_stats().setHp(this.opponent.getCurrent_stats().getHp() - new Battle_Damage(this.you, this.opponent, this.you_move).getDamage_dealt());
				System.out.println("You dealt damage:" + new Battle_Damage(this.you, this.opponent, this.you_move).getDamage_dealt());
			}
		}
	}
}
