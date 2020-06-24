/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductoDAO;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private static final long serialVersionUID=1L;
    
    public ProductoController(){
        super();    
    }
/**
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            
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
    }**/


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion=request.getParameter("opcion");

        if(opcion.equals("crear")){
            System.out.println("usted a precionado la opcion crear");        
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("/views/crear.jsp");
            requestDispatcher.forward(request,response);
        }else if(opcion.equals("listar")){
            
            ProductoDAO  productoDAO=new ProductoDAO();
            List<Producto> lista= new ArrayList<>();        
        try{
            lista=productoDAO.obtenerProducto();       
            for(Producto producto:lista){
                System.out.println(producto);            
            }
            request.setAttribute("lista",lista);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("/views/listar.jsp");
            requestDispatcher.forward(request,response);

        }catch(SQLException e){
            e.printStackTrace();        
        }
        System.out.println("usted a precionado la opcion listar");
        }else if (opcion.equals("meditar")) {
	    int id = Integer.parseInt(request.getParameter("id"));
	    System.out.println("Editar id: " + id);
	    ProductoDAO productoDAO = new ProductoDAO();
	    Producto p = new Producto();
            try {
		p = productoDAO.obtenerProducto(id);
		System.out.println(p);
		request.setAttribute("producto", p);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
		requestDispatcher.forward(request, response);

	    } catch (SQLException e) {
				// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}else if(opcion.equals("eliminar")){
               ProductoDAO productoDAO=new ProductoDAO();
               int id=Integer.parseInt(request.getParameter("id"));
               try{
                   productoDAO.eliminar(id);
                   System.out.println("registro eliminado satisfactoriamente");
                   RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.jsp");
                   requestDispatcher.forward(request,response);
               
               }catch(SQLException e){
                   e.printStackTrace();               
               }        
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion=request.getParameter("opcion");
        Date fechaActual=new Date();
        
        if(opcion.equals("guardar")){
            ProductoDAO productoDAO=new ProductoDAO();
            Producto producto=new Producto();
            producto.setNombre(request.getParameter("nombre"));
            producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
            producto.setPrecio(Double.parseDouble(request.getParameter("precio")));        
            producto.setFechaCrear(new java.sql.Date(fechaActual.getTime()));

            try {
                productoDAO.guardar(producto);            
                System.out.println("registro guardado satisfatoriamente");
                RequestDispatcher requestDispatcher= request.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request,response);
                } catch (SQLException e) {
                e.printStackTrace();
            }
        
        }else if(opcion.equals("editar")){
            Producto producto=new Producto();
            ProductoDAO productoDAO=new ProductoDAO();
            
            producto.setId(Integer.parseInt(request.getParameter("id")));
            producto.setNombre(request.getParameter("nombre"));
            producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
            producto.setPrecio(Double.parseDouble(request.getParameter("precio")));        
            producto.setFechaActualizar(new java.sql.Date(fechaActual.getTime()));        
            try{
                productoDAO.editar(producto);
                System.out.println("registro editado satisfatoriamente");
                RequestDispatcher requestDispatcher= request.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request,response);
                
            }catch(SQLException e){
                e.printStackTrace();                
            }
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
