import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}

public class DistanceBetweenTwoNodes {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createTree();
		System.out.println("Root node is: "+root.data);
		System.out.println("Enter a: ");
		int a = obj.nextInt();
		System.out.println("Enter b: ");
		int b = obj.nextInt();
		int ans = findDist(root, a, b);
		System.out.println("Distance between two nodes is: "+ans);
	}
	
	// function to create tree
	static Node createTree() {
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
	
	// function to find distance between two nodes
	static int findDist(Node root, int a, int b) {
        if(root == null)
          return 0;
          
        Node lca = findLca(root, a, b);
        int fd = dist(lca, a);
        int sd = dist(lca, b);
        
        return fd + sd - 2;
    }
    
	// utility function to calculate lca of two nodes
    static Node findLca(Node root, int a, int b) {
        if(root == null)
          return null;
        if(root.data == a || root.data == b)
          return root;
        Node left = findLca(root.left, a, b);
        Node right = findLca(root.right, a, b);
        
        if(left != null && right != null) 
          return root;
        
        if(left != null)
          return left;
        else
          return right;
    }
    
    // utility function to find distance between lca and the node(s)
    static int dist(Node root, int val) {
        if(root == null)
          return 0;
        if(root.data == val)
          return 1;
        
        int a = dist(root.left, val);
        int b = dist(root.right, val);
        
        if(a == 0 && b == 0)
          return 0;
          
        return a + b + 1;
    }
}