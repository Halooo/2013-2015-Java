package miskewblo3;
public abstract class Tester {

	public static void main(String[] args) {
		
		Player p1 = new Player("Tom", 100, 100);
		Barbarian b1 = new Barbarian("Peter", 100, 100, 100);
		Wizard w1 = new Wizard("Owen", 100, 100, 100);
		
	
		p1.attack();
		b1.attack();
		w1.attack();
		
	}

}
