package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;

public class RecipeBookTest extends TestCase {

    private CoffeeMaker cm;
    private RecipeBook rb;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;

    protected void setUp() throws Exception {

        cm = new CoffeeMaker();

        rb = new RecipeBook();

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

    public void testRecipeBook_checkSize(){
        assertEquals(3, rb.getRecipes().length);
    }

    public void testRecipeBook_addRecipe(){
        rb.addRecipe(r1);
        Recipe firstRecipe = rb.getRecipes()[0];
        String name = firstRecipe.getName();
        assertEquals("Coffee", name);
    }

    public void testRecipeBook_addRecipe_fullRecipeBook(){
        rb.addRecipe(r1);
        rb.addRecipe(r2);
        rb.addRecipe(r3);
        assertFalse("Should not be able to add more then 3 recipes", rb.addRecipe(r4));
    }

    public void testRecipeBook_addRecipe_alreadyExisting(){
        rb.addRecipe(r1);
        assertFalse("false", rb.addRecipe(r1));
    }

    public void testRecipeBook_deleteRecipe(){
        rb.addRecipe(r1);
        assertEquals("Coffee", rb.deleteRecipe(0));
        assertNull("There shouldn't be a recipe in the book", rb.getRecipes());
    }

    public void testRecipeBook_deleteRecipe_noneExisting(){
        assertNull(rb.deleteRecipe(0));
    }

    public void testRecipeBook_editRecipe(){
        rb.addRecipe(r1);
        String newName = r2.getName();
        assertEquals(newName, rb.editRecipe(0, r2));
    }

    public void testRecipeBook_editRecipe_noneExisting(){
        assertNull(rb.editRecipe(0, r1));
    }
}
