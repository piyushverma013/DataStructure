import java.util.*;
public class MoveNegativeToBegining {
	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter size of the array: ");
		int n = obj.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements: ");
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = obj.nextInt();
		}
		
		System.out.println("Array elements are: ");
		printArray(arr, n);
		
		System.out.println();
		moveNegative(arr, n);
		
		System.out.println("Final array is: ");
		printArray(arr, n);
	}
	
	// function to move all negative elements to the left
	static void moveNegative(int arr[], int n)
	{
		int j = 0, temp;
		
		for(int i = 0; i < n; i++) {
			if(arr[i] < 0) {
				if(i != j) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
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