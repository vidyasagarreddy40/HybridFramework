package utilities;

import Reports.extentReportGeneration;
import TestBase.TestBase;
import actions.Textbox;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class dbHelper extends TestBase {
    extentReportGeneration extentreportgeneration = new extentReportGeneration();
    loggerlogs logs = new loggerlogs();
    String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=seleniumdb;";
    String userName = "sa";
    String password = "Reddy@12345";
    Connection con = null;


    public Connection dbConnectionCreation() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(dbURL, userName, password);
            System.out.println(con);
        } catch (Exception e) {
            e.printStackTrace();
            extentreportgeneration.reportLogs("fail", dbHelper.class.getSimpleName() +" "+Thread.currentThread().getStackTrace()[1].getMethodName()+" "+  e, driver);
            logs.logger("error", dbHelper.class.getSimpleName() +" "+Thread.currentThread().getStackTrace()[1].getMethodName()+" "+  e, "");
        }
        return con;
    }


    public HashMap<String, String> fetchSignUp(String TestcaseName) {
        HashMap<String,String> details= new HashMap<>();
        try {
            Statement statement = dbConnectionCreation().createStatement();
            String query="select * from Signup_detailslist where Testcasename='"+TestcaseName+"'";
            ResultSet rs=statement.executeQuery(query);

            while(rs.next()){
                details.put("Email",rs.getString("Email") );
            }
        }
        catch (Exception e){
            e.printStackTrace();
            extentreportgeneration.reportLogs("fail", dbHelper.class.getSimpleName() +" "+Thread.currentThread().getStackTrace()[1].getMethodName()+" "+  e, driver);
            logs.logger("error", dbHelper.class.getSimpleName() +" "+Thread.currentThread().getStackTrace()[1].getMethodName()+" "+  e, "");
        }

        return details;
    }


}
