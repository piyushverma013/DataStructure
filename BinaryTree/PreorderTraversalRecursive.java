import java.util.Scanner;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class PreorderTraversalRecursive {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		System.out.println("Preorder traversal is:");
		preorder(root); 

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
	
	
	// function for preorder traversal and storing the levels in a list
	static void preorder(Node root) {
		if(root == null)
			return;
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
		
	}

}
