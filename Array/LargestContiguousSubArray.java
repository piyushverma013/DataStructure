import java.util.*;
public class LargestContiguousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter the size of the array: ");
		int n = obj.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter array elements: ");
		for(int i = 0; i < n; i++) {
			arr[i] = obj.nextInt();
		}
		
		System.out.println("Longest contiguous sub array is: ");
		int ans = maxSubArray(arr, n);
		System.out.println(ans);

	}
	
	//function to find maximum sub array (Kadane's Algorithm)
	static int maxSubArray(int arr[], int n) {
		
		int curr_max = arr[0];
		int max_so_far = arr[0];
		
		for(int i = 1; i < n; i++) {
			curr_max = Math.max(arr[i], curr_max+arr[i]);
			max_so_far = Math.max(curr_max, max_so_far);
		}
		
		return max_so_far;
	}

}
