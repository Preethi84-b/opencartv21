package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Utility {

	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow wr;
	public static XSSFCell wc;
	public static XSSFCellStyle cs;
	static String path;
	public Utility(String path) {
		this.path=path;
	}
	
	
	
	public static  int getrowcount(String xsheet) throws IOException {
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xsheet);
		int wr1=ws.getLastRowNum();
		wb.close();
		fi.close();
		return wr1;
		}
	
public static  int getcellcount(String xsheet,int row) throws IOException {
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xsheet);
		wr=ws.getRow(row);
		int cellcount=wr.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
		}
public static void setcelldata(String xfile,String xsheet,int row,int cellno,String data) throws IOException {
	
	fi=new FileInputStream(xfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xsheet);
	wr=ws.getRow(row);
wc=wr.createCell(cellno);
wc.setCellValue(data);
	fo=new FileOutputStream(xfile);
	wb.write(fo);
	
	wb.close();
	fi.close();
	fo.close();
	
	}
public static String getcelldata(String xsheet,int row,int cellno) throws IOException {
	
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xsheet);
	wr=ws.getRow(row);
	wc=wr.getCell(cellno);
	String celldata;
	try {
	 //celldata=wc.toString();
	
	  DataFormatter v= new DataFormatter();
	 celldata = v.formatCellValue(wc);//returns string value 
	  }
	catch(Exception e) {
		celldata="";
	}
	wb.close();
	fi.close();
	return celldata;
	}
public static void fillcellcolourgreen(String xsheet,int row,int cellno) throws IOException {
	
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xsheet);
	wr=ws.getRow(row);
	wc=wr.getCell(cellno);
	cs=wb.createCellStyle();;
	cs.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	wc.setCellStyle(cs);
	fo=new FileOutputStream(path);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	
	
}
public static void fillcellcolourred(String xsheet,int row,int cellno) throws IOException {
	
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xsheet);
	wr=ws.getRow(row);
	wc=wr.getCell(cellno);
	cs=wb.createCellStyle();;
	cs.setFillForegroundColor(IndexedColors.RED.getIndex());
	cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	wc.setCellStyle(cs);
	fo=new FileOutputStream(path);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	
	
}

}
