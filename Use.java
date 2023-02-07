package com.quizap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Use {
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet st;
	XSSFRow row;
	XSSFCell cell;
	String path;
	
	Use(String path){
		this.path=path;
	}
	public int getrowcount(String stname) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(stname);
		int rowcount=st.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	public int getcellcount(String stname,int rownum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(stname);
		row=st.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
}
	public String getcelldata(String stname,int rownum,int colnum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(stname);
		row=st.getRow(rownum);
		cell=row.getCell(colnum);
		 DataFormatter format=new DataFormatter();
		String data;
		try {
			data=format.formatCellValue(cell);
		}
		catch (Exception e) {
			data="";
		}
		wb.close();
		fi.close();
		return data;
	
	}
public void setcelldata(String sheetname,int rownum,int colnum,String data) throws IOException {
	File fl=new File(path);
	FileInputStream fi = new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	st=wb.createSheet(sheetname);
	row=st.getRow(rownum);
	cell=row.createCell(colnum);
	cell.setCellValue(data);
	FileOutputStream fo = new FileOutputStream(path);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();

}

}
	
	
	
	
	
	
	
	
	
	
	
