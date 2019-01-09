package StringUtils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JUnitStringUtilsCategoriesTest extends Assert
{
    //...

    @Category(Unit.class)
    @Test
    public void testIsEmpty() {
        //...
        System.out.println("Hello from " + this.getClass().getName());
    }
    //...
}

