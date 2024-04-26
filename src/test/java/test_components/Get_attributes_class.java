package test_components;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Get_attributes_class {
	
	public static WebDriver dr;
	public static Set<String> urls;
	
	public Get_attributes_class(WebDriver dr, Set<String> urls) {
		// TODO Auto-generated constructor stub
		this.dr= dr;
		this.urls= urls;
	}
	
	public static void test_runner() {
		for(String each_one: urls) {
			System.out.println(" ");
			Get_attributes_class.open_link(each_one);
			System.out.println("URL: "+each_one);
			Get_attributes_class.getTitle();
			Get_attributes_class.getHeader();
			Get_attributes_class.get_metaDesc();
			Get_attributes_class.get_pageLang();
			Get_attributes_class.search_image_in_page();
			Get_attributes_class.lookfor_input_elements();
			Get_attributes_class.lookfor_table();
			System.out.println(" ");
		}
	}
	
	public static void getURL(int count) {
		String url = dr.getCurrentUrl();
		System.out.println(count + " url: " + url);
	}

	public static void getTitle() {

		String title;
		try {
			title = dr.findElement(By.xpath("//title")).getAttribute("innerText");
		} catch (Exception e) {
			// TODO: handle exception
			title = "no title";
		}
		System.out.println("title: " + title);

	}

	public static void getHeader() {

		List<WebElement> H1 = dr.findElements(By.xpath("*//h1"));
		List<WebElement> H2 = dr.findElements(By.xpath("*//h2"));
		List<WebElement> H3 = dr.findElements(By.xpath("*//h3"));
		List<WebElement> H4 = dr.findElements(By.xpath("*//h4"));
		List<WebElement> H5 = dr.findElements(By.xpath("*//h5"));
		List<WebElement> H6 = dr.findElements(By.xpath("*//h6"));

		System.out.println("h1 : " + H1.size());
		System.out.println("h2 : " + H2.size());
		System.out.println("h3 : " + H3.size());
		System.out.println("h4 : " + H4.size());
		System.out.println("h5 : " + H5.size());
		System.out.println("h6 : " + H6.size());

	}

	public static void get_metaDesc() {

		String metaDesc;
		try {
			metaDesc = dr.findElement(By.xpath("//meta[@name='description']")).getAttribute("content");
		} catch (Exception e) {
			// TODO: handle exception
			metaDesc = "no desc";
		}
		System.out.println("meta Desc: " + metaDesc);

	}

	public static void get_pageLang() {

		String lang;

		try {
			lang = dr.findElement(By.xpath("//*[@lang]")).getAttribute("lang");
		} catch (Exception e) {
			// TODO: handle exception
			lang = "no lang";
		}
		System.out.println("lang : " + lang);

	}

	public static void search_image_in_page() {

		try {
			List<WebElement> images = dr.findElements(By.xpath("*//img"));
			System.out.println("no. of image: " + images.size());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("NO image");
		}

	}

	public static void search_pdf_in_page(List<String> pdfLINKS) {

		List<WebElement> pdf = dr.findElements(By.xpath("*//a"));

		int pdf_count = 0;
		for (WebElement each : pdf) {
			String text = each.getAttribute("href");

			try {

				if (text.contains(".pdf")) {
					pdf_count++;
					pdfLINKS.add(text);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		System.out.println("No. of PDF: " + pdf_count);
	}

//	loof for in page 

	public static void lookfor_siteMap() {

		try {
			WebElement siteMap_element = dr.findElement(By.xpath("//a[@title='Sitemap']"));
			System.out.println("Sitemap: yes");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Sitemap: No");
		}
	}

	public static void lookfor_stateEmblem() {

		try {
			WebElement emblem = dr.findElement(By.xpath("//img[@alt='Department of Science & Technology (DST)']"));
			System.out.println("emblem: yes");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("emblem: No");
		}
	}

	public static void lookfor_nationalPortal() {
		List<WebElement> nationalPortal = dr.findElements(By.xpath("//li[@class='gov-india']//a"));
		System.out.println("No. of national portal links: " + nationalPortal.size());
	}

	public static void lookfor_TC() {
		try {
			WebElement TC = dr.findElement(By.xpath("//a[@href='/terms-conditions']"));
			System.out.println("T&C: yes");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("T&C: No");
		}
	}

	public static void lookfor_ownership() {
		try {
			WebElement ownership = dr.findElement(By.xpath("//div[@class='copyright-content']"));
			System.out.println("ownership: yes");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ownership: No");
		}
	}

	public static void lookfor_contactUS() {
		try {
			WebElement contactUS = dr.findElement(By.xpath("//a[@href='/contactus']"));
			System.out.println("contact US: yes");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("contact US: No");
		}
	}

	public static void lookfor_table() {
		List<WebElement> tables = dr.findElements(By.xpath("*//table"));
//		System.out.println("Table: "+tables.size());
		if (tables.size() != 0) {
			System.out.println("table links: " +tables.size() );
		}else {
			System.out.println("table links: " +tables.size() );			
		}
	}

	public static void lookfor_Archive() {
		List<WebElement> allElements = dr.findElements(By.xpath("//*"));
		for (WebElement each : allElements) {
			try {
				String txt = each.getText();
				if (txt.contains("archive")) {
					System.out.println("Archive: yes");
					System.out.println("Archive link: " + dr.getCurrentUrl());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	
	public static void open_link(String link) {
		dr.navigate().to(link);
	}
	
	public static void open_new_window(String link) throws Throwable {
		dr.switchTo().newWindow(WindowType.TAB);
		dr.navigate().to(link);
		Thread.sleep(3000);
	}

	public static void page_scroll_to_footer() {
		WebElement footerElement = dr.findElement(By.xpath("//div[@class='footer-bottom-wrapper']"));
		Actions act = new Actions(dr);
		act.scrollToElement(footerElement).perform();
	}

	public static void lookfor_main_content() {
		Set<WebElement> textContents = new HashSet<WebElement>(
				dr.findElements(By.xpath("//*[@id='content']//*[text()]")));
		for (WebElement eachContent : textContents) {
			String txt_get = eachContent.getText();
			if (txt_get.length() > 2) {
				System.out.println(txt_get);
				System.out.println("-- -- -- -- -- -- -- -- --");
			}
		}
	}

	public static Set<String> get_allLinks() {
		
//		List<WebElement> links= dr.findElements(By.xpath("*//a"));
		List<WebElement> links= dr.findElements(By.xpath("*//a[@href]"));
		Set<String> txt_link= new HashSet<String>();
		
		for(WebElement ech: links) {
			
			String lnk_href= ech.getAttribute("href");
			if( (lnk_href != null) && (!lnk_href.contains(".pdf")) && (lnk_href.contains("//dst.gov.in"))){
				txt_link.add(lnk_href);
			}
					
		}
		
		return txt_link;
				
	}
	
	
	public static void lookfor_input_elements() {
//		relative locator
//		By headerLocation= RelativeLocator.with(By.xpath("//input")).below(By.xpath("//div[@class='region region-header-top']"));		
		
		List<WebElement> inp= new ArrayList<WebElement>(dr.findElements(By.xpath("*//input")));
		
		if(inp.size()>0) {
			System.out.println("inp: "+dr.getCurrentUrl());
		}
		
//		List<WebElement> sel= dr.findElements(By.xpath("//select"));
//		
//		if(sel.size()>0) {
//			System.out.println("sel: "+dr.getCurrentUrl());
//		}
		
	}
	
}


