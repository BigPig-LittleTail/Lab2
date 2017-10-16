package com.yiibai.struts2;

import com.opensymphony.xwork2.ActionContext;

public class UpdateAction {
	    String ISBN;
		String Title;
		String AuthorID;
		String Publisher;
		String PublishDate;
		String Price;
	 public String execute() throws Exception
	 {
		 String sql_title = "update book set Title=" +"'"+Title+"'"+" where ISBN="+"'"+ISBN+"'";
		 String sql_AuthorID = "update book set AuthorID=" +"'"+AuthorID+"'"+" where ISBN="+"'"+ISBN+"'";
		 String sql_Publisher = "update book set Publisher=" +"'"+Publisher+"'"+" where ISBN="+"'"+ISBN+"'";
		 String sql_PublishDate = "update book set PublishDate=" +"'"+PublishDate+"'"+" where ISBN="+"'"+ISBN+"'";
		 String sql_Price = "update book set Price=" +"'"+Price+"'"+" where ISBN="+"'"+ISBN+"'";
		 
		 LinkToMySQL mySQL = new LinkToMySQL();
		 
		 mySQL.Connect();
		 
		 try {
			 mySQL.stmt.executeUpdate(sql_AuthorID);
			 try {
				 mySQL.stmt.executeUpdate(sql_PublishDate);
				 mySQL.stmt.executeUpdate(sql_title);
				 mySQL.stmt.executeUpdate(sql_Publisher);
				 mySQL.stmt.executeUpdate(sql_Price);
				 
				 ActionContext.getContext().put("output","更改成功");
				 return "success";
				
			} catch (Exception e) {
				 ActionContext.getContext().put("output","格式有误");
				 mySQL.close();
				 return "success";
			}
			 
		 } catch (Exception e) {
			 ActionContext.getContext().put("output","格式有误");
			 mySQL.close();
			 return "success";
		 }
	 }

		
		 public String getISBN()
	     {
	        return ISBN;
	     }

	     public void setISBN(String ISBN)
	     {
	       this.ISBN = ISBN;
	     }
	     
	     public String getTitle()
	     {
	        return Title;
	     }

	     public void setTitle(String Title)
	     {
	       this.Title = Title;
	     }
	     
	     public String getAuthorID()
	     {
	        return AuthorID;
	     }

	     public void setAuthorID(String AuthorID)
	     {
	       this.AuthorID = AuthorID;
	     }
	     
	     public String getPublisher()
	     {
	        return Publisher;
	     }

	     public void setPublisher(String Publisher)
	     {
	       this.Publisher = Publisher;
	     }
	     
	     public String getPublishDate()
	     {
	        return PublishDate;
	     }

	     public void setPublishDate(String PublishDate)
	     {
	       this.PublishDate = PublishDate;
	     }
	     
	     public String getPrice()
	     {
	        return Price;
	     }

	     public void setPrice(String Price)
	     {
	       this.Price = Price;
	     }
}
