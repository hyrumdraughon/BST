package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

@Override
public boolean insert(String s) {
	if (this.root == null) {
		this.root = new BST_Node(s);
		size++;
		return true;
	} else {
		boolean tf = this.root.insertNode(s);
		if (tf) {
			size++;
		}
		return tf;
	}
}

@Override
public boolean remove(String s) {
	if(!this.contains(s)) {
		return false;
	} else if (this.root.getData().equals(s)) {
		if (this.root.left == null && this.root.right == null) {
			this.root = null;
			size--;
			return true;
		} else if (this.root.left != null && this.root.right == null) {
			this.root = this.root.left;
			size--;
			return true;
		} else if (this.root.left == null && this.root.right != null) {
			this.root = this.root.right;
			size--;
			return true;
		} else {
			//findMin
			BST_Node rightMin = this.root.right;
			while (rightMin.left != null) {
				rightMin = rightMin.left;
			}
			this.root.data = rightMin.data;
			this.root.right.removeNode(rightMin.data);
			size--;
			return true;
		}
	} else {
		boolean tf = this.root.removeNode(s);
		if (tf) {
			size--;
		}
		return tf;
	}
}

@Override
public String findMin() {
	if (size == 0) {
		return null;
	} else {
		return this.root.findMin();
	}
}

@Override
public String findMax() {
	if (size == 0) {
		return null;
	} else {
		return this.root.findMax();
	}
}

@Override
public boolean empty() {
	if (this.size() == 0) {
		return true;
	} else {
		return false;
	}
}

@Override
public boolean contains(String s) {
	if (size == 0) {
		return false;
	} else {
		return this.root.containsNode(s);
	}
}

@Override
public int size() {
	return this.size;
}

@Override
public int height() {
	if (empty()) {
		return -1;
	} else {
		return (this.root.getHeight());
	}
}

}