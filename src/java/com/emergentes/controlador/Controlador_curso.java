
package com.emergentes.controlador;

import com.emergentes.dao.CursoDAO;
import com.emergentes.dao.CursoDAOimpl;
import com.emergentes.modelo.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador_curso", urlPatterns = {"/Controlador_curso"})
public class Controlador_curso extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("EL LINEA CURSO");
         try {
            
            CursoDAO dao = new CursoDAOimpl();           
            // Para recibir un ID
            int id;
            // Para gestionar registros
            Curso cur = new Curso();
            
            String action = (request.getParameter("action")!=null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    //Nuevo registro
                    request.setAttribute("curso", cur);
                    request.getRequestDispatcher("frmcurso.jsp").forward(request, response);
                    break;
                case "edit":
                    //Para editar un registro
                    id = Integer.parseInt(request.getParameter("id"));
                    cur = dao.getId_curso(id);
                    request.setAttribute("curso", cur);
                    request.getRequestDispatcher("frmcurso.jsp").forward(request, response);
                    break;
                case "delete":
                    //OPeraciones para eliminar un registro
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete_curso(id);
                    //request.getRequestDispatcher("Inicio").forward(request, response);
                    response.sendRedirect("Controlador_curso");
                    break;
                default:
                    //Listar los registros
                    List<Curso> lista = dao.getAll_curso();
                    request.setAttribute("curso", lista);
                    request.getRequestDispatcher("listado_curso.jsp").forward(request, response);
                    break;
                
            }
        } catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CursoDAO dao = new CursoDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));  
        String descripcion = request.getParameter("descripcion");
        
        Curso cur = new Curso();
        
        cur.setId_curso(id);
        cur.setDescripcion(descripcion);
        
        if (id == 0) {
            //Nuevo registro
            try {
                dao.insert_curso(cur);
                response.sendRedirect("Controlador_curso");
            } catch (Exception e) {
                System.out.println("error"+ e.getMessage());
            }
        }else{
            //edicion o actualizacion de un registro
            try {
                dao.update_curso(cur);
                response.sendRedirect("Controlador_curso");
            } catch (Exception e) {
                System.out.println("error"+ e.getMessage());
            }            
        }   
    }

}
