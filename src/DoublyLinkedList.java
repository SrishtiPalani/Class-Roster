/**
 * Doubly Linked List is a linear data structure in which each node holds fields
 * that reference the next and the previous nodes in the sequence
 * 
 * @author SrishtiPalani
 */
public class DoublyLinkedList<T> extends LinkedList<T> {
	// the single instance field which holds the tail node
	protected DoublyLinkedListNode<T> tail;

	/**
	 * Constructor
	 */
	public DoublyLinkedList() {
		super();
		// tail = null;
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
	public DoublyLinkedListNode<T> getFirstNode() {
		if (head != null) {
			return (DoublyLinkedListNode<T>) this.head;
		} else {
			return null;
		}

	}

	/**
	 * Get data stored in tail node of list.
	 **/
	public T getLast() {
		// set a LinkedListNode to get the current Node
		DoublyLinkedListNode<T> currentNode = (DoublyLinkedListNode<T>) head;
		// As long as there is a node with data after the current Node
		while (currentNode.getNext() != null) {
			// shift to set the next node as the current Node
			currentNode = (DoublyLinkedListNode<T>) currentNode.getNext();
		}
		// When there is no node after the current Node return the data in the
		// current Node
		return currentNode.getData();
	}

	/**
	 * Get the tail node of the list.
	 **/
	public DoublyLinkedListNode<T> getLastNode() {
		// if the head is null
		if (head == null) {
			return null;
		} else {
			// set a LinkedListNode to get the current Node
			DoublyLinkedListNode<T> currentNode = (DoublyLinkedListNode<T>) head;
			// As long as there is a node with data after the current Node
			while (currentNode.getNext() != null) {
				// shift to set the next node as the current Node
				currentNode = (DoublyLinkedListNode<T>) currentNode.getNext();
			}
			// When there is no node after the current Node return the data in
			// the
			// current Node
			return currentNode;
		}
	}

	/**
	 * Insert a new node with data at the head of the list.
	 **/
	public void insertFirst(T data) {
		// make a new node
		DoublyLinkedListNode<T> firstNode = new DoublyLinkedListNode<T>();
		firstNode.setData(data);
		if (head != null) {
			insertFirstNode(firstNode);
		} else {
			head = firstNode;
			head.setNext(null);
		}

	}

	/**
	 * Insert the node at the head of the list
	 **/
	public void insertFirstNode(DoublyLinkedListNode<T> node) {
		// set the previous of the node we're currently on to point to the
		// passed in node
		((DoublyLinkedListNode<T>) head).setPrevious(node);
		// have the new node point to the old head
		node.setNext(head);
		// Set the new node as the head
		head = node;
	}

	/**
	 * Insert a new node with data after currentNode
	 **/
	public void insertAfter(DoublyLinkedListNode<T> currentNode, T data) {
		System.out.println("The current node is: " + currentNode
				+ " and the data being inserted is: " + data);
		System.out.println("The next node is: " + currentNode.getNext());

		// if the next points to null
		if (currentNode.getNext() == null) {
			// make a new node
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();
			// /add data to this node
			newNode.setData(data);
			// set the node to be the new node
			currentNode.setNext(newNode);
			// set the new node to point to the current node
			newNode.setPrevious(currentNode);

		}

		else {
			// make a new node
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();
			// /add data to this node
			newNode.setData(data);

			// set the pointer for the next node to point to the previous (new)
			// node
			((DoublyLinkedListNode<T>) currentNode.getNext())
					.setPrevious(newNode);

			// set the pointer for the new node to point to the next node
			newNode.setNext(currentNode.getNext());

			// set the current node to point to the new node
			currentNode.setNext(newNode);

			// set the new node to point to the current node
			newNode.setPrevious(currentNode);
		}
	}

	/**
	 * Insert a new node with data at the tail of the list.
	 **/
	public void insertLast(T data) {
		// make a new node
		DoublyLinkedListNode<T> lastNode = new DoublyLinkedListNode<T>();

		// if the list is empty
		if (head == null) {
			// insert at the first node
			insertFirst(data);
		}
		// otherwise
		else {
			// /add data to this node
			lastNode.setData(data);
			// invoke insertafter to link up the new node
			insertAfter(getLastNode(), data);
		}
	}

	/**
	 * Remove head node
	 **/
	// @Override
	public void deleteFirst() {
		// if the head isn't null
		if (head != null){
			if (head.getNext() != null) {
				// have the head be whatever the next node is
				head = head.getNext();
				((DoublyLinkedListNode<T>) head).setPrevious(null);
			} 
			else {
				head = null;
			}
		}
	}

	/**
	 * Remove tail node
	 **/
	public void deleteLast() {
		// if the head is null
		if (head == null) {
			// just stop, leave the function
			return;
		}
		// if the node after the head is null
		if (head.getNext() == null) {
			// set the head to be null
			head = null;
			// just stop, leave the function
			return;
		}

		// Declare variables
		// node goes through to get the last node
		// previous holds the value of the previous node
		DoublyLinkedListNode<T> node = (DoublyLinkedListNode<T>) head;
		DoublyLinkedListNode<T> previous = (DoublyLinkedListNode<T>) head;
		// while the node after the current node isn't null
		while (node.getNext() != null) {
			// set previous equal to node
			previous = node;
			// have node equal the node after the current node
			node = (DoublyLinkedListNode<T>) node.getNext();
		}
		// leave the while loop if the node after current node is null
		// set the previous node (before incrementing) to null
		previous.setNext(null);
	}

	/**
	 * Remove node following currentNode If no node exists (i.e., currentNode is
	 * the tail), do nothing
	 **/
	public void deleteNext(DoublyLinkedListNode<T> currentNode) {
		// if the node after the current node is not null and if the node after
		// the node after the current node isn't null
		if (!currentNode.getNext().equals(null)
				&& !currentNode.getNext().getNext().equals(null)) {
			// have the current node point to the node after the node after the
			// current node
			currentNode.setNext(currentNode.getNext().getNext());
			// set the previous pointer of the current node's next node to point
			// to the current node
			((DoublyLinkedListNode<T>) currentNode.getNext().getNext())
					.setPrevious(currentNode);
		}
	}

	/**
	 * Remove node before currentNode If no node exists (i.e., currentNode is
	 * the tail), do nothing
	 **/
	public void deletePrevious(DoublyLinkedListNode<T> currentNode) {
		if (!currentNode.getPrevious().equals(null)	&& !currentNode.getPrevious().getPrevious().equals(null)) 
		{
			// update pointer of the current node to the next next
			currentNode.setPrevious(currentNode.getPrevious().getPrevious());
			// update pointer of the current node's next to next node's previous
			// to the currentNode
			((DoublyLinkedListNode<T>) currentNode.getPrevious().getPrevious())
					.setNext(currentNode);
		}
		// if the current node is the second element with the previous one being
		// the head
		else if (currentNode.getPrevious() == head) {
			// set the head to current node to
			head = currentNode;
			((DoublyLinkedListNode<T>) head).setPrevious(null);	
		} 
		else// if there's no previous node
		{
			currentNode.setPrevious(currentNode.getPrevious().getPrevious());
			currentNode.getPrevious().setNext(currentNode);
			// exit out
			return;
		}
	}

	/**
	 * Return the number of nodes in this list.
	 **/
	public int size() {
		// set a LinkedListNode to get the current Node
		DoublyLinkedListNode<T> currentNode = (DoublyLinkedListNode<T>) head;
		int listSize = 0;
		// As long as there is a node with data after the current Node
		while (currentNode != null) {
			listSize = listSize + 1;
			// shift to set the next node as the current Node
			currentNode = (DoublyLinkedListNode<T>) currentNode.getNext();
		}
		return listSize;
	}

	/**
	 * Return a String representation of the list.
	 **/
	public String toString() {
		// create a string that holds the value of the list
				// held inside curly braces for my viewing pleasure
				String s = "";
				// if the list is not empty
				if (isEmpty() != true) {
					// create a node and set it to the head
					DoublyLinkedListNode<T> curNode = (DoublyLinkedListNode<T>) head;
					// while the current node isn't null
					while (curNode != null) {
						// add the data in the node to my string
						s += curNode.getData();
						// set current node to be the next node
						curNode = (DoublyLinkedListNode<T>) curNode.getNext();
						s+="\n";
					}
				}
				// return the final string
				return s;
	}

}
