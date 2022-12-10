import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.Bun;

@RunWith(JUnitParamsRunner.class)
public class BunTest {

    @Test
    @Parameters({"Black,11.3", "White,5", "Rice, 0", "Ginger, -1"})
    public void constructorSetsValuesAsGets(String name, float price){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(bun.getName(), name);
        Assert.assertEquals(bun.getPrice(), price, 0.000000001);
    }
}
