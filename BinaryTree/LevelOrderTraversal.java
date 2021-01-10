import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class LevelOrderTraversal {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		System.out.println("Level order traversal is:");
		ArrayList<Integer> res = level_order(root); // getting all the level nodes in a list
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
	
	// function for level order traversal and storing the levels in a list
	
	static ArrayList<Integer> level_order(Node root) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			al.add(temp.data);
			
			if(temp.left != null) {
				queue.add(temp.left);
			}
		    if(temp.right != null) {
		    	queue.add(temp.right);
		    }    
		}
		return al;
	}

}
