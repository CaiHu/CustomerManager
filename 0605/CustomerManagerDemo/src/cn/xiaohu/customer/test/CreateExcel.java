package cn.xiaohu.customer.test;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;



public class CreateExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		//创建HSSFWorkbook对象  
		HSSFWorkbook wkb = new HSSFWorkbook();  
		//创建HSSFSheet对象  
		HSSFSheet sheet = wkb.createSheet("sheet0");  
		//创建HSSFRow对象  
		HSSFRow row = sheet.createRow(0);  
		//创建HSSFCell对象  
		HSSFCell cell=row.createCell(0);  
		//设置单元格的值  
		cell.setCellValue("1111111"); 
		*/
		
	//创建HSSFWorkbook对象(excel的文档对象)  
	 HSSFWorkbook wkb = new HSSFWorkbook();  
	//建立新的sheet对象（excel的表单）  
	HSSFSheet sheet=wkb.createSheet("成绩表");  
	//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个  
	HSSFRow row1=sheet.createRow(0);  
     
	      //创建单元格并设置单元格内容  
	      row1.createCell(0).setCellValue("学号");  
	      row1.createCell(1).setCellValue("姓名");      
	      row1.createCell(2).setCellValue("科目");  
	      row1.createCell(3).setCellValue("成绩");      
	      //在sheet里创建第三行  
	      HSSFRow row2=sheet.createRow(1);  
	      row2.createCell(0).setCellValue("201409160201");  
	      row2.createCell(1).setCellValue("张三丰");  
	      row2.createCell(2).setCellValue("英语");      
	      row2.createCell(3).setCellValue(78); 
	      
	      //在sheet里创建第三行  
	      HSSFRow row3=sheet.createRow(2);  
	      row3.createCell(0).setCellValue("201409160201");  
	      row3.createCell(1).setCellValue("张三丰");  
	      row3.createCell(2).setCellValue("英语");      
	      row3.createCell(3).setCellValue(78); 
		
		
		//输出Excel文件  
		FileOutputStream output=new FileOutputStream("d:\\workbook.xls");  
		wkb.write(output);  
		output.flush();  
		

	}

}
