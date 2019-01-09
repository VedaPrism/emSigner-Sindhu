package Scripts;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_dashboardpage;
import Page_Factory.pf_loginpage;



public class Dashboard_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(Dashboard_Script.class);

	@Test(priority=1,groups={"SMK","REG"})
	public void dashboardPage() throws Exception{

//		String scriptname=hm.get("Script_Name").toString();
//		tcid = hm.get("TC_ID").toString();
//		order=hm.get("Order").toString();

		String sheetName ="Dashboard";
		System.out.println(sheetName);
		pf_dashboardpage ph = new pf_dashboardpage(w);

		ph.dashboardpageftn();

		ph.verifytxt();	
		//cv_equals(actualTxt,exp,scriptname);
		//ph.verifySubDocTxt();
		//cv_equals(actlDocStrTxt,exp,scriptname);
	}
}
