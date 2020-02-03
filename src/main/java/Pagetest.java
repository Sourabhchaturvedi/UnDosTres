import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Pagetest {
	public static WebDriver driver = null;
    
	
	@BeforeClass(alwaysRun = true)
	
	//passing browser as a parameter from testng xml for cross browser testing
	@Parameters({ "browser" }) 
	public void getDriver(String browser) {
		
		//initilazing the selenium driver
		driver = Setupdriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://prueba.undostres.com.mx/");
	}

	public WebDriver Setupdriver(String browser) {
		{

			try {
				switch (browser) {
				case "firefox":

					if (driver == null) {
						
						//Please specify the driver directory for firefox borowser
						System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
						driver = new FirefoxDriver();
					}

				case "Chrome":
					if (driver == null) {
						//Please specify the driver directory for Chrome borowser
						System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
						driver = new ChromeDriver();
					}
				}

				return driver;
			} catch (Exception e) {
				System.out.println("Error while setting up the browser="+e);
			}
			return driver;
		}
	}

	//Actual Selenium Test
	@Test
	public void Testrun() {
		
		//Home Page class
		Homepage home  = new Homepage(driver);
		home.operatordropdown(0);
		home.cellularfield("5523261151");
		home.montederecharga();
		home.siguientebutton();
		Assert.assertTrue(home.isPageOpened(), "Not on the payment page");

		//Payment class
		Paymentpage Page = new Paymentpage(driver);
		Page.tarjetaclick();
		Page.cardname("Test Card number");
		Page.cardnumber("4111111111111111");
		Page.month("11");
		Page.year("2025");
		Page.cvv("111");
		Page.email("test@test.com");
		Page.rechargebutton();
		Page.emailverify("marze.zr@gmail.com");
		Page.passwordverify("123456");
		Page.capctha();
		Page.buttonverify();
		Assert.assertTrue(Page.isrecharge(), "Recharge was not successfull");
	}
	
 //After test closing the browsers
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
