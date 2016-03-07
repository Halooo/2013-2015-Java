
public class BigONotation {
	
	private int[] arr;
	private int arraySize;
	private int elements = 0; 
	static long startT;
	static long endT;
	
	public static void main(String[] args) {
		
		//***********************************Test********************************//
		
		// O(N)
		BigONotation testLinear1 = new BigONotation(1000000);
		testLinear1.genRdmArr();
		
		BigONotation testLinear2 = new BigONotation(2000000);
		testLinear2.genRdmArr();
		
		BigONotation testLinear3 = new BigONotation(3000000);
		testLinear3.genRdmArr();
		
		testLinear1.linearSearch(20);
		testLinear2.linearSearch(20);
		testLinear3.linearSearch(20);
		
		// Test bubblesort O(N^2)
		BigONotation testBubble1 = new BigONotation(10000);
		testBubble1.genRdmArr();
		
		BigONotation testBubble2 = new BigONotation(20000);
		testBubble2.genRdmArr();
		
		BigONotation testBubble3 = new BigONotation(30000);
		testBubble3.genRdmArr();
		
		testBubble1.bubbleSort();
		testBubble2.bubbleSort();
		testBubble3.bubbleSort();
		
		BigONotation testBiSearch1 = new BigONotation(10000000);
		BigONotation testBiSearch2 = new BigONotation(20000000);
		
		//test Binary Search 
		testBubble3.binarySearch(20);
		testBiSearch1.binarySearch(20);
		testBiSearch2.binarySearch(20);
		
		
		//Test Quick Sort
		//case 1 (with 1000000 elements)
		BigONotation testQSort1 = new BigONotation(1000000);
		testQSort1.genRdmArr();
		
		BigONotation testQSort2 = new BigONotation(2000000);
		testQSort2.genRdmArr();
		
		BigONotation testQSort3 = new BigONotation(3000000);
		testQSort3.genRdmArr();
		
		startT = System.currentTimeMillis();
		
		testQSort1.quickSort(0, testLinear1.elements);
		
		endT = System.currentTimeMillis();
		System.out.println("Time spent (Quick Sort): "+ (endT-startT)+ "\n");
		
		//case 2 (with 2000000elements)
		startT = System.currentTimeMillis();
		
		testQSort2.quickSort(0, testLinear1.elements);
		
		endT = System.currentTimeMillis();
		System.out.println("Time spent (Quick Sort): "+ (endT-startT)+ "\n");
		
		//case 3 (with 3000000 elements)
		startT = System.currentTimeMillis();
		
		testQSort3.quickSort(0, testLinear1.elements);
		
		endT = System.currentTimeMillis();
		System.out.println("Time spent (Quick Sort): "+ (endT-startT)+ "\n");
		
		
		//*******************************Test End******************************//
	}
	 
	// O(1)
	public void addElementsInArray(int newElemt) {
		
		arr[elements++] = newElemt;
		
	}
	
	// O(N)
	public void linearSearch(int spam) {
		boolean found = false;
		String position = "";
		
		startT = System.currentTimeMillis();
		
		for (int i = 0; i < arraySize; i++) {
			if (arr[i] == spam) {
				found = true;
				position += i + " ";
			}
		}
		
		System.out.println("Value found: " + found);
		endT = System.currentTimeMillis();
		System.out.println("Time spent (Linear Search): "+ (endT-startT)+ "\n");
		
	}
	
	// O(N^2)
	public void bubbleSort(){
		startT = System.currentTimeMillis();
		for (int i = arraySize - 1; i > 1; i--) {
			
			for (int j = 0; j < i; j++) {
				
				if (arr[j] > arr[j+1]) {
					
					swapValues(j, j+1);
					
				}
			}
			
		}
		
		endT = System.currentTimeMillis();
		System.out.println("Time spent (Bubble Sort): "+ (endT-startT) + "\n");
	}
	
	// O(log N)
	
	public void binarySearch(int spam) {
		
		startT = System.currentTimeMillis();
		
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		int timesThrough = 0;
		
		while (lowIndex <= highIndex) {
			
			int middleIndex = (highIndex + lowIndex) / 2;
			
			if (arr[middleIndex] < spam) 
				lowIndex = middleIndex + 1;
			
			
			else if (arr[middleIndex] > spam) 
				highIndex = middleIndex - 1;
			
			else {
				
				System.out.println("Found index: " + middleIndex);
				lowIndex = highIndex + 1;
				
			}
			
			timesThrough++;
			
		}
		
		endT = System.currentTimeMillis();
		System.out.println("Time spent (Binary Search): "+ (endT-startT));
		System.out.println("Times through: " + timesThrough + "\n");//super efficient!
		
	}
	
	// O(n log N)
	
	public void quickSort(int left, int right) {
		if (right - left <= 0)
			return; // already sorted 
		else {
			int pivot = arr[right];
			int pivotLoc = partitationArr(left, right, pivot);
			quickSort(left, pivotLoc - 1);
			quickSort(pivotLoc + 1, right);
			
		}
	}
	
	public int partitationArr(int left, int right, int pivot) {
		int leftPointer = left - 1; 
		int rightPointer = right;
		
		while (true) { // infinite loop to sort till array is sorted
			
			while (arr[++leftPointer] < pivot)
				;
			while (rightPointer > 0 && arr[--rightPointer] > pivot)
				;
				
			if (leftPointer >= rightPointer) {
				break; // sorted, exit infinite loop
			}
			
			else {
				swapValues(leftPointer, rightPointer);
			}
		}
		swapValues(leftPointer, right);
		return leftPointer;
	}
	
	BigONotation(int len) {
		arraySize = len;
		arr = new int[len];
	}
	
	public void genRdmArr() {
		
		for (int i = 0; i < arraySize; i++) 
			arr[i] = (int)(Math.random()*1000) + 10;
		
		elements = arraySize-1;
		
	}
	
	public void swapValues(int indexOne, int indexTwo) {
		int spam = arr[indexOne];
		arr[indexOne] = arr[indexTwo];
		arr[indexTwo] = spam;
	}
		
	public void genSortedArr() {
		for (int i = 1; i < arraySize;i++)
			arr[i] = i;
		elements = arraySize-1;
	}
}
