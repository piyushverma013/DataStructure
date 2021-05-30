import java.util.*;
class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
	}
}
public class DuplicateSubtree {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+root.data);
		System.out.println("Duplicates are: ");
		printDup(root); //finding root node of all duplicate trees

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
	
	
	// function to print root node of all duplicate subtree
	public static void printDup(Node root){
		
        ArrayList<Integer> al = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        duplicate(root, al, map);
        
        if(al.size() <= 0)
          System.out.print(-1);
          
        Collections.sort(al);
        
        for(int i : al) {
            System.out.print(i+" ");
        }
        System.out.println();  
    }
    
	// utility function to find root node of all duplicate subtree
    public static String duplicate(Node root, ArrayList<Integer> al, HashMap<String, Integer> map) {
        if(root == null)
          return "";
        
        String l = duplicate(root.left, al, map);
        String r = duplicate(root.right, al, map);
        String s = Integer.toString(root.data)+l+r;
        
        if (map.containsKey(s))
            map.put(s, map.get(s) + 1);
        else
            map.put(s, 1);
            
        if (map.get(s) == 2)
            al.add(root.data);
            
        return s;
    }
}