package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DestinationPage {
	private WebDriver driver;

    public DestinationPage(WebDriver driver) {        
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean isUrlContainsVacation() {
    	return driver.getCurrentUrl().contains("vacation");
    }
}


