package cn.xiaohu.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xiaohu.customer.bean.Customer;
import cn.xiaohu.customer.utils.DBConnection;
import cn.xiaohu.customer.utils.PageBean;

public class CustomerDAO {
	
	public int login(Customer cus){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from tb_customer where customer_Name=? and customer_Mobil=?";
		int count=0;		
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cus.getCustomer_Name());
			pstmt.setString(2, cus.getCustomer_Mobile());
			rs=pstmt.executeQuery();
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//添加方法
	public int add(Customer customer){
		int ok=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into tb_customer(customer_Name,customer_Type,customer_Info,customer_Date,customer_Tel,customer_Mobile) values(?,?,?,?,?,?)";
		
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, customer.getCustomer_Name());
			pstmt.setString(2,customer.getCustomer_Type());
			pstmt.setString(3, customer.getCustomer_Info());
			pstmt.setString(4, customer.getCustomer_Date());
			pstmt.setString(5, customer.getCustomer_Tel());
			pstmt.setString(6, customer.getCustomer_Mobile());
			ok=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}
	//按编号查询
		public Customer queryById(Customer cus){
			Customer c=null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql="select * from tb_customer where customer_ID=? ";
			ResultSet rs = null;
			try {
				conn = DBConnection.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cus.getCustomer_ID());
				rs = pstmt.executeQuery();
				while(rs.next()){
					c = new Customer();
					c.setCustomer_ID(rs.getInt(1));
					c.setCustomer_Name(rs.getString(2));
					c.setCustomer_Type(rs.getString(3));
					c.setCustomer_Info(rs.getString(4));
					c.setCustomer_Date(rs.getString(5));
					c.setCustomer_Tel(rs.getString(6));
					c.setCustomer_Mobile(rs.getString(7));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c;
			
		}
	
	//查询方法
	public List<Customer> query(){
		List<Customer> cusList=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from tb_customer";
		Customer c=null;
		conn=DBConnection.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			cusList=new ArrayList<Customer>();
			while(rs.next()){
				c=new Customer();
				c.setCustomer_ID(rs.getInt(1));
				c.setCustomer_Name(rs.getString(2));
				c.setCustomer_Type(rs.getString(3));
				c.setCustomer_Info(rs.getString(4));
				c.setCustomer_Date(rs.getString(5));
				c.setCustomer_Tel(rs.getString(6));
				c.setCustomer_Mobile(rs.getString(7));
				cusList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cusList;
	}
	
	//更新方法
		public int update(Customer customer){
			int ok = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql="update tb_customer set customer_Name=?,customer_Type=?,customer_Info=?,customer_Date=?,customer_Tel=?,customer_Mobile=? where customer_ID=?";
			try {
				conn = DBConnection.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, customer.getCustomer_Name());
				pstmt.setString(2, customer.getCustomer_Type());
				pstmt.setString(3, customer.getCustomer_Info());
				pstmt.setString(4, customer.getCustomer_Date());
				pstmt.setString(5, customer.getCustomer_Tel());
				pstmt.setString(6, customer.getCustomer_Mobile());
				pstmt.setInt(7, customer.getCustomer_ID());
				ok = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ok;
		}
	//删除方法
		public int delete(Customer customer){
			int ok=0;
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql="delete from tb_customer where customer_ID=?";
			
			try {
				conn=DBConnection.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, customer.getCustomer_ID());
				ok=pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ok;
		}
	//查询方法，分页处理
	public PageBean<Customer> queryAllByCon(PageBean<Customer> pc){
		//查询总的记录数，设置到pc对象中
		int totalCount=this.getTotalCount();
		pc.setTotalCount(totalCount);
		/**
		 * 1.如果当前页<=0;当前页设置为1
		 * 2.如果当前页>最大页数，当前页设置为最大页数
		 */
		if(pc.getCurrentPage()<=0){
			pc.setCurrentPage(1);//当前页设置为1
		}else if(pc.getCurrentPage()>pc.getTotalPage()){
			pc.setCurrentPage(pc.getTotalPage());//当前页设置为最大页数
		}
		//1.获取当前页：计算查询的起始行，返回的行数
		int currentPage=pc.getCurrentPage();
		int index=(currentPage-1)*pc.getPageCount();//查询的起始行
		int count=pc.getPageCount();//查询返回的行数
		//2.分页查询数据；把查询到的数据设置到pc对象中
		String sql="select top"+count+"* from(select row_number() over (order by customer_id) as rownumber,* from tb_customer) as A where rownumber>?";
		List<Customer> pageData=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Customer c=null;

		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			rs=pstmt.executeQuery();
			pageData=new ArrayList<Customer>();
			while(rs.next()){
				c = new Customer();
				c.setCustomer_ID(rs.getInt(2));
				c.setCustomer_Name(rs.getString(3));
				c.setCustomer_Type(rs.getString(4));
				c.setCustomer_Info(rs.getString(5));
				c.setCustomer_Date(rs.getString(6));
				c.setCustomer_Tel(rs.getString(7));
				c.setCustomer_Mobile(rs.getString(8));
				pageData.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pc;
	}
	
	//获取总的记录数
	public int getTotalCount(){
			String sql="select count(*) from tb_customer";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int count=0;
			try {
				conn=DBConnection.getConnection();
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					count=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
		}
}
