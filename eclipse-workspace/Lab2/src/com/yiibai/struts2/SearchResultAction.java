package com.yiibai.struts2;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import com.yiibai.struts2.book;
import com.opensymphony.xwork2.ActionContext;
import com.yiibai.struts2.LinkToMySQL;;

public class SearchResultAction {
	String Inputname;
	
    public String execute() throws Exception
    {
    	LinkToMySQL temp = new LinkToMySQL();
    	ResultSet rs_from_author = null;

    	temp.Connect();
    	String sql = "";
    	

		sql = "select * from author where Name = '"+ Inputname +"'";
		try
		{
			rs_from_author = temp.stmt.executeQuery(sql);
			if(rs_from_author.next() == false)
    		{
				ActionContext.getContext().put("output","该作者不存在");
    		}
    		else
    		{   
    			rs_from_author.previous();
    			String authorID = "";
    			String message = "";
    			Statement stmt =  temp.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    			ResultSet rs_from_book = null;
    			LinkedList<book> books = new LinkedList<>();
    			
    			ActionContext.getContext().put("output","全部书籍如下:");
    			while(rs_from_author.next())
    			{
    				authorID = rs_from_author.getString("AuthorID");
    				
    				message = "select * from book where AuthorID = '"+ authorID +"'";
    				
    				try
            		{
        				rs_from_book = stmt.executeQuery(message);
       
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
    		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	temp.close();
    	
    	return "success";
    }

    
    
    public String getInputname()
    {
       return Inputname;
    }

    public void setInputname(String Inputname)
    {
       this.Inputname = Inputname;
    }
  
}
