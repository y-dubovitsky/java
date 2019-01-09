package UserUtils;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Categories.class)
@Categories.IncludeCategory(Name.class)
@Suite.SuiteClasses( { UserUtilsTestName.class, UserUtilsTestId.class})
public class UserUtilsTest {}
