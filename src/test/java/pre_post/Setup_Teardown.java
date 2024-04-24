package pre_post;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import screen_capture.Screen;

public class Setup_Teardown extends Screen{

	String url="https://www.goindigo.in/";
//	String url="https://www.goindigo.in/hotels?linkNav=BookHotels%7C%7CHeader%20Menu";
	
	public static WebDriver dr;
	public static ChromeOptions co;
	
	@BeforeSuite
	public void setup() {
		
		co= new ChromeOptions();
		
		co.addArguments("—allow—running-insecure—content");
		co.addArguments("—ignore—certificate—errors");		
		co.addArguments("—incognito");
		
		dr= new ChromeDriver(co);
		
		dr.manage().window().maximize();
		dr.navigate().to(url);
	}
	
	
	@AfterSuite
	public void teardown() {
		dr.quit();
	}
}
