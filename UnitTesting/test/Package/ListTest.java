package Package;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ListTest {

	ArrayList<Integer> list = new ArrayList<Integer>();

	
	@Before
	@Test
	public void testAdditions(){
		list.clear();
		int size = 5;
		for(int i = 0; i<size; i++) {
			list.add(i);
		}
		assertEquals(size, list.size());
	}
	
	@Test
	public void testGetSize() {
		ArrayList<Integer> newList = new ArrayList<>();
		assertEquals(0, newList.size());
		for(int i = 0; i<100; i++) {
			newList.add(i);
			assertEquals(i, newList.size()-1);
		}
		for(int i = newList.size()-1; i>=0; i--) {
			newList.remove(i);
			assertEquals(i, newList.size());
		}
	}
	
	@Test
	public void testDeletionsByObject() {
		ArrayList<String> listOfStrings = new ArrayList<>();
		listOfStrings.add("one");
		listOfStrings.add("two");
		listOfStrings.add("three");
		assertEquals(3, listOfStrings.size());
		listOfStrings.remove("one");
		assertEquals(2, listOfStrings.size());
	}
	
	@Test
	public void testIndexOf() {
		ArrayList<String> listOfStrings = new ArrayList<>();
		listOfStrings.add("one");
		listOfStrings.add("two");
		listOfStrings.add("three");
		assertEquals(2, listOfStrings.indexOf("three"));
		assertEquals(1, listOfStrings.indexOf("two"));
		assertEquals(0, listOfStrings.indexOf("one"));
	}

	@Test
	public void testDeletionsByIndex() {
		for(int i = list.size()-1; i>=0; i--) {
			list.remove(i);
		}
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testClear() {
		assertTrue(!list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testIsEmpty() {
		assertFalse(list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testContains() {
		for(int i = 0; i<list.size(); i++) {
			assertTrue(list.contains(i));
		}
	}
	
	@Test
	public void testGet() {
		for(int i = 0; i<list.size(); i++) {
			assertEquals((Integer)i, list.get(i));
		}
	}
	

	
	@Test
	public void testShallowCopying() {
		for(int i =0; i<list.size(); i++) {
			assertTrue(list.get(i) == i);
		}
		ArrayList<Integer> newList = list;
		for(int i =0; i<newList.size(); i++) {
			assertTrue(newList.get(i) == i);
		}
		
		for(int i = 0; i<list.size(); i++) {
			assertTrue(list.get(i) == newList.get(i));
		}
		
		for(int i = 0; i<list.size(); i++) {
			list.set(i, i*2);
		}
		
		for(int i = 0; i<list.size(); i++) {
			assertTrue(newList.get(i) == i*2);
		}
		
		list.remove(list.size()-1);
		assertTrue(list.size() == newList.size());
	}
	
	@Test
	public void testSet() {
		for(int i = 0; i<list.size(); i++) {
			assertEquals((Integer)i, list.get(i));
			list.set(i, i*2);
			assertEquals((Integer)(i*2), list.get(i));
		}
	}
	
	@Test
	public void testAddAt() {
		list.add(0, 10);
		assertEquals((Integer)10, list.get(0));
	}

}
