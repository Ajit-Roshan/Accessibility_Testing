package preTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

		list_temp_string = new ArrayList<String>();
	}

	public static Set<String> set_one;
	List<String> list_two;
	public static List<WebElement> list_temp;
	public static List<String> list_temp_string;
	public static List<String> list_one;

	public static void get_links() {
//		int fail_run = 0;

//		for (WebElement each : list_temp) {
		for (String each : list_temp_string) {
			// System.out.println("42: "+each.getAttribute("href"));

			String data;
//			try {

//				System.out.println("each: "+each);
//				System.out.println("each getText: "+each.getText());
//				System.out.println("each tag: "+each.getTagName());
//				System.out.println("each attr: "+each.getAttribute("href") );

//			System.out.println("each_1: " + each);
				
//				System.out.println("each_2: "+each.getAttribute("href"));
//				
//				data = each.getAttribute("href").toString();				

			data = each;
//			System.out.println("64");

//			} catch (Exception e) {
			// TODO: handle exception
//				System.out.println("Exception: "+65);
//				data=should_have;
//			}

//			change if no exception is in the portal
			if (data.contains(should_have) && !(data.contains("pdf")) && !(data.contains("Gallery"))) {
				list_one.add(data);
			}

		}
//		System.out.println("list one size: " + list_one.size());

		for (int i = 0; i < list_one.size(); i++) { // System.out.println("81: index num is "+i);

			int pre_size = set_one.size();
			set_one.add(list_one.get(i));
			int post_size = set_one.size();

			if (pre_size != post_size) {
//				System.out.println("88: " + list_one.get(i));
				dr.navigate().to(list_one.get(i));
				sharing_list();
			}
//			else {
//				System.out.println("calling: print_all_data");
//				print_all_data();
//				i= list_one.size();

//				if((i+1)== list_one.size()) {
//					System.out.println("calling: 94");
//					print_all_data();
//					i= list_one.size();
//				}
				
//				if (fail_run > 3) {
//					fail_run++; System.out.println("calling: 100");
//					i= list_one.size();
//				}

			}

		}

//		System.out.println("----- data -----");
//
//		int index = 1;
//		for (String ech : set_one) {
//			System.out.println(index + " : " + ech + " :");
//			index++;
//		}

//	}



	public static void sharing_list() {

		try {
			WebElement not_reachable = dr.findElement(By.xpath("//*[text()='This site can’t be reached']"));
			if (not_reachable.isDisplayed()) {
				dr.navigate().back();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

//		System.out.println("called: sharing_list");

		list_temp = new ArrayList<WebElement>(dr.findElements(By.xpath("*//a[@href]")));
//		System.out.println("145");

		for (WebElement getString : list_temp) {

			// stale element exception
			try {
				if (getString.getAttribute("href").contains(should_have)) {
					list_temp_string.add(getString.getAttribute("href"));
//					System.out.println(getString.getAttribute("href"));
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("errorful: "+e);
			}

		}

		get_links();
	}

//	printing all the getched links
	public static void print_all_data() {

		System.out.println("----- data -----");

		int index = 1;
		for (String ech : set_one) {
			System.out.println(index + " : " + ech);
			index++;
		}

	}
}
