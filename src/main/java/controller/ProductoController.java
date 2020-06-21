/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;

/**
 *
 * @author user hp
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/productos"})
public class ProductoController extends HttpServlet {
    
    public ProductoController(){
        super();    
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion=request.getParameter("opcion");

        if(opcion.equals("crear")){
            System.out.println("usted a precionado la opcion crear");        
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("views/crear.jsp");
            requestDispatcher.forward(request,response);
        }else if(opcion.equals("listar")){
            System.out.println("usted a precionado la opcion Listar");                    
            }
//        processRequest(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion=request.getParameter("opcion");
        Date fechaActual=new Date();
        
        ProductoDAO productoDAO=new ProductoDAO();
        Producto producto=new Producto();
        producto.setNombre(request.getParameter("nombre"));
        producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
        producto.setPrecio(Double.parseDouble(request.getParameter("precio")));        
        producto.setFechaCrear(new java.sql.Date(fechaActual.getTime()));
        
        try {
            productoDAO.guardar(producto);            
            System.out.println("registro guardado satisfatoriamente");
//        processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
