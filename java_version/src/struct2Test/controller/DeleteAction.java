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

public class DeleteAction extends ActionSupport {
	private String ReferenceType;
        private String Record_Number;
        private String Author;
        private String Year;
        private String Journal;
        private String Volume;
        private String Issue;
        private String Pages;
        private String Short_Title;
        private String Alternate_Journal;
        private String ISSN;
        private String PMCID;
        private String Accession_Number;
        private String Abstract;
        private String Notes;
        private String URL;
        private String Author_Address; 
	private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception{
                
            try{
                //load the driver
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/reference_db?user=root&password=13823201933root");
                System.out.println("admin connect mysql success");
                Statement stmt = conn.createStatement();
                String query_str = "delete from reference where ";
                int flag = 0;
                if(ReferenceType !=  null){
                    query_str += " ReferenceType like '%" + ReferenceType + "%'";
                    flag = 1;
                }else if(Record_Number != null){
                    if(flag == 1)
                        query_str += "and Record_Number like '%" + Record_Number + "%'";
                    else{
                        query_str += " Record_Number like '%" + Record_Number + "%'";
                        flag = 1;
                    }
                }else if(Author != null){
                    if(flag == 1)
                        query_str += "and Author like '%" + Author + "%'";
                    else{
                        query_str += " Author like '%" + Author + "%'";
                        flag = 1;
                    }
                }else if(Year != null){
                    if(flag == 1)
                        query_str += "and Year like '%" + Year + "%'";
                    else{
                        query_str += " Year like '%" + Year + "%'";
                        flag = 1;
                    }
                }else if(Journal != null){
                    if(flag == 1)
                        query_str += "and Journal like '%" + Journal + "%'";
                    else{
                        query_str += " Journal like '%" + Journal + "%'";
                        flag = 1;
                    }
                }else if(Volume != null){
                    if(flag == 1)
                        query_str += "and Volume like '%" + Volume + "%'";
                    else{
                        query_str += " Volume like '%" + Volume + "%'";
                        flag = 1;
                    }
                }else if(Issue != null){
                    if(flag == 1)
                        query_str += "and Issue like '%" + Issue + "%'";
                    else{
                        query_str += " Issue like '%" + Issue + "%'";
                        flag = 1;
                    }
                }else if(Pages != null){
                    if(flag == 1)
                        query_str += "and Pages like '%" + Pages + "%'";
                    else{
                        query_str += " Pages like '%" + Pages + "%'";
                        flag = 1;
                    }
                }else if(Short_Title != null){
                    if(flag == 1)
                        query_str += "and Short_Title like '%" + Short_Title + "%'";
                    else{
                        query_str += " Short_Title like '%" + Short_Title + "%'";
                        flag = 1;
                    }
                }else if(Alternate_Journal != null){
                    if(flag == 1)
                        query_str += "and Alternate_Journal like '%" + Alternate_Journal + "%'";
                    else{
                        query_str += " Alternate_Journal like '%" + Alternate_Journal + "%'";
                        flag = 1;
                    }
                }else if(ISSN != null){
                    if(flag == 1)
                        query_str += "and ISSN like '%" + ISSN + "%'";
                    else{
                        query_str += " ISSN like '%" + ISSN + "%'";
                        flag = 1;
                    }
                }else if(Notes != null){
                    if(flag == 1)
                        query_str += "and Notes like '%" + Notes + "%'";
                    else{
                        query_str += " Notes like '%" + Notes + "%'";
                        flag = 1;
                    }
                }else if(PMCID != null){
                    if(flag == 1)
                        query_str += "and PMCID like '%" + PMCID + "%'";
                    else{
                        query_str += " PMCID like '%" + PMCID + "%'";
                        flag = 1;
                    }
                }else if(Accession_Number != null){
                    if(flag == 1)
                        query_str += "and Accession_Number like '%" + Accession_Number + "%'";
                    else{
                        query_str += " Accession_Number like '%" + Accession_Number + "%'";
                        flag = 1;
                    }
                }else if(Abstract != null){
                    if(flag == 1)
                        query_str += "and Abstract like '%" + Abstract + "%'";
                    else{
                        query_str += " Abstract like '%" + Abstract + "%'";
                        flag = 1;
                    }
                }else if(Author_Address != null){
                    if(flag == 1)
                        query_str += "and Author_Address like '%" + Author_Address + "%'";
                    else{
                        query_str += " Author_Address like '%" + Author_Address + "%'";
                        flag = 1;
                    }
                }else if(URL != null){
                    if(flag == 1)
                        query_str += "and URL like '%" + URL + "%'";
                    else{
                        query_str += " URL like '%" + URL + "%'";
                        flag = 1;
                    }
                }
                
                System.out.print(query_str);
                int temp = stmt.executeUpdate(query_str);
                System.out.print(temp);
                if(temp == 1){
                    System.out.print("delete success");
                    return "success";
                }else{
                    System.out.print("delete fail");
                    return "success";
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println(e.getSQLState());
                System.out.println(e.getErrorCode());
                return "error";
            }

	}

        public String getReferenceType() {
            return ReferenceType;
        }

        public void setReferenceType(String ReferenceType) {
            this.ReferenceType = ReferenceType;
        }

        public String getRecord_Number() {
            return Record_Number;
        }

        public void setRecord_Number(String Record_Number) {
            this.Record_Number = Record_Number;
        }

        public String getAuthor() {
            return Author;
        }

        public void setAuthor(String Author) {
            this.Author = Author;
        }

        public String getYear() {
            return Year;
        }

        public void setYear(String Year) {
            this.Year = Year;
        }

        public String getJournal() {
            return Journal;
        }

        public void setJournal(String Journal) {
            this.Journal = Journal;
        }

        public String getVolume() {
            return Volume;
        }

        public void setVolume(String Volume) {
            this.Volume = Volume;
        }

        public String getIssue() {
            return Issue;
        }

        public void setIssue(String Issue) {
            this.Issue = Issue;
        }

        public String getPages() {
            return Pages;
        }

        public void setPages(String Pages) {
            this.Pages = Pages;
        }

        public String getShort_Title() {
            return Short_Title;
        }

        public void setShort_Title(String Short_Title) {
            this.Short_Title = Short_Title;
        }

        public String getAlternate_Journal() {
            return Alternate_Journal;
        }

        public void setAlternate_Journal(String Alternate_Journal) {
            this.Alternate_Journal = Alternate_Journal;
        }

        public String getISSN() {
            return ISSN;
        }

        public void setISSN(String ISSN) {
            this.ISSN = ISSN;
        }

        public String getPMCID() {
            return PMCID;
        }

        public void setPMCID(String PMCID) {
            this.PMCID = PMCID;
        }

        public String getAccession_Number() {
            return Accession_Number;
        }

        public void setAccession_Number(String Accession_Number) {
            this.Accession_Number = Accession_Number;
        }

        public String getAbstract() {
            return Abstract;
        }

        public void setAbstract(String Abstract) {
            this.Abstract = Abstract;
        }

        public String getNotes() {
            return Notes;
        }

        public void setNotes(String Notes) {
            this.Notes = Notes;
        }

        public String getURL() {
            return URL;
        }

        public void setURL(String URL) {
            this.URL = URL;
        }

        public String getAuthor_Address() {
            return Author_Address;
        }

        public void setAuthor_Address(String Author_Address) {
            this.Author_Address = Author_Address;
        }
	
	
}

