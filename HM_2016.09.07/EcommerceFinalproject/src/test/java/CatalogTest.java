import core.TestBase;
import elements.Header;
import pages.CatalogPage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CatalogTest extends TestBase{

    String targetProductName = "T-shirts";

    @Test
    public void tShirtsCatalog_OpenCatalog_TargetProductIsPresent(){
        Header.navigateToTShirtsCatalogPage();
        Assert.assertTrue(CatalogPage.isInsideEachProductNameFromListPresent(targetProductName),
                "Not each item in a list of Products contains a target Product Name");
    }
}
