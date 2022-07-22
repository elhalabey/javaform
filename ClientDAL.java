/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contactform.dal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.Hashtable;

/**
 *
 * @author Halaby
 */
public class ClientDAL 
{
    Hashtable getAllClients ()
    {
        DbHandler dbhandler;
        try {
            dbhandler = new DbHandler("jdbc:mysql://localhost:3306/mydb","halaby","1234");
            
            ResultSet rs=dbhandler.executeQuery("select * from Clients");
            
            Hashtable clientsTable=new Hashtable();
            
             while(rs.next())
             {
                ClientDO clientDAO = new ClientDO();
                clientDAO.setId(rs.getInt("ClientsID"));
                clientDAO.setFirstname(rs.getString("clientsfirstname"));
                clientsTable.put(clientDAO.getId(), clientDAO);
                
             }

            
            return  clientsTable;
            } 
        
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            return null;
        }
        
        
    } 
    
    static ClientDO getClientById (int id)
    {
        DbHandler dbhandler;
        try {
            dbhandler = new DbHandler("jdbc:mysql://localhost:3306/mydb","halaby","1234");
            ClientDO clientDO = new ClientDO();
            ResultSet rs=dbhandler.executeQuery("select * from Clients where ClientsID = "+ id);
            
            if(rs==null)
                return null;
//    if (clientDO !=null)
//        System.out.println(clientDO.getFirstname());
//    else 
//       System.out.println("client not found");        
             rs.next();
             
            clientDO.setId(rs.getInt("ClientsID"));
            clientDO.setFirstname(rs.getString("clientsfirstname"));
            clientDO.setLastname(rs.getString("clientslastname"));
            clientDO.setEmail(rs.getString("clientsemail"));
            clientDO.setPhone(rs.getInt("clientsphone"));
            clientDO.setOrgloc(rs.getString("clientsorgloc"));
            clientDO.setOrgname(rs.getString("clientsorgname"));
            clientDO.setMessage(rs.getString("clientsmessage"));
            
            return clientDO;
            } 
        
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            return null;
        }
        
        
    }
    
     static ClientDO getClientByName (String name)
    {
        DbHandler dbhandler;
        try {
            dbhandler = new DbHandler("jdbc:mysql://localhost:3306/mydb","halaby","1234");
            ClientDO clientDO = new ClientDO();
            ResultSet rs=dbhandler.executeQuery("select * from Clients where Clientsfirstname = '"+name+"' OR Clientslastname = '"+name+"'");
            
            if(rs==null)
            {
                System.out.println("client not found");  
                return null;
            }
//    if (clientDO !=null)
//        System.out.println(clientDO.getFirstname());
//    else 
//       System.out.println("client not found");        
             rs.next();
             
            clientDO.setId(rs.getInt("ClientsID"));
            clientDO.setFirstname(rs.getString("clientsfirstname"));
            clientDO.setLastname(rs.getString("clientslastname"));
            clientDO.setEmail(rs.getString("clientsemail"));
            clientDO.setPhone(rs.getInt("clientsphone"));
            clientDO.setOrgloc(rs.getString("clientsorgloc"));
            clientDO.setOrgname(rs.getString("clientsorgname"));
            clientDO.setMessage(rs.getString("clientsmessage"));
            
            return clientDO;
            } 
        
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            return null;
        }
        
        
    }
     
    static ClientDO getClientByPhone (int phone)
    {
        DbHandler dbhandler;
        try {
            dbhandler = new DbHandler("jdbc:mysql://localhost:3306/mydb","halaby","1234");
            ClientDO clientDO = new ClientDO();
            ResultSet rs=dbhandler.executeQuery("select * from Clients where Clientsphone = "+ phone);
            
            if(rs==null)
                return null;
//    if (clientDO !=null)
//        System.out.println(clientDO.getFirstname());
//    else 
//       System.out.println("client not found");        
             rs.next();
             
            clientDO.setId(rs.getInt("ClientsID"));
            clientDO.setFirstname(rs.getString("clientsfirstname"));
            clientDO.setLastname(rs.getString("clientslastname"));
            clientDO.setEmail(rs.getString("clientsemail"));
            clientDO.setPhone(rs.getInt("clientsphone"));
            clientDO.setOrgloc(rs.getString("clientsorgloc"));
            clientDO.setOrgname(rs.getString("clientsorgname"));
            clientDO.setMessage(rs.getString("clientsmessage"));
            
            return clientDO;
            } 
        
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            return null;
        }
        
        
    }      
    
    static ClientDO getClientByCategory (int clientCategory)
    {
        DbHandler dbhandler;
        try {
            dbhandler = new DbHandler("jdbc:mysql://localhost:3306/mydb","halaby","1234");
            ClientDO clientDO = new ClientDO();
            ResultSet rsClient=dbhandler.executeQuery("select * from Clients where CategoryID = "+clientCategory);
            //ResultSet rsCategory=dbhandler.executeQuery("select * from Category where CategoryID = "+clientCategory);
            
            if(rsClient==null)
                return null;
            //if(rsCategory==null)
            //    return null;
            
            rsClient.next();
            //rsCategory.next();
            
            clientDO.setId(rsClient.getInt("ClientsID"));
            clientDO.setFirstname(rsClient.getString("clientsfirstname"));
            clientDO.setLastname(rsClient.getString("clientslastname"));
            clientDO.setEmail(rsClient.getString("clientsemail"));
            clientDO.setPhone(rsClient.getInt("clientsphone"));
            clientDO.setOrgloc(rsClient.getString("clientsorgloc"));
            clientDO.setOrgname(rsClient.getString("clientsorgname"));
            clientDO.setMessage(rsClient.getString("clientsmessage"));

            rsClient=dbhandler.executeQuery("select * from Category where CategoryID = "+clientCategory);
            if(rsClient==null)
                return null;
            rsClient.next();
            clientDO.setCategory(rsClient.getString("categoryname"));
            
            return clientDO;
            } 
        
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            return null;
        }
        
        
    }    
   
    static void viewClientData (ClientDO client){
  
       System.out.println("Client ID : "+client.getId());       
       System.out.println("Client Firstname : "+client.getFirstname());       
       System.out.println("Client Lastname : "+client.getLastname());       
       System.out.println("Client Email : "+client.getEmail());       
       System.out.println("Client Phone : "+client.getPhone());       
       System.out.println("Client Message : "+client.getMessage());       
       System.out.println("Client Orginzation location : "+client.getOrgloc());       
       System.out.println("Client Orginzation name : "+client.getOrgname());       
       System.out.println("Client Category : "+client.getCategory());
    }
       public static void main (String args [])

   {
       viewClientData( getClientByCategory(3));      
   }
    
}
