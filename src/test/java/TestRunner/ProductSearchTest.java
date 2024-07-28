package TestRunner;


import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@ExcludeTags("skip")
@IncludeEngines("cucumber")
@SelectClasspathResource("com/pwc/features/productSearch")

public class ProductSearchTest {

}
