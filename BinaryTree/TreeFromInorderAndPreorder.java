import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class TreeFromInorderAndPreorder {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter Inorder and Preorder array size: ");
		int n = sc.nextInt();
		System.out.println("Enter elements of Inorder: ");
		int inorder[] = new int[n];
		for(int i = 0; i < n; i++) {
			inorder[i] = sc.nextInt();
		}
		System.out.println("Enter elements of Preorder: ");
		int preorder[] = new int[n];
		for(int i = 0; i < n; i++) {
			preorder[i] = sc.nextInt();
		}
		Node root = buildTree(inorder, preorder, n);
		
		System.out.println("Elements in Postorder are: ");
		postOrder(root);
	}
	
	// function to create tree using inorder and preorder
	static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    static int idx = 0;
	public static Node buildTree(int inorder[], int preorder[], int n)
    {
        for(int i = 0; i < n; i++) {
            hm.put(inorder[i], i);
        }
        
        Node ans = build(inorder, preorder, 0, n-1);
        return ans;
    }
    
    public static Node build(int inorder[], int preorder[], int start, int end) {
        if(start > end)
          return null;
        int val = preorder[idx++];
        int pos = hm.get(val);
        Node node = new Node(val);
        
        node.left = build(inorder, preorder, start, pos-1);
        node.right = build(inorder, preorder, pos+1, end);
        
        return node; 
    }
    
    //function to print tree in postorder
    public static void postOrder(Node root) {
    	if(root == null)
    		return;
    	postOrder(root.left);
    	postOrder(root.right);
    	System.out.print(root.data+" ");
    }
}