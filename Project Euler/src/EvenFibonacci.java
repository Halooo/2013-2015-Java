
public class EvenFibonacci {
	/*
	public static void main(String[] args) {
		
		int sum = 0; 
		
		for (int i = 1; i < 4000000; i += i) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.print(sum);
		
	}
	*/
	
	
	/*
	public static void main(String[] args) {
	    int f=0,sum=0,s=1;
	    for(int i = 0; i < 4000000; i = f+s){
	        f = s;
	        s = i;
	        if(i % 2 == 0)
	        	sum += i;
	    }
	    System.out.println(sum);
	}*/
	
	public static void main(String[] args) {
		
		int a = 1, b = 2, sum = 0;
		
		while (a < 4000000) {
			
			int large = Math.min(a, b);
			large += Math.max(a, b);
			if (a % 2 == 0)
				sum += large;
			
		}
		
		System.out.print(sum);
		
	}
	
	
}
	
