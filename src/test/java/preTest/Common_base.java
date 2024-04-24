package preTest;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Common_base {

	
	public static void main(String[] args) throws Throwable {
				
		System.out.println("running-- 1");
		
		FileInputStream f = new FileInputStream("./src/test/resources/util.property");
		Properties pr= new Properties();
		pr.load(f);
		
		System.out.println( "prop: " + pr.getProperty("url_to_use") );
		
		
		
		ChromeOptions opt= new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "localhost:9988");
//		opt.addArguments("--disable-notifications");

		WebDriver dr= new ChromeDriver(opt);
		
		
		
//		current project
		
		String base_url="";
		
		String should_have= "https://www.wbiwd.gov.in";
		
		Search_all_links call= new Search_all_links(dr, base_url, should_have);
		
		call.sharing_list();
		
//		call.act_element();
//		call.alrt();
		
		
//		call.get_links();

		//		----------------------------
		
		
//		open portal and get all links
		
		
		
//		open link in new tabs
//		Tst.link_manager();
		
		
//		String base_url= "https://ultimateqa.com/automation";
//		Data_class.baseUrl(base_url);
		
	}
	
}
