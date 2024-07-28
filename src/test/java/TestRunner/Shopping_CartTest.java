package TestRunner;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@IncludeTags({"rentalProduct","addToCart","differentProducts","miniCart","priceRangeProduct","actualCart","estimateShipping","discount","giftCard","terms"})
//@IncludeTags({"estimateShipping"})
@SelectClasspathResource("com/pwc/features/ShoppingCart")

public class Shopping_CartTest {

}
