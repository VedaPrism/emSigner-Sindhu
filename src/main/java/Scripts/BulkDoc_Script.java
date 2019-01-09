package Scripts;

import java.io.File;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_BulkDocument;
import Page_Factory.pf_genericmethods;
import Page_Factory.pf_loginpage;

public class BulkDoc_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(BulkDoc_Script.class);

	@Test(dataProvider= "Bulk_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void bulkDoc(Map hm) throws Exception{

		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="BulkDoc"; 
		
		pf_BulkDocument bulk=new pf_BulkDocument(w);
		
		if(scriptname.equals("Continueclick")) {
			et =  es.startTest("Bulk Doc: "+tcid+"_" + order + "_" + browser_type);
			bulk.bulkSigning(sheetName,scriptname);
			
		}
		//uploading non PDF file
		else if(scriptname.equals("uploadNonPDF")) {
			et =  es.startTest("Bulk Doc: "+tcid+"_" + order + "_" + browser_type);
			File f1=new File(Utility.getpropertydetails("nonPDF"));
			String path=f1.getAbsolutePath();
			bulk.uploadNonPDF(path,sheetName,scriptname);
		}		
		//uploading PDF file
		else if(scriptname.equals("saveBtnMsg")) {
			et =  es.startTest("Bulk Doc: "+tcid+"_" + order + "_" + browser_type);
			File f2=new File(Utility.getpropertydetails("PDF"));
			String pdfpath=f2.getAbsolutePath();
			bulk.uploadPDF(pdfpath,sheetName,scriptname);
		}

		//verify select page in template setting
		else if(scriptname.equals("crossBtnMsg")) {
			et =  es.startTest("Bulk Doc: "+tcid+"_" + order + "_" + browser_type);
			bulk.verifySelectPage(sheetName,scriptname);
		}
		else if (scriptname.equals("browseContinueMsg")) {
			et =  es.startTest("Bulk Doc: "+tcid+"_" + order + "_" + browser_type);
			//upload document
			bulk.uploadDocument();

			bulk.browseDocIsDisplayed();
			
			//verifing browse doc continue btn
			bulk.browseContinue(sheetName,scriptname);
		}
		else if(scriptname.equals("folderSourceCBtn")) {
			et =  es.startTest("Bulk Doc: "+tcid+"_" + order + "_" + browser_type);
			//verifing browse doc continue btn by passing part A path
			bulk.browseSourceContinue(sheetName,scriptname);
		}
	}
}
