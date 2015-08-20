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

public class SearchAction extends ActionSupport {
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
	private ArrayList<searchbean> s_result;
        public String execute() throws Exception{
            
            s_result = new ArrayList<searchbean>();    
            try{
                //load the driver
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/reference_db?user=root&password=13823201933root");
                System.out.println("admin connect mysql success");
                Statement stmt = conn.createStatement();
                String query_str = "select * from reference where ";
                int flag = 0;
                if(ReferenceType !=  null){
                    query_str += " ReferenceType like '%" + ReferenceType + "%'";
                    flag = 1;
                }
                if(Record_Number != null){
                    if(flag == 1)
                        query_str += "and Record_Number like '%" + Record_Number + "%'";
                    else{
                        query_str += " Record_Number like '%" + Record_Number + "%'";
                        flag = 1;
                    }
                }
                if(Author != null){
                    if(flag == 1)
                        query_str += "and Author like '%" + Author + "%'";
                    else{
                        query_str += " Author like '%" + Author + "%'";
                        flag = 1;
                    }
                }
                if(Year != null){
                    if(flag == 1)
                        query_str += "and Year like '%" + Year + "%'";
                    else{
                        query_str += " Year like '%" + Year + "%'";
                        flag = 1;
                    }
                }
                if(Journal != null){
                    if(flag == 1)
                        query_str += "and Journal like '%" + Journal + "%'";
                    else{
                        query_str += " Journal like '%" + Journal + "%'";
                        flag = 1;
                    }
                }
                if(Volume != null){
                    if(flag == 1)
                        query_str += "and Volume like '%" + Volume + "%'";
                    else{
                        query_str += " Volume like '%" + Volume + "%'";
                        flag = 1;
                    }
                }
                if(Issue != null){
                    if(flag == 1)
                        query_str += "and Issue like '%" + Issue + "%'";
                    else{
                        query_str += " Issue like '%" + Issue + "%'";
                        flag = 1;
                    }
                }
                if(Pages != null){
                    if(flag == 1)
                        query_str += "and Pages like '%" + Pages + "%'";
                    else{
                        query_str += " Pages like '%" + Pages + "%'";
                        flag = 1;
                    }
                }
                if(Short_Title != null){
                    if(flag == 1)
                        query_str += "and Short_Title like '%" + Short_Title + "%'";
                    else{
                        query_str += " Short_Title like '%" + Short_Title + "%'";
                        flag = 1;
                    }
                }
                if(Alternate_Journal != null){
                    if(flag == 1)
                        query_str += "and Alternate_Journal like '%" + Alternate_Journal + "%'";
                    else{
                        query_str += " Alternate_Journal like '%" + Alternate_Journal + "%'";
                        flag = 1;
                    }
                }
                if(ISSN != null){
                    if(flag == 1)
                        query_str += "and ISSN like '%" + ISSN + "%'";
                    else{
                        query_str += " ISSN like '%" + ISSN + "%'";
                        flag = 1;
                    }
                }
                if(Notes != null){
                    if(flag == 1)
                        query_str += "and Notes like '%" + Notes + "%'";
                    else{
                        query_str += " Notes like '%" + Notes + "%'";
                        flag = 1;
                    }
                }
                if(PMCID != null){
                    if(flag == 1)
                        query_str += "and PMCID like '%" + PMCID + "%'";
                    else{
                        query_str += " PMCID like '%" + PMCID + "%'";
                        flag = 1;
                    }
                }
                if(Accession_Number != null){
                    if(flag == 1)
                        query_str += "and Accession_Number like '%" + Accession_Number + "%'";
                    else{
                        query_str += " Accession_Number like '%" + Accession_Number + "%'";
                        flag = 1;
                    }
                }
                if(Abstract != null){
                    if(flag == 1)
                        query_str += "and Abstract like '%" + Abstract + "%'";
                    else{
                        query_str += " Abstract like '%" + Abstract + "%'";
                        flag = 1;
                    }
                }
                if(Author_Address != null){
                    if(flag == 1)
                        query_str += "and Author_Address like '%" + Author_Address + "%'";
                    else{
                        query_str += " Author_Address like '%" + Author_Address + "%'";
                        flag = 1;
                    }
                }
                if(URL != null){
                    if(flag == 1)
                        query_str += "and URL like '%" + URL + "%'";
                    else{
                        query_str += " URL like '%" + URL + "%'";
                        flag = 1;
                    }
                }
                ResultSet rs = stmt.executeQuery(query_str + ";");
                System.out.print(query_str);

                searchbean lb = new searchbean();
                while(rs.next()){
                    if(rs.getString("ReferenceType") != null)
                        lb.setReferenceType(rs.getString("ReferenceType"));
                    System.out.print(lb.getReferenceType());
                    if(rs.getString("Record_Number") != null)
                        lb.setRecord_Number(rs.getString("Record_Number"));
                    System.out.print(lb.getRecord_Number());
                    if(rs.getString("Pages") != null)
                        lb.setPages(rs.getString("Pages"));
                    if(rs.getString("Author") != null)
                        lb.setAuthor(rs.getString("Author"));
                    if(rs.getString("Year") != null)
                        lb.setYear(rs.getString("Year"));
                    if(rs.getString("Journal") != null)
                        lb.setJournal(rs.getString("Journal"));
                    if(rs.getString("Volume") != null)
                        lb.setVolume(rs.getString("Volume"));
                    if(rs.getString("Issue") != null)
                        lb.setIssue(rs.getString("Issue"));
                    if(rs.getString("Short_Title") != null)
                        lb.setShort_Title(rs.getString("Short_Title"));
                    if(rs.getString("Alternate_Journal") != null)
                        lb.setAlternate_Journal(rs.getString("Alternate_Journal"));
                    if(rs.getString("ISSN") != null)
                        lb.setISSN(rs.getString("ISSN"));
                    if(rs.getString("PMCID") != null)
                        lb.setPMCID(rs.getString("PMCID"));
                    if(rs.getString("Accession_Number") != null)
                        lb.setAccession_Number(rs.getString("Accession_Number"));
                    if(rs.getString("Abstract") != null)
                        lb.setAbstract(rs.getString("Abstract"));
                    if(rs.getString("Notes") != null)
                        lb.setNotes(rs.getString("Notes"));
                    if(rs.getString("URL") != null)
                        lb.setURL(rs.getString("URL"));
                    if(rs.getString("Author_Address") != null)
                        lb.setAuthor_Address(rs.getString("Author_Address"));
                    if(rs.getString("ID") != null)
                        lb.setId(rs.getString("ID"));
                    s_result.add(lb);
                    lb = new searchbean();
                }
                stmt.close();
                return "success";
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println(e.getSQLState());
                System.out.println(e.getErrorCode());
                return "error";
            }

	}

        public ArrayList<searchbean> getS_result() {
            return s_result;
        }

        public void setS_result(ArrayList<searchbean> s_result) {
            this.s_result = s_result;
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

