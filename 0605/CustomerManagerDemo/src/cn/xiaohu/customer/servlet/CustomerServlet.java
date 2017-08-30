package cn.xiaohu.customer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiaohu.customer.bean.Customer;
import cn.xiaohu.customer.dao.CustomerDAO;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDAO customerDAO=new CustomerDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
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
		String action=request.getParameter("method");
		String name=request.getParameter("txtName");
		String type=request.getParameter("selType");
		String dateTime=request.getParameter("txtDateTime");
		String product=request.getParameter("txtProduct");
		String mobile=request.getParameter("txtMobile");
		String tel=request.getParameter("txtTel");
		
		Customer cus=new Customer(0,name,type,product,dateTime,tel,mobile);
		if(null==action){
			
		}else if("update".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			cus.setCustomer_ID(id);
			if(customerDAO.delete(cus)>0){
				List<Customer> cList=customerDAO.query();
				request.setAttribute("cList", cList);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
		}else if("delete".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			cus.setCustomer_ID(id);
			if(customerDAO.delete(cus)>0){
				List<Customer> cList=customerDAO.query();
				request.setAttribute("cList", cList);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
		}else if("add".equals(action)){
			System.out.println(cus);
			if(customerDAO.add(cus)>0){
				request.setAttribute("tips", "添加成功！");
				request.getRequestDispatcher("add.jsp").forward(request, response);
			}
			else{
				request.setAttribute("tips", "添加失败！");
				request.getRequestDispatcher("add.jsp").forward(request, response);
			}
		}else if("queryAll".equals(action)){
			List<Customer> cList=customerDAO.query();
			if(null==cList||cList.size()<=0){
				request.getRequestDispatcher("do.jsp").forward(request, response);
				
			}else{
				request.setAttribute("cList", cList);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			
			}
		}else if("modify".equals(action)){
		int id = Integer.parseInt(request.getParameter("id"));
		cus.setCustomer_ID(id);
		cus = customerDAO.queryById(cus);
		if(!(null==cus))
		{			
			request.setAttribute("cus", cus);
			request.getRequestDispatcher("modify.jsp").forward(request, response);
		}
	}
}

}

