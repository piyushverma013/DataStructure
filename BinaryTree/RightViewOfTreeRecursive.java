import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class RightViewOfTreeRecursive {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		System.out.println("Right View is:");
		ArrayList<Integer> res = right_view(root); // getting all the right nodes in a list
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
	
	// function to add all the right visible nodes to a list
	static ArrayList<Integer> right_view(Node root) {
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		right_viewUtil(root, 1, ans);
		return ans;
		
	}
	
	// Utility function to add all the right visible nodes
	int max_level = 0;
	void right_viewUtil(Node root, int level, ArrayList<Integer> ans) {
		
		if(root == null)
			return;
		
		if(max_level < level) {
			ans.add(root.data);
			max_level = level;
		}
		
		right_viewUtil(root.right, level+1, ans);
		right_viewUtil(root.left, level+1, ans);
	}

}
