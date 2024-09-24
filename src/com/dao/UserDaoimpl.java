package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;
import com.mysql.cj.protocol.Resultset;

public class UserDaoimpl implements UserDao {
      private Connection con;

	public UserDaoimpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public boolean userRegister(User us) {
		boolean f=false;
		
		try {
			String sql="insert into user(name,email,phno,password) values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, us.getName());
			pst.setString(2, us.getEmail());
		    pst.setString(3, us.getPhno());
			pst.setString(4, us.getPassword());
			
			int i=pst.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}

	
	public User login(String email, String password) {
		User us=null;
				
		try {
			
			String sql=" select * from user where email=? and password=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					us =new User();
					us.setId(rs.getInt(1));
					us.setName(rs.getString(2));
					us.setEmail(rs.getString(3));
					us.setPhno(rs.getString(4));
					us.setPassword(rs.getString(5));
					us.setAddress(rs.getString(6));
					us.setLandmark(rs.getString(7));
					us.setCity(rs.getString(8));
					us.setState(rs.getString(9));
					us.setPincode(rs.getString(10));
					
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	
		return us;
		
	}
      
   
}