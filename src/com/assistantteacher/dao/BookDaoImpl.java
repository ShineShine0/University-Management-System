package com.assistantteacher.dao;

import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ConstantException;
import org.springframework.stereotype.Repository;

import com.assistantteacher.dto.BookDTO;
import com.assistantteacher.dto.BookOrderDTO;
import com.assistantteacher.dto.OrderItemDTO;
import com.assistantteacher.entity.Book;
import com.assistantteacher.entity.BookOrder;
import com.assistantteacher.entity.BookOrderItem;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.util.SecurityUtil;
@Repository
public class BookDaoImpl extends GenericDaoImpl<Long, Book> implements BookDao{
	@Autowired
	private ServletContext context;
	@Override
	public long save(Book book) {
		return (long)getCurrentSession().save(book);
	}

	@Override
	public void updateBook(Book book) {
		
		getCurrentSession().saveOrUpdate(book);
	}

	@Override
	public boolean deleteBook(long id) throws ConstraintViolationException {
		String result="false";
		try{
			SQLQuery q=getCurrentSession().createSQLQuery("Delete from Book Where id=:id");
			q.setParameter("id",id);
			q.executeUpdate();
			result="true";
		}catch(ConstraintViolationException ce){
			ce.printStackTrace();
			result="false";
		}catch (javax.validation.ConstraintViolationException ce) {
			result="false";
		}
		
		return false;
	/*	try{
			Book stu=(Book)getCurrentSession().get(Book.class,id);
			getCurrentSession().delete(stu);
			getCurrentSession().flush();
			return true;
		}catch(Exception ex){
			return false;
		}*/
		
		
	}

	@Override
	public List<BookDTO> getBookList() {
		Criteria c=getCurrentSession().createCriteria(Book.class)
				.createAlias("classlevel", "cl",JoinType.LEFT_OUTER_JOIN)
				;
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name")
				.add(Projections.property("price"), "price")
				.add(Projections.property("author"), "author")
				.add(Projections.property("isbn"), "isbn")
				.add(Projections.property("edition"), "edition")
				.add(Projections.property("imagepath"), "imagepath")
				.add(Projections.property("qty"), "qty")
				.add(Projections.property("cl.name"), "classLevelName")
				.add(Projections.property("cl.id"), "classLevelId")
				);
		c.setResultTransformer(Transformers.aliasToBean(BookDTO.class));
		List<BookDTO> booklist = c.list();
		for(BookDTO book : booklist){
			book.setImagepath(context.getContextPath()+"/resources/upload_images/"+book.getImagepath());
		}
		return booklist;
	}

	@Override
	public BookDTO getBookById(long id) {
		Criteria c=getCurrentSession().createCriteria(Book.class)
				.createAlias("classlevel", "cl",JoinType.LEFT_OUTER_JOIN)
				;
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name")
				.add(Projections.property("price"), "price")
				.add(Projections.property("author"), "author")
				.add(Projections.property("isbn"), "isbn")
				.add(Projections.property("edition"), "edition")
				.add(Projections.property("imagepath"), "imagepath")
				.add(Projections.property("qty"), "qty")
				.add(Projections.property("cl.name"), "classLevelName")
				.add(Projections.property("cl.id"), "classLevelId")
				);
		c.add(Restrictions.eq("id", id));
		c.setResultTransformer(Transformers.aliasToBean(BookDTO.class));
		return (BookDTO)c.uniqueResult();
	}

	@Override
	public List<BookDTO> retrieveClassLevel() {
		Criteria c=getCurrentSession().createCriteria(ClassLevel.class);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name"));
		c.setResultTransformer(Transformers.aliasToBean(BookDTO.class));
		return c.list();
	}

	@Override
	public void saveBook(Book book) {
	getCurrentSession().save(book);
		
	}
	
	@Override
	public void saveBookOrder(BookOrder bookOrder) {
		getCurrentSession().save(bookOrder);
		
	}

	@Override
	public List generateInvoiceNo(String Year) {
		StringBuffer sb=new StringBuffer();
		sb.append("select max(runningNo)as runningNo from(select substring(invoiceNo,5,7) as runningNo,substring(invoiceNo,3,2)as Year from BookOrder) as invoiceGenerate where Year=:year");
		SQLQuery q=getCurrentSession().createSQLQuery(sb.toString());
		q.setParameter("year",Year);
		q.addScalar("runningNo",StandardBasicTypes.STRING);
		return q.list();
	}

	@Override
	public List<BookOrder> getbookOrderList() {
		Criteria c=getCurrentSession().createCriteria(BookOrder.class)
		.createAlias("userInfo", "u" , JoinType.LEFT_OUTER_JOIN);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("totalPrice"), "totalPrice")
				.add(Projections.property("item"), "item")
				.add(Projections.property("invoiceNo"), "invoiceNo")
				);
		c.add(Restrictions.eq("u.id", SecurityUtil.getCurrentLoginAdminUser().getId()));
		c.setResultTransformer(Transformers.aliasToBean(BookOrder.class));
		return c.list();
	}

	@Override
	public List<OrderItemDTO> getbookOrderItemList(Long orderId) {
		Criteria c=getCurrentSession().createCriteria(BookOrderItem.class)
				.createAlias("bookOrder", "o",JoinType.LEFT_OUTER_JOIN)
				.createAlias("book", "b",JoinType.LEFT_OUTER_JOIN);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("qty"), "qty")
				.add(Projections.property("price"), "price")
				.add(Projections.property("b.name"), "name")
				.add(Projections.property("status"), "status")
				.add(Projections.property("message"), "message")
				);
		c.add(Restrictions.eq("o.id", orderId));
		c.setResultTransformer(Transformers.aliasToBean(OrderItemDTO.class));
		return c.list();
	}

	@Override
	public List<BookOrderDTO> getBookOrderForAdmin() {
		// TODO Auto-generated method stub
		SQLQuery query=getCurrentSession().createSQLQuery("SELECT bo.id,bo.invoiceNo,bo.totalPrice,bo.status,u.userName,s.name as studentName FROM BookOrder bo LEFT JOIN UserInfo u ON bo.userInfoId=u.id LEFT JOIN Student s ON u.Id= s.userId");
		query.addScalar("id",StandardBasicTypes.LONG);
		query.addScalar("invoiceNo",StandardBasicTypes.STRING);
		query.addScalar("totalPrice",StandardBasicTypes.DOUBLE);
		query.addScalar("status",StandardBasicTypes.STRING);
		query.addScalar("studentName",StandardBasicTypes.STRING);
		query.setResultTransformer(Transformers.aliasToBean(BookOrderDTO.class));
		return query.list();
	}

	@Override
	public BookOrderDTO getBookOrderDetail(Long id) {
		// TODO Auto-generated method stub
		SQLQuery query=getCurrentSession().createSQLQuery("SELECT bo.id,bo.invoiceNo,bo.totalPrice,bo.status,u.userName,s.name as studentName FROM BookOrder bo LEFT JOIN UserInfo u ON bo.userInfoId=u.id LEFT JOIN Student s ON u.Id= s.userId where bo.id=:orderId");
		query.setParameter("orderId", id);
		query.addScalar("id",StandardBasicTypes.LONG);
		query.addScalar("invoiceNo",StandardBasicTypes.STRING);
		query.addScalar("totalPrice",StandardBasicTypes.DOUBLE);
		query.addScalar("status",StandardBasicTypes.STRING);
		query.addScalar("studentName",StandardBasicTypes.STRING);
		query.setResultTransformer(Transformers.aliasToBean(BookOrderDTO.class));
		BookOrderDTO bo=(BookOrderDTO)query.uniqueResult();
		return bo;
	}

	@Override
	public boolean updateBookOrderItemStatus(Long id, Boolean status,
			String message) {
		// TODO Auto-generated method stub
		try{
			SQLQuery q=getCurrentSession().createSQLQuery("UPDATE BookOrderItem  SET status=:Status,message=:Message Where id=:id");
			q.setParameter("id",id);
			q.setParameter("Status",status);
			q.setParameter("Message",message);
			q.executeUpdate();
			return true;
		}catch(ConstraintViolationException ce){
			ce.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public List<BookDTO> getBookListByClassId(Long classLevelId) {
		Criteria c=getCurrentSession().createCriteria(Book.class)
				.createAlias("classlevel", "cl",JoinType.LEFT_OUTER_JOIN)
				;
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name")
				.add(Projections.property("price"), "price")
				.add(Projections.property("author"), "author")
				.add(Projections.property("isbn"), "isbn")
				.add(Projections.property("edition"), "edition")
				.add(Projections.property("imagepath"), "imagepath")
				.add(Projections.property("qty"), "qty")
				.add(Projections.property("cl.name"), "classLevelName")
				.add(Projections.property("cl.id"), "classLevelId")
				);
		c.add(Restrictions.eq("cl.id", classLevelId));
		c.setResultTransformer(Transformers.aliasToBean(BookDTO.class));
		List<BookDTO> booklist = c.list();
		for(BookDTO book : booklist){
			book.setImagepath(context.getContextPath()+"/resources/upload_images/"+book.getImagepath());
		}
		return booklist;
	}
}
