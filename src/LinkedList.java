public class LinkedList<T> {
	// the single instance field which holds the head node
	protected LinkedListNode<T> head;

	/**
	 * Constructor, initialize the instance field head to null
	 */
	public LinkedList() {
		head = null;
	}

	/**
	 * Get data stored in head node of list.
	 **/
	public T getFirst() {
		return getFirstNode().getData();
	}

	/**
	 * Get the head node of the list.
	 **/
	public LinkedListNode<T> getFirstNode() {
		return this.head;
	}

	/**
	 * Get data stored in tail node of list.
	 **/
	public T getLast() {
		// set a LinkedListNode to get the current Node
		LinkedListNode<T> currentNode = head;
		// As long as there is a node with data after the current Node
		while (currentNode.getNext() != null) {
			// shift to set the next node as the current Node
			currentNode = currentNode.getNext();
		}
		// When there is no node after the current Node return the data in the
		// current Node
		return currentNode.getData();
	}

	/**
	 * Get the tail node of the list.
	 **/
	public LinkedListNode<T> getLastNode() {
		// set a LinkedListNode to get the current Node
		LinkedListNode<T> currentNode = head;
		// As long as there is a node with data after the current Node
		while (currentNode.getNext() != null) {
			// shift to set the next node as the current Node
			currentNode = currentNode.getNext();
		}
		// When there is no node after the current Node return the data in the
		// current Node
		return currentNode;
	}

	/**
	 * Insert a new node with data at the head of the list.
	 **/
	public void insertFirst(T data) {
		// make a new node
		LinkedListNode<T> firstNode = new LinkedListNode<T>();
		firstNode.setData(data);
		insertFirstNode(firstNode);
	}

	/**
	 * Insert the node at the head of the list
	 **/
	public void insertFirstNode(LinkedListNode<T> node) {
		// have the new node point to the old head
		node.setNext(head);
		// Set the new node as the head
		head = node;
	}

	/**
	 * Insert a new node with data after currentNode
	 **/
	public void insertAfter(LinkedListNode<T> currentNode, T data) {
		// create a new linkedListNode
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		// assign that node some data
		newNode.setData(data);
		// point new node where current pointer is
		newNode.setNext(currentNode.getNext());
		// set head pointer to this new node
		currentNode.setNext(newNode);
	}

	/**
	 * Insert a new node with data at the tail of the list.
	 **/
	public void insertLast(T data) {
		if (isEmpty()==true){
			insertFirst(data);
		}
		else{
		insertAfter(getLastNode(), data);
		}
	}

	/**
	 * Remove head node
	 **/
	public void deleteFirst() {
		// change the pointer of the head pointer
		head = head.getNext();
	}

	/**
	 * Remove tail node
	 **/
	public void deleteLast() {
		// set a LinkedListNode to get the current Node
		LinkedListNode<T> currentNode = head;
		// when the next to next node is null
		while (currentNode.getNext().getNext() != null) {
			currentNode = currentNode.getNext(); 
			}
		// set the current node to be null
					currentNode.setNext(null);
	}

	/**
	 * Remove node following currentNode If no node exists (i.e., currentNode is
	 * the tail), do nothing
	 **/
	public void deleteNext(LinkedListNode<T> currentNode) {
		// update pointer of the current node to the next next
		currentNode.setNext(currentNode.getNext().getNext());
	}

	/**
	 * Return the number of nodes in this list.
	 **/
	public int size() {
		// set a LinkedListNode to get the current Node
		LinkedListNode<T> currentNode = head;
		int listSize = 0;
		// As long as there is a node with data after the current Node
		while (currentNode != null) {
			listSize = listSize + 1;
			// shift to set the next node as the current Node
			currentNode = currentNode.getNext();
		}
		return listSize;
	}

	/**
	 * Check if list is empty.
	 * 
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty() {
		// As the head links all the next data, if the head is empty then the
		// LinkedList is empty
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Return a String representation of the list.
	 **/
	public String toString() {
		// set a LinkedListNode to get the current Node
		LinkedListNode<T> currentNode = head;
		String s = "{";
		// As long as there is a node with data after the current Node
		while (currentNode != null) {
			s = s + " " + currentNode.getData();
			// shift to set the next node as the current Node
			currentNode = currentNode.getNext();
			}
		// When there is no node after the current Node return the data in the
		// current Node
		s = s + "}";
		System.out.println("The list is " + s);
		return s;
	}

}
