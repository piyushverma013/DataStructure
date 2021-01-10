import java.util.*;
class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
	}
}
public class Height_Of_Tree {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node ans = createTree();
		System.out.println("Root node is: "+ ans.data);
		
		int height = height(ans);
		System.out.println("Height of tree is: "+ height);
	}
	
	// function to create tree and add nodes
	static Node createTree() {
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		if(data == -1)
			return null;
		Node root = new Node(data);
		
		System.out.println("Enter left for: "+ data);
		root.left = createTree();
		System.out.println("Enter right for: "+ data);
		root.right = createTree();
		
		return root;
	}
	
	// function to find and return height of the binary tree
	static int height(Node root) {
		int height = 0;
		if(root == null)
			return height;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(true) {
		int node_count = queue.size();
		if(node_count == 0)
		{
			return height;
		}
		height++;
		while(node_count > 0)
		{
			Node temp = queue.poll();
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
			
			node_count--;
		}
		
		}
	}
}
