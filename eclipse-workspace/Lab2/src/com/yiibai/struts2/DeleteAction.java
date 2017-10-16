package com.yiibai.struts2;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import com.opensymphony.xwork2.ActionContext;

public class DeleteAction {
	 String DeleteISBN;
	 String Name;
	 public String delete() throws Exception
	 {
		 LinkToMySQL mySQL = new LinkToMySQL();
		 ResultSet rs_from_author = null;
		 mySQL.Connect();
		

		 
		 String sql = "delete from book where ISBN="+"'"+DeleteISBN+"'";
		 
		 String sql2 = "select * from author where Name = '"+ Name +"'";
		 
		 try {
			 mySQL.stmt.executeUpdate(sql);
			 
		    rs_from_author = mySQL.stmt.executeQuery(sql2);
  
			String authorID = "";
			String message = "";
			
			Statement stmt =  mySQL.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs_from_book = null;
			LinkedList<book> books = new LinkedList<>();
			
			while(rs_from_author.next())
			{
				authorID = rs_from_author.getString("AuthorID");
				message = "select * from book where AuthorID = '"+ authorID +"'";
				
				try
        		{
    				rs_from_book = stmt.executeQuery(message);
   
					rs_from_book.previous();
        			while(rs_from_book.next())
        			{
        				book temp_book = new book();
        				
        				temp_book.ISBN = rs_from_book.getString("ISBN");
        				temp_book.AuthorID = rs_from_book.getString("AuthorID");
        				temp_book.Title = rs_from_book.getString("Title");
        				temp_book.PublishDate = rs_from_book.getString("PublishDate");
        				temp_book.Publisher = rs_from_book.getString("Publisher");
        				temp_book.Price = rs_from_book.getString("Price");

            				books.add(temp_book);

            		}
        			ActionContext.getContext().put("AuthorID",authorID);
        		}
        		catch(Exception e)
        		{
        			e.printStackTrace();
        		}
			}
			ActionContext.getContext().put("books", books);
			rs_from_author.close();
			rs_from_book.close();
			stmt.close();
			 
		 } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		 }
		 
		 mySQL.close();

		 return "success";
	 }
	
	 
	 public String getDeleteISBN()
     {
        return DeleteISBN;
     }

     public void setDeleteISBN(String DeleteISBN)
     {
        this.DeleteISBN = DeleteISBN;
     }
     
     public String getName()
     {
        return Name;
     }

     public void setName(String Name)
     {
        this.Name = Name;
     }

	

}
