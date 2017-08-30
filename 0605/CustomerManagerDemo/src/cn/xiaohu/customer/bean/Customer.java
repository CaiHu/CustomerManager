package cn.xiaohu.customer.bean;

public class Customer {
	private int customer_ID;//客户编号
	private String customer_Name;//客户名称
	private String customer_Type;//客户类型
	private String customer_Info;//供求产品
	private String customer_Date;//客户建立日期
	private String customer_Tel;//客户电话号码
	private String customer_Mobile;//客户手机号码
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customer_Date == null) ? 0 : customer_Date.hashCode());
		result = prime * result + customer_ID;
		result = prime * result
				+ ((customer_Info == null) ? 0 : customer_Info.hashCode());
		result = prime * result
				+ ((customer_Mobile == null) ? 0 : customer_Mobile.hashCode());
		result = prime * result
				+ ((customer_Name == null) ? 0 : customer_Name.hashCode());
		result = prime * result
				+ ((customer_Tel == null) ? 0 : customer_Tel.hashCode());
		result = prime * result
				+ ((customer_Type == null) ? 0 : customer_Type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customer_Date == null) {
			if (other.customer_Date != null)
				return false;
		} else if (!customer_Date.equals(other.customer_Date))
			return false;
		if (customer_ID != other.customer_ID)
			return false;
		if (customer_Info == null) {
			if (other.customer_Info != null)
				return false;
		} else if (!customer_Info.equals(other.customer_Info))
			return false;
		if (customer_Mobile == null) {
			if (other.customer_Mobile != null)
				return false;
		} else if (!customer_Mobile.equals(other.customer_Mobile))
			return false;
		if (customer_Name == null) {
			if (other.customer_Name != null)
				return false;
		} else if (!customer_Name.equals(other.customer_Name))
			return false;
		if (customer_Tel == null) {
			if (other.customer_Tel != null)
				return false;
		} else if (!customer_Tel.equals(other.customer_Tel))
			return false;
		if (customer_Type == null) {
			if (other.customer_Type != null)
				return false;
		} else if (!customer_Type.equals(other.customer_Type))
			return false;
		return true;
	}
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	public String getCustomer_Name() {
		return customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	public String getCustomer_Type() {
		return customer_Type;
	}
	public void setCustomer_Type(String customer_Type) {
		this.customer_Type = customer_Type;
	}
	public String getCustomer_Info() {
		return customer_Info;
	}
	public void setCustomer_Info(String customer_Info) {
		this.customer_Info = customer_Info;
	}
	public String getCustomer_Date() {
		return customer_Date;
	}
	public void setCustomer_Date(String customer_Date) {
		this.customer_Date = customer_Date;
	}
	public String getCustomer_Tel() {
		return customer_Tel;
	}
	public void setCustomer_Tel(String customer_Tel) {
		this.customer_Tel = customer_Tel;
	}
	public String getCustomer_Mobile() {
		return customer_Mobile;
	}
	public void setCustomer_Mobile(String customer_Mobile) {
		this.customer_Mobile = customer_Mobile;
	}
	@Override
	public String toString() {
		return "Customer [customer_ID=" + customer_ID + ", customer_Name="
				+ customer_Name + ", customer_Type=" + customer_Type
				+ ", customer_Info=" + customer_Info + ", customer_Date="
				+ customer_Date + ", customer_Tel=" + customer_Tel
				+ ", customer_Mobile=" + customer_Mobile + "]";
	}
	public Customer(int customer_ID, String customer_Name,
			String customer_Type, String customer_Info, String customer_Date,
			String customer_Tel, String customer_Mobile) {
		super();
		this.customer_ID = customer_ID;
		this.customer_Name = customer_Name;
		this.customer_Type = customer_Type;
		this.customer_Info = customer_Info;
		this.customer_Date = customer_Date;
		this.customer_Tel = customer_Tel;
		this.customer_Mobile = customer_Mobile;
	}
	public Customer(){};

	





	

}

