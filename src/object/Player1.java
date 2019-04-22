package object;

public class Player1 extends Player{

	public Player1() {
		super();
		setNama("Mage");
		setHp(100);
	}

	@Override
	public void getAttack(Weapon weapon) {
		int damage = weapon.getDamage();
		this.setHp(getHp() - damage);
	}

	@Override
	public void getEffect(Item item) {
		int effect = item.getEffect();
		this.setHp(getHp() + effect);
	}


}
