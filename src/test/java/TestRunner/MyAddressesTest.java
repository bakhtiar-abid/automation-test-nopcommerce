package TestRunner;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@ExcludeTags("Skip")
@IncludeEngines("cucumber")
@SelectClasspathResource("com/pwc/features/myAddresses")

public class MyAddressesTest {
}
