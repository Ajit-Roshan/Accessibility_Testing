package preTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Search_all_links extends Common_base {

	public static WebDriver dr;
	public static String should_have;

//	constructor
	public Search_all_links(WebDriver dr, String link, String should_have) {
		// TODO Auto-generated constructor stub

		this.should_have = should_have;

		this.dr = dr;
		dr.navigate().to(link);
		set_one = new HashSet<String>();
		list_one = new ArrayList<String>();
	}

	public static Set<String> set_one;
	List<String> list_two;
	public static List<WebElement> list_temp;
	public static List<String> list_one;

	public static void get_links() {
		int fail_run = 0;

		for (WebElement each : list_temp) {
//			System.out.println("42: "+each.getAttribute("href"));

			String data = each.getAttribute("href");

//			change if no exception is in the portal
			if (data.contains(should_have) && !(data.contains("pdf")) && !(data.contains("Gallery"))) {
				list_one.add(data);
			}

		}
		System.out.println(list_one.size());

		for (int i = 0; i < list_one.size(); i++) {

			int pre_size = set_one.size();
			set_one.add(list_one.get(i));
			int post_size = set_one.size();

			if (pre_size != post_size) {
				dr.navigate().to(list_one.get(i));
				sharing_list();
			} else {
				if (fail_run > 3) {
					fail_run++;
					break;
				}
			}

		}

//		System.out.println("----- data -----");
//
//		int index = 1;
//		for (String ech : set_one) {
//			System.out.println(index + " : " + ech + " :");
//			index++;
//		}

	}

	public static void print_all_data() {

		System.out.println("----- data -----");

		int index = 1;
		for (String ech : set_one) {
			System.out.println(index + " : " + ech + " :");
			index++;
		}

	}

	public static void sharing_list() {
		list_temp = new ArrayList<WebElement>(dr.findElements(By.xpath("*//a[@href]")));
		get_links();
	}

	public void alrt() {
		dr.switchTo().alert().dismiss();
	}

	public void act_element() {
		List<WebElement> html = dr.findElements(By.xpath("//html"));
		if (html.size() == 0) {
			Actions act = new Actions(dr);
			act.sendKeys(Keys.ESCAPE).perform();
		}
	}

}
