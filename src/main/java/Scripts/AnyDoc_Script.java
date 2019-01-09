package Scripts;

import java.io.File;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_AnyDocPage;
import Page_Factory.pf_loginpage;

public class AnyDoc_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(AnyDoc_Script.class);

	@Test(dataProvider= "AnyDoc_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void anyDoc(Map hm) throws Exception{

		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="AnyDoc";

		pf_AnyDocPage anyDoc=new pf_AnyDocPage(w);

		if(scriptname.equals("MsgBelowReferenceNumber")) {
			et =  es.startTest("Any Document: "+tcid+"_" + order + "_" + browser_type);
			//For clicking Any Doc and checking the title and message box present below the reference number
			anyDoc.anyDocument(sheetName,scriptname);
		}

		else if(scriptname.equals("uploadNonPDF")) {
			et =  es.startTest("Any Document: "+tcid+"_" + order + "_" + browser_type);
			//upload non PDF document
			File f1=new File(Utility.getpropertydetails("nonPDF"));
			String path=f1.getAbsolutePath();
			anyDoc.uploadNonPDF(path,sheetName,scriptname);
			//uploading PDF file
			File f2=new File(Utility.getpropertydetails("PDF"));
			String pdfpath=f2.getAbsolutePath();
			anyDoc.uploadPDF(pdfpath,sheetName);
		}
		
		else if(scriptname.equals("crossBtnSigntory1")) {
			anyDoc.addSignatory(sheetName,scriptname);
		}
	}
	
	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void dsignanyDoc() throws Exception{
		pf_AnyDocPage anyDoc=new pf_AnyDocPage(w);
		anyDoc.dsignDoc();
	}


}

