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
import javax.servlet.http.HttpSession;
import sqlQuery.QueryToSave;

/**
 *
 * @author AMD
 */
@WebServlet(urlPatterns = {"/resetPassword"})
public class resetPassword extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet resetPassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet resetPassword at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        HttpSession session = req.getSession(false);
        String UserFromLogin=(String)session.getAttribute("Username");
        
        String oldpassword =req.getParameter("oldpassword");
        String newpassword=req.getParameter("newpassword");
        
        //String PasswordFromLogin=(String)session.getAttribute("Password");
        //sqlQuery.QueryToSave querys = new sqlQuery.QueryToSave();
        
        sqlQuery.user runQuery1 = new sqlQuery.user();
        runQuery1.setNewPassword(newpassword);
        runQuery1.setUsername(UserFromLogin);
        runQuery1.setOldPassword(oldpassword);
        
        //System.out.println(runQuery1.getOldPassword());
        //System.out.println(UserFromLogin);
        //System.out.println(runQuery1.getNewPassword());
        
        if(runQuery1.getOldPassword().equals(runQuery1.getNewPassword())){
            
            System.out.println("Old Password and New Password cannot be same.");
            res.sendRedirect("./resetPassword.jsp");
        }else{
            QueryToSave.updatePassword(runQuery1);
            res.sendRedirect("./index.html");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
