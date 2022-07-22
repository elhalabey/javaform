/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contactform.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Halaby
 */
public class DbHandler {
    
        private static Connection myConn = null;
        private static Statement myStmt = null;
        private ResultSet myRs = null;
    
   DbHandler (String dbName,String user,String password)throws SQLException
    {
         if(myConn == null)
             myConn = DriverManager.getConnection(dbName, user,password );
         if (myStmt == null)
             myStmt = myConn.createStatement();
    } 
   
   public  void closeConnection() throws SQLException
   {
               if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
   }
       
   public  ResultSet executeQuery(String query) throws SQLException
           
   {
       return myStmt.executeQuery(query);
   }

   public  void executeUpdate(String query) throws SQLException
   {
        myStmt.executeUpdate(query);
   }
   
   public static void main(String[] args) throws Exception  {      
            DbHandler dbhandler=new DbHandler("jdbc:mysql://localhost:3306/mydb","halaby","1234");
        try {
            //dbhandler.executeUpdate("insert into clients(Clientsid,clientsfirstname) values (12,'cfgffnesfdf')");

            ResultSet myRs =dbhandler.executeQuery("select * from Clients");
            while (myRs.next()) {
                System.out.println(myRs.getInt("Clientsid") + ", " + myRs.getString("clientsfirstname"));
            }

        } catch (Exception exc) {
           throw new Exception("connection failed");
        } 
        dbhandler.closeConnection();
    }        
   
}
