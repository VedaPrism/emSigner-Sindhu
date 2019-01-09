package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_AdminSettings;
import Page_Factory.pf_Settings;
import Page_Factory.pf_loginpage;

public class AdminSettings_Script extends Basefunctions {
	final static Logger log = Logger.getLogger(AdminSettings_Script.class);

	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void settingPage() throws Exception{	

		pf_AdminSettings set=new pf_AdminSettings(w);
		et =  es.startTest("My Profile");
		set.settings();
	} 

	@Test(dataProvider= "admin_setting",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=3,groups={"SMK","REG"})
	public void manageDept(Map hm) throws Exception{
		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="AdminSettings";
		pf_AdminSettings set=new pf_AdminSettings(w);
		if(scriptname.equals("cancelBtnDept")) {
			et =  es.startTest("Manage Department: "+tcid+"_" + order + "_" + browser_type);
			set.manageDeptcnclBtn(scriptname,sheetName);
		}
		else if(scriptname.equals("saveBtnWithoutDept")) {
			et =  es.startTest("Manage Department: "+tcid+"_" + order + "_" + browser_type);
			set.saveBtnWithoutDept(scriptname,sheetName);		
		}
		else if(scriptname.equals("saveBtnWithoutWF")) {
			et =  es.startTest("Manage Department: "+tcid+"_" + order + "_" + browser_type);
			set.saveBtnWithoutWF(scriptname,sheetName);		
		}
		else if(scriptname.equals("withoutEditSaveBtn")) {
			et =  es.startTest("Manage Department: "+tcid+"_" + order + "_" + browser_type);
			set.withoutEditSaveBtn(scriptname,sheetName); 
		}
		else if(scriptname.equals("changeDNameSaveBtn")) {
			et =  es.startTest("Manage Department: "+tcid+"_" + order + "_" + browser_type);
			set.changeDNameSaveBtn(scriptname,sheetName); 
		}
		else if(scriptname.equals("deleteDeptBtn")) {
			et =  es.startTest("Manage Department: "+tcid+"_" + order + "_" + browser_type);
			set.deleteDeptBtn(scriptname,sheetName); 
		}
	}
	
	@Test(dataProvider= "admin_setting",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=4,groups={"SMK","REG"})
	public void manageUsers(Map hm) throws Exception{
		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="AdminSettings";
		pf_AdminSettings set=new pf_AdminSettings(w); 
		if(scriptname.equals("UserWFSuccessMsg")) {
		set.createNewUser(scriptname,sheetName);
		}
		else if(scriptname.equals("editsaveBtnUser")) {
			et =  es.startTest("Manage Users: "+tcid+"_" + order + "_" + browser_type);
			set.editsaveBtnUser(scriptname,sheetName);
			}
		else if(scriptname.equals("deleteuser")) {
			et =  es.startTest("Manage Users: "+tcid+"_" + order + "_" + browser_type);
			set.deleteuser(scriptname,sheetName);
			}
	}
	
	
	@Test(enabled=true,priority=5,groups={"SMK","REG"})
	public void manageUsers() throws Exception{
		
		pf_AdminSettings set=new pf_AdminSettings(w);
		set.create_manage_workflows();
		set.manage_workflows();
	}
	
	/*@Test(enabled=true,priority=6,groups={"SMK","REG"})
	public void subscription() throws Exception{
		
		pf_AdminSettings set=new pf_AdminSettings(w);
		set.renew_subscription();
	}*/
	
	@Test(enabled=true,priority=7,groups={"SMK","REG"})
	public void activityLog() throws Exception{
		
		pf_AdminSettings set=new pf_AdminSettings(w);
		set.activity_log();
	}
}

