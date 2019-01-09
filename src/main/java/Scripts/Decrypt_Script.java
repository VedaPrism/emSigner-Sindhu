package Scripts;


import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import Generic_Library.Basefunctions;
import Page_Factory.pf_DecryptPage;
import Page_Factory.pf_Settings;
import Page_Factory.pf_loginpage;

public class Decrypt_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(Decrypt_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void settingPage() throws Exception{
		pf_Settings set=new pf_Settings(w);
		set.settings();
	}
	@Test(dataProvider= "Decrypt_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=2,groups={"SMK","REG"})
	public void DecryptPage(Map hm) throws Exception{

		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetname="Decrypt";

		pf_DecryptPage decrypt=new pf_DecryptPage(w);

		/*if(scriptname.equals("CancelBtnLndngPage")){
		et =  es.startTest("Decrypt: "+tcid+"_" + order + "_" + browser_type);
		//click on Decrypt button and Verify cancel button
		decrypt.verifyDecryptCancelBtn(sheetname,scriptname);
		}*/

		if(scriptname.equals("DecryptNowBtnMsg")){
			et =  es.startTest("Decrypt: "+tcid+"_" + order + "_" + browser_type);
			decrypt.verifyDecrypt(sheetname,scriptname);
		}
		//		//verifying browse document by passing source,dest folder path
		else if(scriptname.equals("DecryptNowBtnDestMsg")){
			et =  es.startTest("Decrypt: "+tcid+"_" + order + "_" + browser_type);
			decrypt.decryptNow(sheetname,scriptname);
		}
	}
}
