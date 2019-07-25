import java.util.ArrayList;

import org.testng.annotations.Test;

import com.playtika.automation.school.java2.task1.Chef;
import com.playtika.automation.school.java3.task1.exception.IngredientsNotFoundException;

public class ChefTest {

    @Test(expectedExceptions = IngredientsNotFoundException.class)
    public void emptyVegetableListTest() throws IngredientsNotFoundException {
        Chef chef = new Chef();
        chef.makeAndGetSalad(new ArrayList<>());
    }
}