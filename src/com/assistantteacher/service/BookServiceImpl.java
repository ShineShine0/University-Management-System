package com.assistantteacher.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assistantteacher.dao.BookDao;
import com.assistantteacher.dto.AdminDTO;
import com.assistantteacher.dto.BookDTO;
import com.assistantteacher.dto.BookOrderDTO;
import com.assistantteacher.dto.BookOrderItemDTO;
import com.assistantteacher.dto.OrderItemDTO;
import com.assistantteacher.dto.StudentDTO;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.Book;
import com.assistantteacher.entity.BookOrder;
import com.assistantteacher.entity.BookOrderItem;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.UserInfo;
import com.assistantteacher.util.SecurityUtil;



@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bookDao;
	@Autowired
	private ServletContext context;

	@Override
	public long save(BookDTO bookDTO) {
		return bookDao.save(convertUserInfoBean(bookDTO));

		
	}
	@Override
	public void updateBook(BookDTO book) {
		bookDao.save(convertUserInfoBean(book));
		
	}

	@Override
	public boolean deleteBook(long id) {
		
		return bookDao.deleteBook(id);
	}

	@Override
	public List<BookDTO> getBookList() {
		return bookDao.getBookList();
	}

	@Override
	public BookDTO getBookById(long id) {
		
		BookDTO bo = bookDao.getBookById(id);
		bo.setImagepath(context.getContextPath()+"/resources/upload_images/"+bo.getImagepath());
		return bo;
	}

	@Override
	public List<BookDTO> retrieveClassLevel() {
		return bookDao.retrieveClassLevel();
	}
	@Override
	public void saveBook(BookDTO bookDTO) {
		Book book = new Book();
		book = convertUserInfoBean(bookDTO);
		bookDao.saveBook(book);
	}

	private Book convertUserInfoBean(BookDTO bookDTO) {
		Book book = new Book();
		String folder = "/Images/User/Books/";
		String folderD = "/Images/User/UserPhotos/";
		
		if( bookDTO.getId() != null){
			book.setId(bookDTO.getId());
		}
		if (bookDTO.getImgfile().getSize() != 0) {
			String imagePath = writeFile(bookDTO.getImgfile(), folder);
			book.setImagepath(imagePath);
		}
		book.getClasslevel().setId(bookDTO.getClassLevelId());
		
		//for book
		book.setName(bookDTO.getName());
		book.setAuthor(bookDTO.getAuthor());
		book.setIsbn(bookDTO.getIsbn());
		book.setPrice(bookDTO.getPrice());
		book.setEdition(bookDTO.getEdition());
		book.setQty(bookDTO.getQty());
		
	
		
		return book;

}
	private String writeFile(MultipartFile multipartFile, String filePath) {
		File directory = new File(context.getRealPath("/resources/upload_images")); // This is the folder of your application
		//directory = directory.getParentFile();
		//File imageFolder = new File(directory + filePath);
		File imageFolder = new File(directory.getAbsolutePath() );
		if (!imageFolder.exists()) {
			imageFolder.mkdirs();
		}
		String imgFolderPath = imageFolder.toString();
		//String folderName = filePath;
		String tempFilePath = imgFolderPath;
		System.err.println("\n\ntempFilePath>>>>>> " + tempFilePath);
		// logger.info("tempFilePath>>>>>> "+tempFilePath);
		String nano_time = String.valueOf(System.nanoTime());
		String fileName = nano_time + "_" + multipartFile.getOriginalFilename();
		File dest = new File(tempFilePath, fileName);
		try {
			multipartFile.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return  fileName;
		//return folderName + fileName;
	}
	@Override
	public void saveBookOrder(BookOrderDTO bookOrder) {
		BookOrder bookorder = new BookOrder();
		bookorder = convertUserInfoBean(bookOrder);
		bookDao.saveBookOrder(bookorder);	
	}
	public String generateInvoiceNo(){
		Date today= new Date();
		Integer tYear = today.getYear() + 1900;
		System.out.println("\n\n Year = "+tYear);
		StringBuffer sp=new StringBuffer(tYear.toString());
		String ty=sp.substring(2);
		System.out.println("\n\n"+ty);
		List result=bookDao.generateInvoiceNo(ty);
		Iterator it=result.iterator();
		String no=null;
		while(it.hasNext()){
			Object r=it.next();
			if(r==null){
				no="0";
		}else{
			no=(String) r;
		}
		}
		Long maxNo=Long.parseLong(no);
		maxNo++;
		no=String.format("%07d", maxNo);
		String invoiceNo="BO"+ty+no;
		System.out.println("\n\n"+ invoiceNo);
		return invoiceNo;
	}
	private BookOrder convertUserInfoBean(BookOrderDTO bookOrderDTO) {
		BookOrder bookorder= new BookOrder();
		bookorder.setInvoiceNo(generateInvoiceNo());
		bookorder.setTotalPrice(bookOrderDTO.getTotalPrice());
		bookorder.setUserInfo(SecurityUtil.getCurrentLoginAdminUser());
		bookorder.setStatus("Order");
		BookOrderItem item= new BookOrderItem();
		
		for (BookOrderItemDTO t : bookOrderDTO.order) {
			
			item= new BookOrderItem();
			item.getBook().setId(t.getBookId());
			item.setBookOrder(bookorder);
			item.setQty(t.getQty());
			item.setPrice(t.getPrice());
			bookorder.getItem().add(item);
		}
		
		return bookorder;

}
	@Override
	public List<BookOrder> getBookOrderList() {
		 List<BookOrder> list= bookDao.getbookOrderList();
		 
		return list;
	}
	@Override
	public List<OrderItemDTO> getbookOrderItemList(Long orderId) {
		// TODO Auto-generated method stub
		return bookDao.getbookOrderItemList(orderId);
	}
	@Override
	public List<BookOrderDTO> getBookOrderForAdmin() {
		// TODO Auto-generated method stub
		return bookDao.getBookOrderForAdmin();
	}
	@Override
	public BookOrderDTO getBookOrderDetail(Long id) {
		// TODO Auto-generated method stub
		BookOrderDTO orderDTO=bookDao.getBookOrderDetail(id);
		orderDTO.setOrderItemList(bookDao.getbookOrderItemList(id));
		return orderDTO;
	}
	@Override
	public boolean updateBookOrderItemStatus(Long id, Boolean status,
			String message) {
		// TODO Auto-generated method stub
		return bookDao.updateBookOrderItemStatus(id, status, message);
	}
	@Override
	public List<BookDTO> getBookListById(Long classLevelId) {
		return bookDao.getBookListByClassId(classLevelId);
	}
}
