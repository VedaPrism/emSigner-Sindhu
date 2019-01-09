package Page_Factory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import Generic_Library.Basefunctions;

public class pf_genericmethods extends Basefunctions {

	//	Entering text

	public void cl_entertext(WebElement el, String input){

		el.sendKeys(input);
	}

	//	Click on element

	public void cl_click(WebElement el){

		el.click();
	}

	// click OK on alert
	public void cl_popup() throws Exception {
		// Switch to Alert        
		Alert alert = w.switchTo().alert();		

		// Capture alert message.    
		String alertMessage= w.switchTo().alert().getText();		

		// Display alert message		
		System.out.println(alertMessage);	
		Thread.sleep(5000);

		// Accepting alert		
		alert.accept();	
	}
	
	

}
