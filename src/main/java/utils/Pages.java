package utils;

import chunks.HeaderChunk;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class Pages {
	public static HeaderChunk getHeaderChunk() {
		HeaderChunk page = new HeaderChunk();
		PageFactory.initElements(Browser.getWebDriver(), page);
		return page;
	}
	
	public static GoogleSearchPage getGoogleSearchPage() {
		GoogleSearchPage page = new GoogleSearchPage();
		PageFactory.initElements(Browser.getWebDriver(), page);
		return page;
	}
	
	public static GooglePlayPage getGooglePlayPage() {
		GooglePlayPage page = new GooglePlayPage();
		PageFactory.initElements(Browser.getWebDriver(), page);
		return page;
	}
	
	public static ApplicationPage getApplicationPage() {
		ApplicationPage page = new ApplicationPage();
		PageFactory.initElements(Browser.getWebDriver(), page);
		return page;
	}
}
