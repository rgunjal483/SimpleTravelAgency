package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {
    private WebDriver driver;

    @FindBy(name = "inputName")
    private WebElement inputName;

    @FindBy(xpath = "//*[text()='Total Cost: ']")
    private WebElement totalCost;
    
    @FindBy(xpath = "//*[text()='914.76 ']")
    private WebElement totalCostvalue;

    @FindBy(xpath = "//input[@value='Purchase Flight']")
    private WebElement purchaseFlightButton;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isTotalCostFormatValid() {
        String costRegex = "\\d{3}\\.\\d{2}";
        return totalCostvalue.getText().matches(costRegex);
    }

    public void enterName(String name) {
        inputName.sendKeys(name);
    }

    public void clickPurchaseFlightButton() {
        purchaseFlightButton.click();
    }
}

