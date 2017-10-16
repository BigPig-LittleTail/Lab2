package com.yiibai.struts2;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionContext;
import com.yiibai.struts2.LinkToMySQL;;

public class BookDetailsAction {
	String ISBN;
	String AuthorID;
	
	
	public String execute() throws Exception
    {
		LinkToMySQL mySQL = new LinkToMySQL();
		mySQL.Connect();
		
		ResultSet rs_mybook = null;
		
		try {
			String sql = "select * from book where ISBN = '"+ ISBN +"'";
			
			rs_mybook = mySQL.stmt.executeQuery(sql);
			
			if(rs_mybook == null)
			{
				
			}
			else
			{
				book temp_book = new book();
				while (rs_mybook.next()) {
    				temp_book.ISBN = rs_mybook.getString("ISBN");
    				temp_book.AuthorID = rs_mybook.getString("AuthorID");
    				temp_book.Title = rs_mybook.getString("Title");
    				temp_book.PublishDate = rs_mybook.getString("PublishDate");
    				temp_book.Publisher = rs_mybook.getString("Publisher");
    				temp_book.Price = rs_mybook.getString("Price");
				}
				ActionContext.getContext().put("book",temp_book);
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		ResultSet rs_author = null;
		
		try {
			String sql = "select * from author where AuthorID = '"+ AuthorID +"'";
			
			rs_author = mySQL.stmt.executeQuery(sql);
			
			if(rs_author == null)
			{
				
			}
			else
			{
				author Author = new author();
				while (rs_author.next()) {
					Author.Age = rs_author.getString("Age");
					Author.AuthorID = rs_author.getString("AuthorID");
					Author.Country = rs_author.getString("Country");
					Author.Name = rs_author.getString("Name");
    				
				}
				ActionContext.getContext().put("author",Author);
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		mySQL.close();
		
		
		return "success";
    }
	
	 public String getISBN()
	    {
	       return ISBN;
	    }

    public void setISBN(String ISBN)
    {
       this.ISBN = ISBN;
    }
    
    public String getAuthorID()
    {
       return AuthorID;
    }

    public void setAuthorID(String AuthorID)
    {
      this.AuthorID = AuthorID;
    }
    
}
