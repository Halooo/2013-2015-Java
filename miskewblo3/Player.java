package miskewblo3;

public class Player {
	
	private String name; 
	private int xp; 
	private int hp;	
	
	public Player(String s, int x, int h) {
		
		name = s;
		xp = x;
		hp = h;
		
	}
	public void attack() {
	
		_.pl("PLAYER ATTACK");
	
		if (this instanceof Wizard) {
			((Wizard)(this)).increaseMana(10);
		}
		if (this instanceof Barbarian) {
			((Barbarian)(this)).increaseRage(10);
		
		}
	}
	
	public void setHp(int a) {
		hp = a;
	}
	public int getHp() {
		return hp;
	}
}
