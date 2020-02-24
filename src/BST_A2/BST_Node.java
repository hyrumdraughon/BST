package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  public boolean containsNode(String s) {
	  if (this.data.equals(s)) {
		  return true;
	  } else if (this.data.compareTo(s) > 0) {
		  if (this.left == null) {
			  return false;
		  } else {
			  return this.left.containsNode(s);
		  }
	  } else {
		  if (this.right == null) {
			  return false;
		  } else {
			  return this.right.containsNode(s);
		  }
	  }
  }
  
  public boolean insertNode(String s) {
	  if (this.data.equals(s)) {
		  return false;
	  } else if (this.data.compareTo(s) > 0) {
		  if (this.left == null) {
			  this.left = new BST_Node(s);
			  return true;
		  } else {
			  return this.left.insertNode(s);
		  }
	  } else {
		  if (this.right == null) {
			  this.right = new BST_Node(s);
			  return true;
		  } else {
			  return this.right.insertNode(s);
		  }
	  }
  }
  
  public boolean removeNode(String s) { 
	  if (this.data.compareTo(s) > 0) {
		  if (this.left.data.equals(s)) {
			  //3 remove types
			  //1--------------------------------------------------
			  if (this.left.left == null && this.left.right == null) {
				  this.left = null;
				  return true;
			//2-----------------------------------------------
			  } else if (this.left.left != null && this.left.right == null) {
				  this.left = this.left.left;
				  return true;
			  } else if (this.left.left == null && this.left.right != null) {
				  this.left = this.left.right;
				  return true;
			//3------------------------------------------------------
			  } else {
				  //findMin
				  BST_Node rightMin = this.left.right;
				  while (rightMin.left != null) {
					  rightMin = rightMin.left;
				  }
				  this.left.data = rightMin.data;
				  this.left.removeNode(rightMin.getData());
				  return true;
			  }
		  } else {
			  return this.left.removeNode(s);
		  }
	  } else {
		  if (this.right.data.equals(s)) {
			  //3 remove types
			  //1-------------------------------------------------
			  if (this.right.left == null && this.right.right == null) {
				  this.right = null;
				  return true;
			  } else if (this.right.left != null && this.right.right == null) {
				  this.right = this.right.left;
				  return true;
			  } else if (this.right.left == null && this.right.right != null) {
				  this.right = this.right.right;
				  return true;
			  } else {
				  //findMin
				  BST_Node rightMin = this.right.right;
				  while (rightMin.left != null) {
					  rightMin = rightMin.left;
				  }
				  this.right.data = rightMin.data;
				  this.right.removeNode(rightMin.getData());
				  return true;
			  }
		  } else {
			  return this.right.removeNode(s);
		  }
	  }
  }
  
  public String findMin() {
	 if (this.left == null) {
		 return this.getData();
	 } else {
		 return this.left.findMin();
	 }
  }
  
  public String findMax() {
	 if (this.right == null) {
		 return this.getData();
	 } else {
		 return this.right.findMax();
	 }
  }
  
  public int getHeight() {
	 if (this.left == null && this.right == null) {
		 return 0;
	 } else {
		 int leftHeight;
		 int rightHeight;
		 //leftHeight
		 if (this.left == null) {
			 leftHeight = 0;
		 } else {
			 leftHeight = this.left.getHeight();
		 }
		 //rightHeight
		 if (this.right == null) {
			 rightHeight = 0;
		 } else {
			 rightHeight = this.right.getHeight();
		 }
		 //findMax between L and R heights
		 if (leftHeight > rightHeight) {
			 return (leftHeight + 1);
		 } else {
			 return (rightHeight + 1); 
		 }
	 }
  }
  

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}