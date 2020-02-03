
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Paymentpage {

	private WebDriver driver;

	public Paymentpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#payform > div > a.list-group-item.text-center.select-card.active > p")
	WebElement tarjetaclick;

	@FindBy(css = "#payment-form > div.card-info-box > div:nth-child(2) > div > div > input")
	WebElement cardname;

	@FindBy(css = "#payment-form > div.card-info-box > div:nth-child(3) > div > div > div.field.input-group > input")
	WebElement cardnumber;

	@FindBy(css = "#payment-form > div.card-info-box > div:nth-child(4) > div.col-xs-7.col-md-7 > div > div.field.col-xs-5.col-md-5.paddleft0 > input")
	WebElement month;

	@FindBy(css = "#payment-form > div.card-info-box > div:nth-child(4) > div.col-xs-7.col-md-7 > div > div.field.col-xs-7.col-md-7.paddleft0 > input")
	WebElement year;

	@FindBy(css = "#payment-form > div.card-info-box > div:nth-child(4) > div.col-xs-5.col-md-5.pull-right > div > input")
	WebElement cvv;

	@FindBy(css = "#email_block > div > div > input")
	WebElement email;

	@FindBy(css = "#paylimit")
	WebElement rechargebutton;

	@FindBy(css = "#login > div > div > div.modal-content > div.modal-body")
	WebElement rechargepopup;

	@FindBy(css = "#usrname")
	WebElement emailverify;

	@FindBy(css = "#psw")
	WebElement passwordverify;

	@FindBy(css = "#recaptcha-anchor > div.recaptcha-checkbox-border")
	WebElement capctha;

	@FindBy(css = " #loginBtn")
	WebElement buttonverify;

	@FindBy(css = "#add_err")
	WebElement errmsg;

	public void tarjetaclick() {
		tarjetaclick.click();

	}

	public void cardname(String card) {
		cardname.clear();
		cardname.sendKeys(card);
	}

	public void cardnumber(String cardnum) {
		cardnumber.clear();
		cardnumber.sendKeys(cardnum);
	}

	public void month(String mon) {
		month.clear();
		month.sendKeys(mon);
	}

	public void year(String yer) {
		year.clear();
		year.sendKeys(yer);
	}

	public void cvv(String cv) {
		cvv.clear();
		cvv.sendKeys(cv);
	}

	public void email(String mail) {
		email.clear();
		email.sendKeys(mail);
	}

	public void rechargebutton() {
		rechargebutton.click();

	}

	public void emailverify(String emailver) {
		// wait.until(ExpectedConditions.elementToBeClickable(rechargepopup));
		emailverify.clear();
		emailverify.sendKeys(emailver);

	}

	public void passwordverify(String pass) {
		passwordverify.clear();
		passwordverify.sendKeys(pass);
	}

	public void capctha() {
		// wait.until(ExpectedConditions.elementToBeClickable(capctha));
		driver.switchTo().frame(0);
		capctha.click();
		driver.switchTo().defaultContent();
	}

	public void buttonverify() {
		buttonverify.submit();
	}

	public boolean isrecharge() {
		return errmsg.getTagName().isEmpty();
	}

}
