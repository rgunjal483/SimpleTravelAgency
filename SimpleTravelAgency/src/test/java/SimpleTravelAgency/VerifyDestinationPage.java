package SimpleTravelAgency;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.DestinationPage;
import Pages.HomePage;
import dev.failsafe.internal.util.Assert;

public class VerifyDestinationPage {
	private WebDriver driver;
    private HomePage homePage;
    private DestinationPage destinationPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://blazedemo.com/index.php");
        homePage = new HomePage(driver);
        destinationPage = new DestinationPage(driver);
    }

    @Test
    public void testDestinationLinkOpensNewTab() {
        homePage.clickOnDestinationLink();      
        Assert.isTrue(destinationPage.isUrlContainsVacation(), "New tab opened with URL containing 'vacation'");        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
