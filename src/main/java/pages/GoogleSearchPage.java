package pages;

import chunks.HeaderChunk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.Configs;
import utils.Pages;

public class GoogleSearchPage extends HeaderChunk {
	private static final Logger logger = LogManager
			.getLogger(GoogleSearchPage.class);

	public void goTo() {
		logger.info(String.format("Navigating to [%s] page", this.getClass().getName()));
		Browser.navigate(Configs.getInstance().getUrl());
	}

	public boolean isAt() {
		boolean result = Browser.getTitle().trim().toLowerCase()
				.equals("google");
		if (result) {
			logger.info(String.format("Title for [%s] is correct", this.getClass().getName()));
			return result;
		}

		logger.info(String.format("Title for [%s] page is not correct", this.getClass().getName()));
		return false;
	}

	public HeaderChunk getHeaderChunk()
	{
		HeaderChunk page = new HeaderChunk();
		PageFactory.initElements(Browser.getWebDriver(), page);
		return page;
	}
}
