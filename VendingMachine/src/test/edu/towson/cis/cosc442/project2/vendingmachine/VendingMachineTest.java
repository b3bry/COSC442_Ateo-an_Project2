package test.edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine;
import edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineException;
import edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem;

public class VendingMachineTest {
	VendingMachine vm;
	VendingMachineItem chips;
	VendingMachineItem coke;
	@Before
	public void setUp() throws Exception {
		vm = new VendingMachine();
		chips = new VendingMachineItem("chips",9.99);
		coke = new VendingMachineItem("coke",1.99);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * vanilla test of add item
	 * Verifies postcondition
	 * 
	 */
	@Test
	public void testAddItem() {
		vm.addItem(chips, "A");
		assertEquals("chips",vm.removeItem("A").getName());
	}
	
	/**
	 * Tests when an item is added into an occupied slot
	 * 
	 */
	@Test(expected=VendingMachineException.class)
	public void testAddItem_SameSlot(){
		vm.addItem(chips, "A");
		vm.addItem(coke, "A");
	}
	
	/**
	 * Tests when an item is added into a slot that doesn't exist
	 */
	@Test(expected=VendingMachineException.class)
	public void testAddItem_InvalidCodeNotExist(){
		vm.addItem(chips, "E");
	}
	
	/**
	 * Tests when an item is added into a slot that is not a letter
	 */
	@Test(expected=VendingMachineException.class)
	public void testAddItem_InvalidCodeNotLetter(){
		vm.addItem(chips, "0");
	}
	
	/**
	 * Tests when not slot is given
	 */
	@Test(expected=VendingMachineException.class)
	public void testAddItem_InvalidCodeEmpty(){
		vm.addItem(chips, "");
	}
	
	/**
	 * vanilla test case for remove item
	 */
	@Test
	public void testRemoveItem() {
		vm.addItem(coke, "C");
		assertEquals("coke",vm.removeItem("C").getName());
	}

	@Test
	public void testInsertMoney() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBalance() {
		fail("Not yet implemented");
	}

	@Test
	public void testMakePurchase() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnChange() {
		fail("Not yet implemented");
	}

}
