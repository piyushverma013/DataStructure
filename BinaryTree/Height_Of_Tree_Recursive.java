import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
	}
}
public class Height_Of_Tree_Recursive {
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
		if(root == null)
			return 0;
		
		int left_height = height(root.left);
		int right_height = height(root.right);
		
		return (Math.max(left_height, right_height) + 1);
		
	}
}
