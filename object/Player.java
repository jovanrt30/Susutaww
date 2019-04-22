package object;


public abstract class Player {
	protected String nama;
	protected int hp;
	
	protected Weapon basic;
	protected Weapon bomb;
	protected Weapon doubleAttack;
	protected Item bigHealing;
	protected Item heal;
	
	protected Weapon currWeapon;
	
	public Player() {
		basic = new BasicWeapon();
		bomb = new SpecialWeapon1();
		doubleAttack = new SpecialWeapon2();	
		bigHealing = new SpecialItem1();
		heal = new SpecialItem2();
		currWeapon = basic;
	}

	
	
	public abstract void getAttack(Weapon weapon);
	public abstract void getEffect(Item item);
//	public abstract Image getImage();

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setCurrWeapon(Weapon currWeapon) {
		this.currWeapon = currWeapon;
	}

	public Weapon getBasic() {
		return basic;
	}

	public void setBasic(Weapon basic) {
		this.basic = basic;
	}

	public Weapon getBomb() {
		return bomb;
	}

	public void setBomb(Weapon bomb) {
		this.bomb = bomb;
	}

	public Weapon getDoubleAttack() {
		return doubleAttack;
	}

	public void setDoubleAttack(Weapon doubleAttack) {
		this.doubleAttack = doubleAttack;
	}

	public Item getBigHealing() {
		return bigHealing;
	}

	public void setBigHealing(Item bigHealing) {
		this.bigHealing = bigHealing;
	}

	public Item getHeal() {
		return heal;
	}

	public void setHeal(Item heal) {
		this.heal = heal;
	}

	public Weapon getCurrWeapon() {
		return currWeapon;
	}
	
	
	
}
