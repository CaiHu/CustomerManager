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
		//����HSSFWorkbook����  
		HSSFWorkbook wkb = new HSSFWorkbook();  
		//����HSSFSheet����  
		HSSFSheet sheet = wkb.createSheet("sheet0");  
		//����HSSFRow����  
		HSSFRow row = sheet.createRow(0);  
		//����HSSFCell����  
		HSSFCell cell=row.createCell(0);  
		//���õ�Ԫ���ֵ  
		cell.setCellValue("1111111"); 
		*/
		
	//����HSSFWorkbook����(excel���ĵ�����)  
	 HSSFWorkbook wkb = new HSSFWorkbook();  
	//�����µ�sheet����excel�ı���  
	HSSFSheet sheet=wkb.createSheet("�ɼ���");  
	//��sheet�ﴴ����һ�У�����Ϊ������(excel����)��������0��65535֮����κ�һ��  
	HSSFRow row1=sheet.createRow(0);  
     
	      //������Ԫ�����õ�Ԫ������  
	      row1.createCell(0).setCellValue("ѧ��");  
	      row1.createCell(1).setCellValue("����");      
	      row1.createCell(2).setCellValue("��Ŀ");  
	      row1.createCell(3).setCellValue("�ɼ�");      
	      //��sheet�ﴴ��������  
	      HSSFRow row2=sheet.createRow(1);  
	      row2.createCell(0).setCellValue("201409160201");  
	      row2.createCell(1).setCellValue("������");  
	      row2.createCell(2).setCellValue("Ӣ��");      
	      row2.createCell(3).setCellValue(78); 
	      
	      //��sheet�ﴴ��������  
	      HSSFRow row3=sheet.createRow(2);  
	      row3.createCell(0).setCellValue("201409160201");  
	      row3.createCell(1).setCellValue("������");  
	      row3.createCell(2).setCellValue("Ӣ��");      
	      row3.createCell(3).setCellValue(78); 
		
		
		//���Excel�ļ�  
		FileOutputStream output=new FileOutputStream("d:\\workbook.xls");  
		wkb.write(output);  
		output.flush();  
		

	}

}
