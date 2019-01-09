package Page_Factory;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic_Library.Basefunctions;

public class pf_dashboardpage extends pf_genericmethods{
	Basefunctions b = new Basefunctions();

	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class = 'row']/div")}) public List <WebElement> statuslist;
	@FindBy(how = How.XPATH, using = "//h4[@id = 'Pendingcount']") WebElement pendingcount;
	@FindBy(how = How.XPATH, using = "//h4[@id = 'Notyetstartedcount']") WebElement draftscount;
	@FindBy(how = How.XPATH, using = "//h4[@id = 'completedcount']") WebElement completedcount;
	@FindBy(how = How.XPATH, using = "//h4[@id = 'declinedcount']") WebElement declinedcount;
	@FindBy(how = How.XPATH, using = "//h4[@id = 'recalledcount']") WebElement recalledcount;

	//	Workflows elements

	@FindAll({@FindBy(how = How.XPATH, using = "//*[@id='adminWorkflowMenu']/li[2]/ul/li")}) public List<WebElement> workflowlist;
	String source ="//*[@id='adminWorkflowMenu']/li[2]/ul/li[#DELIM#]/a/span[1]";

	//	Workflow submenu elements

	@FindAll({@FindBy(how = How.XPATH, using = "//*[@id='adminWorkflowMenu']/li[2]/ul/li[1]/ul/li")}) public List<WebElement> submenuorkflowlist;
	String submenusource = "//*[@id='adminWorkflowMenu']/li[2]/ul/li[1]/ul/li[#DELIM#]/a";

	//	Documents to upload page elements

	@FindBy(how = How.XPATH, using = "//input[@id ='btnValue']") WebElement continuebtn;
	@FindBy(how = How.XPATH, using = "//div[@id ='msgcontent']") WebElement popupwindow;

	//	Verifying Doc Store and Profile name
	@FindBy(how=How.XPATH, using= "//div[@class='free-storage text-primary hidden-sm hidden-xs']") WebElement txtUnlimtedStrg;
	@FindBy(how=How.XPATH, using= "//span[text()='Doc store']") WebElement docStore;

	//	Manage workflow elements

	@FindBy(how = How.XPATH, using = "//div[@class='page-topbar']/div[2]/div[2]/ul/li/a/span") WebElement profiledropdown;
	@FindBy(how = How.XPATH, using = "//div[@class='page-topbar']/div[2]/div[2]/ul/li/ul/li[5]/a") WebElement Gotoadmin;
	@FindBy(how = How.XPATH, using = "//*[text()='Manage Workflows']") WebElement manageworkflows;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='jstree']/ul/li")}) public List<WebElement> manageworkflowlist;
	@FindBy(how = How.XPATH, using = "//*[@id='li_620_anchor']") WebElement workflowselection;
	String activitiesworkflowlist = "//div[@id='jstree']/ul/li[#DELIM#]/a";
	@FindAll({@FindBy(how = How.XPATH, using = "//ul[@class='jstree-children']/li")}) public List<WebElement> child_workflowlist;
	String childworkflow = "//ul[@class='jstree-children']/li[#DELIM#]/a";
	@FindBy(how = How.XPATH, using = "//input[@id='btnStep1Continue']") WebElement continuebutton;
	@FindBy(how = How.XPATH, using = "//div[@id='sample']") WebElement uploaddocuments;
	@FindBy(how = How.ID, using = "btnStep2Continue") WebElement uploadcontinue;
	@FindBy(how = How.ID, using = "btnprofilesave") WebElement activateworkflow;



	//	Create Work flow Elements

	@FindBy(how = How.ID, using = "btnaddgroup") WebElement createworkflow; 
	@FindBy(how = How.ID, using = "VerticalName") WebElement nameforworkflow; 
	@FindBy(how = How.ID, using = "btnSaveVertical") WebElement saveforworkflow; 
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okbutton;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='jstree']/ul/li")}) public List<WebElement> listofworkflow;


	//	Initializing the Pagefactory

	public pf_dashboardpage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void dashboardpageftn() throws Exception{
		Thread.sleep(5000);
		System.out.println("Total No of Status tabs : "+statuslist.size());
		System.out.println("Pending Count : "+pendingcount.getText());
		System.out.println("Drafts Count : "+draftscount.getText());
		System.out.println("Completed Count : "+completedcount.getText());
		System.out.println("Declined Count : "+declinedcount.getText());
		System.out.println("Recalled Count : "+recalledcount.getText());

		//	Work flows list check

		//	int wl = workflowlist.size();
		//	System.out.println("Workflows list : "+wl);
		//for(int i =1; i<=wl;i++){

		Thread.sleep(5000);
		//cl_click(b.w.findElement(By.xpath(source.replace("#DELIM#",String.valueOf(i)))))	;
		//b.w.findElement(By.xpath(source.replace("#DELIM#",String.valueOf(i)))).click();
		//		b.w.findElement(By.xpath("/html/body/div[5]/div/div/ul[1]/li[2]/ul/li[4]/a/span[2]")).click();

		cl_click(profiledropdown);
		Thread.sleep(3000);
		cl_click(Gotoadmin);
		Thread.sleep(3000);
		cl_click(manageworkflows);

		//	 Submenu of workflow check

		/*int sml = submenuorkflowlist.size();
	 for(int j=1;j<=sml;j++){

		 cl_click(b.w.findElement(By.xpath(submenusource.replace("#DELIM#",String.valueOf(j)))));
		 Thread.sleep(3000);
		 cl_click(continuebtn);
		 b.w.switchTo().alert();
		 System.out.println("Alert Message : "+popupwindow.getText());*/

		/*int mwl = manageworkflowlist.size();
		System.out.println(mwl);
		for(int k=1;k<=mwl;k++){
//			cl_click(b.w.findElement(By.xpath(activitiesworkflowlist.replace("#DELIM#",String.valueOf(k)))));
			int cwl = child_workflowlist.size();
			for(int h=1;h<=cwl;h++){
				cl_click(b.w.findElement(By.xpath(childworkflow.replace("#DELIM#",String.valueOf(h)))));
				cl_click(continuebutton);*/
		cl_click(createworkflow);
		Thread.sleep(6000);
		//			b.w.switchTo().alert();
		cl_entertext(nameforworkflow, "Automationtest2");
		Thread.sleep(2000);
		cl_click(saveforworkflow);
		Thread.sleep(6000);
		//			b.w.switchTo().alert();
		cl_click(okbutton);
		int lwf = listofworkflow.size();
		System.out.println(lwf);
		Thread.sleep(3000);

		cl_click(workflowselection);
		//			cl_click(b.w.findElement(By.id("jstree")).findElement(By.className("jstree-container-ul jstree-children")).findElement(By.className("jstree-children")).findElement(By.xpath("//*[@id='li_469]")).findElement(By.id("li_469_anchor")));
		/*JavascriptExecutor js = (JavascriptExecutor)b.w;
			WebElement element = b.w.findElement(By.xpath("//*[@class='jstree-anchor'][4]"));
			String script = "arguments[0].click();";
			js.executeScript(script, element);
//			cl_click(b.w.findElement(By.xpath("//i[contains(text(),'Automationtest'")));
		 */			Thread.sleep(5000);
		cl_click(continuebutton);
		 Thread.sleep(2000);
		 cl_click(uploaddocuments);
		 Thread.sleep(2000);
		 Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\emSigner scripts\\autoit scripts\\uploadfiles.exe");
		 Thread.sleep(2000);
		 cl_click(uploadcontinue);
		 Thread.sleep(3000);
		 cl_click(activateworkflow);
	}

	public void verifytxt() {
		System.out.println("Verify the text: "+txtUnlimtedStrg.getText());
		System.out.println("Verify the text: "+docStore.getText());
	}

}


