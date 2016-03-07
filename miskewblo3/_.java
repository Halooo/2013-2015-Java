package miskewblo3;
import java.awt.Color;


public class _ {
	public static void pl(String s) {
		System.out.println(s);
	}
	public static void pt(String s) {
		System.out.print(s);
	}
	public static char[][] generateRGBBoard(int rows, int cols){
		char[][] arr = new char[rows][cols];
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				int rdmCl = (int) (Math.random() * 3);
				if (rdmCl == 0) 
					arr[r][c] = 'R';
				else if (rdmCl == 1)
					arr[r][c] = 'G';
				else if (rdmCl == 2)
					arr[r][c] = 'B';
			}
		}
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) 
				System.out.print(arr[r][c]);
			System.out.println("");
		}
		return arr;
		
	}
	
	public static void replace(char[][] b, char ch) {
		if (b == null) return;
		for (int r = 0; r < b.length; r++) 
			for (int c = 0; c < b[r].length; c++) 
				if (b[r][c] == ch) 
					b[r][c] = ' ';
	}
	
	public static void findConnect(char[][] b, int i, int j, char v) {
		if (b[i][j] != v) {
			b[i][j] = b[i][j];
		}
		else if (b[i][j] == v) {
			b[i][j] = ' ';
			for(int m = -1;m<=1;m++){  
                for(int n = -1;n<=1;n++){  
                    if((i+m)>=0 && (i+m)<b.length && (j+n)>=0 && (j+n)<b[m].length){  
                        findConnect(b,i+m,j+n,v);
                    }  
                }  
            }  
		}
	}
	
	public static int arrMax(int[][] a) {
		int large = 0;
		for (int r = 0; r < a.length; r++)
			for (int c = 0; c < a[r].length; c++)
				if(a[r][c] > large)
					large = a[r][c];
		return large;
	}
	
	public static int rowSum(int[][] a, int x) {
		int sum = 0;
		for (int r = 0; r < a.length; r++)
			for (int c = 0; c < a[r].length; c++)
				if (r == x)
					sum+= a[r][c];
						
		System.out.print(sum);
		return sum;
	}
	
	public int findLCol(int[][] image, int charWid) {
		int lrg = 0, col = 0;
		for (int i = 0; i < image[0].length - charWid; i++) {
			int sum = 0;
			for (int r = 0; r < image.length; r++)
				for (int c = 0; c < image[r].length; c++)
					sum += image[r][c];
			if (sum > lrg) {
				lrg = sum;
				col = i;
			}
		}
		return col;
	}
	
	public static void ClrDrop(char[][] board, int a, int b){
		
	}
	
	
	public static void main(String[] args) {
		int[][] arr = {{2,3,4},{1,2,3}};
		rowSum(arr, 0);
	}
}
