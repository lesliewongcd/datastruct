package leslie.struct.binarytree;

public abstract class BinaryTree {

	protected void preOrder(Node root){
		if (root != null) {
			System.out.println("-v:" + root.value);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	protected void midOrder(Node root){
		if (root != null) {
			
			preOrder(root.left);
			System.out.println("-v:" + root.value);
			preOrder(root.right);
		}
	}
	protected void postOrder(Node root){
		if (root != null) {
			preOrder(root.left);
			preOrder(root.right);
			System.out.println("-v:" + root.value);
		}
	}
}
