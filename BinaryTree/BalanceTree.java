/* A tree is said to be balanced if the difference between left and right subtree 
 * is not more than one or vice versa */

import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class BalanceTree {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		System.out.println("The Tree is:");
		boolean ans = isBalanced(root);
		if(ans)
			System.out.print("Balnced Tree");
		else
			System.out.print("Not a balnced tree");
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
	
	// function to find if a tree is balanced or not
	static int flag = 1;
	static boolean isBalanced(Node root) {
		if(root == null)
			return true;
		
		isBalancedUtil(root);
		
		if(flag == 1)
			return true;
		else
			return false;
		}
	
	// Utility function to check for the validity of balance tree
	static int isBalancedUtil(Node root) {
		if(root == null)
			return 0;
		int lh = isBalancedUtil(root.left);
		int rh = isBalancedUtil(root.right);
		
		if(Math.abs(lh-rh) > 1)
			flag = 0;
		
		return Math.max(lh, rh) + 1;
	}
}