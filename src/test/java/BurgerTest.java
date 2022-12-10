import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Bun bun = Mockito.mock(Bun.class);
    Ingredient ingredient = Mockito.mock(Ingredient.class);
    Ingredient ingredient1 = Mockito.mock(Ingredient.class);
    Ingredient ingredient2 = Mockito.mock(Ingredient.class);

    @Before
    public void setUp(){
        Mockito.when(bun.getName()).thenReturn("White bun");
        Mockito.when(bun.getPrice()).thenReturn(1F);
        Mockito.when(ingredient.getName()).thenReturn("Onions");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(10F);
        Mockito.when(ingredient1.getPrice()).thenReturn(5F);
    }

    @Test
    public void addIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredient(){
        int newIndex = 2;
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,newIndex);
        Assert.assertEquals(burger.ingredients.indexOf(ingredient),newIndex);
    }

    @Test
    public void getPrice(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        float expectedPrice = burger.bun.getPrice() * 2;
        for (Ingredient ingredient : burger.ingredients) {
            expectedPrice += ingredient.getPrice();
        }
        Assert.assertEquals( expectedPrice,burger.getPrice(),0.00000001);
    }

    @Test
    public void getReceipt(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", burger.bun.getName()));
        for (Ingredient ingredient : burger.ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", burger.bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals(receipt.toString(),burger.getReceipt());
    }
}
