
public class Problem12 {
	
	// 1. for loop generate the number
	// 2. for loop find the number of divisors 
	// 3. if # of divisors is greater than 500, return number
	/*
	public static void main(String[] args) {
		
		for (long i = 1;; i++) {
			if (getDivisorNumber(i) == 501)
				System.out.println(i);		
		}
		
	}
	
	public static int getDivisorNumber(long a) {
		int ctr = 0;
		
		for (long i = 1; i <= a; i++) {
			if (a%i == 0) {
				ctr++;
			}
		}
	return ctr;	
	}
}*/
	
	 public static boolean divNumber(int n){
	        int counter=0;
	        int sum=0;
	        int end =(int) Math.sqrt(n);
	        end++;//because looping to i<end is faster than looping to i<=end
	        for(int i = 1 ; i < end; i++){
	            if(n%i==0){
	                counter+=2;
	                sum+=i;
	            }
	        }
	       
	        if(counter>500){
	            System.out.println("the result is: "+n);
	            return false;
	        }

	        else
	            return true;
	    }
	    public static void main(String[] args){
	    	int val=0;
	    	int inc =0;
	    	boolean iterrate=true;
	    	while(iterrate){
	    		val+=inc;
	    		iterrate=divNumber(val);
	    		inc++;

	       }

	}
}
