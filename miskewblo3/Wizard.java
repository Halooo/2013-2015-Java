package miskewblo3;
public class Wizard extends Player{

	private int mana; //this is major stores	
	public Wizard(String name, int x, int h, int m) {
		super(name,x,h);
		mana = m;
	}
	
	public void attack() {
		_.pl("WIZARD ATTACK");
	}
	
	public void increaseMana(int a) {
		mana = mana + 10;
	}
	public void prepareAttack() {
		
		if (mana > 0) {
			attack();
			mana = mana - (int)(Math.random()*50);
		}
		else {
			//how do I call attack in Player?
			super.attack();
		}
	}
	
	public void rest() {
		mana += 1;
	}
	
}
