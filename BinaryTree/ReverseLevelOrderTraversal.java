import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	Node(int data) {
		this.data = data;
	}
}
public class ReverseLevelOrderTraversal {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		System.out.println("Revers level order traversal is:");
		ArrayList<Integer> res = reverse_level_order(root); // getting all the level nodes in a list
		for(int num : res) {
			System.out.print(num+ " ");
		}

	}
	
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
	
	static ArrayList<Integer> reverse_level_order(Node root) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if(root == null) return al;
		
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			stack.push(temp);
			
		    if(temp.right != null) {
		    	queue.add(temp.right);
		    } 
			if(temp.left != null) {
				queue.add(temp.left);
			}   
		}
		
		while(!stack.isEmpty()) {
			Node c = stack.pop();
			al.add(c.data);
		}
		return al;
	}

}
