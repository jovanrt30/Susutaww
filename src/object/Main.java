package object;

public class Main {

	public Main() {
		//ini simulasi player 1 alias si mage
		Player p1 = new Player1();
		System.out.println(p1.getNama());
		System.out.println("HP AWAL: "+p1.getHp());
		p1.getAttack(p1.currWeapon);
		System.out.println("HP SETELAH KENA BASIC ATTACK: "+p1.getHp());
//		p1.getAttackSW1();
		System.out.println("HP SETELAH KENA BOMB: "+p1.getHp());
//		p1.getAttackSW2();
		System.out.println("HP SETELAH KENA DOUBLE DAMAGE: "+p1.getHp());
//		p1.getEffectSI1();
		System.out.println("HP SETELAH PAKE ITEM 1: "+ p1.getHp());
//		p1.getEffectSI2();
		System.out.println("HP SETELAH PAKE ITEM 2: "+ p1.getHp());
		
		//ini simulasi player 2 alias si archer
		Player p2 = new Player2();
		System.out.println(p2.getNama());
		System.out.println("HP AWAL: "+p2.getHp());
//		p2.getAttack();
		System.out.println("HP SETELAH KENA BASIC ATTACK 2x: "+p2.getHp());
//		p2.getAttackSW1();
		System.out.println("HP SETELAH KENA BOMB: "+p2.getHp());
//		p2.getAttackSW2();
		System.out.println("HP SETELAH KENA DOUBLE DAMAGE: "+p2.getHp());
//		p2.getEffectSI1();
		System.out.println("HP SETELAH PAKE ITEM 1: "+ p2.getHp());
//		p2.getEffectSI2();
		System.out.println("HP SETELAH PAKE ITEM 2: "+ p2.getHp());
		
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
