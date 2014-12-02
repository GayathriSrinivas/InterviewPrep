public class Tree {

	private Tree left;
	private Tree right;
	private int data;

	public Tree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void insert( Tree node, int x) {

		if( x < node.data ) {
			if(node.left != null) {
				insert(node.left, x);
			} else {
				node.left = new Tree(x);
			}
		}
		else {
			if(node.right != null) {
				insert(node.right, x);
			} else {
				node.right = new Tree(x);
			}
		}

	}

	public Integer findMin(Tree node) {

		if(node == null) {
			return null;
		}

		while(node.left != null) {
			node = node.left;
		}

		System.out.println("The MIN element is ::" + node.data);
		return node.data;
	}

	public Integer findMax(Tree node) {

		if(node == null) {
			return null;
		}

		while(node.right != null) {
			node = node.right;
		}

		System.out.println("The MAX element is ::" + node.data);
		return node.data;
	}

	public void deleteNode(Tree node, int x) {
		if()
	}
	/*
	Inorder Traversal 
	*/
	public void traversal(Tree node) {
		if(node != null) {
			traversal(node.left);
			System.out.println(" node.data:: " + node.data);
			traversal(node.right);
		}
	}

	public static void main(String[] args) {
		Tree root = new Tree(10);
		Tree node = root;
		root.insert(node, 5);
		root.insert(root, 15);
		root.insert(root, 1);
		root.insert(root, 7);
		root.insert(root, 6);

		/*Check for non null values*/
		root.findMin(root);
		root.findMax(root);

		root.traversal(root);
		
	}

}