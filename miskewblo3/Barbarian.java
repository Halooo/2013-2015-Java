package miskewblo3;

public class Barbarian extends Player{

	private int rage;
	
	
	public Barbarian(String name, int x, int h, int r) {
		super("Ha",0,100);
		rage = r;
		
	}
	
	public void attack() {
		System.out.println("BARBARIAN ATTACK");
	}
	
	public void increaseRage(int a) {
		rage = rage + 10;
	}
	
	public void prepareAttack() {
		
		if (rage > 0) {
			attack();
		}
		else {
			//how do I call attack in Player?
			super.attack();
			
		}
	}
	public void goBerserk(){
		if (rage == 100)
			_.pl("erserking");
		else _.pl("Not enough rage");
	}
	
	public void rest() {
		rage -= 1;
		setHp(getHp()+10);
	}

}
