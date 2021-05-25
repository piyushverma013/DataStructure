import java.util.*;
class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
	}
}
public class LowestCommonAncestorInBinaryTree {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+root.data);
		
		System.out.println("Enter n1: ");
		int n1 = obj.nextInt();
		System.out.println("Enter n2: ");
		int n2 = obj.nextInt();
		
		System.out.println("LCA of n1 and n2 is: ");
		Node ans = lca(root, n1, n2);
		System.out.print(ans.data);

	}
	
	// function to create tree
	static  Node createTree() {
		System.out.println("Enter data: ");
		int data = obj.nextInt();
		if(data == 0)
			return null;
		Node root = new Node(data);
		
		System.out.println("Enter left for: "+data);
		root.left = createTree();
		System.out.println("Enter right for: "+data);
		root.right = createTree();
		return root;
	}
	
	//function to find LowestCommonAncestor
	static Node lca(Node root, int n1, int n2) {
		if(root == null)
			return null;
		if(root.data == n1 || root.data == n2)
			return root;
		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);
		
		if(left!= null && right != null)
			return root;
		if(left!= null)
			return left;
		else
			return right;
	}
}