package leslie.struct.binarytree;

public class AVLBinaryTree extends BinaryTree {


	private Node rootNode;

	public void insert(int value) {
		rootNode = insert(rootNode, value);
	}

	public void remove(int value) {
		Node node = search(rootNode, value);
		rootNode = remove(rootNode, node);
	}

	public Node search(int value) {
		return search(rootNode, value);
	}

	public Node iterateSearch(int value) {
		return iterateSearch(rootNode, value);
	}
	
	public void preOrder() {
		preOrder(rootNode);
	}
	public void postOrder(){
		postOrder(rootNode);
	}
	public void midOrder(){
		midOrder(rootNode);
	}


	private Node insert(Node node, int value) {

		if (node == null) {
			node = new Node(value);
		} else if (node.value < value) {

			node.right =(insert(node.right, value));

			if (!isBalance(node)) {
				if (value > node.right.value) {
					node = RRRotate(node);
				} else {
					node = RLRotate(node);
				}
			}
		} else if (node.value > value) {

			node.left = (insert(node.left, value));
			if (!isBalance(node)) {
				if (value < node.left.value) {
					node = LLRotate(node);
				} else {
					node = LRRotate(node);
				}
			}
		} else {
			System.out.println("插入重复数据");
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}

	private Node remove(Node root, Node remove) {

		if (root == null) {
			return null;
		}

		if (root.value < remove.value) {

			root.right =(remove(root.right, remove));
			if (!isBalance(root)) {

				Node left = root.left;

				if (height(left.right) > height(left.left)) {
					root = LRRotate(root);
				} else {
					root = LLRotate(root);
				}
			}
		} else if (root.value > remove.value) {

			root.left = (remove(root.left, remove));

			if (!isBalance(root)) {

				Node right = root.right;

				if (height(right.left) > height(right.right)) {
					root = RLRotate(root);
				} else {
					root = RRRotate(root);
				}
			}
		} else {
			if (root.left != null && root.right != null) {

				if (height(root.left) > height(root.right)) {

					Node maxNode = maxNode(root.left);
					root.value = maxNode.value;
					root.right =(remove(root.left, maxNode));
				} else {

					Node minNode = minNode(root.right);
					root.value = (minNode.value);
					root.right =(remove(root.right, minNode));
				}

			} else {
				root = root.left != null ? root.left : root.right;
			}
		}
		return root;
	}

	private Node minNode(Node node) {
		while (node != null && node.left != null) {
			node = node.left;
		}
		return node;
	}

	private Node maxNode(Node node) {

		while (node != null && node.right != null) {
			node = node.right;
		}
		return node;
	}

	private Node search(Node right, int value) {

		if (right == null) {
			return null;
		}
		if (value > right.value) {
			return search(right.right, value);
		} else if (value < right.value) {
			return search(right.left, value);
		} else {
			return right;
		}
	}

	private Node iterateSearch(Node root, int value) {

		while (root != null && root.value != value) {

			if (value < root.value) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return root;
	}

	private boolean isBalance(Node node) {
		return Math.abs(height(node.left) - height(node.right)) <= 1;
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	private Node LLRotate(Node root) {
		System.out.println("ll");
		Node left = root.left;
		root.left = (left.right);
		left.right =(root);
		root.height = (Math.max(height(root.left), height(root.right)) + 1);//
		left.height = (Math.max(height(left.left), root.height) + 1);//
		return left;
	}

	private Node RRRotate(Node left) {
		System.out.println("rr");
		Node right = left.right;
		right.left = (left);
		left.right =(right.left);
		left.height = (Math.max(height(left.left), height(left.right)) + 1);//
		right.height = Math.max(height(right.right), left.height) + 1;//
		return left;
	}

	private Node LRRotate(Node root) {
		System.out.println("lr");
		root.left = RRRotate(root.left);
		return LLRotate(root);
	}

	private Node RLRotate(Node root) {
		System.out.println("rl");
		root.right =LLRotate(root.right);
		return RRRotate(root);
	}

	public int height(Node left) {
		return left == null ? -1 : left.height;
	}
}
