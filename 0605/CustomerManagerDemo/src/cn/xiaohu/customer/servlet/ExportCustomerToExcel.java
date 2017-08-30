package cn.xiaohu.customer.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import cn.xiaohu.customer.bean.Customer;
import cn.xiaohu.customer.dao.CustomerDAO;

/**
 * Servlet implementation class ExportCustomerToExcel
 */
@WebServlet("/ExportCustomerToExcel")
public class ExportCustomerToExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportCustomerToExcel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wkb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wkb.createSheet("客户信息表");
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("客户信息一览表");
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
		// 在sheet里创建第二行
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("客户编号");
		row2.createCell(1).setCellValue("客户姓名");
		row2.createCell(2).setCellValue("产品供求");
		row2.createCell(3).setCellValue("客户类型");
		row2.createCell(4).setCellValue("建立日期");
		row2.createCell(5).setCellValue("电话");
		row2.createCell(6).setCellValue("手机号");
		// 在sheet里创建第三行
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



		
		//输出Excel文件  
	    OutputStream output=response.getOutputStream();  
	    response.reset();  
	    response.setHeader("Content-disposition", "attachment; filename=details.xls");  
	    response.setContentType("application/msexcel");          
	    wkb.write(output);  
	    output.close();  
	    
	}

}
