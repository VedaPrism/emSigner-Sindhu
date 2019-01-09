package Dataproviders;


import java.util.ListIterator;

import org.testng.annotations.DataProvider;

import Generic_Library.Utility;

public class dp_login {

	@DataProvider(name = "invalid_login")
	public ListIterator<Object[]> dp_invalid() throws Exception
	{
		return Utility.dp_commonlogic("Credentials","InvalidLogin");
	}
	
	@DataProvider(name = "valid_login")
	public static ListIterator<Object[]> dp_valid() throws Exception
	{
		return Utility.dp_commonlogic("Credentials", "ValidLogin");
	}
	
	@DataProvider(name = "Form16_sign")
	public static ListIterator<Object[]> dp_valid1() throws Exception
	{
		return Utility.dp_commonlogic("Form16", "Script_Name");
	}
	
	@DataProvider(name = "Encrypt_Page")
	public static ListIterator<Object[]> dp_EncryptPage() throws Exception
	{
		return Utility.dp_commonlogic("Encrypt","Script_Name");
	}
	
	@DataProvider(name = "Decrypt_Page")
	public static ListIterator<Object[]> dp_DencryptPage() throws Exception
	{
		return Utility.dp_commonlogic("Decrypt", "Script_Name");
	}

	@DataProvider(name = "AnyDoc_Page")
	public static ListIterator<Object[]> dp_anyDocPage() throws Exception
	{
		return Utility.dp_commonlogic("AnyDoc", "Script_Name");
	}
	
	@DataProvider(name = "Dashboard_Page")
	public static ListIterator<Object[]> dp_dashboardPage() throws Exception
	{
		return Utility.dp_commonlogic("Dashboard", "Script_Name");
	}
	
	@DataProvider(name = "setting_page")
	public static ListIterator<Object[]> dp_settingsPage() throws Exception
	{
		return Utility.dp_commonlogic("Settings", "Script_Name");
	}
	
	@DataProvider(name = "Bulk_Page")
	public static ListIterator<Object[]> dp_bulkPage() throws Exception
	{
		return Utility.dp_commonlogic("BulkDoc", "Script_Name");
	}
	
	@DataProvider(name = "admin_setting")
	public static ListIterator<Object[]> dp_adminSettingPage() throws Exception
	{
		return Utility.dp_commonlogic("AdminSettings", "Script_Name");
	}
	
}

