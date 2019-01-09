package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_Settings;
import Page_Factory.pf_loginpage;

public class Setting_Script extends Basefunctions {
	final static Logger log = Logger.getLogger(Setting_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void settingPage() throws Exception{
		pf_Settings set=new pf_Settings(w);
		et =  es.startTest("My Profile");
		set.settings();
	}

	@Test(dataProvider= "setting_page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=2,groups={"SMK","REG"})
	public void myProfileEdit(Map hm) throws Exception{	
		
		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="Settings";
		pf_Settings set=new pf_Settings(w);
		if(scriptname.equals("cancelBtnlndPage")) {
			et =  es.startTest("My Profile: "+tcid+"_" + order + "_" + browser_type);
			log.info("Check for cancel button");
			set.myProfilecnclBtn(scriptname,sheetName);
		}

		else if(scriptname.equals("saveBtnMsg")) {
			et =  es.startTest("My Profile: "+tcid+"_" + order + "_" + browser_type);
			log.info("Click save button without changing the profile information");
			set.myProfileNoEdit(scriptname,sheetName);
		}
	}
	
	@Test(dataProvider= "setting_page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=3,groups={"SMK","REG"})
	public void portNumberEdit(Map hm) throws Exception{	

		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="Settings";
		
		pf_Settings set=new pf_Settings(w);
		
		if(scriptname.equals("blnkUpdateMsg")) {
			//click update button without entering port number
			et =  es.startTest("Port Settings: "+tcid+"_" + order + "_" + browser_type);
			set.portblankUpdateBtn(scriptname,sheetName);
		}
		else if(scriptname.equals("UpdateMsg")) {
			et =  es.startTest("Port Settings: "+tcid+"_" + order + "_" + browser_type);
			//click update button by entering change port number
			set.portUpdateBtn(scriptname,sheetName);
		}
		else if(scriptname.equals("successMsg")) {
			et =  es.startTest("Port Settings: "+tcid+"_" + order + "_" + browser_type);
			set.portUpdateBtnsuccess(scriptname,sheetName);
		}

	}
	
	@Test(enabled=true,priority=4,groups={"SMK","REG"})
	public void manageAuthToken() throws Exception{		
		pf_Settings set=new pf_Settings(w);
		et =  es.startTest("Manage AuthToken");
		set.generateToken();
	}
	
	@Test(dataProvider= "setting_page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=5,groups={"SMK","REG"})
	public void editmanageAuthToken(Map hm) throws Exception{	

		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="Settings";
		
		pf_Settings set=new pf_Settings(w);
		
		if(scriptname.equals("editAuthToken")) {
			//delete the token
			et =  es.startTest("Manage AuthToken: "+tcid+"_" + order + "_" + browser_type);
			set.editAuthToken(scriptname,sheetName);
		}
	}
	
	/*@Test(dataProvider= "setting_page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=5,groups={"SMK","REG"})
	public void deletemanageAuthToken(Map hm) throws Exception{	

		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="Settings";
		
		pf_Settings set=new pf_Settings(w);
		
		if(scriptname.equals("deleteAuthToken")) {
			//delete the token
			et =  es.startTest("Manage AuthToken: "+tcid+"_" + order + "_" + browser_type);
			set.deleteAuthToken(scriptname,sheetName);
		}
	}*/
	
	@Test(enabled=true,priority=6,groups={"SMK","REG"})
	public void autoDelegate() throws Exception{		
		pf_Settings set=new pf_Settings(w);
		et =  es.startTest("Auto Delegate");
		set.createAutoD();
	}
	
	@Test(enabled=true,priority=7,groups={"SMK","REG"})
	public void manageAdhocUser() throws Exception{		
		pf_Settings set=new pf_Settings(w);
		et =  es.startTest("Auto Delegate");
		set.createAdhocUser();
	}
	
	@Test(dataProvider= "setting_page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=8,groups={"SMK","REG"})
	public void editNDeleteAdhocUser(Map hm) throws Exception{	

		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="Settings";
		
		pf_Settings set=new pf_Settings(w);
		
		if(scriptname.equals("editAdhocUserMsg")) {
			//edit adhoc User
			et =  es.startTest("Manage Adhoc User: "+tcid+"_" + order + "_" + browser_type);
			set.editAdhocUser(scriptname,sheetName);
		}
		if(scriptname.equals("deleteAdhocUserMsg")) {
			//delete adhoc User
			et =  es.startTest("Manage Adhoc User: "+tcid+"_" + order + "_" + browser_type);
			set.deleteAdhocUser(scriptname,sheetName);
		}
	}
	
	/*@Test(enabled=true,priority=10,groups={"SMK","REG"})
	public void validateSignedFile() throws Exception{		
		pf_Settings set=new pf_Settings(w);
		et =  es.startTest("Auto Delegate");
		String file=Utility.getpropertydetails("SignedFile");
		set.validateFile(file,w);
	}*/
	
}





