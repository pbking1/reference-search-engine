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

public class InsertAction extends ActionSupport {
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
                String query_str1 = "insert into reference(ReferenceType,Record_Number,Pages,Author,Year,Journal,Volume,Issue,Short_Title,Alternate_Journal,ISSN,PMCID,Accession_Number,Abstract,Notes,URL,Author_Address) values(";
                String query_str2 = ReferenceType + ",";
                String query_str3 = Record_Number + ",";
                String query_str4 = Author + "," + Year + "," + Journal + "," + Volume + ",";
                String query_str5 = Issue + "," + Pages + "," + Short_Title + "," + Alternate_Journal + ",";
                String query_str6 = ISSN + "," + PMCID + "," + Accession_Number + "," + Abstract + ",";
                String query_str7 = Notes + "," + URL + "," + Author_Address + ");";
                String str1 = query_str1 + query_str2 + query_str3 + query_str4 + query_str5 + query_str6 + query_str7;
                System.out.print(str1);
                int temp = stmt.executeUpdate(str1);
                System.out.print(temp);
                if(temp == 1){
                    System.out.print("insert success");
                    return "success";
                }else{
                    System.out.print("insert fail");
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
