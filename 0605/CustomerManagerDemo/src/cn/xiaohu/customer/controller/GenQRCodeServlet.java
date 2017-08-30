package cn.xiaohu.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiaohu.customer.TDCode.TwoDimensionCode;
import cn.xiaohu.customer.bean.Customer;

/**
 * Servlet implementation class GenORCodeServlet
 */
@WebServlet("/GenORCodeServlet")
public class GenQRCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenQRCodeServlet() {
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
		String customername=request.getParameter("customername");
		String selType=request.getParameter("selType");
		String dateTime=request.getParameter("starttime");
		String product=request.getParameter("product");
		String mobile=request.getParameter("mobile");
		String tel=request.getParameter("tel");
		
		Customer cus=new Customer(0,customername,selType,product,dateTime,tel,mobile);
		String imgPath=this.getServletContext().getRealPath("")+"\\img\\"+tel+"QRCode.png";
		String ecoderContent="客户姓名："+customername+"\n"
				+"客户类型："+selType+"\n"
				+"创建日期："+product+"\n"
				+"供求产品："+dateTime+"\n"
				+"客户手机："+tel+"\n"
				+"客户电话："+mobile+"\n";
		TwoDimensionCode handler=new TwoDimensionCode();
		handler.encoderQRCode(ecoderContent, imgPath, "png");
		request.setAttribute("imgPath", tel+"QRCode.png");
		System.out.println(imgPath);
		request.getRequestDispatcher("genQRCode.jsp").forward(request, response);
		
	}

}
