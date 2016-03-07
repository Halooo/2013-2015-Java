
public class Largest_palindrome_product {
	public static void main(String[] args) {
        int a = 0;
        for(int i = 100;i <=999;i++)
        {
            for(int j = i;j <=999;j++)
            {
                int product = i * j;
                StringBuilder sb1 = new StringBuilder(""+product);
                String sb2 = ""+product;
                sb1.reverse();
                
                if(sb2.equals(sb1.toString()) && a<product) 
                    a = product;
            }
        }

        System.out.println(a);
	}
}
