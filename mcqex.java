/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 19CSE028
 */
@WebServlet(urlPatterns = {"/mcqex"})
public class mcqex extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection con;
        Statement st;
        try
        {
            int mark=0;
            String name=request.getParameter("t1");
            String rollno=request.getParameter("t2");
            String q1=request.getParameter("q1");
            String q2=request.getParameter("q2");
            String q3=request.getParameter("q3");
            String q4=request.getParameter("q4");
            String q5=request.getParameter("q5");
            String q6=request.getParameter("q6");
            String q7=request.getParameter("q7");
            String q8=request.getParameter("q8");
            String q9=request.getParameter("q9");
            String q10=request.getParameter("q10");
            if(q1.equals("True"))
            {
                mark=mark+1;
            }
            if(q2.equals("False"))
            {
                mark=mark+1;
            }
            if(q3.equals("Hypertext Markup Language"))
            {
                mark=mark+1;
            }
            if(q4.equals("bold"))
            {
                mark=mark+1;
            }
            if(q5.equals("id"))
            {
                mark=mark+1;
            }
            if(q6.equals("Java Script Object Notation"))
            {
                mark=mark+1;
            }
            if(q7.equals("3"))
            {
                mark=mark+1;
            }
            if(q8.equals("#"))
            {
                mark=mark+1;
            }
            if(q9.equals("const"))
            {
                mark=mark+1;
            }

            if(q10.equals("stringify"))
            {
                mark=mark+1;
            }
            out.println("Name:"+name);
            out.println("Marks:"+mark);
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/test");
            st=con.createStatement();
            String insert="insert into student values('"+name+"',"+mark+")";
            st.executeUpdate(insert);
            out.println("Row inserted");
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            out.close();
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
