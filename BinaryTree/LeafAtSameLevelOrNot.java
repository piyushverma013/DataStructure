import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class LeafAtSameLevelOrNot {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+ root.data);
		System.out.println();
		boolean ans = check(root);
		if(ans)
			System.out.println("The leaf nodes are at the same level");
		else
			System.out.println("The leaf nodes are not at the same level");
		
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
	
	// function to check if all leaf nodes are at the same level or not
	static boolean check(Node root) {
		if(root == null)
			return true;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		int level = 0;
		int result = Integer.MAX_VALUE;
		int size;
		
		while(!queue.isEmpty()) {
			size = queue.size();
			level++;
			while(size > 0) {
				Node temp = queue.poll();
				if(temp.left != null) {
					queue.add(temp.left);
					
					if(temp.left.left == null && temp.left.right == null)
					{
						if(result == Integer.MAX_VALUE) {
							result = level;
						}
						else if(result != level) {
							return false;
						}
					}
				}
				
				if(temp.right != null) {
					queue.add(temp.right);
					
					if(temp.right.left == null && temp.right.right == null) {
						
						if(result == Integer.MAX_VALUE) {
							result = level;
						}
						else if(result != level) {
							return false;
						}
					}
				}
				size--;
			}
		}
		return true;
	}
}


// Recursive way of checking if leaf nodes are at same level or not.
/*
    int leaf_level = 0;
    boolean check(Node root)
    {
	// Your code here
	  int level = 0;
	  return checkUtil(root, level);
    }
    
    boolean checkUtil(Node root, int level) {
        if(root == null)
          return true;
        if(root.left == null && root.right == null) {
            if(leaf_level == 0) {
              leaf_level = level;
              return true;
            }
            else
              return leaf_level == level;
        }
        return checkUtil(root.left, level+1) && checkUtil(root.right, level+1);
    }
*/
