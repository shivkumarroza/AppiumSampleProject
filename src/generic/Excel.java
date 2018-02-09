package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getData(String path,String sheet, int row, int column)
	{
		String value="";
		Workbook wb;
		try {
			wb=WorkbookFactory.create(new FileInputStream(path));;
			value=wb.getSheet(sheet).getRow(row).getCell(column).toString();
		}catch(Exception e)
		{

		}
		return value;
	}

	public static int rowCount(String path,String sheet)
	{
		int rc=0;
		Workbook wb;
		try {
			wb=WorkbookFactory.create(new FileInputStream(path));
			rc=wb.getSheet(sheet).getLastRowNum();
		}catch(Exception e) {}
		return rc;
	}

	public static int columnCount(String path,String sheet, int row)
	{
		int cc=0;
		Workbook wb;
		try {
			wb=WorkbookFactory.create(new FileInputStream(path));
			cc=wb.getSheet(sheet).getRow(row).getLastCellNum();
		}catch(Exception e) {}
		return cc;
	}
}
