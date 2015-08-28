
//	The first algorithm (Algorithm 1) is the most straightforward one,
//	i.e. to sort the list and then return the kth smallest element.
//	It takes O(n log n) amount time.  

public class Algorithm1 implements IAlgorithm{
	
	@Override
	public int getAlgorithm(){
		return 1;
	}
	
	@Override
	public int findKth(int k, int[] arr){
		int[] merged = mergeSort(arr);
		return merged[(int)k-1];
	}

	private int[] mergeSort(int[] input){
		
		if(input.length == 1){
			return input;
		}
		
		int middle = (int) Math.ceil((double)input.length / 2);
		int[] left = new int[middle];
		
		int rightLength = 0;
		if(input.length % 2 == 0){
			rightLength = middle;
		}
		else{
			rightLength = middle - 1;
		}
		int[] right = new int[rightLength];
		
		int leftIndex = 0; 
		int rightIndex = 0;
		
		for (int i = 0; i < input.length; i++) {
			if(i < middle){
				left[leftIndex] = input[i];
				leftIndex++;
			}
			else{
				right[rightIndex] = input[i];
				rightIndex++;
			}
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}
	
	private int[] merge(int[] left, int[] right){
		int[] result = new int[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		
		while(leftIndex < left.length || rightIndex < right.length){
			if(leftIndex < left.length && rightIndex < right.length){
				if(left[leftIndex] < right[rightIndex]){
					result[resultIndex] = left[leftIndex];
					leftIndex++;
					resultIndex++;
				}
				else{
					result[resultIndex] = right[rightIndex];
					rightIndex++;
					resultIndex++;
				}
			}
			else if(leftIndex < left.length){
				for (int i = resultIndex; i < result.length; i++) {
					result[i] = left[leftIndex];
					leftIndex++;
				}
			}
			else if(rightIndex < right.length){
				for (int i = resultIndex; i < result.length; i++) {
					result[i] = right[rightIndex];
					rightIndex++;
				}
			}
		}
		
		return result;
	}
}
