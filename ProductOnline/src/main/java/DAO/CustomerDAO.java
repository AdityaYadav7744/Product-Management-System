package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Beans.CustomerBean;
public class CustomerDAO 
{
	public CustomerBean custValid(String userName,String passWord)
	{
		
		CustomerBean cb=null;
              
		try {
			Connection con =DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customer55 where user_name=? and pass_word=?");
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next())
			{
				cb=new CustomerBean();
				cb.setUserName(rs.getString(1));
				cb.setPassWord(rs.getString(2));
				cb.setFirstName(rs.getString(3));
				cb.setLastName(rs.getString(4));
				cb.setEmail(rs.getString(5));
				cb.setMobile(rs.getLong(6));
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return cb;
	}

}
