package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_loginpage;
import Page_Factory.pf_reports;

public class Reports_Script  extends Basefunctions  {
	final static Logger log = Logger.getLogger(Reports_Script.class);

	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void reports() throws Exception{
		pf_reports rep=new pf_reports(w);
		rep.agingReport();
		rep.agingPivotReport();
		rep.workflowDetailedReport();
		rep.workflowCompletedDetailsReport();
	}
}

