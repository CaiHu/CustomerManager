package cn.xiaohu.customer.test;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import cn.xiaohu.customer.bean.Customer;
import cn.xiaohu.customer.dao.CustomerDAO;

public class CreateCustomerExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// ����HSSFWorkbook����(excel���ĵ�����)
		HSSFWorkbook wkb = new HSSFWorkbook();
		// �����µ�sheet����excel�ı���
		HSSFSheet sheet = wkb.createSheet("�ͻ���Ϣ��");
		// ��sheet�ﴴ����һ�У�����Ϊ������(excel����)��������0��65535֮����κ�һ��
		HSSFRow row1 = sheet.createRow(0);
		// ������Ԫ��excel�ĵ�Ԫ�񣬲���Ϊ��������������0��255֮����κ�һ��
		HSSFCell cell = row1.createCell(0);
		// ���õ�Ԫ������
		cell.setCellValue("�ͻ���Ϣһ����");
		// �ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
		// ��sheet�ﴴ���ڶ���
		HSSFRow row2 = sheet.createRow(1);
		// ������Ԫ�����õ�Ԫ������
		row2.createCell(0).setCellValue("�ͻ����");
		row2.createCell(1).setCellValue("�ͻ�����");
		row2.createCell(2).setCellValue("��Ʒ����");
		row2.createCell(3).setCellValue("�ͻ�����");
		row2.createCell(4).setCellValue("��������");
		row2.createCell(5).setCellValue("�绰");
		row2.createCell(6).setCellValue("�ֻ���");
		// ��sheet�ﴴ��������
		CustomerDAO cd = new CustomerDAO();
		List<Customer> cList = cd.query();
		for (int i = 0; i < cList.size(); i++) {
			HSSFRow row3 = sheet.createRow(i + 2);
			Customer c = cList.get(i);
			row3.createCell(0).setCellValue(c.getCustomer_ID());
			row3.createCell(1).setCellValue(c.getCustomer_Name());
			row3.createCell(2).setCellValue(c.getCustomer_Info());
			row3.createCell(3).setCellValue(c.getCustomer_Type());
			row3.createCell(4).setCellValue(c.getCustomer_Date());
			row3.createCell(5).setCellValue(c.getCustomer_Tel());
			row3.createCell(6).setCellValue(c.getCustomer_Mobile());
		}

		// ���Excel�ļ�
		FileOutputStream output = new FileOutputStream("d:\\workbook.xls");
		wkb.write(output);
		output.flush();

	/*	
		//���Excel�ļ�  
	    OutputStream output=response.getOutputStream();  
	    response.reset();  
	    response.setHeader("Content-disposition", "attachment; filename=details.xls");  
	    response.setContentType("application/msexcel");          
	    wkb.write(output);  
	    output.close();  
	    */
	}

}
