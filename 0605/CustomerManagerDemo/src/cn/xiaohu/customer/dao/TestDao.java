/**
 * 
 */
package cn.xiaohu.customer.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.xiaohu.customer.bean.Customer;

/**
 * @author Administrator
 *
 */
public class TestDao extends CustomerDAO {
	CustomerDAO dao=new CustomerDAO();

	
	@Test
	public void testAdd() {
		Customer customer = new Customer(0,"tom","供应商","苹果","2017-3-20","12345","67890");
		assertEquals(1, dao.add(customer));
	}
	
	@Test
	public void testQuery(){
		List<Customer> clist=dao.query();
		assertEquals(25,clist.size());
	}

	@Test
	public void testDelete(){
		Customer cus=new Customer();
		cus.setCustomer_ID(1);
		assertEquals(1,dao.delete(cus));
	}

}
