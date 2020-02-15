package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;

public class EyuellBookTest extends TestCase {
    private RecipeBook testBook;

    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;

    protected void setUp() throws Exception {
        testBook = new RecipeBook();

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
        r4.setName("Hot Chocolate");
        r4.setAmtChocolate("4");
        r4.setAmtCoffee("0");
        r4.setAmtMilk("1");
        r4.setAmtSugar("1");
        r4.setPrice("65");

        super.setUp();
    }

    public void testBookSize(){
        assertEquals(3, testBook.getRecipes().length);
    }

    public void testAddingARecipe(){
        assertTrue(testBook.addRecipe(r1));
    }

    public void testAddingSameNamedRecipe(){
        testBook.addRecipe(r1);
        assertFalse(testBook.addRecipe(r1));
    }

    public void testAddingMoreThanThreeRecipe(){
        testBook.addRecipe(r1);
        testBook.addRecipe(r2);
        testBook.addRecipe(r3);
        assertFalse(testBook.addRecipe(r4));
    }

    public void testDeleting(){
        testBook.addRecipe(r1);
        assertEquals("Coffee", testBook.deleteRecipe(0));
    }

    public void testDeletingNonExisting(){
        assertNull(testBook.deleteRecipe(0));
    }

    public void testOnMovingRecipesAfterDeletion(){
        testBook.addRecipe(r1);
        testBook.addRecipe(r2);
        testBook.deleteRecipe(0);
        assertEquals("Mocha", testBook.deleteRecipe(0));
    }
}
