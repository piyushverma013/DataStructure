import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}

public class DiagonalTraversal {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		System.out.println("Diagonal traversal is:");
		ArrayList<Integer> res = diagonal(root); // getting all the diagonal nodes in a list
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
	
	// function for diagonal order traversal and storing the levels in a list
	static ArrayList<Integer> diagonal(Node root) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if(root == null)
			return al;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			
			while(temp != null) {
				al.add(temp.data);
			
				if(temp.left != null)
					queue.add(temp.left);
				
				temp = temp.right;
			}
		}
		return al;
	}
}
