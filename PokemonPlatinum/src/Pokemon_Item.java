/**
 * @version 1.0 
 * TODO Needs to make all the actual items, currently don't have many
 * @author ningwang
 *
 */
public class Pokemon_Item {
	private final Item_Name item_name;
	private final Item_Pocket item_pocket;
	private final Item_Type item_type;
	private final boolean held_item;
	private final boolean consumable;
	
	public enum Item_Name
	{
		NONE, LUCKY_EGG;
	}
	
	public enum Item_Pocket
	{
		NONE, KEY_ITEM, POKEBALL, ITEMS, BATTLE_ITEMS, MEDICINE;
	}
	
	public enum Item_Type
	{
		NONE, REPEL, BERRY, TM_HM;
	}
	/**
	 * 
	 * @param item
	 * @param key_item
	 * @param held_item
	 * @param consumable
	 * @param tm_hm
	 * @param repel
	 * @param berry
	 */
	public Pokemon_Item(Item_Name item_name, Item_Pocket item_pocket, Item_Type item_type, boolean held_item, boolean consumable)
	{
		this.item_name = item_name;
		this.item_pocket  = item_pocket;
		this.item_type = item_type;
		this.held_item = held_item;
		this.consumable = consumable;
	}
	
	public Item_Name getItem_name() {
		return item_name;
	}
	
	public Item_Pocket getItem_pocket() {
		return item_pocket;
	}
	
	public Item_Type getItem_type() {
		return item_type;
	}
	
	public boolean isHeld_item() {
		return held_item;
	}
	
	public boolean isConsumable() {
		return consumable;
	}
}
