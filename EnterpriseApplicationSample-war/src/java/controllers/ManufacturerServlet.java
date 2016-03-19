/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import EJBBeans.ManufacturerBeans;
import entityClasses.Manufacturer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ZANDUT
 */
public class ManufacturerServlet extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
   @EJB
   ManufacturerBeans manuBeans;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        String page = new String();
        try (PrintWriter out = response.getWriter())
        {
            String action = request.getParameter("action");
            switch (action)
            {
                case "insert":
                    Manufacturer m = new Manufacturer(Integer.parseInt(request.getParameter("id")));
                    m.setName(request.getParameter("name"));
                    
                    manuBeans.create(m);
                    
                    page = "index.jsp";
                    
                    break;
                    
                case "display" :
                    
                    List<Manufacturer> array = manuBeans.findManufacturerAll();
                    request.getSession().setAttribute("array", array);
                    
                    page ="displayManufacturer.jsp";
                    
                    break;
                    
                case "delete" :
                    Integer id = Integer.parseInt(request.getParameter("id").toString());
                    Manufacturer manu = manuBeans.findManufacturer(id);
                    manuBeans.destroy(manu);
                    
                    
                    
                    page = "ManufacturerServlet?action=display";
                    break;
                
            }
            
            request.getRequestDispatcher(page).forward(request, response);
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
