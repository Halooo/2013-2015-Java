
public class PrimeFactor {
	public static void main(String[] args) {
		
		long a = 600851475143L;
		int i = 2;
		for (; i < a; i++) {
			if (a % i == 0){
				a = a/i;
				i--;
			}
		}
		System.out.print(i);
		
	}
	
}
