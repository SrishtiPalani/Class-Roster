/**
 * Doubly Linked List is a linear data structure 
 * in which each node holds fields that reference the next and the previous nodes 
 * in the sequence 
 * 
 * @author SrishtiPalani
 */
public class DoublyLinkedListNode <T>  extends LinkedListNode<T>
{
	// pointer to the previous node in the list
	protected DoublyLinkedListNode<T> previous; // pointer to the previous node in the list

	/**
	 * Get (pointer to) previous node.
	 **/
	protected DoublyLinkedListNode<T> getPrevious() {
		return previous;
	}

	/**
	 * Set the previous pointer to passed node.
	 **/
	protected void setPrevious(DoublyLinkedListNode<T> previousNode) {
		this.previous = previousNode;
	}
	
	

}
