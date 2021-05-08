import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	Node(int data) {
		this.data = data;
		}
}
public class ValidityOfSumTree {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree();
		System.out.println("The tree is: ");
		printTree(root);
		System.out.println();
		boolean ans = isSumTree(root);
		if(ans)
			System.out.println("The given tree is a sum tree");
		else
			System.out.println("The given tree is not a sum tree");
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
	
	// function to check if binary tree is sum tree
	static int ans = 1;
	static boolean isSumTree(Node root)
	{
             // Your code here
             if(root == null)
               return true;
               
             isSumTreeUtil(root);
             if(ans == 1)
               return true;
             return false;
	}
	
	// Utility function to check if binary tree is sum tree
	static int isSumTreeUtil(Node root) {
	    if(root == null)
	      return 0;
	    if(root.left == null && root.right == null)
	      return root.data;
	    if(ans == 0)
	    	return 0;
	    int left = isSumTreeUtil(root.left);
	    int right = isSumTreeUtil(root.right);
	      
	    if(root.data != left + right)
	    	ans = 0;
	    return root.data + left + right;
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