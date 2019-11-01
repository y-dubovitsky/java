package unknow.string_utils;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory (Unit.class)
@Suite.SuiteClasses ({
        JUnitOtherTest.class,
        JUnitStringUtilsCategoriesTest.class
})
public class JUnitTestSuite {}
