package com.dao;

 import java.util.List;

import com.entity.BookDtls;

public interface Bookdao {
	
	public boolean addBooks(BookDtls b);

	public List<BookDtls> getAllBooks();
	
	public BookDtls getBookById(int id);
	
	public boolean updateEditBook(BookDtls b);
	
	public boolean deleteBook(int id); 
	
	public List<BookDtls> getNewBook();
	

}
