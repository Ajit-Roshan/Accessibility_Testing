package test_components;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.testng.annotations.Test;

import pre_post.Setup_Teardown;

public class Get_addressbar_links extends Setup_Teardown {

	Set<String> addressBar_links;
	
	@Test(priority = 5, enabled = false)
	public void print_stored_link() {
		for(String eachLink: addressBar_links) {
			System.out.println("-> "+eachLink);
		}
	}
	
	@Test(priority = 4, enabled = false)
	public void getUrl_addressBar() throws Throwable{
		addressBar_links = new HashSet<String>();
		
		int count= 0;
		int size_of_links= 0;
		while(true) {
			addressBar_links.add(dr.getCurrentUrl());
			
			if(size_of_links != addressBar_links.size()) {
				size_of_links= size_of_links+1;
				
				count= count +1;
				
				Thread.sleep(5000);
				
				// title
				Get_attributes_class.getURL(count);
				Get_attributes_class.getTitle();
				Get_attributes_class.getHeader();
				Get_attributes_class.get_metaDesc();
				Get_attributes_class.get_pageLang();
				
				System.out.println(" ");
				System.out.println(" ------ ----- ");
				
				
			}
			
		}		
	}

	Set<String> getLinks;
	Set<String> handles;

	XLSX_file_reader_and_writer_class data;

	@Test(priority = 3, enabled = false)
	public void xlsx_data_communicate() throws Throwable {
		data = new XLSX_file_reader_and_writer_class();

		// data.data_sheet();

		data.set_data("https://sample.com");
	}

	@Test(priority = 2, enabled = false)
	public void getLinks_from_address_bar() {
		getLinks = new HashSet<String>();

		handles = new HashSet<String>(dr.getWindowHandles());

		System.out.println("size of handles " + handles.size());

		for (String eachHandle : handles) {
			dr.switchTo().window(eachHandle);
			System.out.println(dr.getCurrentUrl());
		}
	}

	@Test(priority = 1, enabled = true)
	public void print_urls() {

		Scanner sc = new Scanner(System.in);
		System.out.println("press Enter to continue.. ");
		String userInput = sc.nextLine();

	}
}
