

public class DijkstraAlg {
	/** 
	 * 
	 * @author acurazee
	 *	Minheap for dijkstra
	 */
	public class Minheap{
		/**
		 * Node class for the minheap
		 * @author acurazee
		 *
		 */
		public class Node{
			//variables
			int value;
			int id;
			Node previous;
			Node nextLeft;
			Node nextRight;
			
			//controll constructor
			public Node(int value,Node nextLeft,Node nextRight, Node previous) {
				this.value = value;
				this.nextLeft = nextLeft;
				this.nextRight = nextRight;
				this.previous = previous;
				
			}
			
			//standard const
			public Node(int value, int id) {
				this.value = value;
				this.id = id;
				this.previous = null;
				this.nextLeft = null;
				this.nextRight = null;
				
			}
			
			
		}
		
		//variables
		Node base;
		int nextToAdd;
		
		//standard const, reads int array
		public Minheap(int[] values) {
			
			for(int i : values) {
				this.addNode(new Node(i, nextToAdd));
				
			}
			printInOrder(base);
		}
		
		//add a new node
		public void addNode(Node toAdd) {
			//base node
			if(base.nextLeft == null ) {
				base.nextLeft = toAdd;
				restoreHeap(toAdd);
				nextToAdd = 2;
				
			}
			//base node
			else if(base.nextRight == null) {
				base.nextRight = toAdd;
				restoreHeap(toAdd);
				nextToAdd = 3;
			}
			//normals node
			else {
				Node nextPos = traverse(nextToAdd);
				if(nextPos == null ) {
					nextPos.nextLeft = toAdd;
					restoreHeap(toAdd);
					nextToAdd++;
					
				}
				else if(nextPos.nextRight == null) {
					nextPos.nextRight = toAdd;
					restoreHeap(toAdd);
					nextToAdd++;
				}
			}
		}
		
		//get new node position
		public Node traverse(Node root, Node lastNode) {
			if(root != null) {
				
				printInOrder(root.nextLeft);
				lastNode = root;
				printInOrder(root.nextRight);
				
			}
			else {
				return lastNode;
			}
			
			
			
			
		}
		
		//restore the heap 
		public void restoreHeap(Node rest) {
			if(rest.value < rest.previous.value) {
				swap(rest, rest.previous);
			}
		}
		
		//swap two nodes
		public void swap(Node node1, Node node2) {
			Node previous1 = node2.previous;
			Node nextLeft1 = node2.nextLeft;
			Node nextRight1 = node2.nextRight;
			boolean isRight = true;
			
			if(node2.nextRight.equals(node1)) {
				isRight = true;
				
			}
			else {
				isRight = false;
			}
			
			
			if(isRight == true) {
				node2.previous = node1.previous;
				node2.nextLeft = node1.nextLeft;
				node2.nextRight = node1;
				
				node1.previous = node2;
				node1.nextLeft = nextLeft1;
				node1.nextRight = nextRight1;
			}
			else {
				node2.previous = node1.previous;
				node2.nextLeft = node1;
				node2.nextRight = node1.nextRight;
				
				node1.previous = node2;
				node1.nextLeft = nextLeft1;
				node1.nextRight = nextRight1;
			}
			
			
			
		}
		//prints the inorder
		public void printInOrder(Node root) {
			if(root != null) {
				printInOrder(root.nextLeft);
				System.out.println(root.value);
				printInOrder(root.nextRight);
			}
		}
		
		
	}
	public static void main( String[] args ){
		DijkstraAlg x = new DijkstraAlg();
		int[] testInt = {5,2,5,7,4,5,6,3,1};
		Minheap testHeap = x.new Minheap(testInt);
	}
}