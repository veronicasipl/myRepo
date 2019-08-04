package unitTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.playtika.automation.school.java2.task1.constant.VegetableType;
import com.playtika.automation.school.java2.task1.factory.VegetableFactory;
import com.playtika.automation.school.java2.task1.vegetable.Vegetable;

public class FactoryTest extends Assert {

    @AfterClass(description = "After class (invokes once per class instance)")
    public void executionLog() {
        System.out.println("All tests from class executed");
    }

    @Test(dataProvider = "dataProviderForVeg")
    public void factoryTest(VegetableType type, String name, int weight, int calories, int amount) {
        Vegetable veg = VegetableFactory.getVegetable(type, name, weight, calories, amount, 1);

        Assert.assertEquals(name, veg.getName());
        Assert.assertEquals(weight, veg.getWeight());
        Assert.assertEquals(calories, veg.getCalories());
        Assert.assertEquals(amount, veg.getAmount());
    }

    @DataProvider(name = "dataProviderForVeg")
    public Object[][] dataProvider() {
        return new Object[][]{
                {VegetableType.POTATO, "potato", 5, 1, 1},
                {VegetableType.CARROT, "carrot", 3, 2, 4},
                {VegetableType.ONION, "onion", 3, 1, 4}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void unknownVegetableTypeTest() {
        VegetableFactory.getVegetable(VegetableType.UNKNOWN, "potato", 2, 4, 5, 1);
    }
}