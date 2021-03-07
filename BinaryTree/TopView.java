import java.util.*;
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
public class TopView {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree();  //getting root node
		System.out.println("Root node is: "+ root.data);
		
		System.out.println("Top view is: ");
		ArrayList<Integer> res = top_view(root); // getting all the top view nodes in a list
		
		for(int num : res) {
			System.out.print(num+ " ");
		}
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
	
	// function to add all the top visible nodes to a list
	static ArrayList<Integer> top_view(Node root) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		if(root == null)
			return al;
		
		class QueueNode {
			Node node;
			int hd;
			
			QueueNode(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}
		
		Queue<QueueNode> q = new LinkedList<QueueNode>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		q.add(new QueueNode(root, 0));
		
		while(!q.isEmpty()) {
			
			QueueNode temp = q.poll();
			
			if(!map.containsKey(temp.hd))
				map.put(temp.hd, temp.node.data);
			
			if(temp.node.left != null)
				q.add(new QueueNode(temp.node.left, temp.hd-1));
			
			if(temp.node.right != null)
				q.add(new QueueNode(temp.node.right, temp.hd+1));
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			al.add(entry.getValue());
		}
		return al;
		
	}

}