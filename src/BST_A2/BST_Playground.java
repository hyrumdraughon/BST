package BST_A2;

public class BST_Playground {
/*
 * you will test your own BST implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create BST objects,
 * put data into them, take data out, look for values stored
 * in it, checking size and height, and looking at the BST_Nodes
 * to see if they are all linked up correctly for a BST
 * 
*/
  
  public static void main(String[]args){

   // you should test your BST implementation in here
   // it is up to you to test it thoroughly and make sure
   // the methods behave as requested above in the interface
  
   // do not simple depend on the oracle test we will give
   // use the oracle tests as a way of checking AFTER you have done
   // your own testing

   // one thing you might find useful for debugging is a print tree method
   // feel free to use the printLevelOrder method to verify your trees manually
   // or write one you like better
   // you may wish to print not only the node value, and indicators of what
   // nodes are the left and right subtree roots,
   // but also which node is the parent of the current node
	  
	  BST bst = new BST();
	  bst.insert("I");
	  bst.insert("EA");
	  bst.insert("EB");
	  bst.insert("EC");
	  bst.insert("ED");
	  bst.insert("B");
	  bst.insert("A");
	  bst.insert("E");
	  bst.insert("G");
	  bst.insert("H");
	  bst.insert("D");
	  bst.insert("C");
	  bst.insert("F");
	  //bst.insert(s)
	  printLevelOrder(bst);
	  System.out.println(bst.contains("I"));
	  System.out.println(bst.root.getHeight());
	  System.out.println(bst.getRoot().getData());
	  System.out.println(bst.size());
	  System.out.println(bst.findMin());
	  System.out.println(bst.findMax());
	  bst.remove("D");
	  System.out.println(bst.contains("D"));
	  printLevelOrder(bst);
	  System.out.println("\n" + bst.height());
	  System.out.println(bst.size());
	  
	  BST empty = new BST();
	  System.out.println(empty.size());
	  System.out.println(empty.height());
	  System.out.println(empty.findMax());
	  
 
  }

  static void printLevelOrder(BST tree){ 
  //will print your current tree in Level-Order...
  //https://en.wikipedia.org/wiki/Tree_traversal
    int h=tree.getRoot().getHeight();
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    
  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data+" ");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
  static void printInOrder(BST_Node root){
  //will print your current tree In-Order
  if(root!=null){
    printInOrder(root.getLeft());
    System.out.print(root.getData() + " ");
    printInOrder(root.getRight());
  }
  }
}
