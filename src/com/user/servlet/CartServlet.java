package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBconnect;
import com.dao.Bookdaoimpl;
import com.dao.cartDaoImpl;
import com.entity.BookDtls;
import com.entity.Cart;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int bid=Integer.parseInt(req.getParameter("bid"));
			int uid=Integer.parseInt(req.getParameter("uid"));
		
			Bookdaoimpl dao =  new Bookdaoimpl(DBconnect.getCon());
			BookDtls b=dao.getBookById(bid);
			
			Cart c= new Cart();
			c.setBid(bid);
			c.setUserId(uid);
			c.setBookName(b.getBookName());
			c.setAuthor(b.getAuthor());
		   
			c.setPrice(Double.parseDouble(b.getPrice()));
			c.setTotalPrice(Double.parseDouble(b.getPrice()));
			
			cartDaoImpl dao2=new cartDaoImpl(DBconnect.getCon());
			
			boolean f=dao2.addCart(c);
			if(f)
			{
				System.out.println("add cart sucess");
			}else
			{
				System.out.println("not added to cart");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
