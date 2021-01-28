import java.util.*;
public class KthMin {
	public static void main (String[] args) {
		
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter size of the array: ");
		int n = obj.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements: ");
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = obj.nextInt();
		}
		    
		System.out.println("Enter kth element: ");
		int k = obj.nextInt();
	    System.out.println("Kth smallest is: ");
		System.out.println(kthSmallest(arr, k));
	}
	
	
	public static int kthSmallest(int[] arr, int k) 
	{ 
		
	    PriorityQueue<Integer> pro = new PriorityQueue<Integer>(Collections.reverseOrder());
	    
	    for(int i : arr) {
	        pro.add(i);
	        if(pro.size() > k) {
	            pro.poll();
	        }
	    }
	    return pro.poll();
	    
	}
}