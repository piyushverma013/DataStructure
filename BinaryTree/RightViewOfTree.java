import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class RightViewOfTree {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		System.out.println("Right View is:");
		ArrayList<Integer> res = right_View(root); // getting all the level nodes in a list
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
	
	// function to add all the left visible nodes to a list
	static ArrayList<Integer> right_View(Node root) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			for(int i = 1; i <= n; i++)
			{
				Node temp = queue.poll();;
				if(i == n) {
				al.add(temp.data);
				}
				
				if(temp.left != null) {
					queue.add(temp.left);
				}
				
				if(temp.right != null) {
					queue.add(temp.right);
				}
			}
		}
		return al;
	}

}
