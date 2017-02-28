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
	
	/**
	 * Tests when an empty slot is given
	 */
	@Test(expected=VendingMachineException.class)
	public void testRemoveItem_Empty(){
		vm.removeItem("B");
	}
	
	/**
	 * Tests when no slot is given
	 */
	@Test(expected=VendingMachineException.class)
	public void testRemoveItem_NoSlot(){
		vm.removeItem("");
	}
	
	/**
	 * Tests invalid slot
	 */
	@Test(expected=VendingMachineException.class)
	public void testRemoveItem_invalidSlot(){
		vm.removeItem("AA");
	}
	
	
	
	/**
	 * vanilla test case for insert money
	 * Inserting a valid amount
	 */
	@Test
	public void testInsertMoney() {
		double init_balance = vm.getBalance();
		vm.insertMoney(0.00);
		double cur_balance = vm.getBalance();
		
		assertEquals(0.00, cur_balance-init_balance,0.00);
	}
	
	/**
	 * 2nd vanilla test case for insert money
	 * Inserting a valid amount
	 */
	public void testInsertMoney_2ndVanilla(){
		double init_balance = vm.getBalance();
		vm.insertMoney(5.00);
		double cur_balance = vm.getBalance();
		
		assertEquals(5.00, cur_balance-init_balance,0.00);
	}
	
	/**
	 * Tests when a negative amount is given
	 */
	@Test(expected=VendingMachineException.class)
	public void testInsertMoney_NegativeAmount(){
		vm.insertMoney(-0.01);
	}
	
	/**
	 * Tests when an extremely large amount is given
	 * 
	 */
	@Test
	public void testInsertMoney_LargeAmount(){
		double init_balance = vm.getBalance();
		vm.insertMoney(Double.MAX_VALUE);
		double cur_balance = vm.getBalance();
		
		assertEquals(Double.MAX_VALUE, cur_balance-init_balance,0.00);
	}

	@Test
	public void testGetBalance() {
	}

	@Test
	public void testMakePurchase() {
	}

	@Test
	public void testReturnChange() {
	}

}
