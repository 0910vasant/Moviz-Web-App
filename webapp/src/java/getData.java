/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AMD
 */
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/getData")
public class getData extends HttpServlet{
    public String name;
    public String password;
    private Object Entity;
    
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
        //res.setContentType("text/html");
        
        //req.setAttribute(name, res);
        name=req.getParameter("Lusername");
        password=req.getParameter("Lpassword");
        //req.setAttribute(password, res);
        //PrintWriter out=res.getWriter();
        System.out.println(name);
        System.out.println(password);
        
        sqlQuery.QueryToSave querys = new sqlQuery.QueryToSave();
        
        sqlQuery.user runQuery = new sqlQuery.user();
        runQuery.setUsername(name);
        runQuery.setPassword(password);
        
        if(querys.getUserName(runQuery) && querys.getPassword(runQuery) == true){  
        
            HttpSession session=req.getSession();
            session.setAttribute("Username", name);
            //session.setAttribute("Password", password);
            //RequestDispatcher rd=req.getRequestDispatcher("./afterLoginGetData.jsp");
            //rd.forward(req,res);
            System.out.println("Login Successful"); 
            res.sendRedirect("./afterLoginGetData.jsp");
        }else{  
            System.out.println("Sorry username or password error");  
            //RequestDispatcher rd=req.getRequestDispatcher("index.html");  
            //rd.include(req,res); 
            res.sendRedirect("./index.html");
        }  
        
        
        //res.sendRedirect("./afterLoginGetData.jsp");
      
       
    }
   
    
    
}
