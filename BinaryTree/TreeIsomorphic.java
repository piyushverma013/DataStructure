import java.util.*;
class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
	}
}
public class TreeIsomorphic {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("For tree1 ");
		Node root1 = createTree1(); //getting root node
		System.out.println("Root node is: "+root1.data);
		
		System.out.println();
		
		System.out.print("For tree2 ");
		Node root2 = createTree2(); //getting root node
		System.out.println("Root node is: "+root2.data);
		
		if (isIsomorphic(root1, root2) == true)
		  System.out.println("Yes, two trees are isomorphic");
		else
		  System.out.println("No, two trees are not isomorphic");
	}
	
	// function to create tree1
	static Node createTree1() {
		System.out.println("Enter data: ");
		int data = obj.nextInt();
		if(data == 0)
			return null;
		Node root = new Node(data);
		
		System.out.println("Enter left for: "+data);
		root.left = createTree1();
		System.out.println("Enter right for: "+data);
		root.right = createTree1();
		return root;
	}
	
	// function to create tree2
	static Node createTree2() {
		System.out.println("Enter data: ");
		int data = obj.nextInt();
		if(data == 0)
			return null;
		Node root = new Node(data);
		
		System.out.println("Enter left for: "+data);
		root.left = createTree2();
		System.out.println("Enter right for: "+data);
		root.right = createTree2();
		return root;
	}
	
	// function to check if two trees are isomorphic or not
	static boolean isIsomorphic(Node root1, Node root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.data != root2.data)
			return false;
		
		boolean a = isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);
		boolean b = isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);
		
		return a || b;	
	}
}
