
public class Problem14 {
	public static void main(String[] args) {
		
		System.out.print(longestChain());
		
	}
	
	public static int collatz(long n, int ctr) {
		if (n == 1) {
			return ++ctr;
		}
		else if (n % 2 == 0) {
			return collatz(n/2, ++ctr);
		}
		else {
			return collatz(3*n+1, ++ctr);
		}
	}
	
	public static int longestChain() {
		int[] arr = new int[1000000];
		int result = 0;
		for (int i = 0; i < 1000000; i++) {
			arr[i] = collatz(i, 0);
		}
		for (int i = 0; i < 999999; i++) {
			if (arr[i] > arr[i+1]) {
				result = arr[i];
			}
			else {
				result = arr[i+1];
			}
		}
		return result;
	}
}















/*int ctr = 0;
int temp = 0, comp = 0;

for (int i = 13; i < 100; i++) {
	temp = i;
	if(temp == 1) {
		ctr++;
		if (ctr > comp) {
			comp = ctr;
		}
		i = 1000000;
	}
	
	if (temp % 2 == 0) {
		temp = temp/2;
		ctr++;
	}
	
	if (temp % 2 == 1) {
		temp = 3*temp + 1;
		ctr++;
	}
	
}
System.out.println(comp);
*/