import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class TreeFromInorderAndPostorder {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter Inorder and Postorder array size: ");
		int n = sc.nextInt();
		System.out.println("Enter elements of Inorder: ");
		int inorder[] = new int[n];
		for(int i = 0; i < n; i++) {
			inorder[i] = sc.nextInt();
		}
		System.out.println("Enter elements of Postorder: ");
		int postorder[] = new int[n];
		for(int i = 0; i < n; i++) {
			postorder[i] = sc.nextInt();
		}
		Node root = buildTree(inorder, postorder, n);
		
		System.out.println("Elements in Preorder are: ");
		preOrder(root);
	}
	
	// function to create tree using inorder and postorder
	static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    static int idx = 0;
	public static Node buildTree(int inorder[], int postorder[], int n)
    {
        for(int i = 0; i < n; i++) {
            hm.put(inorder[i], i);
        }
        idx = n-1;
        Node ans = build(inorder, postorder, 0, n-1);
        return ans;
    }
    
    public static Node build(int inorder[], int postorder[], int start, int end) {
        if(start > end)
          return null;
        int val = postorder[idx--];
        int pos = hm.get(val);
        Node node = new Node(val);
        
        node.right = build(inorder, postorder, pos+1, end);
        node.left = build(inorder, postorder, start, pos-1);
        
        return node; 
    }
    
    //function to print tree in preorder
    public static void preOrder(Node root) {
    	if(root == null)
    		return;
    	System.out.print(root.data+" ");
    	preOrder(root.left);
    	preOrder(root.right);
    }
}
