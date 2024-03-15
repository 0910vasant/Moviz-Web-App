/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlQuery;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author AMD
 */
public class QueryToSave {
    
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users?characterEncoding=utf8","root","root");  
        }catch(Exception a){System.out.println(a);}  
        return con;  
    }  

    
    public void SignUp(user e){
        int status=0; 
        QueryToSave forCheck = new QueryToSave();
        if(forCheck.getUserName(e) == true){
            System.out.println("Username already occupaied use another");
        }else{
            try{
                
                Connection con=QueryToSave.getConnection();   
            
                //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?characterEncoding=utf8","root","root");
                PreparedStatement ps= con.prepareStatement("insert into userdetails(name,email, username, password) values (?,?,?,?)");
                ps.setString(1, e.getName());
                ps.setString(2,e.getEmail());
                ps.setString(3,e.getUsername());
                ps.setString(4,e.getPassword());
                status=ps.executeUpdate();  
                
                System.out.println(e.getName());
                System.out.println(e.getEmail());
                System.out.println(e.getUsername());
                System.out.println(e.getPassword());
                
                System.out.println("Data inserted successfully");
                
            }catch(Exception a){System.out.println(a);}
        }
        
    }
    
    public boolean getUserName(user e){
        //user e = new user();
    
        boolean status=false;   
        try{
            
            Connection con= QueryToSave.getConnection();
              
            PreparedStatement ps=con.prepareStatement("select * from userdetails where username=?");  
            ps.setString(1,e.getUsername());  
            ResultSet rs = ps.executeQuery();
            //con.close(); 
            return status = rs.next();
             
        }catch(Exception ex){ex.printStackTrace();}
        return true;
    }  
    
    public boolean getPassword(user e){
        //user e = new user();
    
        boolean status=false;   
        try{
            
            Connection con= QueryToSave.getConnection();
              
            PreparedStatement ps=con.prepareStatement("select * from userdetails where password=?");  
            ps.setString(1,e.getPassword());  
            ResultSet rs = ps.executeQuery();
            //con.close(); 
            return status = rs.next();
             
        }catch(Exception ex){ex.printStackTrace();}
        return true;
    }  
}
