package Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_reports extends pf_genericmethods {
	Basefunctions b = new Basefunctions();
	//Aging Reports
	//Report	
	@FindBy(how = How.ID, using = "Reports") WebElement reports;
	@FindBy(how = How.ID, using = "AgingReport") WebElement agingReport;

	//from date 
	@FindBy(how = How.ID, using = "txtfromdate") WebElement fromDate;
	//to date
	@FindBy(how = How.ID, using = "txttodate") WebElement toDate;
	//search button
	@FindBy(how = How.ID, using = "btnReportsubmit") WebElement searchAgingR;
	//reset button 
	@FindBy(how = How.ID, using = "btnCancel") WebElement resetAgingR;
	
	//Aging Pivot Report
	@FindBy(how = How.ID, using = "AgingPivotReport") WebElement agingPivotReport;
	//Workflow Detailed Report
	@FindBy(how = How.ID, using = "WorkflowDetailedReport") WebElement workflowDetailedReport;
	//Workflow Completed Details Report
	@FindBy(how = How.ID, using = "WorkflowCompletedDetailsReport") WebElement workflowCompletedDetailsReport;
	//My Schedule Report
	@FindBy(how = How.ID, using = "MyScheduleReport") WebElement myScheduleReport;
	
	public pf_reports(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void agingReport() throws Exception {
		cl_click(reports);
		cl_click(agingReport);
		cl_click(resetAgingR);
		Thread.sleep(3000);
		String startDate=Utility.getpropertydetails("AgingReportStartDate");
		cl_entertext(fromDate, startDate);
		String toD=Utility.getpropertydetails("AgingReportToDate");
		cl_entertext(toDate, toD);
		cl_click(searchAgingR);
		Thread.sleep(3000);
		b.getScreenshot();
	}
	
	public void agingPivotReport() throws Exception {
		cl_click(reports);
		cl_click(agingPivotReport);
		cl_click(resetAgingR);
		Thread.sleep(3000);
		String startDate=Utility.getpropertydetails("AgingPivotReportStartDate");
		cl_entertext(fromDate, startDate);
		String toD=Utility.getpropertydetails("AgingPivotReportToDate");
		cl_entertext(toDate, toD);
		cl_click(searchAgingR);
		Thread.sleep(3000);
		b.getScreenshot();
	}
	
	public void workflowDetailedReport() throws Exception {
		cl_click(reports);
		cl_click(workflowDetailedReport);
		cl_click(resetAgingR);
		Thread.sleep(3000);
		String startDate=Utility.getpropertydetails("wrkflwDetailedRprtStartDate");
		cl_entertext(fromDate, startDate);
		String toD=Utility.getpropertydetails("wrkflwDetailedRprtToDate");
		cl_entertext(toDate, toD);
		cl_click(searchAgingR);
		Thread.sleep(3000);
		b.getScreenshot();
	}
	
	public void workflowCompletedDetailsReport() throws Exception {
		cl_click(reports);
		cl_click(workflowCompletedDetailsReport);
		cl_click(resetAgingR);
		Thread.sleep(3000);
		String startDate=Utility.getpropertydetails("wrkflwCmplteDtlRprtStartDate");
		cl_entertext(fromDate, startDate);
		String toD=Utility.getpropertydetails("wrkflwCmplteDtlRprtToDate");
		cl_entertext(toDate, toD);
		cl_click(searchAgingR);
		Thread.sleep(3000);
		b.getScreenshot();
	}
}
