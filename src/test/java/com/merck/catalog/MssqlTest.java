package com.merck.catalog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
import org.junit.Test;
 
public class MssqlTest {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //private static final String URL = "jdbc:sqlserver://wdtest01.iptime.org:9433;databaseName=PIPATEST";
    //private static final String USER = "sa"; //DB 사용자명
    //private static final String PW = "wisedigm!@";   //DB 사용자 비밀번호
    private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=PIPATEST";
    private static final String USER = "test01"; //DB 사용자명
    private static final String PW = "01test";   //DB 사용자 비밀번호
    
    @Test
    public void testConnection() throws Exception{

        Class.forName(DRIVER); //com.microsoft.sqlserver.jdbc.SQLServerDriver JDBC Driver class 로딩

        Connection con = DriverManager.getConnection(URL, USER, PW); // java.sql.Connection 객체생성

        try{
            System.out.println(con);
             
            System.out.println(con.isClosed()); // connection 닫힘 유무

            Statement stmt = con.createStatement(); // Statement 객체생성

            String sql = "select TOP (1000) [CMMN_CD_ID]\r\n" + 
            		"      ,[CMMN_CD_ID_NM]\r\n" + 
            		"      ,[MANG_ITEM_PARM_01]\r\n" + 
            		"      ,[MANG_ITEM_VAL_01]\r\n" + 
            		"      ,[MANG_ITEM_PARM_02]\r\n" + 
            		"      ,[MANG_ITEM_VAL_02]\r\n" + 
            		"      ,[MANG_ITEM_PARM_03]\r\n" + 
            		"      ,[MANG_ITEM_VAL_03]\r\n" + 
            		"      ,[USE_YN]\r\n" + 
            		"      ,[REGIST_DT]\r\n" + 
            		"      ,[REGIST_USR_ID]\r\n" + 
            		"      ,[UPDT_DT]\r\n" + 
            		"      ,[UPDT_USR_ID] from TB_SAA001M\r\n"+
            		" WHERE CMMN_CD_ID_NM LIKE N'TES%'"
            		; // 쿼리문

            ResultSet rs = stmt.executeQuery(sql); // 

            while(rs.next()) {
                System.out.println(rs.getString("CMMN_CD_ID_NM")+"///"+rs.getString("USE_YN")+"///"+rs.getString("REGIST_DT"));
            }

            con.close();

            System.out.println(con.isClosed());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            con.close();
        }
   }
}
