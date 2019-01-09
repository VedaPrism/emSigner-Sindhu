package Page_Factory;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_DecryptPage extends pf_genericmethods {

	final static Logger log = Logger.getLogger(pf_DecryptPage.class);
	
	@FindBy(how = How.XPATH, using = "//div/h1[@class='title']") WebElement decyptTitle;
	//@FindBy(how = How.XPATH, using = "//span[text()='Encrypt & Decrypt']") WebElement encryptDecrypt;
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[3]/div[9]/a") WebElement decryptBtn;
	@FindBy(how = How.ID, using = "frmDecrypt") WebElement decryptPage;
	@FindBy(how = How.ID, using = "rdSingle") WebElement singleRdBtn;
	@FindBy(how = How.ID, using = "btnProcess") WebElement decryptNow;
	@FindBy(how = How.ID, using = "btnCancel") WebElement cancelBtn;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please upload')]") WebElement decryptNowMsg;	
	//source folder
	@FindBy(how = How.ID, using = "btnSingle") WebElement souceFoldr;
	//dest folder
	@FindBy(how = How.ID, using = "btnMultiple") WebElement destFoldr;
	//without dest folder decrypt now 
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please choose')]") WebElement destencryptNowMsg;

	//success msg
	@FindBy(how = How.XPATH, using = "//div[text()='Decryption successfully done.']") WebElement decyptSucccessMsg;

	public pf_DecryptPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void verifyDecryptCancelBtn(String sheetname,String scriptname) throws Exception {
		//cl_click(encryptDecrypt);
		cl_click(decryptBtn);
		System.out.println("Decrypt page title: "+decyptTitle.getText());
		
		if(singleRdBtn.isSelected()) {
			System.out.println("single radio button is selected");
		}else {
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
		}

		cl_click(cancelBtn);
		String url=w.getCurrentUrl();
		Utility.comparelogic(url,sheetname,scriptname);		
	}

	public void verifyDecrypt(String sheetname,String scriptname) throws Exception {
		//cl_click(encryptDecrypt);
		log.info("--Decrypt page--");
		cl_click(decryptBtn);
		if(decryptPage.isDisplayed()) {
			System.out.println("Decrypt page is displayed");
		}else {
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
		}
		cl_click(decryptNow);
		Thread.sleep(1000);
		String msg=decryptNowMsg.getText();
		cl_click(okBtn);
		Utility.comparelogic(msg,sheetname,scriptname);
	}

	public void decryptNow(String sheetname,String scriptname) throws Exception {
		cl_click(souceFoldr);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\sourceFolder\\source.exe");
		Thread.sleep(6000);
		cl_click(decryptNow);
		Thread.sleep(1000);
		String destMsg=destencryptNowMsg.getText();
		cl_click(okBtn);
		Utility.comparelogic(destMsg,sheetname,scriptname);

		cl_click(destFoldr);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\destFolder\\destfolder.exe");
		Thread.sleep(4000);
		cl_click(decryptNow);
		Thread.sleep(20000);
		Basefunctions.getScreenshot();
		System.out.println("Screenshot of Decrypt WebSocket is taken");
		
		//		String decryptNowMsg=destencryptNowMsg.getText();
		//		cl_click(okBtn);
		//		Utility.comparelogic(decryptNowMsg,sheetname);
	}


}
