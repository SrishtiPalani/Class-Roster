// import junit
import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTest {
	LinkedList<String> testList = new LinkedList<String>();

	@Test
	public void isEmptyTest() {
		// check if the test list is an empty Linked List
		assertEquals("Tests if the LinkedList is empty", true,// expected
				testList.isEmpty());
	}

	@Test
	public void sizeTest() {
		// check the size of the initial list created
		assertEquals("Check the size of the Linked List, which should be 0", 0,// expected
																				// answer
				testList.size());
	}

	/**
	 * This test checks the functionality of insertFirst(), getFirst() and
	 * getFirstNode() methods
	 */
	@Test
	public void firstTest() {
		// run insertFirst() method
		testList.insertFirst("a");
		// use assertEquals to check functionality
		assertEquals(
				"Check if new node was added by checking the data of the new first node, which should be 'a'",
				"a", // expected data from new inserted node
				testList.getFirst());
		// test size again
		// assertEquals("The size of the LinkedList should now be 1",
		// 1,
		// testList.size());
	}

	/**
	 * This test checks the functionality of insertAfter() and getFirstNode()
	 * methods
	 */
	@Test
	public void afterTest() {
		// insert new node and data for first node so additional data could be
		// added -- creates working list as starting point
		testList.insertFirst("a");
		// insert new node with data after first node (to be checked) -- run
		// insertAfter() method
		testList.insertAfter(testList.getFirstNode(), "b");
		// use assertEquals to check functionality
		assertEquals(
				"Check if the new node was added after the first node by checking data, which should be 'b'",
				"b",// expected data from this node
				testList.getFirstNode().getNext().getData());
	}

	/**
	 * This test checks the functionality of insertLast(), getLast() and
	 * getLastNode() methods
	 */
	@Test
	public void lastTest() {
		// create working list with nodes with data "a" and "b" in that order
		testList.insertFirst("a");
		System.out.println(testList.getFirstNode().getData());
		testList.insertAfter(testList.getFirstNode(), "b");
		System.out.println(testList.getFirstNode().getNext().getData());
		// fun insertLast method
		testList.insertLast("z");
		System.out.println(testList.getFirstNode().getNext().getNext().getData());
		// use assertEquals to check functionality (getLast() uses getLastNode()
		// method)
		assertEquals(
				"Check if the new node was added to the end of the list, which should have data 'z'",
				"z",// expected data from new node
				testList.getLast());
		// test size again
		assertEquals("The size of the LinkedList should now be 3", 3,
		testList.size());
	}

	/**
	 * This test checks deleteFirst() method
	 */
	@Test
	public void deleteFirstTest() {
		// check working list to deal with (nodes with data "a", "b" and "z" in
		// that order)
		testList.insertFirst("a");
		testList.insertAfter(testList.getFirstNode(), "b");
		testList.insertLast("z");
		// check that delete first works
		testList.deleteFirst();
		// use assertEquals to check functionality
		assertEquals(
				"Testing if first node was deleted, so new first node should have data 'b'",
				"b",// expected data
				testList.getFirst());
	}

	/**
	 * This test checks deleteNext() method
	 */
	@Test
	public void deleteNextTest() {
		// create working list to deal with (nodes with data "a", "b" and "z" in
		// that order)
		testList.insertFirst("a");
		testList.insertAfter(testList.getFirstNode(), "b");
		testList.insertLast("z");
		// run deleteNext method -- intending to delete the second node
		testList.deleteNext(testList.getFirstNode());
		// use assertEquals to check functionality
		assertEquals(
				"Testing if first node was deleted, so second node data should now be 'z'",
				"z",// expected data
				testList.getFirstNode().getNext().getData());
	}

	/**
	 * This test checks deleteLast() method
	 */
	@Test
	public void deleteLastTest() {
		// create working list to deal with (nodes with data "a", "b" and "z" in
		// that order)
		testList.insertFirst("a");
		testList.insertAfter(testList.getFirstNode(), "b");
		testList.insertLast("z");
		// run deleteLast method
		testList.deleteLast();
		// use assertEquals to check functionality
		assertEquals(
				"Testing if first node was deleted, so last data should now be 'b'",
				"b",// expected data
				testList.getLast());
	}

	/**
	 * This test runs the code (testing toString() method) from wiki site.
	 * Console output checked manually to see if it matched wiki site.
	 */
	@Test
	public void toStringTest() {
		// insert "a" at the head
		testList.insertFirst("a");
		System.out.println(testList.toString());
		// insert "v" at the head
		testList.insertFirst("v");
		System.out.println(testList.toString());
		// insert "a" at the head
		testList.insertFirst("a");
		System.out.println(testList.toString());
		// insert "l" at the head
		testList.insertFirst("l");
		System.out.println(testList.toString());
		// insert "o" at the head
		testList.insertFirst("o");
		System.out.println(testList.toString());
		// insert "i" at the head
		testList.insertFirst("i");
		System.out.println(testList.toString());
		// insert "j" after the node following the head node
		testList.insertAfter(testList.getFirstNode().getNext(), "j");
		System.out.println(testList.toString());
		// insert "e" after the node following the head node
		testList.insertAfter(testList.getFirstNode().getNext(), "e");
		System.out.println(testList.toString());
		// insert "v" after the node following the head node
		testList.insertAfter(testList.getFirstNode().getNext(), "v");
		System.out.println(testList.toString());
		// insert "l" after the head node
		testList.insertAfter(testList.getFirstNode(), "l");
		System.out.println(testList.toString());
		// delete the node after the node after the node after the node after
		// the node after the head node
		testList.deleteNext(testList.getFirstNode().getNext().getNext()
				.getNext().getNext());
		System.out.println(testList.toString());

	}

}
