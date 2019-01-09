package Page_Factory;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_EncryptPage extends pf_genericmethods{

	final static Logger log = Logger.getLogger(pf_EncryptPage.class);
	
	@FindBy(how = How.XPATH, using = "//span[text()='Encrypt & Decrypt']") WebElement encryptDecrypt;
	@FindBy(how = How.ID, using = "rdSingle") WebElement singleRdBtn;
	@FindBy(how = How.ID, using = "rdMultiple") WebElement multipleRdBtn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[3]/div[8]/a") WebElement encryptBtn;
	@FindBy(how = How.ID, using = "frmEncrypt") WebElement encryptPage;
	@FindBy(how = How.ID, using = "btnCancel") WebElement cancelBtn;
	@FindBy(how = How.ID, using = "btnProcess") WebElement encryptNowBtn;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please upload')]") WebElement encryptNowMsg;	
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn; 
	//source folder
	@FindBy(how = How.ID, using = "btnSingle") WebElement souceFoldr;
	//dest folder
	@FindBy(how = How.ID, using = "btnMultiple") WebElement destFoldr;
	//select certificate  
	@FindBy(how = How.ID, using = "btncertificate") WebElement certificateFoldr;
	//without dest folder encrypt now 
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please choose')]") WebElement destencryptNowMsg;
	//without certificate folder encrypt now 
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please select Certificate')]") WebElement selectCencryptNowMsg;
	//with source,dest and certificate, encrypt now
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Encryption successfully done')]") WebElement allencryptNowMsg;
	//encrypt page to setting page	
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmEncrypt\"]/div[1]/div/div/h1/a") WebElement bckBtnToSettingsPage;
	public pf_EncryptPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void verifyEncrypt(String sheetname, String scriptname) throws Exception {
		//cl_click(encryptDecrypt);
		log.info("--Encrypt page--");
		cl_click(encryptBtn);
		if(encryptPage.isDisplayed()) {
			log.info("Encrypt page is displayed");
			System.out.println("Encrypt page is displayed");
		}else {
			log.info("Encrypt page did not displayed");
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
			log.info("Screenshot taken");
			Assert.fail();
		}

		if(singleRdBtn.isSelected()) {
			log.info("single radio button is selected");
			System.out.println("single radio button is selected");
		}else {
			log.info("Radio button did not selected");
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
			log.info("Screenshot taken");
			Assert.fail();
		}
		
		cl_click(encryptNowBtn);
		log.info("Encrypt now Button is clicked");
		String msg=encryptNowMsg.getText();
		log.info("Encrypt now msg is displayed without selecting any folder: "+msg);
		cl_click(okBtn);
		Utility.comparelogic(msg,sheetname,scriptname);
	}

	public void verifyEncryptCancelBtn(String sheetname, String scriptname) throws Exception {
		//cl_click(encryptDecrypt);
		cl_click(encryptBtn);
		log.info("Encrypt page is displayed");		
		cl_click(cancelBtn);
		log.info("Cancel button is clicked");
		String url=w.getCurrentUrl();
		log.info("URL found when cancel button is clicked: "+url);
		Utility.comparelogic(url,sheetname,scriptname);
		Thread.sleep(3000);
	}

	public void encryptNow(String sheetname,String scriptname) throws Exception {
		cl_click(souceFoldr);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\partB\\partBFolder.exe");
		log.info("Source folder path is passed successfully");
		Thread.sleep(10000);
		cl_click(encryptNowBtn);
		Thread.sleep(1000);
		String destMsg=destencryptNowMsg.getText();
		cl_click(okBtn);
		log.info("Message displayed when Source folder is passed: "+destMsg);
		Utility.comparelogic(destMsg,sheetname,scriptname);
	}


	public void encryptNowSourceDest(String sheetname,String scriptname) throws Exception {
		cl_click(destFoldr);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\destFolder\\destfolder.exe");
		log.info("Destination folder path is passed successfully");
		Thread.sleep(10000);
		cl_click(encryptNowBtn);
		Thread.sleep(1000);
		String cMsg=selectCencryptNowMsg.getText();
		cl_click(okBtn);
		log.info("Message displayed when Source,dest folder is passed: "+cMsg);
		Utility.comparelogic(cMsg,sheetname,scriptname);
	}
	
	public void encryptNowSourceDestCert(String sheetname,String scriptname) throws Exception {
		cl_click(certificateFoldr);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\certFolder\\cert.exe");
		log.info("Certificate folder path is passed successfully");
		Thread.sleep(10000);
		cl_click(encryptNowBtn);
		log.info("Encrypt now button is clicked");
		String Msg=allencryptNowMsg.getText();
		log.info("Message displayed when Source,dest,cert folder is passed: "+Msg);
		cl_click(okBtn);
		Utility.comparelogic(Msg,sheetname,scriptname);
		cl_click(bckBtnToSettingsPage);
	}
}
