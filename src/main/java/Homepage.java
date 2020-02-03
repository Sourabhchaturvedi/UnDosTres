import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage {
        
    private WebDriver driver;
	public Homepage(WebDriver driver) {	
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	//WebDriverWait wait = new WebDriverWait(driver, 60);
	
	// Using FindBy for locating elements
	@FindBy(css = "#col-sm-12 > form > div > div:nth-child(1) > div.user-interact > div.form > ul > li:nth-child(1) > div > div > input[type=text]")
	WebElement operatordropdown;
	@FindBy(css = "#col-sm-12 > form > div > div:nth-child(1) > div.user-interact > div.form > ul > li:nth-child(1) > div > div > div > ul > li:nth-child(1)")
	WebElement operatordropdownoption;
	
	@FindBy(css = "#col-sm-12 > form > div > div:nth-child(1) > div.user-interact > div.form > ul > li:nth-child(2) > div > div > input[type=tel]")
	WebElement cellularfield;
	@FindBy(css = "#col-sm-12 > form > div > div:nth-child(1) > div.user-interact > div.form > ul > li:nth-child(3) > div > div > input[type=text]")
	WebElement montederecharga;
	
	@FindBy(css = "#col-sm-12 > form > div > div:nth-child(1) > div.user-interact > div.form > ul > li:nth-child(3) > div > div > div > ul.category-list.cat1 > li:nth-child(1)")
	WebElement rechargevalue;
	
	@FindBy(css = "#col-sm-12 > form > div > div:nth-child(1) > div.user-interact > div.proceed > div > button")
	WebElement siguientebutton;
	
	
	
	@FindBy(css = "body > header > div > nav > div > div > div:nth-child(2) > center > table > tbody > tr > td:nth-child(2) > h2")
	WebElement heading;
	
	
	public void operatordropdown(int option) { 
		operatordropdown.click();
		operatordropdownoption.click();
	        
	}


	public void cellularfield(String cellular) {
		cellularfield.clear();
		cellularfield.sendKeys(cellular);
	}
	
	public void montederecharga() {
	     montederecharga.click();     
	    rechargevalue.click();       
	}
	 public void siguientebutton(){
		 siguientebutton.click();
	   }
	 public boolean isPageOpened(){ 
	       return heading.getText().toString().contains("Paga de Forma Segura por Tu Recarga");
	   }
     }


    
   

