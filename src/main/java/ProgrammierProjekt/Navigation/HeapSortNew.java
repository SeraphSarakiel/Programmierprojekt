package ProgrammierProjekt.Navigation;

public class HeapSortNew {
	int capacity;
	int heapSize;
	int[] harr;
	
	public HeapSortNew(int capacity) {
		heapSize = 0;
		this.capacity = capacity;
		this.harr = new int[capacity];
	}
	
	public void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}
	
	int getMin() {return harr[0];}
	
	int parent(int i) {
		return (i-1)/2;
	}
	
	int left(int i) {
		return(2*i + 1);
	}
	
	int right(int i) {
		return(2*i + 2);
	}
	
	public void addKey(int k) {
		if(heapSize == capacity) {
			System.out.println("Overflow");
			return;
		}
		heapSize++;
		int i = heapSize-1;
		harr[i] = k;
		
		while(i != 0 && harr[parent(i)] > harr[i]) {
			swap(harr[i], harr[parent(i)]);
			i = parent(i);
		}
		
		
	}
	
	void decreaseKey(int i, int newVal) {
		harr[i] = newVal;
		while(i != 0 && harr[parent(i)] > harr[i]) {
			swap(harr[i], harr[parent(i)]);
			i = parent(i);
		}
	}
	
	int extractMin() {
		if(heapSize <= 0) {
			return Integer.MAX_VALUE;
		}
		if(heapSize==1) {
			heapSize--;
			return harr[0];
		}
		
		int root = harr[0];
		harr[0] = harr[heapSize-1];
		heapSize--;
		minHeapify(0);
		return root;
	}
	
	void deleteKey(int i) {
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
	
	void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if(l < heapSize && harr[l] < harr[i])
			smallest = l;
		if(r < heapSize && harr[r] < harr[smallest])
			smallest = r;
		if(smallest != i) {
			swap(harr[i], harr[smallest]);
			minHeapify(smallest);
		}
	}
	
	public static void main(String[] args) {
		HeapSortNew test = new HeapSortNew(15);
		test.addKey(3);
		test.addKey(2);
		test.deleteKey(1);
		test.addKey(15);
		test.addKey(5);
		test.addKey(4);
		test.addKey(45);
		System.out.println(test.extractMin());
		System.out.println(test.getMin());
		test.decreaseKey(2, 1);
		System.out.println(test.getMin());
	
		
		
	}
}


