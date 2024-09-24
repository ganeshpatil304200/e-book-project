 package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookDtls;
import com.mysql.cj.xdevapi.Result;

public class Bookdaoimpl implements Bookdao {

	private Connection con;

	public Bookdaoimpl(Connection con) {
		super();
		this.con = con;
	}

	public boolean addBooks(BookDtls b) {
		boolean f = false;

		try {
			String sql = "insert into bookdtls(bookname,author,price,bookCategory,status,photo,email) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, b.getBookName());
			pst.setString(2, b.getAuthor());
			pst.setString(3, b.getPrice());
			pst.setString(4, b.getBookCategory());
			pst.setString(5, b.getStatus());
			pst.setString(6, b.getPhotoName());
			pst.setString(7, b.getEmail());

			int i = pst.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	@Override
	public List<BookDtls> getAllBooks() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;

		try {
			String sql = "select * from bookDtls";
			PreparedStatement pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BookDtls getBookById(int id) {
		BookDtls b = null;
		try {
			String sql = "select * from bookdtls where BookId=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public boolean updateEditBook(BookDtls b) {
		boolean f = false;
		try {
			String sql = "update bookdtls set bookname=?,author=?,price=?,status=? where bookId=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, b.getBookName());
			pst.setString(2, b.getAuthor());
			pst.setString(3, b.getPrice());
			pst.setString(4, b.getStatus());
			pst.setInt(5, b.getBookId());

			int i = pst.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	@Override
	public boolean deleteBook(int id) {
		boolean f=false;
		try {
			
			String sql="delete from Bookdtls where bookId=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			int i =pst.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
             		
		
		return f;
	}

	@Override
	public List<BookDtls> getNewBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b=null;
		try {
			String sql="select * from BookDtls where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setString(1, "New");
			pst.setString(2, "Active");
			ResultSet rs=pst.executeQuery();
			int i=0;
			while(rs.next() && i<=100)
			{
				b=new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				i++;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
