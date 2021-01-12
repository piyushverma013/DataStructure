import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class PreorderTraversal {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		System.out.println("Preorder traversal is:");
		ArrayList<Integer> res = preorder(root); // getting all the level nodes in a list
		for(int num : res) {
			System.out.print(num+ " ");
		}
		
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
	static ArrayList<Integer> preorder(Node root) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			Node temp = stack.pop();
			al.add(temp.data);
			
			if(temp.right != null)
			{
				stack.push(temp.right);
			}
			
			if(temp.left != null)
			{
				stack.push(temp.left);
			}
		}
		
		return al;
	}

}
