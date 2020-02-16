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

    public void testBook_Size(){
        int bookSize = 3;
        assertEquals(bookSize, testBook.getRecipes().length);
    }

    public void testRecipeBook_AddRecipe(){
        assertTrue(testBook.addRecipe(r1));
    }

    public void testRecipeBook_AddRecipe_AlreadyExisting(){
        testBook.addRecipe(r1);
        assertFalse(testBook.addRecipe(r1));
    }

    public void testRecipeBook_AddRecipe_FullRecipeBook(){
        testBook.addRecipe(r1);
        testBook.addRecipe(r2);
        testBook.addRecipe(r3);
        assertFalse(testBook.addRecipe(r4));
    }

    public void testRecipeBook_DeleteRecipe(){
        testBook.addRecipe(r1);
        assertEquals("Coffee", testBook.deleteRecipe(0));
    }

    public void testRecipeBook_DeleteRecipe_NoneExisting(){
        assertNull(testBook.deleteRecipe(0));
    }

    public void testRecipeBook_CheckListAfterDeletion(){
        testBook.addRecipe(r1);
        testBook.addRecipe(r2);
        testBook.deleteRecipe(0);
        String rName = r2.getName();
        assertEquals(rName, testBook.deleteRecipe(0));
    }

    public void testRecipeBook_EditRecipe(){
        testBook.addRecipe(r1);
        testBook.editRecipe(0,r2);
        String oldTxt = r1.getName();
        assertFalse(oldTxt.equals(r1.getName()));
        //assertNotEquals(oldTxt,r1.getName());
    }

    public void testRecipeBook_EditRecipe_NoneExisting(){
        testBook.editRecipe(0,r1);
        String oldTxt = r1.getName();
        assertNull(r1.getName());
    }
}
