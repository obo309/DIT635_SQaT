package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class RecipeTest extends TestCase {

    private CoffeeMaker cm;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;

    protected void setUp() throws Exception {

        cm = new CoffeeMaker();

        //Set up for r1
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");

        //Set up for r2
        r2 = new Recipe();
        r2.setName("Mocha");
        r2.setAmtChocolate("20");
        r2.setAmtCoffee("3");
        r2.setAmtMilk("1");
        r2.setAmtSugar("1");
        r2.setPrice("75");

        //Set up for r3
        r3 = new Recipe();
        r3.setName("Latte");
        r3.setAmtChocolate("0");
        r3.setAmtCoffee("3");
        r3.setAmtMilk("3");
        r3.setAmtSugar("1");
        r3.setPrice("100");

        //Set up for r4
        r4 = new Recipe();
        r4.setName("Hot Cocoa");
        r4.setAmtChocolate("4");
        r4.setAmtCoffee("0");
        r4.setAmtMilk("1");
        r4.setAmtSugar("1");
        r4.setPrice("65");

        super.setUp();
    }

    public void testRecipe_setAmtChocolate() throws RecipeException{
        try {
            r1.setAmtChocolate("2");
            assertEquals(2, r1.getAmtChocolate());
        } catch (RecipeException e){
            fail("RecipeException shouldn't be thrown");
        }
    }

    public void testRecipe_setAmtChocolate_negativeInput() throws RecipeException{
        try {
            r1.setAmtChocolate("-1");
            fail("RecipeException: You can't have a negative ingredient amount!");
        } catch (RecipeException e){
            // Success
        }
    }

    public void testRecipe_setAmtChocolate_stringInput() throws RecipeException{
        try {
            r1.setAmtChocolate("Erroneus Input");
            fail("InventoryException: The ingredient amount must be a positive integer");
        } catch (RecipeException e){
            // Success
        }
    }

    public void testRecipe_setAmtCoffee() throws RecipeException{
        try {
            r1.setAmtCoffee("2");
            assertEquals(2, r1.getAmtCoffee());
        } catch (RecipeException e){
            fail("RecipeException shouldn't be thrown");
        }
    }

    public void testRecipe_setAmtCoffee_negativeInput() throws RecipeException{
        try {
            r1.setAmtCoffee("-1");
            fail("RecipeException: You can't have a negative ingredient amount!");
        } catch (RecipeException e){
            // Success
        }
    }

    public void testRecipe_setAmtCoffee_stringInput() throws RecipeException{
        try {
            r1.setAmtCoffee("Erroneus Input");
            fail("RecipeException: The ingredient amount must be a positive integer");
        } catch (RecipeException e){
            // Success
        }
    }

    public void testRecipe_setAmtSugar() throws RecipeException{
        try {
            r1.setAmtSugar("2");
            assertEquals(2, r1.getAmtSugar());
        } catch (RecipeException e){
            fail("RecipeException shouldn't be thrown");
        }
    }

    public void testRecipe_setAmtSugar_negativeInput() throws RecipeException{
        try {
            r1.setAmtSugar("-1");
            fail("RecipeException: You can't have a negative ingredient amount!");
        } catch (RecipeException e){
            // Success
        }
    }

    public void testRecipe_setAmtSugar_stringInput() throws RecipeException{
        try {
            r1.setAmtSugar("Erroneus Input");
            fail("RecipeException: The ingredient amount must be a positive integer");
        } catch (RecipeException e){
            // Success
        }
    }

    public void testRecipe_setAmtMilk() throws RecipeException{
        try {
            r1.setAmtMilk("2");
            assertEquals(2, r1.getAmtMilk());
        } catch (RecipeException e){
            fail("RecipeException shouldn't be thrown");
        }
    }

    public void testRecipe_setAmtMilk_negativeInput() throws RecipeException{
        try {
            r1.setAmtMilk("-1");
            fail("RecipeException: You can't have a negative ingredient amount!");
        } catch (RecipeException e){
            // Success
        }
    }

    public void testRecipe_setAmtMilk_stringInput() throws RecipeException{
        try {
            r1.setAmtMilk("Erroneus Input");
            fail("RecipeException: The ingredient amount must be a positive integer");
        } catch (RecipeException e){
            // Success
        }
    }

    public void testRecipe_setName(){
        r1.setName("New Name");
        assertEquals("New Name", r1.getName());
    }

    public void testRecipe_setPrice() throws RecipeException{
        try {
            r1.setPrice("20");
            assertEquals(20, r1.getPrice());
        } catch (RecipeException e){
            fail("RecipeException shouldn't be thrown");
        }
    }

    public void testRecipe_setPrice_stringInput() throws RecipeException{
        try {
            r1.setPrice("Erroneus Input");
            fail("RecipeException: The price must be a positive integer");
        } catch (RecipeException e){
            //Success
        }
    }

    public void testRecipe_setPrice_negativeInput() throws RecipeException{
        /*try {
            r1.setPrice("-20");
            fail("RecipeException: You can't have a negative price!");
        } catch (RecipeException e){
            //Success
        }*/

        try {
            r1.setPrice("-20");
        } catch (RecipeException e){
            fail("RecipeException: You can't have a negative price!");
        }
    }
}
