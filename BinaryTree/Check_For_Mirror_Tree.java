import java.util.*;
class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
	}
}
public class Check_For_Mirror_Tree {
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
		
		if (areMirror(root1, root2) == true)
            System.out.println("Yes, two trees are mirror");
        else
            System.out.println("No, two trees are not mirror");
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
	
	// function to check and return if two trees are mirror of each other
	static boolean areMirror(Node root1, Node root2) {
		
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null || root2 == null)
			return false;
		
		return (root1.data == root2.data 
				&& areMirror(root1.left, root2.right) && areMirror(root1.right, root2.left));
	}
}