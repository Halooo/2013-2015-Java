
public class the10001stPrime {
	
	public static void main(String[] args) {
		
		int result = 0, ctr = 0;
		
		for (int i = 1;; i++) {
			if (ifPrime(i))
				ctr ++;
			if (ctr == 10002) {
				System.out.print(i);
				System.exit(0);
			}
		}
		
	}
	
	public static boolean ifPrime(int a) {
		for (int i = 2; i < a; i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}

}