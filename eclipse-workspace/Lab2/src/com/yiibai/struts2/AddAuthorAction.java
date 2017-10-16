package com.yiibai.struts2;

import com.opensymphony.xwork2.ActionContext;

public class AddAuthorAction {
	String AuthorID;
	String Name;
	String Age;
	String Country;
	String Select_str;
	public String execute() throws Exception
	{
		String message = "insert into author(AuthorID,Name,Age,Country) values"
				+"('"+AuthorID+"',"+"'"+Name+"',"+"'"+Age+"',"+"'"+Country+"')";
		LinkToMySQL mySQL = new LinkToMySQL();
		mySQL.Connect();
		try {
			mySQL.stmt.executeUpdate(message);
			try {
				mySQL.stmt.executeUpdate(Select_str);
			} catch (Exception e) {
				ActionContext.getContext().put("output","图书信息有误");
				return "success";
			}
		} catch (Exception e) {
			ActionContext.getContext().put("output","作者信息格式有误");
			return "success";
		}
		ActionContext.getContext().put("output","添加图书和作者成功");
		return "success";
	}
	
	
	
	public String getAuthorID()
    {
       return AuthorID;
    }

    public void setAuthorID(String AuthorID)
    {
      this.AuthorID = AuthorID;
    }
    
    public String getName()
    {
       return Name;
    }

    public void setName(String Name)
    {
      this.Name = Name;
    }
    
    public String getAge()
    {
       return Age;
    }

    public void setAge(String Age)
    {
      this.Age = Age;
    }
	
    public String getCountry()
    {
       return Country;
    }

    public void setCountry(String Country)
    {
      this.Country = Country;
    }
    
    public String getSelect_str()
    {
       return Select_str;
    }

    public void setSelect_str(String Select_str)
    {
      this.Select_str = Select_str;
    }
	
	
}
