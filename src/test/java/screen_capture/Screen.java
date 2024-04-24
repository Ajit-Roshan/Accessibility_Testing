package screen_capture;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Screen {

	public static void capture_screen(WebDriver dr, int i) throws Throwable {
		File file= ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		
		String output_path= "screen/access_file_screen_"+i+"_.png";
		
		Files.move(file, new File(output_path));
		
	}
	
}
