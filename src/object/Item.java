package object;

public abstract class Item {
	protected String name;
	protected int effect;
	protected boolean isValid;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String name, int effect, Boolean isValid) {
		super();
		this.name = name;
		this.effect = effect;
		this.isValid = isValid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

}
