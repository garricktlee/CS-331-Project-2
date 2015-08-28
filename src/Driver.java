
//	Write a program to implement the above algorithms for solving the Selection Problem and compare the times.
//	Select-kth 1 is to implement Algorithm 1 using the O(n log n) Mergesort sorting method.
//	Select-kth 2 will implement the Algorithm 2 using the partition procedure of Quicksort iteratively
//	and Select-kth 3 will implement the Algorithm 2 recursively.  Select-kth 4 is a recursive procedure to
//	implement the Algorithm 3 with mm rule.
//	Run your program for n = 10, 50, 100, 250, 500, 1000, … (with k = 1, n/4, n/2, 3n/4, and n).

import java.util.ArrayList;
import java.util.List;


public class Driver {

	public static void main(String[] args) {
		int n = 100000000;
		double startTime, endTime;
		
		//Generate test cases
		int[] testArray = generateNumbers(n);
		List<Integer> kList = createTestK(n);

		IAlgorithm a1 = new Algorithm1();
		IAlgorithm a2 = new Algorithm2();
		IAlgorithm a3 = new Algorithm3();
		
		
		runTest(a1, testArray, kList);
		runTest(a2, testArray, kList);
		runTest(a3, testArray, kList);

	}
	
	private static void runTest(IAlgorithm a, int[] testArray, List<Integer> kList){
		System.out.println("Algorithm " + a.getAlgorithm());
		
		for(int k: kList){
			double startTime = System.nanoTime();
			int kth = a.findKth(k,testArray);
			double endTime = System.nanoTime() - startTime;
			System.out.println(k + "kth element: " + kth);
			System.out.println("Total time: " + endTime/1000000000 + " seconds.");
		}
	}
	
	private static List<Integer> createTestK(int n){
		List<Integer> kList = new ArrayList<Integer>();
		kList.add(1);
		kList.add(n/4);
		kList.add(n/2);
		kList.add((3*n)/4);
		kList.add(n);
		
		return kList;
	}

	private static int[] generateNumbers(int size){
		int[] list = new int[size];
		
		for(int i = 0; i< size ; i++){
			list[i] = (int) Math.round((Math.random()*1000));
		}
		return list;
	}
	
	private static void PrintArray(int[] arr){
		System.out.print("[");
		for(int i = 0; i<arr.length-1;i++){
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[arr.length-1] + "]\n");
	}
}
