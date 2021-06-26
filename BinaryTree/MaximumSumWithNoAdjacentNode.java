import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class MaximumSumWithNoAdjacentNode {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		int ans = maximum(root);
		System.out.println("Maximum sum is: "+ans);
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
	
	// function to find maximum sum of nodes in binary tree with no two adjacent nodes
	static int maximum(Node root) {
		if(root == null)
			return 0;
		
		HashMap<Node, Integer> hm = new HashMap<Node, Integer>();
		int res = maxUtil(root, hm);
		
		return res;
	}
	
	// utility function to find maximum sum of nodes in binary tree with no two adjacent nodes
	static int maxUtil(Node root, HashMap<Node, Integer> hm) {
		
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.data;
		if(hm.containsKey(root))
			return hm.get(root);
		
		int left = 0;
		int right = 0;
		
		if(root.left != null) {
			left = maxUtil(root.left.left, hm) + maxUtil(root.left.right, hm);
		}
		
		if(root.right != null) {
			right = maxUtil(root.right.left, hm) + maxUtil(root.right.right, hm);
		}
		
		int incl = left + right + root.data;
		int excl = maxUtil(root.left, hm) + maxUtil(root.right, hm);
		
		hm.put(root, Math.max(incl, excl));
		
		return Math.max(incl, excl);	
	}
}