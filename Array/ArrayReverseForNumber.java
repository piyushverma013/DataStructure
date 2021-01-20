import java.util.*;
public class ArrayReverseForNumber {
static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("Enter size of the array: ");
		int n = obj.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements: ");
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = obj.nextInt();
		}
		
		reverseArray(arr, n);
		
		System.out.println("Reverse array is: ");
		printArray(arr, n);
	}
	
	// function to reverse the array
	static void reverseArray(int arr[], int n)
	{
		int start = 0, end = n - 1;
		int temp;
		while(start < end)
		{
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	// function to print the array
	static void printArray(int arr[], int n)
	{
		for(int i = 0; i < n; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

}
