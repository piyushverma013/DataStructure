import java.util.*;
class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
	}
}
public class DuplicateSubtreeWithSize2orMore {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+root.data);
		
		dupSub(root); //finding count of all duplicate trees
		
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
	
	// function to find total duplicate subtree with size two or more
    public static void dupSub(Node root) {
    	
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        duplicate(root, map);
        int count = 0;
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 2) {
                count++;
            }
        }
        if(count > 0)
          System.out.println("Total duplicates: "+count);
        else
          System.out.println("No duplicates with size two or more exist");    
    }
    
    // utility function to find total duplicate subtree with size two or more
    public static String duplicate(Node root, HashMap<String, Integer> map) {
        if(root == null)
          return "$";
        
        if(root.left == null && root.right == null)
          return Integer.toString(root.data);
          
        String l = duplicate(root.left, map);
        String r = duplicate(root.right, map);
        String s = Integer.toString(root.data)+l+r;
        
        if(map.containsKey(s))
          map.put(s, map.get(s)+1);
          
        else
          map.put(s, 1);
          
        return s;
    }
    
}