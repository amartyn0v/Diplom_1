import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(JUnitParamsRunner.class)
public class IngredientTest {

    @Test
    @Parameters({"SAUCE, MAYO, 0.5","FILLING, ONIONS, 1","FILLING, CUCUMBER, 0","SAUCE, BECHAMEL, -1"})
    public void constructorSetsVariablesAsGets(IngredientType type, String name, float price){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price, ingredient.getPrice(), 0.000001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorThrowsExceptionOnUnsupportedIngredientType() {
        IngredientType type = IngredientType.valueOf("SOUTH");
        String name = "Pole";
        float price = 0;
        Ingredient ingredient = new Ingredient(type, name, price);
    }
}
