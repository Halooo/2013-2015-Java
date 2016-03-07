public class Test {
	
	/*public static void main(String[] args) {
		int[] a = {4, 4, 1, 2, 3};
		post4(a);
	}
	public static int[] post4(int[] nums) {
		  int index4 = 0;
		  for (int i = 0; i < nums.length; i++) {
		    if (nums[i] == 4){
		      index4 = i;
		      System.out.println(index4);
		    }
		  } 
		  
		  int[] arr = new int[nums.length - 1 - index4];
		  int ctr = 0;
		  for (int i = index4+1; i < arr.length; i++) {
		    arr[ctr] = nums[index4+ctr];
		    ctr++;
		  }
		  return arr;
		}
		*/
	
	public static void main (String[] args) {
		doThis(3);
	}
	
	public static void doThis(int n) {
		if (n>0){
			doThis(n-1);
			System.out.print(n);
			doThis(n-1);
		}
	}

}
