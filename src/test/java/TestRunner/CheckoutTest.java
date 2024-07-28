package TestRunner;


import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@IncludeTags({"checkoutBilling", "checkoutShipping", "checkoutShippingMethod", "checkoutPaymentMethod","checkoutOrderConfirm","checkoutOrderSuccess"})
//@IncludeTags({"checkoutOrderConfirm"})
@SelectClasspathResource("com/pwc/features/Checkout")

public class CheckoutTest {
}
