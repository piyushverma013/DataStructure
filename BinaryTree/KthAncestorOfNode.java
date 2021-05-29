import java.util.*;
class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
	}
}
public class KthAncestorOfNode {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+root.data);
		
		System.out.println("Enter K value: ");
		int k = obj.nextInt();
		
		System.out.println("Enter node value: ");
		int node = obj.nextInt();
		
		int ans = kthAncestor(root, k, node);
		if(ans == -1)
			System.out.println("Ancestor not found");
		else
		System.out.println(k+" Ancestor of "+node+" is: "+ans);
	}
	
	// function to create tree
	static  Node createTree() {
		System.out.println("Enter data: ");
		int data = obj.nextInt();
		if(data == 0)
			return null;
		Node root = new Node(data);
		
		System.out.println("Enter left for: "+data);
		root.left = createTree();
		System.out.println("Enter right for: "+data);
		root.right = createTree();
		return root;
	}
	
	
    // function to find kth ancestor of given node in binary tree
    public static int kthAncestor(Node root, int k, int node)
    {
        //Write your code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        findPath(root, node, al);
        if (k > al.size() - 1 || k <= 0)
        return -1;
        
        return (al.get(al.size()-1 - k));
    }
    
    // utility function to find kth ancestor
    public static boolean findPath(Node root, int node, ArrayList<Integer> al) {
        if(root == null)
          return false;
        
        al.add(root.data);
        
        if(root.data == node)
          return true;
        
        if(findPath(root.left, node, al) || findPath(root.right, node, al))
          return true;
        
        al.remove(al.size()-1);
        return false;
    }
}
