package com.assistantteacher.dao;

import java.util.List;

import com.assistantteacher.dto.BookDTO;
import com.assistantteacher.dto.BookOrderDTO;
import com.assistantteacher.dto.OrderItemDTO;
import com.assistantteacher.entity.Book;
import com.assistantteacher.entity.BookOrder;
import com.assistantteacher.entity.BookOrderItem;
import com.assistantteacher.entity.ClassLevel;

public interface BookDao {
	long save(Book book);
	void updateBook(Book book);
	boolean deleteBook(long id);
	List<BookDTO> getBookList();
	BookDTO getBookById(long id);
	public List<BookDTO> retrieveClassLevel() ;
	void saveBook(Book book);
	
	public void saveBookOrder(BookOrder bookOrder);
	public List generateInvoiceNo(String Year);
	public List<BookOrder> getbookOrderList();
	public List<OrderItemDTO> getbookOrderItemList(Long orderId);
	public List<BookOrderDTO> getBookOrderForAdmin();
	public BookOrderDTO getBookOrderDetail(Long id);
	public boolean updateBookOrderItemStatus(Long id,Boolean status,String message);
	List<BookDTO> getBookListByClassId(Long classLevelId);

}