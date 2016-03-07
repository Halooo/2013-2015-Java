
public class SumSquareDifference {
	public static void main(String[] args) {
		long sumSq = 0, temp = 0, result = 0;
		for (int i = 1; i <= 100; i++) {
			sumSq += i*i;
		}
		System.out.println(sumSq);
		
		for (int i = 1; i <= 100; i++) {
			temp += i;
		}
		temp = temp * temp;
		System.out.println(temp);
		
		result = temp - sumSq;
		System.out.print("result:" +result);
		
	}
	
	
}
