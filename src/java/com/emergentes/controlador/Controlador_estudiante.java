
package com.emergentes.controlador;

import com.emergentes.dao.EstudiantesDAO;
import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.modelo.Estudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador_estudiante", urlPatterns = {"/Controlador_estudiante"})
public class Controlador_estudiante extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("EL LINEA ESTUDIANTES");
         try {
            EstudiantesDAO dao = new EstudiantesDAOimpl();
            // Para recibir un ID
            int id;
            // Para gestionar registros
            Estudiantes est = new Estudiantes();
            
            String action = (request.getParameter("action")!=null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    //Nuevo registro
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    //Para editar un registro
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.getId_est(id);
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "delete":
                    //OPeraciones para eliminar un registro
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete_est(id);
                    //request.getRequestDispatcher("Inicio").forward(request, response);
                    response.sendRedirect("Controlador_estudiante");
                    break;
                default:
                    //Listar los registros
                    List<Estudiantes> lista = dao.getAll_est();
                    request.setAttribute("estudiante", lista);
                    request.getRequestDispatcher("listado_estudiantes.jsp").forward(request, response);
                    break;
                
            }
        } catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EstudiantesDAO dao = new EstudiantesDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));  
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        
        Estudiantes est = new Estudiantes();
        
        est.setId(id);
        est.setNombre(nombre);
        est.setApellidos(apellidos);
        est.setCorreo(correo);
        
        if (id == 0) {
            //Nuevo registro
            try {
                dao.insert_est(est);
                response.sendRedirect("Controlador_estudiante");
            } catch (Exception e) {
                System.out.println("error"+ e.getMessage());
            }
        }else{
            //edicion o actualizacion de un registro
            try {
                dao.update_est(est);
                response.sendRedirect("Controlador_estudiante");
            } catch (Exception e) {
                System.out.println("error"+ e.getMessage());
            }            
        }  
    }
}
