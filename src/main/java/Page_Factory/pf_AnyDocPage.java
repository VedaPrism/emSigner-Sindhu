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
import org.testng.Assert;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_AnyDocPage extends pf_genericmethods {

	Basefunctions b = new Basefunctions();
	final static Logger log = Logger.getLogger(pf_AnyDocPage.class);

	@FindBy(how = How.ID, using = "main-content") WebElement onlineSigngPage;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-menu-wrapper\"]/a[1]/span") WebElement AnyDoc;
	@FindBy(how = How.XPATH, using = "//*[@id=\"btnpdfupload\"]") WebElement uploadDoc; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"li\"]/span[1]") WebElement uploadDocNameSize;
	@FindBy(how = How.XPATH, using = "//span[text()='Uploaded']") WebElement uploaded; 
	@FindBy(how = How.ID, using = "btnStep1Continue") WebElement continueBtn;

	//title
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/form/div[1]/div/div/h1") WebElement titleOnlneSign;

	@FindBy(how = How.XPATH, using = " //div[@class='message-box']") WebElement msgBoxBelowReference; 

	//message while uploading doc other than pdf
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'NOTE:Only .PDF document(s)')]") WebElement uploadMessage;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;

	//choose template 
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Choose Temp')]") WebElement chooseTemp;
	@FindBy(how = How.ID, using = "template-selection") WebElement docTemplate;
	//back button 
	@FindBy(how = How.ID, using = "btntemplateCancel") WebElement backBtn;

	//cross button beside signatory one  
	@FindBy(how = How.ID, using = "signatoryDelete_1") WebElement crossBtn;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Atleast one')]") WebElement crossBtnMsg;

	@FindBy(how = How.XPATH, using = "//a[text()='Signatory  1']") WebElement addSign;
	//+ icon
	@FindBy(how = How.ID, using = "addnewsigner") WebElement plusIcon;
	//Select signing type page
	@FindBy(how = How.ID, using = "Step1Left") WebElement selectSignTypePage;
	//back button 
	@FindBy(how = How.ID, using = "btnadhocAddCancel") WebElement bckBtnAddNewSigner; 

	//first Radio button(ME)
	@FindBy(how = How.XPATH, using = "//*[@title='ME']") WebElement radioBtn;
	//apply button
	@FindBy(how = How.ID, using = "btnSignatorySave") WebElement applyBtn; 
	//Template Name
	@FindBy(how = How.XPATH, using = "//div[@id='docSignerRight']/div[1]/ul/li/ul/li/span/span/div/input") WebElement tempName;
	//alert msg if the template name alert exist	
	@FindBy(how = How.ID, using = "msgcontent") WebElement alertMsg;
	//save and continue button
	@FindBy(how = How.ID, using = "btnstep1") WebElement saveNCntnue;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please enter template name to  ')]") WebElement saveCntnueMsg;

	@FindBy(how = How.XPATH, using = "//span[text()='Add Signatory']") WebElement addSignatory;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"div-dsign\"]/label") public WebElement dsign;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='sign-font-block']/ul/li")}) public List<WebElement> signs;
	String si = "//div[@class='innertab-panel']/div/ul/li[#DELIM#]/span[2]";
	@FindBy(how = How.ID, using = "btnradiosign") WebElement signbutton;

	public pf_AnyDocPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}


	public void anyDocument(String sheetName,String scriptname) throws Exception {
		cl_click(AnyDoc);
		log.info("--Online signing page--");
		System.out.println("Title of the Page: "+titleOnlneSign.getText());
		String msg=msgBoxBelowReference.getText();
		Utility.comparelogic(msg,sheetName,scriptname);

	}


	public void uploadNonPDF(String path, String sheetName, String scriptname) throws Exception {
		log.info("--Upload NON PDF document--");
		cl_entertext(uploadDoc, path);
		String upldnonPDFMsg=uploadMessage.getText();
		cl_click(okBtn);
		Utility.comparelogic(upldnonPDFMsg,sheetName,scriptname);

	}


	public void uploadPDF(String pdfpath, String sheetName) throws Exception {
		log.info("--Upload PDF document--");
		cl_entertext(uploadDoc, pdfpath);
		Thread.sleep(10000);
		System.out.println("File name and Size: "+uploadDocNameSize.getText());
		/*if(uploaded.isDisplayed()) {
			System.out.println("File got uploaded");
		}else {
			System.out.println("File not uploaded");
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
			log.info("Screenshot taken");
			Assert.fail();
		}*/
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",continueBtn);
		cl_click(continueBtn);
		Thread.sleep(30000);
		cl_click(saveNCntnue);
		System.out.println("without Template/signatory save and continue button: "+saveCntnueMsg.getText());
		cl_click(okBtn);
		cl_click(chooseTemp);
		if(docTemplate.isDisplayed()) {
			System.out.println("Document Template page is displayed");
		}else {
			System.out.println("Document Template page not displayed");
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
			log.info("Screenshot taken");
			Assert.fail();	
		}
		Thread.sleep(2000);
		cl_click(backBtn);
		Thread.sleep(2000);

	}


	public void addSignatory(String sheetName, String scriptname) throws Exception {
		Thread.sleep(2000);
		cl_click(addSignatory);
		log.info("Add signatory is clicked");
		cl_click(crossBtn);
		String msg=crossBtnMsg.getText();
		Utility.comparelogic(msg, sheetName, scriptname);
		cl_click(okBtn);
		log.info("Cross button is clicked"+msg);
		Thread.sleep(1000);
		cl_click(addSign);
		/*cl_click(plusIcon);
		if(selectSignTypePage.isDisplayed()) {
			System.out.println("Add new Signer Page is displayed");
		}else {
			System.out.println("Add new Signer Page is not displayed");
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
			log.info("Screenshot taken");
			Assert.fail();
		}
		Thread.sleep(2000);
		cl_click(bckBtnAddNewSigner);*/
		cl_click(radioBtn);
		cl_click(applyBtn);
		log.info("Apply button clicked after selecting signatory");
		String templateName=Utility.getpropertydetails("AnyDocTemplateName");
		System.out.println("templateName: "+templateName);
		cl_entertext(tempName,templateName);
		cl_click(saveNCntnue);
		log.info("Save button clicked after adding template name");
		Thread.sleep(5000);
		String alrtmsg=alertMsg.getText();
		System.out.println(alrtmsg);
		if(alrtmsg.startsWith("Template name already")) {
			b.getScreenshot();
			System.out.println("Screenshot Taken");
			Assert.fail();
		}	
	}


	public void dsignDoc() throws Exception {
		log.info("--dsign page--");
		cl_click(dsign);
		log.info("dsign radio button is clicked");
		int ss = signs.size();
		Random r = new Random();
		int n = r.nextInt(ss);
		if(n==0) {
			n=n+1;
		}
		cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",signbutton);
		cl_click(signbutton);
		Thread.sleep(20000);
		log.info("Sign button is clicked");
		b.getScreenshot();
		
	}

}
