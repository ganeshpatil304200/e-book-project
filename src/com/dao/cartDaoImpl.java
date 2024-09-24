package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.entity.Cart;

public class cartDaoImpl implements cartDao {

	private Connection con;
	
	public cartDaoImpl(Connection con)
	{
		this.con=con;
	}
	
	
	@Override
	public boolean addCart(Cart c) {
		boolean f=false;
		
		try {
			
			String sql="insert into cart(cid,bid,uid,bookName,author,price,total_price) values(?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, c.getCid());
			pst.setInt(2, c.getBid());
			pst.setInt(3, c.getUserId());
			pst.setString(4, c.getBookName());
			pst.setString(5, c.getAuthor());
			pst.setDouble(6, c.getPrice());
			pst.setDouble(7, c.getTotalPrice());
			
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

}
