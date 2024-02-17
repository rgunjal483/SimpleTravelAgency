package Pages;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseFlightPage {
	private WebDriver driver;
	
	 @FindBy(xpath = "//table[@class='table']//tr[@class='row']")
	    private List<WebElement> flightRows;

	 @FindBy(xpath = "//*[@value='Choose This Flight']")
	    private WebElement chooseFlightButton;
	
	public ChooseFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void chooseLowestPriceFlight() {
        List<WebElement> chooseFlightButtons = driver.findElements(By.cssSelector("input[type='submit'][value='Choose This Flight']"));
        chooseFlightButtons.get(0).click(); 
    }
	
	public boolean isPurchasePageDisplayed() {
		return driver.getCurrentUrl().contains("purchase");		
	}
	
	

}
