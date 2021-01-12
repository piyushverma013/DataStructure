import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class PostorderTraversal {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);

		System.out.println("Postorder traversal is:");
		ArrayList<Integer> res = postorder(root); // getting all the level nodes in a list
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
	
	
	// function for postorder traversal and storing the levels in a list
	static ArrayList<Integer> postorder(Node root) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		Stack<Integer> stack1 = new Stack<Integer>();
		while(!stack.isEmpty())
		{
			Node temp = stack.pop();
			stack1.push(temp.data);
			
			if(temp.left != null)
			{
				stack.push(temp.left);
			}
			
			if(temp.right != null)
			{
				stack.push(temp.right);
			}
		}
		
		while(!stack1.isEmpty()) {
			int c = stack1.pop();
			al.add(c);
		}
		return al;
	}

}
