package cn.xiaohu.customer.servlet;

import java.awt.print.Paper;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xiaohu.customer.bean.Customer;
import cn.xiaohu.customer.dao.CustomerDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("account");
		//if(account==null){account="";}
		String pwd=request.getParameter("pwd");
		String checkCode=request.getParameter("checkCode");
		HttpSession session=request.getSession();
		String code=(String)session.getAttribute("code");
		if(pwd==null){pwd="";}
		if(account==null){account="";}
		/*if(checkCode==null){checkCode="";}
		if(code==null){code="";}
		System.out.println(checkCode+"===="+code);
		String info="";*/
		/*if(!(null==checkCode||checkCode.trim().length()<=0)){
			System.out.println(checkCode);
			if(code.equals(checkCode)){*/
				CustomerDAO cd=new CustomerDAO();
				Customer cus=new Customer();
				cus.setCustomer_Name(account);
				cus.setCustomer_Mobile(pwd);
				int count=cd.login(cus);
				if(count>0){
					System.out.println(count);
					//request.getRequestDispatcher("IndexServlet").forward(request, response);
				}/*else{
					info="’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°";
					request.setAttribute("info", info);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else{
				info="—È÷§¬Î¥ÌŒÛ£°";
				request.setAttribute("info", info);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			info="—È÷§¬ÎŒ™ø’£¨«ÎÃÓ–¥—È÷§¬Î£°";
			request.setAttribute("info", info);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}*/
	}

}
