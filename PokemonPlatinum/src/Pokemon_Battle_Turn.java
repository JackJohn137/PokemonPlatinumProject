
public class Pokemon_Battle_Turn{
	private Player you;
	private Pokemon_Trainer opponent;
	private Pokemon you_field;
	private Pokemon opponent_field;
	private Pokemon_Move you_move;
	private Pokemon_Move opponent_move;
	public Pokemon_Battle_Turn(Player you, Pokemon_Trainer opponent, Pokemon_Move you_move, Pokemon_Move opponent_move)
	{
		this.you = you;
		this.opponent = opponent;
		this.you_field = you.getPokemon_storage().getPokemon(0);
		this.opponent_field =  opponent.getPokemon_storage().getPokemon(0);
		this.you_move = you_move;
		this.opponent_move = opponent_move;
		battle();
	}

	private void battle() {
		
		if(this.you_field.getCurrent_stats().getSpd() > this.opponent_field.getCurrent_stats().getSpd())
		{
			this.opponent_field.getCurrent_stats().setHp(this.opponent_field.getCurrent_stats().getHp() - new Battle_Damage(this.you_field, this.opponent_field, this.you_move).getDamage_dealt());
			if (this.opponent_field.getCurrent_stats().getHp() > 0)
			{
				this.you_field.getCurrent_stats().setHp(this.you_field.getCurrent_stats().getHp() - new Battle_Damage(this.opponent_field, this.you_field, this.opponent_move).getDamage_dealt());
			}
		}
		else
		{
			this.you_field.getCurrent_stats().setHp(this.you_field.getCurrent_stats().getHp() - new Battle_Damage(this.opponent_field, this.you_field, this.opponent_move).getDamage_dealt());
			if (this.you_field.getCurrent_stats().getHp() > 0)
			{
				this.opponent_field.getCurrent_stats().setHp(this.opponent_field.getCurrent_stats().getHp() - new Battle_Damage(this.you_field, this.opponent_field, this.you_move).getDamage_dealt());
			}
		}
	}
}
