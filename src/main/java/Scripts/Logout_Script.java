package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_loginpage;

public class Logout_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(Login_Script.class);
	
	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void Logout() throws Exception{	
		
		pf_loginpage pl = new pf_loginpage(w);
		pl.logout();
		log.info("Logged out successfully");
	}
}
