/**
 * Roster Program to keep track of students during the add/drop period
 * Add/Remove student while maintaining the alphabetical order of the list
 * Roster in form "Lastname, Firstname" Also, has a unsorted wait list
 * 
 * @author SrishtiPalani
 */
public class RosterProgram 
{
// list to hold the enrolled students
protected DoublyLinkedList<String> students = new DoublyLinkedList<String>();
// list to hold the wait listed students
protected DoublyLinkedList<String> waitlist = new DoublyLinkedList<String>();
// variable that holds the amount of students allowed to enroll in the class
protected int classSize = 5;

	/*
	 * Constructor for the Roster Program
	 */
	public RosterProgram() 
	{

	}

	/*
	 * method to get a string of the enrolled students
	 */
	protected String getStudents() {
		return students.toString();
	}

	/*
	 * method to get a string of the wait listed students
	 */
	protected String getWaitlist() {
		return waitlist.toString();
	}

	/**
	 * Alphabetizes the roster: sort the list alphabetically & insert the name
	 * after the appropriate node
	 */
	public void sortRoster(DoublyLinkedList<String> list, String name) {
		// Get the first node of the list
		DoublyLinkedListNode<String> currentNode = list.getFirstNode();
		// boolean shows if the list is sorted
		boolean sorted = false;

		System.out.println("**********");
		System.out.println("INPUTS");
		System.out.println(list.toString());
		System.out.println(name);
		System.out.println("**********");

		System.out.println("Compared to the first, I go: "
				+ name.compareToIgnoreCase(list.getFirst()));
		System.out.println("Compared to the last, I go: "
				+ name.compareToIgnoreCase(list.getLast()));

		// if the name needs to be at the start of the list:
		if (name.compareToIgnoreCase(list.getFirst()) < 0) {
			// create a new node
			DoublyLinkedListNode<String> first = new DoublyLinkedListNode<String>();
			// set the data of the node to be the name
			first.setData(name);
			// insert the new node at the first node position
			list.insertFirstNode(first);
			// set sorted to true
			sorted = true;
			return;
		}
		// if the name is at the end of the list
		else if (name.compareToIgnoreCase(list.getLast()) > 0) {
			// insert the new data at the last node position
			list.insertLast(name);
			// set sorted to true
			sorted = true;
			return;
		}
		// otherwise, it's somewhere in the middle...
		else {
			// while it's not sorted
			while (!sorted) {
				// if the name goes after the current node
				if (name.compareToIgnoreCase(currentNode.getData()) > 0) {
					// if the name goes before the next node
					if (name.compareToIgnoreCase(currentNode.getNext()
							.getData()) < 0) {
						System.out
								.println("I am in the right position, inserting after the current node which is: "
										+ currentNode.getData());
						// SORTED!!! Insert at the position after the current
						// node
						list.insertAfter(currentNode, name);
						// it is sorted
						sorted = true;
						// stop the while loop
						break;
					}
					// update current node to be the next node
					currentNode = (DoublyLinkedListNode<String>) currentNode
							.getNext();
				}
			}
		}
	}

/**
 * 
 * Update either the enrolled or waitlist doubly linked list behavior =
 * "add" or "remove"
 */
	public void updateStudent(String name, String behavior) {
		if (behavior.equals("add")) {
			addStudent(name);
		} 
		else if (behavior.equals("remove")){
			removeStudent(name);
		}

		System.out.println("                                                    ");
		System.out.println("The registered list is: " + students.toString());
		System.out.println("the waitlisted list is: " + waitlist.toString());
		System.out
				.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	/**
	 * add a student to either the registered or waitlist doubly linked lists
	 * 
	 * @param name
	 */

	public void addStudent(String name) {
		System.out.println("There are " + students.size()
				+ " students in the class before me");
		// If there are less students than allowed, allow the student into the
		// class
		if (students.size() < classSize) 
		{
			System.out.println("The size is less than numAllowed(5)");
			// if there are no students enrolled
			if (students.getFirstNode() == null) {
				System.out.println("This is the first node");
				// insert the name in the first slot
				students.insertFirst(name);
			}
			// otherwise
			else {
				System.out.println("I am being added to the enrolled students");
				// sort the list alphabetically & insert the name after the
				// appropriate node
				sortRoster(students, name);
			}
		}
		// otherwise waitlist the student
		else {
			// insert the student at the last spot
			// Does NOT need to be sorted!!!!
			waitlist.insertLast(name);
		}
	}

	/**
	 * removes the student from either list
	 * 
	 * @param name
	 */
	public void removeStudent(String name) 
	{// current node variable
		DoublyLinkedListNode<String> currentNode = students.getFirstNode();
		// if the name exists = true
		boolean exists = false;
		// if the name exists = true
		boolean isPresent = false;

		if (students.isEmpty() == false && students.getFirst().equals(name)){
			students.deleteFirst();
			return;
		}
		if (waitlist.isEmpty() == false && waitlist.getFirst().equals(name)){
			waitlist.deleteFirst();
			return;
		}
		

		// check if the name is in the enrolled list
		while (!exists) {
			if (currentNode.getData().equals(name)) 
			{
				if (currentNode == students.getLastNode()) {
					students.deleteLast();
				} 
				else {
					System.out.println("Ready to remove...");
					// if so, remove the name by setting the next pointer from
					// the previous node to the node after the current node
					students.deletePrevious((DoublyLinkedListNode<String>) currentNode
							.getNext());
				}
				// check the size of the list. If it is less than the allowed
				// amount, take a student from the waitlisted list
				while (students.size() < classSize && waitlist.isEmpty() == false) {
						addStudent(waitlist.getFirstNode().getData());
						// remove the student (firstnode of waitlisted)
						waitlist.deleteFirst();
				}
				exists = true;
				break;
			}

			// if the current node is the last in the list
			else if (currentNode.getNext() == null) 
			{
				// break from the while loop
				break;
			}
			else{
				currentNode = (DoublyLinkedListNode<String>) currentNode.getNext();
			}
			
		}

		// update current node to be the waitlisted first node
		currentNode = waitlist.getFirstNode();

		// check if the waitlist is not empty.
		if (waitlist.getFirstNode() != null) {
			// check if the name is in the waitlisted list
			while (!isPresent) {
				
				if (currentNode.getData().equals(name)) {
					
					if (currentNode == waitlist.getLastNode()) {
						waitlist.deleteLast();
						return;
					} 
					else{
					// if so, remove the name by setting the next pointer from
					// the previous node to the node after the current node
					waitlist.deletePrevious((DoublyLinkedListNode<String>) currentNode.getNext());
					isPresent = true;
					break;
					}
				}
				// if the current node is the last in the list
				if (currentNode.getNext() == null) {
					// break from the while loop
					break;
				}
				currentNode = (DoublyLinkedListNode<String>) currentNode.getNext();
			}
		}
	}
}

