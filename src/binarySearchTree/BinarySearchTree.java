package binarySearchTree;

public class BinarySearchTree {
	Node head;
	int min, max, size;

	// Constructor
	public BinarySearchTree() {
		this.head = null;
		this.size = 0;
	}

	public int getSize() {
		return this.size;
	}

	public void insert(int newVal) {
		Node newNode = new Node(newVal, null, null);

		if (this.head == null) {
			this.head = newNode;
			this.size++;
			return;
		}

		Node curr = this.head;
		Node prev = curr;

		while (curr != null) {
			prev = curr;
			if (newVal < curr.val) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}

		if (newVal < prev.val) {
			prev.left = newNode;
		} else {
			prev.right = newNode;
		}
		this.size++;
	}

	public boolean contains(int val) {
		Node curr = this.head;

		while (curr != null) {
			if (val == curr.val) {
				return true;
			}

			if (val < curr.val) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		return false;
	}

	public int maximum() {
		Node curr = this.head;
		while (curr.right != null) {
			curr = curr.right;
		}
		return curr.val;
	}

	public int minimum() {
		Node curr = this.head;
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr.val;
	}

	public void preOrderTraversal() {
		Node curr = this.head;
		this.preOrderHelper(curr);
	}

	// preOrder Helper
	private void preOrderHelper(Node curr) {
		if (curr == null) {
			return;
		}

		System.out.println(curr.val);
		this.preOrderHelper(curr.left);
		this.preOrderHelper(curr.right);
	}

	public void inOrderTraversal() {
		Node curr = this.head;
		this.inOrderHelper(curr);
	}

	// inOrder Helper
	private void inOrderHelper(Node curr) {
		if (curr == null) {
			return;
		}

		this.inOrderHelper(curr.left);
		System.out.println(curr.val);
		this.inOrderHelper(curr.right);
	}

	public void postOrderTraversal() {
		Node curr = this.head;
		this.postOrderHelper(curr);
	}

	// postOrder Helper
	private void postOrderHelper(Node curr) {
		if (curr == null) {
			return;
		}
		this.postOrderHelper(curr.left);
		this.postOrderHelper(curr.right);
		System.out.println(curr.val);
	}

	public int maxDepth() {
		Node curr = this.head;
		return this.maxDepthHelper(curr);

	}

	// maxDepth Helper
	private int maxDepthHelper(Node curr) {
		if (curr == null) {
			return 0;
		}

		return Math.max(maxDepthHelper(curr.left) + 1, maxDepthHelper(curr.right) + 1);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(45);
		bst.insert(25);
		bst.insert(75);
		bst.insert(15);
		bst.insert(35);

		bst.preOrderTraversal();
		System.out.println();
		bst.inOrderTraversal();
		System.out.println();
		System.out.println(bst.maxDepth());
		System.out.println();
		System.out.println(bst.maximum());
		System.out.println(bst.minimum());
	}

}
