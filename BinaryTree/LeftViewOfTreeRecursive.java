import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	Node(int data) {
		this.data = data;
	}
}
public class LeftViewOfTreeRecursive {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree();
		
		System.out.println("Left View is:");
		ArrayList<Integer> res = left_View(root); // getting all the left nodes in a list
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
		System.out.println("Enter left for :" +data);
		root.left = createTree();
		System.out.println("Enter right for :" +data);
		root.right = createTree();
		
		return root;
		
	}
	
	
	// function to add all the left visible nodes to a list
	static ArrayList<Integer> left_View(Node root) {
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		leftleft_ViewUtil(root, 1, ans);
		return ans;
		
	}
	
	// Utility function to add all the left visible nodes
	static int max_level = 0;
	static void leftleft_ViewUtil(Node root, int level, ArrayList<Integer> ans) {
		
		if(root == null)
			return;
		
		if(max_level < level) {
			ans.add(root.data);
			max_level = level;
		}
		
		leftleft_ViewUtil(root.left, level+1, ans);
		leftleft_ViewUtil(root.right, level+1, ans);	
	
	}
}
