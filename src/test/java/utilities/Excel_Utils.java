package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utils {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public Excel_Utils(String path) {
		this.path=path;
	}
	
	public int getRowCount(String sheet) throws Exception{
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sh=wb.getSheet(sheet);
			int rowcount=sh.getLastRowNum();
			fi.close();
			wb.close();
		
			return rowcount;
		}

		public int getCellCount(String sheet, int rownum) throws Exception{
			fi= new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sh=wb.getSheet(sheet);
			row=sh.getRow(rownum);
			int cellcount=row.getLastCellNum();
			fi.close();
			wb.close();
		
			return cellcount;
		}
	
		public String getCellData(String sheet, int rownum, int colnum) throws Exception{
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sh=wb.getSheet(sheet);
			row=sh.getRow(rownum);
			cell=row.getCell(colnum);
			String data;
			try {
			
				DataFormatter format=new DataFormatter();
				data=format.formatCellValue(cell);
				return data;
			
			}catch(Exception e){
				data="";
			
			}
			fi.close();
			wb.close();
		
			return data;
		}
	
		public void setCellData(String sheet, int rownum, int cellnum, String data) throws Exception{
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			
			sh=wb.getSheet(sheet);
			row=sh.getRow(rownum);
			
			cell=row.createCell(cellnum);
			cell.setCellValue(data);
			
			fo= new FileOutputStream(path);
			System.out.println(wb.getWorkbookType());
			wb.write(fo);
			
			fi.close();
			fo.close();
			wb.close();
		
	}
	
	public void fillGreencolor(String sheet, int rownum, int colnum) throws Exception {
		fi= new FileInputStream(path);
		
		wb= new XSSFWorkbook(fi);
		sh=wb.getSheet(sheet);
		row=sh.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo= new FileOutputStream(path);
		wb.write(fo);
		fi.close();
		fo.close();
		wb.close();
		
		
		
	}
	
	public void fillRedcolor(String sheet, int rownum, int colnum) throws Exception{
		
		fi= new FileInputStream(path);
		
		wb= new XSSFWorkbook(fi);
		sh=wb.getSheet(sheet);
		row=sh.getRow(rownum);
		cell=row.getCell(colnum);
		
		style= wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo= new FileOutputStream(path);
		wb.write(fo);
		fi.close();
		fo.close();
		wb.close();
		
	}
	
}
