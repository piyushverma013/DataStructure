import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class LargestSubTreeSum {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		int ans = findLargestSubtreeSum(root);
		System.out.println("Largest subtree sum is: "+ans);
	}

	// function to create tree
	static Node createTree() {
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		if(data == -1)
			return null;
		
		Node root = new Node(data);
		
		System.out.println("Enter left for: "+data);
		root.left = createTree();
		System.out.println("Enter right for: "+data);
		root.right = createTree();
		
		return root;	
	}
	
	//function to calculate largest subtree sum
	static int ans = 0;
	static int findLargestSubtreeSum(Node root) {
		if(root == null)
			return 0;
		findLargestSubtreeSumUtil(root);
		return ans;
	}
	
	//Utility function to calculate largest subtree sum
	static int findLargestSubtreeSumUtil(Node root) {
		if(root == null)
			return 0;
		int left = findLargestSubtreeSumUtil(root.left);
		int right = findLargestSubtreeSumUtil(root.right);
		int val = left + right + root.data;
		ans = Math.max(ans, val);
		return left + right + root.data;
	}
}