package Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_loginpage extends pf_genericmethods {
	
	
	@FindBy(how = How.CLASS_NAME, using = "btn-login") WebElement loginbutton;
	@FindBy(how = How.ID, using = "UserName") WebElement Usernamebox;
	@FindBy(how = How.ID, using = "Password") WebElement Passwordbox;
	@FindBy(how = How.ID, using = "btnLogin") WebElement Loginsubmit;
	@FindBy(how = How.XPATH, using = "//div[@class='validation-summary-errors']/ul/li") public WebElement msgerror; 

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Email ID')]") public WebElement EmailIDerror;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Please enter')]") public WebElement PaswrdError;
	
	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-user icon-xs icon-rounded']") public WebElement username;
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']") public WebElement logoutBtn;
	
	public pf_loginpage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}


	
	public void logincredentials(String uname,String pass) throws Exception{
		//Thread.sleep(10000);
		cl_click(loginbutton);
		cl_entertext(Usernamebox, uname);
		cl_entertext(Passwordbox, pass);
		cl_click(Loginsubmit);
	}
	
	public void logout() throws Exception{
		Thread.sleep(1000);
		cl_click(username);
		Thread.sleep(1000);
		cl_click(logoutBtn);
	}

}
