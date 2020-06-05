/*
 * CIS 22C - Data Structures
 * Spring 2020
 * 
 * @author Natalie Stepankevycova
 * 
 * This program implements the BinaryTree ADT
*/


public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {
	
	public BinarySearchTree() {
		super();
	} // end default constructor

	public BinarySearchTree(T rootEntry) {
		super();
		setRootNode(new BinaryNode<>(rootEntry));
	} // end constructor

	public void setTree(T rootData) // Disable setTree (see Segment 25.6)
	{
		throw new UnsupportedOperationException();
	} // end setTree

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	} // end setTree

	public boolean contains(T entry) {
		return getEntry(entry) != null;
	} // end contains

	public T getEntry(T entry) {
		return (T) findEntry(getRootNode(), entry);
	} // end getEntry

	private T findEntry(BinaryNode<T> rootNode, T entry) {
		T result = null;
		if (rootNode != null) {
			T rootEntry = (T) rootNode.getData();
			if (entry.equals(rootEntry))
				result = rootEntry;
			else if (entry.compareTo(rootEntry) < 0)
				result = findEntry(rootNode.getLeftChild(), entry);
			else
				result = findEntry(rootNode.getRightChild(), entry);
		} // end if
		return result;
	} // end findEntry

	private T addEntry(BinaryNode<T> rootNode, T newEntry) {
		assert rootNode != null;
		T result = null;
		int comparison = newEntry.compareTo(rootNode.getData());

		if (comparison == 0) // newEntry matches entry in root
		{
			result = rootNode.getData();
			rootNode.setData(newEntry);
		} else if (comparison < 0) // newEntry < entry in root
		{
			if (rootNode.hasLeftChild())
				result = addEntry(rootNode.getLeftChild(), newEntry);
			else
				rootNode.setLeftChild(new BinaryNode<T>(newEntry));
		} else // newEntry > entry in root
		{
			assert comparison > 0;

			if (rootNode.hasRightChild())
				result = addEntry(rootNode.getRightChild(), newEntry);
			else
				rootNode.setRightChild(new BinaryNode<T>(newEntry));
		} // end if

		return result;
	} // end addEntry

	public T remove(T entry) {
		ReturnObject oldEntry = new ReturnObject(null);
		BinaryNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
		setRootNode(newRoot);

		return oldEntry.get();
	} // end remove

	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry, ReturnObject oldEntry) {
		
		if (rootNode != null) {
		
			T rootData = rootNode.getData();
			
			int comparison = entry.compareTo(rootData);
			
			if (comparison == 0) {
				
				oldEntry.set(rootData);
				
				rootNode = removeFromRoot(rootNode);
			
			} else if (comparison < 0){
				
				BinaryNode<T> leftChild = rootNode.getLeftChild();
			
				BinaryNode<T> subtreeRoot = removeEntry(leftChild, entry, oldEntry);
				
				rootNode.setLeftChild(subtreeRoot);
			
			} else {
				BinaryNode<T> rightChild = rootNode.getRightChild();
				rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
			} // end if
		} // end if
		return rootNode;
	} // end removeEntry

	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {
		
	// two children
		if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
			
	// node with largest entry in left subtree
			BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
			
			BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
			
			// replace with root
			rootNode.setData(largestNode.getData());
			
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		} 

		// max one child
		else if (rootNode.hasRightChild())
			
			rootNode = rootNode.getRightChild();
		else
			rootNode = rootNode.getLeftChild();
		
		return rootNode;
	} // end removeEntry

	private BinaryNode<T> findLargest(BinaryNode<T> rootNode) {
		if (rootNode.hasRightChild())
			
			rootNode = findLargest(rootNode.getRightChild());
		
		return rootNode;
	} // end findLargest


	/* Remove node that contains the largest entry 
	 * @param rootnode
	 * @return root node*/
	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
		if (rootNode.hasRightChild()) {
			BinaryNode<T> rightChild = rootNode.getRightChild();
			BinaryNode<T> root = removeLargest(rightChild);
			rootNode.setRightChild(root);
		} else
			rootNode = rootNode.getLeftChild();
		return rootNode;
	} // end removeLargest

	
	private class ReturnObject {
		private T object;

		private ReturnObject(T entry) {
			object = entry;
		} // end constructor

		public T get() {
			return object;
		} // end get

		public void set(T entry) {
			object = entry;
		} // end set
	} // end ReturnObject

	@Override
	public T add(T newEntry) {
		T result = null;
		if (isEmpty())
			
			setRootNode(new BinaryNode<T>(newEntry));
		else
			result = (T) addEntry(getRootNode(), newEntry);
		
		return result;
	} // end add

} // end BinarySearchTree


/*=====================SAMPLE OUTPUT======================
 * 
Tree 1:

     A      
   /   \   
  B     C   
 / \   / \
D   E  F  G 

The tree is not empty
Root of tree is A; s/b A
Height of tree is 3; s/b 3
# nodes in tree is 7; s/b 7

Preorder:
A B D E C F G  Expected
A B D E C F G  Actual using PreorderIterator
A B D E C F G  Actual using iterativePreorderTraverse
---------------

Inorder:
D B E A F C G  Expected
D B E A F C G  Actual using InorderIterator
D B E A F C G  Actual using iterativeInorderTraverse
---------------

PostOrder:
D E B F G C A  Expected
D E B F G C A  Actual using PostorderIterator
---------------

Level order:
A B C D E F G  Expected
A B C D E F G  Actual using LevelOrderIterator
---------------

Tree 2:

     A      
   /   \   
  B     C   
   \   / \
    E  F  G 

The tree is not empty
Root of tree is A; s/b A
Height of tree is 3; s/b 3
# nodes in tree is 6; s/b 6

Preorder:
A B E C F G  Expected
A B E C F G  Actual using PreorderIterator
A B E C F G  Actual using iterativePreorderTraverse
---------------

Inorder:
B E A F C G  Expected
B E A F C G  Actual using InorderIterator
B E A F C G  Actual using iterativeInorderTraverse
---------------

PostOrder:
E B F G C A  Expected
E B F G C A  Actual using PostorderIterator
---------------

Level order:
A B C E F G  Expected
A B C E F G  Actual using LevelOrderIterator
---------------

Tree 3:

     A      
   /   \  
  B     C  
 / \   /  
D   E  F   
        \ 
         G 

The tree is not empty
Root of tree is A; s/b A
Height of tree is 4; s/b 4
# nodes in tree is 7; s/b 7

Preorder:
A B D E C F G  Expected
A B D E C F G  Actual using PreorderIterator
A B D E C F G  Actual using iterativePreorderTraverse
---------------

Inorder:
D B E A F G C  Expected
D B E A F G C  Actual using InorderIterator
D B E A F G C  Actual using iterativeInorderTraverse
---------------

PostOrder:
D E B G F C A  Expected
D E B G F C A  Actual using PostorderIterator
---------------

Level order:
A B C D E F G  Expected
A B C D E F G  Actual using LevelOrderIterator
---------------

Tree 4:

     A      
   /   \   
  B     C   
 / \   / \
D   E  F  G 
 \         
  H         

The tree is not empty
Root of tree is A; s/b A
Height of tree is 4; s/b 4
# nodes in tree is 8; s/b 8

Preorder:
A B D H E C F G  Expected
A B D H E C F G  Actual using PreorderIterator
A B D H E C F G  Actual using iterativePreorderTraverse
---------------

Inorder:
D H B E A F C G  Expected
D H B E A F C G  Actual using InorderIterator
D H B E A F C G  Actual using iterativeInorderTraverse
---------------

PostOrder:
H D E B F G C A  Expected
H D E B F G C A  Actual using PostorderIterator
---------------

Level order:
A B C D E F G H  Expected
A B C D E F G H  Actual using LevelOrderIterator
---------------

Tree 5:

     A      
   /   \   
  B     C   
 / \   / \
D   E  F  G 
     \     
      H     

The tree is not empty
Root of tree is A; s/b A
Height of tree is 4; s/b 4
# nodes in tree is 8; s/b 8

Preorder:
A B D E H C F G  Expected
A B D E H C F G  Actual using PreorderIterator
A B D E H C F G  Actual using iterativePreorderTraverse
---------------

Inorder:
D B E H A F C G  Expected
D B E H A F C G  Actual using InorderIterator
D B E H A F C G  Actual using iterativeInorderTraverse
---------------

PostOrder:
D H E B F G C A  Expected
D H E B F G C A  Actual using PostorderIterator
---------------

Level order:
A B C D E F G H  Expected
A B C D E F G H  Actual using LevelOrderIterator
---------------

Tree 6:

     A      
   /   \   
  B     C   
 / \     \
D   E     H 
   / \     
  F   G     

The tree is not empty
Root of tree is A; s/b A
Height of tree is 4; s/b 4
# nodes in tree is 8; s/b 8

Preorder:
A B D E F G C H  Expected
A B D E F G C H  Actual using PreorderIterator
A B D E F G C H  Actual using iterativePreorderTraverse
---------------

Inorder:
D B F E G A C H  Expected
D B F E G A C H  Actual using InorderIterator
D B F E G A C H  Actual using iterativeInorderTraverse
---------------

PostOrder:
D F G E B H C A  Expected
D F G E B H C A  Actual using PostorderIterator
---------------

Level order:
A B C D E H F G  Expected
A B C D E H F G  Actual using LevelOrderIterator
---------------

Tree 7:

     A      
   /   \     
  B     B     
 / \   / \  
D   E D   E   
   / \   / \
  F   G F   G 

The tree is not empty
Root of tree is A; s/b A
Height of tree is 4; s/b 4
# nodes in tree is 11; s/b 11

Preorder:
A B D E F G B D E F G  Expected
A B D E F G B D E F G  Actual using PreorderIterator
A B D E F G B D E F G  Actual using iterativePreorderTraverse
---------------

Inorder:
D B F E G A D B F E G  Expected
D B F E G A D B F E G  Actual using InorderIterator
D B F E G A D B F E G  Actual using iterativeInorderTraverse
---------------

PostOrder:
D F G E B D F G E B A  Expected
D F G E B D F G E B A  Actual using PostorderIterator
---------------

Level order:
A B B D E D E F G F G  Expected
A B B D E D E F G F G  Actual using LevelOrderIterator
---------------

Test empty tree:
myTree is not null--CORRECT.
myTree is empty--CORRECT.

Testing code in Segment 23.21:
Root of tree contains A
Height of tree is 4
Tree has 8 nodes
A preorder traversal visits nodes in this order:
A B D E F G C H 
Should be 
A B D E F G C H 

Done.
*/

