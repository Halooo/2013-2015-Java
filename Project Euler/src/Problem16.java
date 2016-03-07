import java.math.BigInteger;
public class Problem16 {
	public static void main(String[] args) {
		String number = BigInteger.valueOf(2).pow(1000).toString();
		int sum = 0;
		
		for (int i = 0; i < number.length(); i++)
			sum += Integer.parseInt(String.valueOf(number.charAt(i)));
		System.out.print(sum);
	}
	
}

