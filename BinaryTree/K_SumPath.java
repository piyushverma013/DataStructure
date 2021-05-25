import java.util.*;
class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
	}
}
public class K_SumPath {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createTree(); //getting root node
		System.out.println("Root node is: "+root.data);
		
		System.out.println("Enter K value: ");
		int k = obj.nextInt();
		
		System.out.println("The paths are: ");
		printKPath(root, k);
		System.out.println("Total paths: "+count);

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
	
	// function to find K sum path
	static ArrayList<Integer> al = new ArrayList<Integer>();
	static int count = 0;
	
	static void printKPath(Node root, int k) {
		if(root == null)
			return;
		
		al.add(root.data);
		printKPath(root.left, k);
		printKPath(root.right, k);
		
		int f = 0;
		for(int i = al.size()-1; i >= 0; i--) {
			f+= al.get(i);
			if(f == k) {
				printList(al, i);
				count++;
			}
		}
		al.remove(al.size()-1);
	}
	
	// function to print list 
	static void printList(ArrayList<Integer> al, int i) {
		for(int j = i; j < al.size(); j++) {
			System.out.print(al.get(j)+" ");
		}
		System.out.println();
	}
}