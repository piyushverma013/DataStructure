import java.util.*;
public class ArrayRotateAntiClockWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Size of array: ");
		int n = obj.nextInt();  // array size
		
		System.out.println("Enter array elements: ");
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = obj.nextInt();     //array elements
		}
		
		System.out.println("Enter the number of rotation: ");
		int k = obj.nextInt();
		
		System.out.println("Array elements are: ");
		printArray(arr, n); //function to print the array
		System.out.println();
		rotateClockWise(arr, n, k); //function to rotate the array
		System.out.println("Rotated array: ");
		printArray(arr, n); //function to print the reverse array
	
	}
	
	static void rotateClockWise(int arr[], int n, int k) {   //function to perform k rotations
		
		k = k % n;
		
		reverse(arr, 0, k-1);                 
		reverse(arr, k, n-1);
		reverse(arr, 0, n-1);
	}
	
	static void reverse(int arr[], int start, int end) {
		
		while(start <= end) {
			int temp = arr[start];
			arr[start] = arr[end];              //utility function to rotate the array by reversing array
			arr[end] = temp;
			start++;
			end--;
			
		}
	}
	
	static void printArray(int arr[], int n) {    //function to print array elements
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}