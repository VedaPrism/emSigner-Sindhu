package Page_Factory;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_form16SigningPage extends pf_genericmethods {

	Basefunctions b = new Basefunctions();
	final static Logger log = Logger.getLogger(pf_form16SigningPage.class);

	@FindBy(how = How.XPATH, using = "//*[text()='Form16 Signing']") WebElement form16Signing;
	@FindBy(how = How.ID, using = "step1Content") WebElement templtePage;
	@FindBy(how = How.ID, using = "btnpdfupload") WebElement createTempbutton;
	@FindBy(how = How.ID, using = "btncontinue") WebElement continuebutton;
	@FindBy(how = How.XPATH, using = "//div[@class='info']") WebElement continueMsg;

	//message while uploading doc other than pdf
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'NOTE:Only .PDF document(s)')]") WebElement uploadMessage;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;
	//check progress bar
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Preparing your document for')]") WebElement progressMsg;
	//check template setting
	@FindBy(how = How.CLASS_NAME, using = "box") WebElement tmplteSettingBox;
	//save button
	@FindBy(how = How.ID, using = "btnSave") WebElement saveBtn;
	@FindBy(how = How.XPATH, using ="//div[contains(text(),'Please Enter Document')]") WebElement saveBtnMsg;
	//select page dropdown
	@FindBy(how = How.ID, using = "ddlSelectpage") WebElement selectPage;

	//cross button in select drop down page

	@FindBy(how = How.ID, using = "DeleteSigners_1") WebElement crossSign;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Atleast one signatory')]") WebElement signatryMsg;

	//doc successfully created
	@FindBy(how = How.ID, using = "objpdfconfigviewmodel_Profile") WebElement docName;

	@FindBy(how = How.ID, using = "msgcontent") WebElement alertMsg;	
	//browse doc page	
	@FindBy(how = How.XPATH, using = "//div[@class='row form-page top15']") WebElement browseDocPage;

	//browse doc continue btn  
	@FindBy(how = How.ID, using = "btncontinuenext") WebElement browseContinueBtn;
	@FindBy(how = How.XPATH, using = "//div[text()='Please select PartA Folder.']") WebElement browseContinueMsg;
	@FindBy(how = How.XPATH, using = "//div[text()='Please select PartB Folder.']") WebElement browseAContinueMsg;
	@FindBy(how = How.XPATH, using = "//div[text()='Please select destination folder']") WebElement browseABContinueMsg;
	@FindBy(how = How.XPATH, using = "//div[text()='Please upload CSV file format.']") WebElement browseABDContinueMsg;

	//part A folder
	@FindBy(how = How.ID, using = "btnFormA") WebElement partAFolder;
	//part B folder
	@FindBy(how = How.ID, using = "btnFormB") WebElement partBFolder;
	//Dest folder
	@FindBy(how = How.ID, using = "btnDest") WebElement destFolder;
	//csv folder
	@FindBy(how = How.ID, using = "btnfile") WebElement csvFolder;
	//doc setting page	
	@FindBy(how = How.ID, using = "step3Content") WebElement docSetngPage;
	@FindBy(how = How.ID, using = "btnProcess") WebElement continueProcess;	
	@FindBy(how = How.ID, using = "btncancel") WebElement cancelBtn;

	//emailing option 	
	@FindBy(how = How.ID, using = "sendEmail") WebElement chckbxSndMail;
	@FindBy(how = How.ID, using = "rdemudhraconfig") WebElement rBtnemSignerSMTP;
	@FindBy(how = How.ID, using = "rdotherconfig") WebElement rBtnOtherSMTP;	
	@FindBy(how = How.XPATH, using = "//div[text()='Please enter Email Address']") WebElement processContinueMsg;
	@FindBy(how = How.ID, using = "From") WebElement fromAddress;
	@FindBy(how = How.ID, using = "Subject") WebElement subject;

	//sign option
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='sign-font-block']/ul/li")}) public List<WebElement> signs;	
	String sign = "//div[@class='innertab-panel']/div/ul/li[#DELIM#]/span[2]";

	public pf_form16SigningPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void form16Signing(String sheetName,String scriptname) throws Exception{
		log.info("--Form16_Signing Page--");
		log.info("Click on continue button without selecting/Creating template");
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",form16Signing);
		cl_click(form16Signing);
		Thread.sleep(3000);
		cl_click(continuebutton);
		log.info("Continue button is clicked");
		String msg= continueMsg.getText();
		Utility.comparelogic(msg,sheetName,scriptname);
		cl_click(okBtn);
		log.info("Message displayed when Continue button is clicked: "+msg);
	}

	public void uploadPDF(String path,String sheetName, String scriptname) throws Exception {
		log.info("Upload PDF document");
		cl_entertext(createTempbutton,path);
		Thread.sleep(3000);
		Boolean b=progressMsg.isDisplayed();
		System.out.println("progress bar displayed: "+b);
		log.info("Progress bar is displayed");
		if(b == false) {
			log.info("Progress bar is not displayed");
			Basefunctions.getScreenshot();
			Assert.fail();
		}
		Thread.sleep(30000);		
		cl_click(saveBtn);
		String saveMsg=saveBtnMsg.getText();
		Utility.comparelogic(saveMsg,sheetName,scriptname);
		log.info("Msg when we upload PDF doc and click on save button"+saveMsg);
		cl_click(okBtn);
	}

	public void uploadNonPDF(String path,String sheetName,String scriptname) throws Exception {
		log.info("Upload Non pdf document");
		cl_entertext(createTempbutton,path);
		String uploadMsg=uploadMessage.getText();
		Utility.comparelogic(uploadMsg,sheetName,scriptname);
		cl_click(okBtn);
		log.info("Message when NON PDF file is uploaded: "+uploadMsg);
	}

	public void verifySelectPage(String sheetName,String scriptname) throws Exception {
		Select slctPge=new Select(selectPage);
		slctPge.selectByIndex(6);
		cl_click(crossSign);
		String msg=signatryMsg.getText();
		Utility.comparelogic(msg,sheetName,scriptname);
		cl_click(okBtn);
		log.info("Message when signatory cross button is clicked: "+msg);
	}

	public void uploadDocument() throws Exception {
		String name=Utility.getpropertydetails("docTemplateName");
		System.out.println("Form16 document Template Name: "+name);
		cl_entertext(docName,name);
		cl_click(saveBtn);
		Thread.sleep(3000);
		String exp=alertMsg.getText();
		System.out.println("docCreationMsg: "+exp);
		cl_click(okBtn);
		if(exp.startsWith("Sorry!Template name")) {
			System.out.println("Screenshot Taken");
			b.getScreenshot();
			Assert.fail();
		}		
	}

	public void browseDocIsDisplayed() throws Exception {
		if(browseDocPage.isDisplayed()) {
			System.out.println("Browse documents is displayed");
			log.info("Browse document page is displayed");
		}else {
			log.info("Browse document page is not displayed");
			b.getScreenshot();
			Assert.fail();			
		}
	}

	public void browseContinue(String sheetName,String scriptname) throws Exception {
		log.info("Click on Continue button in browse doc page");
		cl_click(browseContinueBtn);
		Thread.sleep(1000);
		String browseCtnMsg=browseContinueMsg.getText();
		cl_click(okBtn);
		Utility.comparelogic(browseCtnMsg,sheetName,scriptname);
		log.info("Browse continue button without selecting a folder: "+browseCtnMsg);
	}

	public void browseAContinue(String sheetName,String scriptname) throws Exception {
		cl_click(partAFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\partAFolder\\new.exe");
		Thread.sleep(8000);
		cl_click(browseContinueBtn);
		Thread.sleep(1000);
		String browseCMsg=browseAContinueMsg.getText();
		cl_click(okBtn);
		Utility.comparelogic(browseCMsg,sheetName,scriptname);
		log.info("Browse continue button by selecting only A folder: "+browseCMsg);
	}

	public void browseABContinue(String sheetName,String scriptname) throws Exception {
		cl_click(partBFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\partBFolder\\new.exe");
		Thread.sleep(6000);
		cl_click(browseContinueBtn);
		Thread.sleep(1000);
		String browseABMsg=browseABContinueMsg.getText();
		cl_click(okBtn);
		Utility.comparelogic(browseABMsg,sheetName,scriptname);
		log.info("Browse continue button by selecting A and B folder: "+browseABMsg);
	}

	public void browseABDestContinue(String sheetName,String scriptname) throws Exception {
		cl_click(destFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\destFolder\\destfolder.exe");
		Thread.sleep(6000);
		cl_click(browseContinueBtn);
		Thread.sleep(1000);
		String browseDCMsg=browseABDContinueMsg.getText();
		cl_click(okBtn);
		Utility.comparelogic(browseDCMsg,sheetName,scriptname);
		log.info("Browse continue button by selecting A, B,dest folder: "+browseDCMsg);
		Thread.sleep(2000);
		cl_click(csvFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\csvFolder\\csvFile.exe");
		Thread.sleep(7000);
		cl_click(browseContinueBtn);
		//System.out.println("doc setting page is displayed: "+docSetngPage.isDisplayed());
		if(docSetngPage.isDisplayed() == true) {
			System.out.println("doc setting page is displayed");
		}
		else {
			log.info("Document setting page is not displayed");
			b.getScreenshot();
			Assert.fail();
		}

		Thread.sleep(5000);
		int ss = signs.size();
		Random r = new Random();
		int n = r.nextInt(ss);
		if(n==0) {
			n=n+1;
		}
		cl_click(w.findElement(By.xpath(sign.replace("#DELIM#",String.valueOf(n)))));
		Thread.sleep(000);
		log.info("Sign is picked");
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",continueProcess);
		cl_click(continueProcess);
		Thread.sleep(20000);
		b.getScreenshot();

	}


	/*public void verifyemSignerSMTP(String fromAdd, String sbjct,String sheetName) throws Exception {
		cl_click(chckbxSndMail);

		if(!rBtnemSignerSMTP.isSelected()) {
			cl_click(rBtnemSignerSMTP);
			cl_click(continueProcess);
			String msg= processContinueMsg.getText();
			cl_click(okBtn);
			Utility.comparelogic(msg,sheetName);

			cl_entertext(fromAddress, fromAdd);
			cl_entertext(subject, sbjct);
			cl_click(continueProcess);
			String msg1= processContinueMsg.getText();		
			cl_click(okBtn);
			Utility.comparelogic(msg1,sheetName);
		}
	}

	public void verifyOtherSMTP(String sbjct,String sheetName) throws Exception {

		if(!rBtnOtherSMTP.isSelected()) {
			cl_click(rBtnOtherSMTP);
			cl_click(continueProcess);
			String msg= processContinueMsg.getText();	
			Utility.comparelogic(msg,sheetName);
			cl_click(okBtn);

			cl_entertext(subject, sbjct);
			cl_click(continueProcess);
			String msg1= processContinueMsg.getText();	
			Utility.comparelogic(msg1,sheetName);
			cl_click(okBtn);
		}
	}*/

}
