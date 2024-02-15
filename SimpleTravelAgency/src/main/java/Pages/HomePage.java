package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	private WebDriver driver;
	private Select select ;
	
	@FindBy(xpath = "//*[text() = 'destination of the week! The Beach!']")
	private WebElement destinationLink ;
	
	@FindBy(xpath = "//*[@name='fromPort']")
	private WebElement departureCity ;
	
	@FindBy(xpath = "//*[@name='toPort']")
	private WebElement destinationCity ;
	
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement findFlight ;
	
	@FindBy(xpath = "//*[text() = 'Travel The World']")
	private WebElement pageTitle ;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnDestinationLink() {
		destinationLink.click();
	}
	
	public void selectDepartureCity(String city) {
		select = new Select(departureCity) ;
		select.selectByValue(city);
	}
	
	public void selectDestinationCity(String city) {
		select = new Select(destinationCity) ;
		select.selectByValue(city);
	}

	public boolean isTitleDisplayed() {
		return pageTitle.isDisplayed();
	}
	
	public void clickOnfindFlight() {
		findFlight.click();
	}

}
