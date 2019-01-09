package Page_Factory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Scripts.Setting_Script;

public class pf_DocstorePage extends pf_genericmethods {
	final static Logger log = Logger.getLogger(pf_DocstorePage.class);
	Basefunctions b = new Basefunctions();
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"TopMenu\"]/ul/li[1]/a/span") WebElement dashboard;
	@FindBy(how = How.XPATH, using = "//a[@id=\"status-cosignpending-link\"]") WebElement waitingForOthers;
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='tblPendingInformation']/tbody/tr")}) public List<WebElement> waitForOthersList;
	
	String doc="//table[@id='tblPendingInformation']/tbody/tr[#DELIM#]/td[8]/ul/li[3]/a/i";
	String docName="//table[@id='tblPendingInformation']/tbody/tr[#DELIM#]/td[4]";
	@FindBy(how = How.XPATH, using = "//span[text()='Doc store']") WebElement docStore;
	//title
	@FindBy(how = How.XPATH, using = "//*[text()='Document Store']") WebElement docStoreTitle;
	//share button
	@FindBy(how = How.XPATH, using = "//*[@id=\"btnshareid\"]/i") WebElement docShareBtn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/div/ul/li[2]/a/i") WebElement docDwnldBtn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/div/ul/li[1]/a/i") WebElement doctagBtn;
	//*[@id="pager_left"]/div/ul/li[1]/a/i
	//search button
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/table/tbody/tr/td[2]") WebElement searchBtn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/table/tbody/tr/td[1]/div") WebElement clearBtn;
	
	@FindBy(how = How.ID, using = "cb_WorkFlowGrid") WebElement cb_WorkFlowGrid;
	//search doc name
	@FindBy(how = How.ID, using = "gs_DocumentName") WebElement docNameSearch;
		
	//upload Document

	@FindBy(how = How.XPATH, using = "//a[text()='Upload Document']") WebElement uploadDocBtn; 

	@FindBy(how = How.ID, using = "treetag") WebElement BrowseCategory;
	@FindBy(how = How.XPATH, using = "//div[@class='modal-content']") WebElement BrowseCategoryPopup;

	@FindBy(how = How.ID, using = "searchid") WebElement popupSearch;
	//Select workflow
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='jstree']/ul/li")}) public List<WebElement> WFSearchList;
	String Userwflist = "//div[@class='jstree-section']/div/ul/li[#DELIM#]/a";
	//upload document	
	//@FindBy(how = How.ID, using = "btnFileUpload") WebElement uploadDocument;

	@FindBy(how = How.CSS, using = "input#btnFileUpload") WebElement uploadDocument;

	@FindBy(how = How.XPATH, using = "//*[text()='Uploaded Documents']") WebElement uploadedDoc;
	//action

	@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[10]/ul") WebElement action;
	//Status 
	
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='WorkFlowGrid']/tbody/tr[not(@class='jqgfirstrow')]/td[9]")}) public List<WebElement> statusCount;
	String status="//table[@id='WorkFlowGrid']/tbody/tr[not(@class='jqgfirstrow')][#DELIM#]/td[9]";
	//@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[10]/ul") WebElement action;
	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-actions']/li/a") WebElement viewDoc;
	//Mark it as inactive
	@FindBy(how = How.XPATH, using = "//*[@id=\"lnkDelete\"]/i") WebElement markAsInactive;
	//Download the file	
	@FindBy(how = How.XPATH, using = "//ul[@id='actionSettings']/li[3]/a") WebElement downloadDoc;
	//Tag Category
	@FindBy(how = How.XPATH, using = "//*[@id=\"lnkMapCategory\"]/i") WebElement tagWF;
	//Share file button
	@FindBy(how = How.XPATH, using = "//a[@class='lnkshare']/i") WebElement shareFile; 
	//Email ID
	@FindBy(how = How.ID, using = "txtemail") WebElement emailID; 
	@FindBy(how = How.ID, using = "btnshared") WebElement emailSendBtn;
	//success msg	
	//@FindBy(how = How.XPATH, using = "//div[contains(text(),'You're done!')]") public WebElement sendBtnSuccessMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@class='success']") public WebElement sendBtnSuccessMsg;
	//ok button
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;
	
	//export to excel button	
	@FindBy(how = How.ID, using = "btnExport") WebElement exportToExcelBtn;
	public pf_DocstorePage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}




	public void clickDocstore() throws Exception {
		cl_click(docStore);
		Thread.sleep(3000);
		System.out.println("Title Document Store is displayed: "+docStoreTitle.isDisplayed());
		cl_click(dashboard);
		Thread.sleep(3000);
		cl_click(waitingForOthers);
		int size=waitForOthersList.size();
		if(size>0)
		{
			Random r=new Random();
			int n=r.nextInt(size);
			if(n==0) {
				n=n+1;
			}
			WebElement a = b.w.findElement(By.xpath(docName.replace("#DELIM#",String.valueOf(n))));
			String name=a.getText();
			System.out.println("name: "+name);
			cl_click(b.w.findElement(By.xpath(doc.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(2000);
			cl_click(okBtn);
			Thread.sleep(3000);
		
			cl_click(docStore);
			Thread.sleep(5000);
			log.info("--Doc Store page--");
			cl_click(searchBtn);
			log.info("Search button is clicked");
			cl_entertext(docNameSearch, name);
			Robot rob=new Robot();
			rob.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			try {
			cl_click(cb_WorkFlowGrid);
			cl_click(docDwnldBtn);
			Thread.sleep(2000);
			log.info("Download button is clicked");
			cl_click(docShareBtn);
			Thread.sleep(2000);
			log.info("Document share button is clicked");
			String mailID=Utility.getpropertydetails("DocStoreShareMailID");
			cl_entertext(emailID, mailID);
			Thread.sleep(2000);
			cl_click(emailSendBtn);
			Thread.sleep(3000);
			String msg=sendBtnSuccessMsg.getText();
			System.out.println("Email send successfully: "+msg);
			cl_click(okBtn);
			Thread.sleep(2000);
			cl_click(searchBtn);			
			cl_entertext(docNameSearch,name);
			Robot rob1=new Robot();
			rob1.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			cl_click(cb_WorkFlowGrid);
			cl_click(doctagBtn);
			log.info("Tag category button is clicked");
			Random r1 = new Random();
			int randomValue = r1.nextInt(WFSearchList.size());
			cl_click(b.w.findElement(By.xpath(Userwflist.replace("#DELIM#",String.valueOf(randomValue)))));
			Thread.sleep(3000);
			String msg1=sendBtnSuccessMsg.getText();
			System.out.println("Workflow mapped to the document: "+msg1);
			cl_click(okBtn);
			Thread.sleep(2000);
			}catch(Exception e) {
				cl_click(okBtn);
				log.info("No document got selected/ Checkbox is not present");
				System.out.println("No document got selected/ Checkbox is not present");
			}
			}	
		else {
			b.getScreenshot();
			System.out.println("Waiting for others signature in Dashboard page is not present");
			log.info("Waiting for others signature in Dashboard page is not present");
			Thread.sleep(2000);
		}
		
	}

		
	
	public void uploadDocument() throws Exception {
		cl_click(docStore);
		Thread.sleep(3000);
		cl_click(uploadDocBtn);
		log.info("Upload document button is clicked");
		cl_click(BrowseCategory);
		log.info("Browse Category button is clicked");
		Thread.sleep(3000);
		Random r = new Random();
		int randomValue = r.nextInt(WFSearchList.size());
		cl_click(b.w.findElement(By.xpath(Userwflist.replace("#DELIM#",String.valueOf(randomValue)))));
		Thread.sleep(3000);
				/*String path=Utility.getpropertydetails("DocStoreDocUpload");
				cl_click(uploadDocument);
				Thread.sleep(4000);
				//uploadDocument.sendKeys(path);
				//cl_click(uploadDocument);
				
//				Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\validatefile.exe");
//				Thread.sleep(8000);
*/		cl_click(uploadedDoc);
		Thread.sleep(4000);
	}




	public void actionSettings() throws Exception {
		int size=statusCount.size();
		System.out.println("size"+size);
		Random r1 = new Random();
		int ran = r1.nextInt(statusCount.size());
		WebElement statusv = b.w.findElement(By.xpath(status.replace("#DELIM#",String.valueOf(ran))));
		Thread.sleep(3000);
		String value=statusv.getText();
		if(value.equals("Initiate")) {
			cl_click(downloadDoc);
			Thread.sleep(2000);
			log.info("Download button present in actions is clicked");
			cl_click(shareFile);
			Thread.sleep(2000);
			log.info("Share button present in actions is clicked");
			String mailID=Utility.getpropertydetails("DocStoreShareMailID");
			cl_entertext(emailID, mailID);
			Thread.sleep(2000);
			cl_click(emailSendBtn);
			Thread.sleep(3000);
			String msg=sendBtnSuccessMsg.getText();
			System.out.println("Email send successfully: "+msg);
			cl_click(okBtn);
			Thread.sleep(2000);
			cl_click(tagWF);
			log.info("Tag category button present in actions is clicked");
			Random r = new Random();
			int randomValue = r.nextInt(WFSearchList.size());
			cl_click(b.w.findElement(By.xpath(Userwflist.replace("#DELIM#",String.valueOf(randomValue)))));
			Thread.sleep(3000);
			String msg1=sendBtnSuccessMsg.getText();
			System.out.println("Workflow mapped to the document: "+msg1);
			cl_click(okBtn);
			Thread.sleep(2000);
		}
		else if(value.equals("Completed")){
			cl_click(viewDoc);
			log.info("View Document button present in actions is clicked");
			Thread.sleep(4000);
		}else {
			b.getScreenshot();
			log.info("Status is neither Initiate or Completed, Screenshot taken");
			System.out.println("Screenshot Taken");
			Thread.sleep(2000);
		}
	}


	public void exportToExcel() {
		cl_click(exportToExcelBtn);
		log.info("Export to Excel button is clicked");
	}
}
