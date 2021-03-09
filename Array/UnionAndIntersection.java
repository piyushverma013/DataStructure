import java.util.*;
public class UnionAndIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter the number of elements in first array: ");
		int m = obj.nextInt();
		System.out.println("Enter first array elements: ");
		int arr1[] = new int[m];
		for(int i = 0; i < m; i++) {
			arr1[i] = obj.nextInt();	
		}
		
		System.out.println("Enter the number of elements in second array: ");
		int n = obj.nextInt();
		System.out.println("Enter second array elements: ");
		int arr2[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr2[i] = obj.nextInt();	
		}
		
		System.out.println("Union of two array is: ");
		findUnion(arr1, m, arr2, n);
		
		System.out.println();
		
		System.out.println("Intersection of two array is: ");
		findInterSection(arr1, m, arr2, n);
		
	}
	
	//finding union in two arrays
	static void findUnion(int arr1[], int n, int arr2[], int m) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = 0; i < n; i++ ) {
			hs.add(arr1[i]);
		}
		for(int i = 0; i < m; i++ ) {
			hs.add(arr2[i]);
		}
		
		for(int i : hs) {
			System.out.print(i+ " ");
		}
	}
	
	
	//finding intersection in two arrays
	static void findInterSection(int arr1[], int n, int arr2[], int m) {
		HashSet<Integer> hs = new HashSet<Integer>();
		HashSet<Integer> hs2 = new HashSet<Integer>();
		for(int i = 0; i < n; i++ ) {
			hs.add(arr1[i]);
		}
		for(int i = 0; i < m; i++ ) {
			if(hs.contains(arr2[i]))
				hs2.add(arr2[i]);
		}
		
		for(int i : hs2) {
			System.out.print(i+ " ");
		}
	}
}
