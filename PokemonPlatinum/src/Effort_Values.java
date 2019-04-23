/**
 * @version 1.0
 * @author ningwang
 *
 */
public class Effort_Values {
	private int ev_hp;
	private int ev_atk;
	private int ev_spAtk;
	private int ev_def;
	private int ev_spDef;
	private int ev_spd;
	
	/**
	 * 
	 * @param ev_hp = Stat used for pokemon's bonus trained hp
	 * @param ev_atk = Stat used for pokemon's bonus trained atk
	 * @param ev_spAtk = Stat used for pokemon's bonus trained spAtk
	 * @param ev_def = Stat used for pokemon's bonus trained def
	 * @param ev_spDef = Stat used for pokemon's bonus trained spDef
	 * @param ev_spd = Stat used for pokemon's bonus trained spd
	 */
	public Effort_Values(int ev_hp, int ev_atk, int ev_spAtk, int ev_def, int ev_spDef, int ev_spd)
	{
		this.ev_hp = ev_hp;
		this.ev_atk = ev_atk;
		this.ev_spAtk = ev_spAtk;
		this.ev_def = ev_def;
		this.ev_spDef = ev_spDef;
		this.ev_spd = ev_spd;
	}
	
	public void addEffort_Value_Drop(Effort_Value_Drop ev)
	{
		switch (ev.getStat1())
		{
			case HP:
				this.addEv_hp(ev.getQuantity1());
				break;
				
			case ATK:
				this.addEv_atk(ev.getQuantity1());
				break;
				
			case SPATK:
				this.addEv_spAtk(ev.getQuantity1());
				break;
				
			case DEF:
				this.addEv_def(ev.getQuantity1());
				break;
				
			case SPDEF:
				this.addEv_spDef(ev.getQuantity1());
				break;
				
			case SPD:
				this.addEv_spd(ev.getQuantity1());
				break;
				
			default:
				System.out.println("ERROR: Add_Effort_Value_Drop_1");
				break;
		}
		
		switch (ev.getStat2())
		{
			case HP:
				this.addEv_hp(ev.getQuantity2());
				break;
				
			case ATK:
				this.addEv_atk(ev.getQuantity2());
				break;
				
			case SPATK:
				this.addEv_spAtk(ev.getQuantity2());
				break;
				
			case DEF:
				this.addEv_def(ev.getQuantity2());
				break;
				
			case SPDEF:
				this.addEv_spDef(ev.getQuantity2());
				break;
				
			case SPD:
				this.addEv_spd(ev.getQuantity2());
				break;
				
			default:
				System.out.println("ERROR: Add_Effort_Value_Drop_2");
				break;
		}
	}
	
	public int getEv_hp() {
		return ev_hp;
	}

	public int getEv_atk() {
		return ev_atk;
	}
	
	public int getEv_spAtk() {
		return ev_spAtk;
	}
	
	public int getEv_def() {
		return ev_def;
	}
	
	public int getEv_spDef() {
		return ev_spDef;
	}
	
	public int getEv_spd() {
		return ev_spd;
	}
	
	public void setEv_hp(int ev_hp) {
		this.ev_hp = ev_hp;
	}
	
	public void setEv_atk(int ev_atk) {
		this.ev_atk = ev_atk;
	}

	public void setEv_spAtk(int ev_spAtk) {
		this.ev_spAtk = ev_spAtk;
	}

	public void setEv_def(int ev_def) {
		this.ev_def = ev_def;
	}

	public void setEv_spDef(int ev_spDef) {
		this.ev_spDef = ev_spDef;
	}

	public void setEv_spd(int ev_spd) {
		this.ev_spd = ev_spd;
	}
	
	public void addEv_hp(int ev)
	{
		this.ev_hp += ev;
	}
	
	public void addEv_atk(int ev)
	{
		this.ev_atk += ev;
	}
	
	public void addEv_spAtk(int ev)
	{
		this.ev_spAtk += ev;
	}
	
	public void addEv_def(int ev)
	{
		this.ev_def += ev;
	}
	
	public void addEv_spDef(int ev)
	{
		this.ev_spDef += ev;
	}
	
	public void addEv_spd(int ev)
	{
		this.ev_spd += ev;
	}
}
