
public class SummationOfPrimes {
	public static boolean ifPrime(long a) {
		for (long i = 2; i < a; i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		long sum = 0L;
		for (long i = 2L; i < 2000000; i++) {
			if (ifPrime(i)) {
				sum = sum + i;
			}
			
		}
		System.out.print(sum);
		
	}
}
