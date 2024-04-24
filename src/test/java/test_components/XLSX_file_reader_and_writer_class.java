package test_components;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSX_file_reader_and_writer_class {
	
	Workbook wb;
	Workbook wbo;
	
	FileOutputStream fos;
	
	String path= "D:/__ AJIT __/Z_Automation/spaceOne/Accessibility_test/xlsx_file/link_sheet.xlsx";
	String out_path= "D:/__ AJIT __/Z_Automation/spaceOne/Accessibility_test/xlsx_file/output_data_sheet.xlsx";
	
	public void set_data(String link) throws Throwable {
		
		fos= new FileOutputStream(out_path);
		wbo= new XSSFWorkbook();
		
		wbo.createSheet().createRow(0).createCell(0).setCellValue(link);	
		
		wbo.write(fos);
		
	}
	
	
	public void data_sheet() throws Throwable {
		
		wb= new XSSFWorkbook(new FileInputStream(path));
		Sheet sheet= wb.getSheetAt(0);
		Row row= sheet.getRow(0);
		
		Cell cell= row.getCell(0);
		
		int cell_count= sheet.getPhysicalNumberOfRows();
		
		String cellData= cell.getStringCellValue();
		
		System.out.println("cell data= "+cellData);
		System.out.println("cell count= "+cell_count);
	}
	
	
	
}
