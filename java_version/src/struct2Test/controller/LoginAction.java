package struct2Test.controller;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.*;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
        private ArrayList<loginbean> arr;
	LoginCheck lc = new LoginCheck();
	
	public void validate(){
		if(username == null || "".equals(username.trim())){
			addFieldError("username", "username is required");
		}
		
		if(password == null || "".equals(password.trim())){
			addFieldError("password", "password is required");
		}
	}
	
	public String execute() throws Exception{
                
		if(lc.isLogin(username,password)){
                    arr = new ArrayList<loginbean>();
                    try{
                        //load the driver
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/reference_db?user=root&password=13823201933root");
                        System.out.println("admin connect mysql success");
                        Statement stmt = conn.createStatement();
                        String query_str = "select * from reference;";
                        ResultSet rs = stmt.executeQuery(query_str);

                        loginbean lb = new loginbean();
                        while(rs.next()){
                            lb.setReferenceType(rs.getString("ReferenceType"));
                            lb.setRecord_Number(rs.getString("Record_Number"));
                            lb.setPages(rs.getString("Pages"));
                            lb.setAuthor(rs.getString("Author"));
                            lb.setYear(rs.getString("Year"));
                            lb.setJournal(rs.getString("Journal"));
                            lb.setVolume(rs.getString("Volume"));
                            lb.setIssue(rs.getString("Issue"));
                            lb.setShort_Title(rs.getString("Short_Title"));
                            lb.setAlternate_Journal(rs.getString("Alternate_Journal"));
                            lb.setISSN(rs.getString("ISSN"));
                            lb.setPMCID(rs.getString("PMCID"));
                            lb.setAccession_Number(rs.getString("Accession_Number"));
                            lb.setAbstract(rs.getString("Abstract"));
                            lb.setNotes(rs.getString("Notes"));
                            lb.setURL(rs.getString("URL"));
                            lb.setAuthor_Address(rs.getString("Author_Address"));
                            lb.setId(rs.getString("ID"));
                            arr.add(lb);
                            lb = new loginbean();
                        }
                        stmt.close();
                        return "success";
                    }catch(SQLException e){
                        System.out.println(e.getMessage());
                        System.out.println(e.getSQLState());
                        System.out.println(e.getErrorCode());
                        return "error";
                    }
		} else{
			addFieldError("username","invald username or password");
			return "error";
			
		}
	}
	
		
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getUsername(){
		return username;
	}
        public ArrayList<loginbean> getArr() {
            return arr;
        }

        public void setArr(ArrayList<loginbean> arr) {
            this.arr = arr;
        }
}
