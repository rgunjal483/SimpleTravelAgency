package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseConfirmationPage {
 private WebDriver driver;

 @FindBy(xpath = "//div[@class='container']//h1")
 private WebElement confirmationHeader;
 
 @FindBy(xpath = "(//tr//td)[2]")
 private WebElement confirmationId;

 public PurchaseConfirmationPage(WebDriver driver) {
     this.driver = driver;
     PageFactory.initElements(driver, this);
 }

 public String getConfirmationHeaderText() {
     return confirmationHeader.getText();
 }
 
 public  String getconfirmationId() {
	 return confirmationId.getText();
 }
 
 
}
