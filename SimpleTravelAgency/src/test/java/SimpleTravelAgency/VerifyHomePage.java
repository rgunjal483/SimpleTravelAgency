package SimpleTravelAgency;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.BrowserSetUp;
import Pages.ChooseFlightPage;
import Pages.DestinationPage;
import Pages.HomePage;
import Pages.PurchaseConfirmationPage;
import Pages.PurchasePage;
import Utils.Utility;

public class VerifyHomePage extends BrowserSetUp {
	WebDriver driver;
	String testID;
    HomePage homePage;
    ChooseFlightPage chooseFlightPage;
    DestinationPage destinationPage;
    PurchasePage purchasePage;
    PurchaseConfirmationPage purchaseConfirmationPage;
    SoftAssert soft;
    static ExtentTest test;
    static ExtentHtmlReporter reporter ;
        
    @Parameters("browser")
	@BeforeTest   
    public void setUp() {
    	reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);		
		driver = new ChromeDriver();
		driver.get("https://blazedemo.com/index.php");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		                  
    }
    
    @BeforeClass
    public void createPomObject() {
    	homePage = new HomePage(driver);
    	destinationPage = new DestinationPage(driver);
    	chooseFlightPage = new ChooseFlightPage(driver);
    	purchasePage = new PurchasePage(driver);
    	purchaseConfirmationPage = new PurchaseConfirmationPage(driver);
    	soft = new SoftAssert();
    }    	
    
    @Test(priority = 1)
    public void verifyHomePageTitle() {    	
    	testID ="T01";
    	Assert.assertEquals(homePage.isTitleDisplayed(),true);
    }   
        
    @Test(priority = 2)
    public void testDestinationLinkOpensNewTab() {
    	testID ="T02";
    	homePage.clickOnDestinationLink();      
        Assert.assertEquals(destinationPage.isUrlContainsVacation(),true); 
        driver.navigate().back();
    }

    @Test(priority = 3)
    public void purchaseTicket() throws InterruptedException {
    	testID ="T03";
    	homePage.selectDepartureCity("Mexico City");
    	homePage.selectDestinationCity("London");
    	homePage.clickOnfindFlight();
    	chooseFlightPage.chooseLowestPriceFlight();
       	Assert.assertEquals(chooseFlightPage.isPurchasePageDisplayed() , true);     	  
    }
    
    @Test(priority = 4)
    public void testTotalCostFormat() {
    	testID="T04";
    	Assert.assertTrue(purchasePage.isTotalCostFormatValid(), "Total Cost format is not valid");
        purchasePage.clickPurchaseFlightButton(); 
        String expected = "Thank you for your purchase today!";
        String actual = purchaseConfirmationPage.getConfirmationHeaderText();
        soft.assertEquals(actual, expected);
        String id = purchaseConfirmationPage.getconfirmationId();
        System.out.println("Purchase Confirmation ID is " + id);       
    }
    
    @AfterMethod
	public void captureScreenshotinFailure(ITestResult result) throws IOException {
		if(ITestResult.FAILURE== result.getStatus()) {
			Utility.captureScreenshot(driver, testID);
		}
    }	
    
    @AfterClass
	public void objectClear() {
		homePage = null;
		destinationPage = null;
		chooseFlightPage = null;
		purchasePage = null;
		purchaseConfirmationPage = null;		
	}
    
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}     
}
	


