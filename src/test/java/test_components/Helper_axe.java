package test_components;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import com.deque.axe.AXE;

import preTest.Common_base;

public class Helper_axe extends Common_base{
	
	private static final URL SCRIP_URL= Helper_axe.class.getResource("/axe.min.js");

	public static void axe_helper(WebDriver dr) {
		
		JSONObject response = new AXE.Builder(dr, SCRIP_URL).analyze();
		
//		System.out.println("resp: "+response);
		
		JSONArray violations= response.getJSONArray("violations");
		
		int size= violations.length();
		System.out.println("array size: "+size);
		
		for(int i=0; i< size; i++) {
			String vio_obj= violations.getJSONObject(i).getString("help");
			System.out.println(i+" error: "+vio_obj);
			
		}
		
	}
	
}
