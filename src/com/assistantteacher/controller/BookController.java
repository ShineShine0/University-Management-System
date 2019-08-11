package com.assistantteacher.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.assistantteacher.dto.BookDTO;
import com.assistantteacher.dto.BookOrderDTO;
import com.assistantteacher.dto.OrderItemDTO;
import com.assistantteacher.service.BookService;
import com.assistantteacher.util.Citizens;
import com.assistantteacher.util.Nationality;
import com.assistantteacher.util.Religion;

@Controller
@RequestMapping(value="/book")
public class BookController {
	@Autowired
	private BookService bookService;

	/*@RequestMapping(value="/book_list.htm")
	public String index(Model model){
		model.addAttribute("bookList", bookService.getBookList());
		return "book_list";
	}*/
	@RequestMapping(value="/bookManagement.htm")
	public String createBook(Model model){
		model.addAttribute("BookDTO", new BookDTO());
		model.addAttribute("bookList", bookService.getBookList());
		model.addAttribute("classLevelList",bookService.retrieveClassLevel());
		
		return "bookManagement";
	}		
	@RequestMapping(value="/bookManagement.htm",method=RequestMethod.POST)
	public String addBook(Model model,@ModelAttribute(value="BookDTO")BookDTO book){
		bookService.saveBook(book);
		//bookService.saveBookOrder(book);
		return "redirect:/book/bookManagement.htm";
	}
	
	@RequestMapping(value="/bookOrder.htm",method=RequestMethod.GET)
	public String bookorder(Model model){
		model.addAttribute("classDto",new BookDTO());
		model.addAttribute("bookList", bookService.getBookList());
		model.addAttribute("classLevelList",bookService.retrieveClassLevel());
		return "bookOrder";
	}
	
	@RequestMapping(value="/searchClassLevelList.htm",method=RequestMethod.POST)
	public String searchClassLevelList(Model model,@ModelAttribute(value="classDto")BookDTO book){
		model.addAttribute("classDto",new BookDTO());
		model.addAttribute("bookList", bookService.getBookListById(book.getClassLevelId()));
		model.addAttribute("classLevelList",bookService.retrieveClassLevel());
		return"bookOrder";
	}
	
	
	@RequestMapping(value="/bookOrder.htm",method=RequestMethod.POST)
	public String orderBook(Model model,@ModelAttribute(value="BookDTO") BookOrderDTO bookorder){
		model.addAttribute("bookOrderDTO", new BookOrderDTO());
		
		bookService.saveBookOrder(bookorder);
		return"redirect:/book/bookOrder.htm";
	}
	
	@RequestMapping(value="/bookOrderList.htm")
	public String bookorderList(Model model){
	
		model.addAttribute("bookOrderList", bookService.getBookOrderList());
		return "bookOrderList";
	}
	@RequestMapping(value="/getOrderItemList")
	public ResponseEntity<Object> getOrderItemListByOrderId(@RequestParam(value="orderId")Long id){
		
		return	new ResponseEntity<>(bookService.getbookOrderItemList(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/book/ajax/delete-book/(id}",method=RequestMethod.GET)
	public  Boolean deleteStudent(Model model,@PathVariable(value="id")long id){

		return  bookService.deleteBook(id);
	}
	@RequestMapping(value="/editBook.htm/{id}")
	public String updateStudent(Model model,@PathVariable(value="id")long id){
		
		model.addAttribute("classLevelList", bookService.retrieveClassLevel());
		model.addAttribute("BookDTO", bookService.getBookById(id));
		
		return"updateBook";
	}

	@RequestMapping(value="/student_book_orderList.htm")
	public String studentBookOrderList(Model model){
		model.addAttribute("bookOrderList", bookService.getBookOrderForAdmin());
		return "student_book_order_list";
	}
	@RequestMapping(value="/order_detail.htm/{orderId}")
	public String bookOrderDetail(@PathVariable(value="orderId")Long id,Model model){
		model.addAttribute("orderDetail",bookService.getBookOrderDetail(id));
		return "book_order_detail";
	}
	@RequestMapping(value="/postOrderStatus",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateOrderItemStatus(@RequestBody OrderItemDTO orderItem){
		boolean result=bookService.updateBookOrderItemStatus(orderItem.getId(), orderItem.getStatus(), orderItem.getMessage());
		return new ResponseEntity<Object>(result,HttpStatus.OK);
	}
	
	
	
	
	

}
