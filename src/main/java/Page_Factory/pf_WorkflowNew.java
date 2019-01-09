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

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_WorkflowNew extends pf_genericmethods {
	final static Logger log = Logger.getLogger(pf_WorkflowNew.class);

	Basefunctions b = new Basefunctions(); 
	//workflow elements
	@FindAll({@FindBy(how = How.XPATH, using = "//ul[@id='adminWorkflowMenu']/li[2]/ul/li")}) public List<WebElement> workflowlist;
	String source ="//ul[@id='adminWorkflowMenu']/li[2]/ul/li[#DELIM#]/a/span[1]";
	//Workflow submenu elements

	@FindAll({@FindBy(how = How.XPATH, using = "//*[@id='adminWorkflowMenu']/li[2]/ul/li[1]/ul/li")}) public List<WebElement> submenuorkflowlist;
	String submenusource = "//*[@id='adminWorkflowMenu']/li[2]/ul/li[#DELIM#]/ul/li[1]/a";


	@FindBy(how = How.XPATH, using = "//span[@class='arrow open']") public WebElement arrowOpen;
	@FindBy(how = How.ID, using = "frmSign") WebElement uploadDocPage;

	@FindBy(how = How.XPATH, using = "//div[@class='workflow-section row ']") WebElement spcfyParticipantsPage;
	//document list 
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='tblDocDetails']/tbody/tr")}) public List<WebElement> docNamelist;

	//Choose file button
	@FindBy(how = How.XPATH, using = "//div[@class='content-body']/div/table/tbody/tr/td[3]/input") public WebElement chooseFile;
	//without selecting file press continue button
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please upload document')]") WebElement withoutFileCBtn;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;

	//without signatory save and continue button
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please map user')]") WebElement withoutSignSaveBtn;

	@FindBy(how = How.ID, using = "btnstep1") WebElement saveNContinueBtn;

	//signatory 1
	@FindBy(how = How.XPATH, using = "//div[@class='signerwrapper']/ul/li/ul/li/a") WebElement signatoryBtn;

	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='signerwrapper']/ul/li")}) public List<WebElement> docmtList;
	String documentList="//div[@class='signerwrapper']/ul/li[#DELIM#]";
	//Signatory list
	//@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='signerwrapper']/ul/li/ul/li")}) public List<WebElement> signatoryList;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='signerwrapper']/ul/li/ul/li")}) public List<WebElement> signatoryList;
	String signatory="//div[@class='signerwrapper']/ul/li/ul/li[#DELIM#]/a";

//	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='signerwrapper']/ul/li/ul/li/a[contains(text(),'Review')]")}) public List<WebElement> reviewList;
//	String reviewer="//div[@class='signerwrapper']/ul/li/ul/li[#DELIM#]/a";
	
	//Reviewer comment	
	@FindAll({@FindBy(how = How.XPATH, using = "//section[@class='box']/div[2]/div/div/div/div[1]/div/div")}) public List<WebElement> reviewerComntSize;
	//String rcomment="//div[@class='documentContainment']/div/div[#DELIM#]/textarea";
	String rcomment="//section[@class='box']/div[2]/div/div/div/div[#DELIM#]/div/div/textarea";
	//comment count 
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='singerWrapper']/div/div")}) public List<WebElement> rComntSize;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='signatories-section']/ul/li")}) public List<WebElement> signatoryIDs;
	//signatory radio button
	String signatoryRButton="//div[@class='signatories-section']/ul/li[#DELIM#]/span/input";
	//radio button  
	@FindBy(how = How.XPATH, using = "//span[@class='chk-signer']/input") WebElement radioBtn;
	//apply button
	@FindBy(how = How.ID, using = "btnSignatorySave") WebElement applyBtn; 
	//continue button
	@FindBy(how = How.ID, using = "btnValue") WebElement continueBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"div-dsign\"]/label") public WebElement dsign;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='sign-font-block']/ul/li")}) public List<WebElement> signs;
	//String si = "//div[@class='sign-font-block']/ul/li[#DELIM#]/input";
	String si = "//div[@class='innertab-panel']/div/ul/li[#DELIM#]/span[2]";
	@FindBy(how = How.ID, using = "btnradiosign") WebElement signbutton;

	public pf_WorkflowNew(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void selectWorkflow(WebDriver driver) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		int size = workflowlist.size();

		System.out.println("size"+size);
		//works for s=6,7,10, 9
		for(int s=7;s<=size;s++) {		
		WebElement fe = w.findElement(By.xpath(source.replace("#DELIM#",String.valueOf(s))));
		System.out.println(fe.getText());		
		js.executeScript("arguments[0].scrollIntoView();",fe);
		cl_click(fe);
		Thread.sleep(50000);
		try{
			if(arrowOpen.isDisplayed()) {
				System.out.println("open arrow is present");
				cl_click(w.findElement(By.xpath(submenusource.replace("#DELIM#",String.valueOf(s)))));
				Thread.sleep(40000);
		
				String url=w.getCurrentUrl();
				System.out.println(url);
				//boolean aa=continueBtn.isDisplayed();
				if(url.contains("Verticalization")) {
					int docList=docNamelist.size();
					System.out.println("Doclist"+docList);
					cl_click(continueBtn);
					System.out.println("Without choosing file,press continue button: "+withoutFileCBtn.getText());
					Thread.sleep(1000);
					cl_click(okBtn);
					String filePath=Utility.getpropertydetails("WorkflowChooseFilePath");
					Thread.sleep(2000);
					cl_entertext(chooseFile, filePath);
					cl_click(continueBtn);
					Thread.sleep(4000);	
					cl_click(saveNContinueBtn);
					System.out.println("Without Signatory,press save and continue button: "+withoutSignSaveBtn.getText());
					Thread.sleep(1000);
					cl_click(okBtn);				
					int signatorysize=signatoryList.size();
					System.out.println("signatory: "+signatoryList.size());
					for(int k=1;k<=signatorysize;k++) {
						cl_click(w.findElement(By.xpath(signatory.replace("#DELIM#",String.valueOf(k)))));					
						cl_click(w.findElement(By.xpath(signatoryRButton.replace("#DELIM#",String.valueOf(k)))));
						Thread.sleep(2000);
						cl_click(applyBtn);
						Thread.sleep(3000);
					}					
						Thread.sleep(2000);
						cl_click(saveNContinueBtn);
						Thread.sleep(5000);
						cl_click(dsign);
						Thread.sleep(2000);
						int ss = signs.size();
						Random r = new Random();
						int n = r.nextInt(ss);
						cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
						Thread.sleep(1000);
						cl_click(signbutton);
						Thread.sleep(20000);
						b.getScreenshot();
					
				}
				else {
					
					cl_click(saveNContinueBtn);
					System.out.println("Without Signatory,press save and continue button: "+withoutSignSaveBtn.getText());
					Thread.sleep(1000);
					cl_click(okBtn);
					int signatorysize=signatoryList.size();
					
					System.out.println("signatory: "+signatoryList.size());
					
					//for having only one doc --Signatory
					for(int k=1;k<=signatorysize;k++) {
						cl_click(w.findElement(By.xpath(signatory.replace("#DELIM#",String.valueOf(k)))));					
						cl_click(w.findElement(By.xpath(signatoryRButton.replace("#DELIM#",String.valueOf(k)))));
						Thread.sleep(2000);
						cl_click(applyBtn);
						Thread.sleep(1000);
					}
						Thread.sleep(4000);
						cl_click(saveNContinueBtn);
						Thread.sleep(10000);
						cl_click(dsign);
						int ss = signs.size();
						Random r = new Random();
						int n = r.nextInt(ss);
						Thread.sleep(3000);
						cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
						Thread.sleep(3000);
						cl_click(signbutton);
						Thread.sleep(20000);
						b.getScreenshot();
							}
				}
		}catch(Exception e){

					String url=w.getCurrentUrl();
					System.out.println(url);
					//boolean aa=continueBtn.isDisplayed();
					if(url.contains("Verticalization")) {
						int docList=docNamelist.size();
						System.out.println("Doclist"+docList);
						cl_click(continueBtn);
						System.out.println("Without choosing file,press continue button: "+withoutFileCBtn.getText());
						Thread.sleep(1000);
						cl_click(okBtn);
						String filePath=Utility.getpropertydetails("WorkflowChooseFilePath");
						Thread.sleep(2000);
						cl_entertext(chooseFile, filePath);
						cl_click(continueBtn);
						Thread.sleep(4000);	
						cl_click(saveNContinueBtn);
						System.out.println("Without Signatory,press save and continue button: "+withoutSignSaveBtn.getText());
						Thread.sleep(1000);
						cl_click(okBtn);				
						int signatorysize=signatoryList.size();
						System.out.println("signatory: "+signatoryList.size());
						for(int k=1;k<=signatorysize;k++) {
							cl_click(w.findElement(By.xpath(signatory.replace("#DELIM#",String.valueOf(k)))));					
							cl_click(w.findElement(By.xpath(signatoryRButton.replace("#DELIM#",String.valueOf(k)))));
							Thread.sleep(2000);
							cl_click(applyBtn);
							Thread.sleep(3000);
						}
						
							Thread.sleep(2000);
							cl_click(saveNContinueBtn);
							Thread.sleep(5000);
							cl_click(dsign);
							Thread.sleep(2000);
							int ss = signs.size();
							Random r = new Random();
							int n = r.nextInt(ss);
							cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
							Thread.sleep(1000);
							cl_click(signbutton);
							Thread.sleep(20000);
							b.getScreenshot();
						
					}
					else {
						cl_click(saveNContinueBtn);
						System.out.println("Without Signatory,press save and continue button: "+withoutSignSaveBtn.getText());
						Thread.sleep(1000);
						cl_click(okBtn);
						int signatorysize=signatoryList.size();
						
						System.out.println("signatory: "+signatoryList.size());
						
						//for having only one doc --Signatory
						for(int k=1;k<=signatorysize;k++) {
							cl_click(w.findElement(By.xpath(signatory.replace("#DELIM#",String.valueOf(k)))));					
							cl_click(w.findElement(By.xpath(signatoryRButton.replace("#DELIM#",String.valueOf(k)))));
							Thread.sleep(2000);
							cl_click(applyBtn);
							Thread.sleep(1000);
						}
							Thread.sleep(4000);
							cl_click(saveNContinueBtn);
							Thread.sleep(10000);
							cl_click(dsign);
							int ss = signs.size();
							Random r = new Random();
							int n = r.nextInt(ss);
							Thread.sleep(3000);
							cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
							Thread.sleep(3000);
							cl_click(signbutton);
							Thread.sleep(20000);
							b.getScreenshot();
//								}
					}
				}
			}
	}
}

