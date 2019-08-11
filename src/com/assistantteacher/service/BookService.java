package com.assistantteacher.service;

import java.util.List;

import com.assistantteacher.dto.BookDTO;
import com.assistantteacher.dto.BookOrderDTO;
import com.assistantteacher.dto.OrderItemDTO;
import com.assistantteacher.entity.BookOrder;
import com.assistantteacher.entity.ClassLevel;

public interface BookService {
	public long save(BookDTO bookDTO);
	
	 public void updateBook(BookDTO book);
	 public boolean  deleteBook(long id);
	 public List<BookDTO> getBookList();
	 public BookDTO getBookById(long id);
	public List<BookDTO> retrieveClassLevel() ;
	public void saveBook(BookDTO bookDTO);
	
	public void saveBookOrder(BookOrderDTO bookOrder);
	public List<BookOrder> getBookOrderList();
	public List<BookOrderDTO> getBookOrderForAdmin();
	public BookOrderDTO getBookOrderDetail(Long id);
	public List<OrderItemDTO> getbookOrderItemList(Long orderId);
	public boolean updateBookOrderItemStatus(Long id, Boolean status,
			String message);

	public List<BookDTO> getBookListById(Long classLevelId);
}
