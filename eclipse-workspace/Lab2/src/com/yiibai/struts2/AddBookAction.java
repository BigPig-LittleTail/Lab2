package com.yiibai.struts2;
//this is the second changed area 
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionContext;

public class AddBookAction {
	
	String ISBN;
	String Title;
	String AuthorID;
	String Publisher;
	String PublishDate;
	String Price;

	public String execute() throws Exception
	{
		LinkToMySQL mySQL = new LinkToMySQL();
		mySQL.Connect();
		
		String sql = "select * from book where ISBN="+"'"+ISBN+"'";
		ResultSet rs = null;
		try {
			rs = mySQL.stmt.executeQuery(sql);
			
			if(rs.next() == true)
			{
				//书存在
				rs.close();
				mySQL.close();
				
				ActionContext.getContext().put("output","这个ISBN已经存在了");
				
				return "success";
			}
			else
			{
				rs.close();
				
				ResultSet rs_author = null;
				String message = "select * from author where AuthorID="+"'"+AuthorID+"'";
				try {
					rs_author = mySQL.stmt.executeQuery(message);
					
					String insert = "insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values"
							+"('"+ISBN+"',"+"'"+Title+"',"+"'"+AuthorID+"',"+"'"+Publisher+"',"+"'"+PublishDate+"',"
							+"'"+Price+"')";
					
					
					if(rs_author.next() == false)
					{
						rs_author.close();
						mySQL.close();
						
						ActionContext.getContext().put("str",insert);
						
						
						return "author_not_exist";
						
					}
					else
					{
						rs_author.close();
						
						mySQL.stmt.executeUpdate(insert);
						
						mySQL.close();
						
						ActionContext.getContext().put("output","添加成功");
						return "success";
					}
					
				} catch (Exception e) {
					
					mySQL.close();
					ActionContext.getContext().put("output","输入的格式有误");
					return "success";
					
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			mySQL.close();
			ActionContext.getContext().put("output","输入的格式有误");
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
