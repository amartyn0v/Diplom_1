import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.IngredientType;

import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class IngredientTypeTest {

    @Test
    @Parameters({"SAUCE,0", "FILLING,1"})
    public void classContainsConstants(String name, int order){
        try{
            Assert.assertEquals(order, IngredientType.valueOf(name).ordinal());
        }
        catch(IllegalArgumentException e){
            fail(String.format("Enum value \"%s\" does not exist in the enum class",name));
        }

}
}
