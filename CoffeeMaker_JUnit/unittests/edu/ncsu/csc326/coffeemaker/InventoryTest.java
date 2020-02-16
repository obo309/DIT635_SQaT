package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class InventoryTest extends TestCase {
    private Inventory inventory;
    private Recipe testRecipe;

    protected void setUp() throws Exception {
        inventory = new Inventory();

        testRecipe = new Recipe();
        testRecipe.setName("TestRecipe");
        testRecipe.setAmtChocolate("15");
        testRecipe.setAmtCoffee("15");
        testRecipe.setAmtMilk("15");
        testRecipe.setAmtSugar("15");
        testRecipe.setPrice("5000");

        super.setUp();
    }

    public void testInventory_setChocolate(){
        inventory.setChocolate(5);
        assertEquals(5, inventory.getChocolate());
    }

    public void testInventory_setChocolate_negativeInput(){
        inventory.setChocolate(-1);
        assertEquals(15, inventory.getChocolate());
    }

    public void testInventory_setCoffee(){
        inventory.setCoffee(5);
        assertEquals(5, inventory.getCoffee());
    }

    public void testInventory_setCoffee_negativeInput(){
        inventory.setCoffee(-1);
        assertEquals(15, inventory.getCoffee());
    }

    public void testInventory_setSugar(){
        inventory.setSugar(5);
        assertEquals(5, inventory.getSugar());
    }

    public void testInventory_setSugar_negativeInput(){
        inventory.setSugar(-1);
        assertEquals(15, inventory.getSugar());
    }

    public void testInventory_setMilk(){
        inventory.setMilk(5);
        assertEquals(5, inventory.getMilk());
    }

    public void testInventory_setMilk_negativeInput(){
        inventory.setMilk(-1);
        assertEquals(15, inventory.getMilk());
    }

    public void testInventory_addChocolate(){
        try{
            inventory.addChocolate("5");
            assertEquals(20, inventory.getChocolate());
        }catch (InventoryException e){
            fail("InventoryException should not be thrown");
        }
    }

    public void testInventory_addChocolate_negativeInput(){
        try{
            inventory.addChocolate("-5");
            fail("InventoryException should be thrown when input is a negative number");
        }catch (InventoryException e){
            // Success
        }
    }

    public void testInventory_addChocolate_emptyString(){
        try{
            inventory.addChocolate("");
            fail("InventoryException should be thrown when input is not a number");
        }catch (InventoryException e){
            // Success
        }
    }

    public void testInventory_addCoffee(){
        try{
            inventory.addCoffee("10");
            assertEquals(25, inventory.getCoffee());
        }catch (InventoryException e){
            fail("InventoryException should not be thrown");
        }
    }

    public void testInventory_addCoffee_negativeInput(){
        try{
            inventory.addCoffee("-10");
            fail("InventoryException should be thrown");
        }catch (InventoryException e){
            // Success
        }
    }

    public void testInventory_addCoffee_emptyString(){
        try{
            inventory.addCoffee("");
            fail("InventoryException should be thrown when input is not a number");
        }catch (InventoryException e){
            // Success
        }
    }

    public void testInventory_addSugar(){
        try{
            inventory.addSugar("15");
            assertEquals(30, inventory.getSugar());
        }catch (InventoryException e){
            fail("InventoryException should not be thrown");
        }
    }

    public void testInventory_addSugar_negativeInput(){
        try{
            inventory.addSugar("-15");
            fail("InventoryException should be thrown");
        }catch (InventoryException e){
            // Success
        }
    }

    public void testInventory_addSugar_emptyString(){
        try{
            inventory.addSugar("");
            fail("InventoryException should be thrown when input is not a number");
        }catch (InventoryException e){
            // Success
        }
    }

    public void testInventory_addMilk(){
        try{
            inventory.addMilk("5");
            assertEquals(20, inventory.getMilk());
        }catch (InventoryException e){
            fail("InventoryException should not be thrown");
        }
    }

    public void testInventory_addMilk_negativeInput(){
        try{
            inventory.addMilk("-5");
            fail("InventoryException should be thrown");
        }catch (InventoryException e){
            // Success
        }
    }

    public void testInventory_addMilk_emptyString(){
        try{
            inventory.addMilk("");
            fail("InventoryException should be thrown when input is not a number");
        }catch (InventoryException e){
            // Success
        }
    }

    public void testInventory_enoughIngredients(){
        assertTrue(inventory.enoughIngredients(testRecipe));
    }

    public void testInventory_enoughIngredients_notEnoughChocolate() throws Exception{
        testRecipe.setAmtChocolate("16");
        assertFalse(inventory.enoughIngredients(testRecipe));
    }

    public void testInventory_enoughIngredients_notEnoughCoffee() throws Exception{
        testRecipe.setAmtCoffee("16");
        assertFalse(inventory.enoughIngredients(testRecipe));
    }

    public void testInventory_enoughIngredients_notEnoughSugar() throws Exception{
        testRecipe.setAmtSugar("16");
        assertFalse(inventory.enoughIngredients(testRecipe));
    }

    public void testInventory_enoughIngredients_notEnoughMilk() throws Exception{
        testRecipe.setAmtMilk("16");
        assertFalse(inventory.enoughIngredients(testRecipe));
    }

    public void testInventory_useIngredients(){
        assertTrue(inventory.useIngredients(testRecipe));
        assertEquals(0, inventory.getChocolate());
        assertEquals(0, inventory.getCoffee());
        assertEquals(0, inventory.getSugar());
        assertEquals(0, inventory.getMilk());
    }

    public void testInventory_useIngredients_notEnoughChocolate() throws Exception{
        testRecipe.setAmtChocolate("16");
        assertFalse(inventory.useIngredients(testRecipe));
        assertEquals(15, inventory.getChocolate());
    }

    public void testInventory_useIngredients_notEnoughCoffee() throws Exception{
        testRecipe.setAmtCoffee("16");
        assertFalse(inventory.useIngredients(testRecipe));
        assertEquals(15, inventory.getCoffee());
    }

    public void testInventory_useIngredients_notEnoughSugar() throws Exception{
        testRecipe.setAmtSugar("16");
        assertFalse(inventory.useIngredients(testRecipe));
        assertEquals(15, inventory.getSugar());
    }

    public void testInventory_useIngredients_notEnoughMilk() throws Exception{
        testRecipe.setAmtMilk("16");
        assertFalse(inventory.useIngredients(testRecipe));
        assertEquals(15, inventory.getMilk());
    }
}
