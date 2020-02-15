package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;

public class RecipeBookTest extends TestCase {

    private CoffeeMaker cm;
    private RecipeBook rb;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;
    private Recipe r5;
    private Recipe r1nr2;

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

        //Set up for r5
        r5 = new Recipe();
        r5.setName("Lumumba");
        r5.setAmtChocolate("6");
        r5.setAmtCoffee("0");
        r5.setAmtMilk("12");
        r5.setAmtSugar("11");
        r5.setPrice("5");

        //Set up for r1nr2
        r1nr2 = new Recipe();
        r1nr2.setName("Coffee");
        r1nr2.setAmtChocolate("0");
        r1nr2.setAmtCoffee("3");
        r1nr2.setAmtMilk("1");
        r1nr2.setAmtSugar("1");
        r1nr2.setPrice("50");

        super.setUp();
    }

    public void testRecipeBook_AddRecipe(){
        rb.addRecipe(r1);
        Recipe firstRecipe = rb.getRecipes()[0];
        String name = firstRecipe.getName();
        assertEquals("Coffee", name);
    }

    public void testRecipeBook_AddRecipe_FullRecipeBook(){
        rb.addRecipe(r1);
        rb.addRecipe(r2);
        rb.addRecipe(r3);
        rb.addRecipe(r4);
        assertFalse("false", rb.addRecipe(r5));
    }

    public void testRecipeBook_AddRecipe_AlreadyExisting(){
        rb.addRecipe(r1);
        assertFalse("false", rb.addRecipe(r1nr2));
    }

    public void testRecipeBook_DeleteRecipe(){
        rb.addRecipe(r1);
        assertEquals("Coffee", rb.deleteRecipe(0));
    }

    public void testRecipeBook_DeleteRecipe_NoneExisting(){
        assertEquals(null, rb.deleteRecipe(0));
    }

    public void testRecipeBook_EditRecipe(){
        rb.addRecipe(r1);
        assertEquals("Coffee", rb.editRecipe(0, r1nr2));
    }

    public void testRecipeBook_EditRecipe_NoneExisting(){
        assertEquals(null, rb.editRecipe(0, r1nr2));
    }
}
