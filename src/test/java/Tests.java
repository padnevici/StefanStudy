import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectElements.Application;
import chunks.HeaderChunk;
import utils.Pages;
import utils.TestBase;


public class Tests extends TestBase {

    @Parameters({"searchString", "applicationName"})
    @Test
    public void test_1(String searchString, String applicationName) {
        try {
            Pages.getGoogleSearchPage().goTo();
            AssertJUnit.assertTrue(Pages.getGoogleSearchPage().isAt());

            Pages.getHeaderChunk().openPageForGoogleService(HeaderChunk.GoogleServices.Play);
            AssertJUnit.assertTrue(Pages.getGooglePlayPage().isAt());

            Pages.getGooglePlayPage().searchFor(searchString);
            Pages.getGooglePlayPage().openPageForAnApp(applicationName);

            Pages.getApplicationPage().isAt(applicationName);
            Application app = Pages.getApplicationPage().getApplicationObject();

            Assert.assertNotEquals(app.getName(), "");
            Assert.assertNotEquals(app.getRating(), 0);
            Assert.assertNotEquals(app.getReviews(), 0);

            logger.info(String.format(
                    "Application name: '%s'\tRating: %.1f\tReviews count: %d",
                    app.getName(), app.getRating(), app.getReviews()));
        } catch (Exception e) {
            logger.error(e);
            logger.error(e.getStackTrace());
            Assert.fail("An error occurred during execution", e);
        }
    }
}
