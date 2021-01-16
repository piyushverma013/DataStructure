import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class BoundaryTraversal {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		
		System.out.println("Boundary of Tree is:");
		ArrayList<Integer> res = printBoundary(root); // getting all the boundary nodes in a list
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
	
	// function for storing the boundary nodes  
	static ArrayList<Integer> printBoundary(Node root) {
	ArrayList<Integer> ans = new ArrayList<Integer>();
	
	ans.add(root.data);
	
	printLeftTree(root.left, ans);
	printLeafOfTree(root, ans);
	printRightTree(root.right, ans);
	
	return ans;
    }
	
    // function to get all the left boundary nodes
	static void printLeftTree(Node root, ArrayList<Integer> ans)
	{
		if(root == null)
			return;
		 if(root.left != null) {
			 ans.add(root.data);
			 printLeftTree(root.left, ans);
		    }
		    
		    else if(root.right != null) {
		        ans.add(root.data);
		        printLeftTree(root.right, ans);
		    }	
	}
	
	// function to get all the leaf nodes
	static void printLeafOfTree(Node root, ArrayList<Integer> ans)
	{
		if(root == null)
			return;
		
		printLeafOfTree(root.left, ans);
		if(root.left == null && root.right == null) {
			ans.add(root.data);
		}
		printLeafOfTree(root.right, ans);
	}
	
	// function to get all the right boundary nodes
	static void printRightTree(Node root, ArrayList<Integer> ans)
	{
		if(root == null)
			return;
		 if(root.right != null) {
			 printRightTree(root.right, ans);
			 ans.add(root.data);
		    }
		    
		    else if(root.left != null) {
		    	printRightTree(root.left, ans);
		    	ans.add(root.data);
		    }	
	}

}
