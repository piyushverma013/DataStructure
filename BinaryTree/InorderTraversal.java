import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class InorderTraversal {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		System.out.println("Inorder traversal is:");
		ArrayList<Integer> res = inorder(root); // getting all the level nodes in a list
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
	
	
	// function for inorder traversal and storing the levels in a list
	static ArrayList<Integer> inorder(Node root) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		Node curr = root;
		while(!stack.isEmpty() || curr != null)
		{
			if(curr != null)
			{
				stack.push(curr);
				curr = curr.left;
			}
			
			else
			{
				curr = stack.pop();
				al.add(curr.data);
				curr = curr.right;
			}
		}
		
		return al;
	}

}
