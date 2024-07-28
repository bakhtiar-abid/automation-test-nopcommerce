package TestRunner;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;

@Suite
//@IncludeTags("run")
@IncludeEngines("cucumber")
@SelectClasspathResource("com/pwc/features/HomePage")
public class HomepageTest {
}
