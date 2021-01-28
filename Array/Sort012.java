import java.util.*;
public class Sort012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		sortArray012(arr, n);
		
		System.out.println("Sorted array is: ");
		printArray(arr, n);
	}
	
	
	// function to sort the array
	static void sortArray012(int arr[], int n)
	{
		int low = 0, mid = 0, high = n - 1;
		int temp;
		
		while(mid <= high)
		{
			if(arr[mid] == 0) 
			{
					temp = arr[low];
					arr[low] = arr[mid];
					arr[mid] = temp;
					low++;
					mid++;	
			}
			else if(arr[mid] == 1) 
			{
					mid++;
			}
			
			else
			{
				temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high--;
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
