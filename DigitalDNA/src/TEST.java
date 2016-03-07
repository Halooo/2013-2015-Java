import java.util.ArrayList;
import java.util.Scanner;
public class TEST {
	private static Scanner sc;
	public static void main(String args[]) {
		//Arraylist only work with reference types 
		//You cannot make an Arraylist that contains primitive  
		sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (;;) {
			int input = sc.nextInt();
			arr.add(input);
			if (input == 0) break;
		}
		System.out.println(rmvEven(arr));
		
		/* .remove(int)
		 * Two thing s to highlight
		 * 1. it changes the indexs
		 * 2. Notice - remove returns an object <E>
		 * 
		 * adding a primitive type to an Arraylist is okay since the program will do the correct conversation 
		 * however, removing storing an ArrayList element can be "dangerous" when thingking about types
		 */
	}
	
	public static ArrayList<Integer> rmvEven(ArrayList<Integer> other) {
		for (int i = 0; i < other.size(); i++) 
			if (other.get(i)%2 == 0){
				other.remove(i);
				i--;
			}
		return other;
	}
}