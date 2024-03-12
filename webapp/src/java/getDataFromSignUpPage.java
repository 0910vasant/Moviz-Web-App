/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author AMD
 */
@WebServlet(urlPatterns = {"/getDataFromSignUpPage"})
public class getDataFromSignUpPage extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
        //res.setContentType("text/html");
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //PrintWriter out=res.getWriter();
        
        
        sqlQuery.user runQuery = new sqlQuery.user();
        runQuery.setName(name);
        runQuery.setEmail(email);
        runQuery.setUsername(username);
        runQuery.setPassword(password);
        
        sqlQuery.QueryToSave querys = new sqlQuery.QueryToSave();
        querys.SignUp(runQuery);
        
        
        res.sendRedirect("./index.html");
    }
    

}
