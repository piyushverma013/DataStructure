import java.util.*;
public class MaximumAndMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the number of elements in an array: ");
		int n = obj.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements: ");
		for(int i = 0; i < n; i++) {
			arr[i] = obj.nextInt();
		}
		System.out.println("Maximum and Minimum elements are: ");
		int ans1[] = max_min(arr, n);
		for(int i = ans1.length-1; i >= 0 ; i--)
		{
			System.out.println(ans1[i]);
		}
	}
	
	// function to find maximum and minimum in an array 
	static int[] max_min(int arr[], int n) {
		int ans[] = new int[2];
		
		if(n == 0)
			return ans;
		
		if(n == 1) {
			ans[0] = arr[0];
			ans[1] = arr[0];
			return ans;
		}
		
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++)
		{
			if(arr[i] < max)
			max = arr[i];
			
			else if(arr[i] > min)
			min = arr[i];
		}
		   ans[0] = max;
		   ans[1] = min;
		return ans;
	}

}
