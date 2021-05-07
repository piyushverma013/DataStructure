import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	Node(int data) {
		this.data = data;
		}
}
public class BinaryTreeToSumTree {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree();
		System.out.println("Original tree is: ");
		printTree(root);
		System.out.println();
		sumTree(root);
		System.out.println("Sum tree is: ");
		printTree(root);
	}
	
	// function to create tree
	public static Node createTree() {
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
	
	// function to calculate sum tree
	public static void sumTree(Node root) {
		sumTreeUtil(root);
	}
	
	// Utility function to calculate sum tree
	public static int sumTreeUtil(Node root) {
		if(root == null)
			return 0;
		
		int left = sumTreeUtil(root.left);
		int right = sumTreeUtil(root.right);
		int val = root.data;
		root.data = left + right;
		return val + left + right;
	}
	
	// function to print tree
	public static void printTree(Node root) {
		if(root == null)
			return;
		printTree(root.left);
		System.out.print(root.data+" ");
		printTree(root.right);
	}
}