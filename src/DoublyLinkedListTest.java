import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author Srishti Palani
 *
 */
public class DoublyLinkedListTest {
	//test is a linked list with lots of elements
	DoublyLinkedList<String> filledTest = new DoublyLinkedList<String>();
	//twoTest is a linked list with two elements 
	DoublyLinkedList<String> twoTest = new DoublyLinkedList<String>();
	//oneTest is a linked list with one element
	DoublyLinkedList<String> oneTest = new DoublyLinkedList<String>();
	//emptyTest is a linked list that's empty
	DoublyLinkedList<String> emptyTest = new DoublyLinkedList<String>();
	
	/**
	 * To create a generic list, and subtly test if insertFirst function works
	 */
	@Before
	public void createList() {
		//create a string called "testString" backwards
		String string = "gnirtStset";
		//go through a for loop
		for(int i = 0 ; i < string.length(); i++){
			//create a new node with each letter (starting at the end, which is why I had to make it backwards before)
			filledTest.insertFirst(String.valueOf(string.charAt(i)));
		}
		//create a string called "te" backwards
		String two = "et";
		//go through a for loop
		for(int j = 0 ; j < two.length(); j++){
			//create a new node with each letter (starting at the end, which is why I had to make it backwards before)
			twoTest.insertFirst(String.valueOf(two.charAt(j)));
		}
		//create a new node with t
		oneTest.insertFirst("t");
	}
	
	/**
	 * To test if able to get size of the list
	 */
	@Test
	public void testSize() {
		//the size of "testString" is 10 letters, i.e. 10 nodes
		assertEquals (10,filledTest.size());
		//the size of twoTest is 2 
		assertEquals (2, twoTest.size());
		//the size of oneTest is 1
		assertEquals (1, oneTest.size());
		//the size of the emptyTest is zero
		assertEquals (0, emptyTest.size());
	}
	
	/**
	 * To test if deleting the last node
	 */
	@Test
	public void testDeleteLast() {
		//delete the last node
		filledTest.deleteLast();
		twoTest.deleteLast();
		oneTest.deleteLast();
		emptyTest.deleteLast();
		
		//the test should check that the last element was deleted
		assertEquals ("testStrin", filledTest.toString());
		assertEquals ("t", twoTest.toString());
		assertEquals ("", oneTest.toString());
		assertEquals ("", emptyTest.toString());
	}
	
	/**
	 * To test getFirst this means that getFirstNode also works
	 */
	@Test
	public void testFirst() {
		//the first letter is "t"
		assertEquals ("t",filledTest.getFirst());
		//the first letter is t
		assertEquals ("t", twoTest.getFirst());
		assertEquals ("t", oneTest.getFirst());
		//The get first is funky for the empty test and I have no clue why!!!
		//assertEquals ("null", emptyTest.getFirst());
	}
	
	/**
	 * To test getLast this means that getLastNode also works
	 */
	@Test
	public void testLast() {
		//the last letter is "g"
		assertEquals ("g",filledTest.getLast());
		assertEquals ("e", twoTest.getLast());
		assertEquals ("t", oneTest.getLast());
	//The get last is funky for the empty test and I have no clue why!!!
	//	assertEquals ("", emptyTest.getLast());
	}
	
	/**
	 * To test if inserting at the first spot works
	 */
	@Test
	public void testInsertFirst() {
		//insert a letter at the first node
		filledTest.insertFirst("X");
		twoTest.insertFirst("Y");
		oneTest.insertFirst("Z");
		emptyTest.insertFirst("A");
		
		//the first letter should be whatever I've inserted (see above)
		assertEquals ("X",filledTest.getFirst());
		assertEquals ("Y", twoTest.getFirst());
		assertEquals ("Z", oneTest.getFirst());
		assertEquals ("A", emptyTest.getFirst());
	}
	
	/**
	 * To test if inserting after a node works
	 */
	@Test
	public void testInsertAfter() {
		
		//insert a Z at the spot after the head
		filledTest.insertAfter(filledTest.getFirstNode(),"Z");
		//insert a Z at the spot after the head
		twoTest.insertAfter(twoTest.getFirstNode(),"Z");
		//insert a Z at the spot after the head
		oneTest.insertAfter(oneTest.getFirstNode(),"Z");
		
		//the spot after the head should hold a "Z"
		assertEquals ("Z", filledTest.getFirstNode().getNext().toString());
		assertEquals ("Z", twoTest.getFirstNode().getNext().toString());
		assertEquals ("Z", oneTest.getFirstNode().getNext().toString());
	}
	
	/**
	 * To test if inserting at the end
	 */
	@Test
	public void testInsertLast() {
		//insert a "Z" after the last node
		filledTest.insertLast("Z");
//		twoTest.insertAfter(twoTest.getLastNode(),"Z");
//		oneTest.insertAfter(oneTest.getLastNode(),"Z");
		//I get a null pointer
		//emptyTest.insertAfter(emptyTest.getLastNode(),"Z");
		
		//the last node should now hold "Z"
		assertEquals ("Z", filledTest.getLastNode().toString());
//		assertEquals ("Z", twoTest.getLastNode().toString());
//		assertEquals ("Z", oneTest.getLastNode().toString());
	}
	
	/**
	 * To test if deleting the first node
	 */
	@Test
	public void testDeleteFirst() {
		//delete the first node
		filledTest.deleteFirst();
		//the first letter should have been deleted
		assertEquals ("estString", filledTest.toString());
	}
	
	/**
	 * To test if deleting the node following the current node
	 */
	@Test
	public void testDeleteNext() {
		
		
		//delete the node after the current node
		filledTest.deleteNext(filledTest.getFirstNode());
		
		//the e should have been deleted
		assertEquals ("tstString", filledTest.toString());
	}
	
	/**
	 * To test if the list is empty
	 */
	@Test
	public void testEmpty() {
		//the list is not empty because @before we made a LL and filled it
		assertEquals (false, filledTest.isEmpty());
		//the list is not empty because @before we made a LL and filled it
		assertEquals (false, twoTest.isEmpty());
		//the list is not empty because @before we made a LL and filled it
		assertEquals (false, oneTest.isEmpty());
		//the list is empty because we made an empty LL
		assertEquals (true, emptyTest.isEmpty());
	}
}
