package unitTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.playtika.automation.school.java2.task1.Salad;
import com.playtika.automation.school.java2.task1.vegetable.Potato;
import com.playtika.automation.school.java3.task1.exception.SaladBowlIsFullException;

import org.testng.Assert;

public class SaladTest {

    private Salad salad;

    @BeforeMethod
    void setUp() {
        salad = new Salad();
    }

    @Test
    public void getTotalCaloriesTest() throws SaladBowlIsFullException {
        int totalCalories = 5;
        Potato potato = new Potato("potato", totalCalories, 1, 1, 1);
        salad.addComponent(potato);
        Assert.assertEquals(totalCalories, salad.getTotalCalories());
    }

    @Test(expectedExceptions = SaladBowlIsFullException.class)
    public void saladBowlIsFullExceptionTest() throws SaladBowlIsFullException {
        Potato potato = new Potato("potato", 5, 1, 1, 1);
        salad.addComponent(potato);
        salad.addComponent(potato);
        salad.addComponent(potato);
        salad.addComponent(potato);
        salad.addComponent(potato);
    }
}