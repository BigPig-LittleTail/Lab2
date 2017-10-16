package com.yiibai.struts2;

import java.sql.ResultSet;
import java.util.LinkedList;

import com.opensymphony.xwork2.ActionContext;
import com.yiibai.struts2.LinkToMySQL;;

public class ShowAllBookAction {
	 public String execute() throws Exception
	 {
		 LinkToMySQL mySQL = new LinkToMySQL();
		 mySQL.Connect();
		 
		 ResultSet rs = mySQL.stmt.executeQuery("select * from book");
		 LinkedList<book> books = new LinkedList<>();
		 
		 while(rs.next())
		 {
			 book temp_book = new book();
				
			temp_book.ISBN = rs.getString("ISBN");
			temp_book.AuthorID = rs.getString("AuthorID");
			temp_book.Title = rs.getString("Title");
			temp_book.PublishDate = rs.getString("PublishDate");
			temp_book.Publisher = rs.getString("Publisher");
			temp_book.Price = rs.getString("Price");
			books.add(temp_book);
			
//			try {
//				Statement sttm = mySQL.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//				ResultSet rs_author = sttm.executeQuery("select * from author");
//				LinkedList<String> allauthorid = new LinkedList<>();
//				 while(rs_author.next())
//				 {
//					 String authorid = rs_author.getString("AuthorID");
//					 allauthorid.add(authorid);
//				 }
//				 ActionContext.getContext().put("allauthorid", allauthorid);
//				rs_author.close();
//				sttm.close();
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
		 }
		 ActionContext.getContext().put("books", books);
		 
		 rs.close();
		 
		 
		
		 
		 
		 
		 mySQL.close();
		 
		 return "success";
	 }
}
