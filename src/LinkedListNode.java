public class LinkedListNode<T> {
	protected T data; // data stored in the node
	protected LinkedListNode<T> next; // pointer to the next node in the list

	/**
	 * Get the data stored at this node.
	 **/
	public T getData() {
		return data;
	}

	/**
	 * Set the data stored at this node.
	 **/
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Get (pointer to) next node.
	 **/
	public LinkedListNode<T> getNext() {
		return next;
	}

	/**
	 * Set the next pointer to passed node.
	 **/
	public void setNext(LinkedListNode<T> node) {
		this.next = node;
	}

	/**
	 * Returns a String representation of this node.
	 **/
	public String toString() {
		return data.toString();
	}

}
