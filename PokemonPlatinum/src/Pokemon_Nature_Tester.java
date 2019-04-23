/**
 * @category: This is just to test if Pokemon_Nature functioned correctly
 * @author ningwang
 *
 */
public class Pokemon_Nature_Tester {

	public Pokemon_Nature_Tester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pokemon_Nature n = new Pokemon_Nature();
		System.out.println(n.getNature());
		System.out.println("Atk x" + n.getNature().atk);
		System.out.println("spAtk x" + n.getNature().spAtk);
		System.out.println("def x" + n.getNature().def);
		System.out.println("spDef x" + n.getNature().spDef);
		System.out.println("spd x" + n.getNature().spd);
	}

}
