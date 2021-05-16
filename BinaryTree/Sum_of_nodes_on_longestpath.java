import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}

public class Sum_of_nodes_on_longestpath {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree();
		System.out.println("Root node is: "+root.data);
		int ans = sumonLongestPath(root);
		System.out.println("Maximum sum of longest path: "+ans);
	}
	
	// function to create tree
	static Node createTree() {
		System.out.println("Enter data: ");
		int data = obj.nextInt();
		if(data == -1)
			return null;
		
		Node root = new Node(data);
		
		System.out.println("Enter left for: "+data);
		root.left = createTree();
		System.out.println("Enter right for: "+data);
		root.right = createTree();
		
		return root;
	}
	
	// function to calculate the sum on longest path
	static int max_sum = 0;
	static int max_len = 0;
	static int sumonLongestPath(Node root) {
		if(root == null)
			return 0;
		
		sumonLongestPathUtil(root, 0, 0);
		return max_sum;
	}
	
	// function to calculate the sum on longest path
	static void sumonLongestPathUtil(Node root, int sum, int len) {
		if(root == null) {
			if(max_len < len) {
				max_len = len;
				max_sum = sum;
			}
			else if(max_len == len && max_sum < sum) {
				max_sum = sum;
			}
			return;
		}
		
		sumonLongestPathUtil(root.left, sum+root.data, len+1);
		sumonLongestPathUtil(root.right, sum+root.data, len+1);
		
	}
}