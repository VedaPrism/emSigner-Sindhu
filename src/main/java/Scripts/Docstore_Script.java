package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_DocstorePage;
import Page_Factory.pf_Settings;
import Page_Factory.pf_loginpage;

public class Docstore_Script extends Basefunctions {
	
	final static Logger log = Logger.getLogger(Docstore_Script.class);
	
	
	
	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public static void dash_docStore() throws Exception{	
		
		pf_DocstorePage docstore=new pf_DocstorePage(w);
		docstore.clickDocstore();
	}
	
	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public static void uploadDoc() throws Exception{	
		
		pf_DocstorePage docstore=new pf_DocstorePage(w);
		docstore.uploadDocument();
	}
	
	@Test(enabled=true,priority=3,groups={"SMK","REG"})
	public static void exprtExcel() throws Exception{	
		
		pf_DocstorePage docstore=new pf_DocstorePage(w);
		docstore.exportToExcel();
	}
	
	@Test(enabled=true,priority=4,groups={"SMK","REG"})
	public static void actions() throws Exception{	
		
		pf_DocstorePage docstore=new pf_DocstorePage(w);
		docstore.actionSettings();
		
	}
}
