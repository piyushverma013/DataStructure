import java.util.*;
class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class ZigZagTraversal {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node ans = createTree(); //getting root node
		System.out.println("Root node is: "+ ans.data);
		
		System.out.println();
		
		ArrayList<Integer> res = zigzagTraversal(ans); //getting all the levels in a zigzag manner
		System.out.println("Zig zag traversal is: ");
		for(int i : res) {
			System.out.print(i+ " ");
		}

	}
	
	//function to create tree
	public static Node createTree() {
		System.out.println("Enter data: ");
		int data = obj.nextInt();
		
		if(data == -1)
			return null;
		
		Node root = new Node(data);
		System.out.println("Enter left for: "+data);
		root.left = createTree();
		System.out.println("Enter right for: "+data);
		root.right = createTree();
		
		return root;
	}
	
	//function to perform zigzag traversal and returning the levels in a list
	public static ArrayList<Integer> zigzagTraversal(Node root) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		if(root == null)
			return al;
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.push(root);
		boolean flag = true;
		
		while(!s1.isEmpty()) {
			Node ans = s1.pop();
			al.add(ans.data);
			
			if(flag) {
				if(ans.left != null)
					s2.push(ans.left);
				if(ans.right != null)
					s2.push(ans.right);
			}
			
			else {
				if(ans.right != null)
					s2.push(ans.right);
				if(ans.left != null)
					s2.push(ans.left);
			}
			
			if(s1.isEmpty()) {
				flag = !flag;
				Stack<Node> temp = s1;
				s1 = s2;
				s2 = temp;
			}
		}
		return al;	
	}
}