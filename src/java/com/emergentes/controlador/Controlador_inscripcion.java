
package com.emergentes.controlador;

import com.emergentes.dao.InscripcionDAO;
import com.emergentes.dao.InscripcionesDAOimpl;
import com.emergentes.modelo.Inscripciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Controlador_inscripcion", urlPatterns = {"/Controlador_inscripcion"})
public class Controlador_inscripcion extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("EL LINEA INSCRIPCIONES");
         try {
            InscripcionDAO dao = new InscripcionesDAOimpl();
            // Para recibir un ID
            int id;
            // Para gestionar registros
            Inscripciones ins = new Inscripciones();
            
            String action = (request.getParameter("action")!=null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    //Nuevo registro
                    //List<Inscripciones> lista = dao.getAll_ins();
                    //request.setAttribute("inscripcion", lista);
                    
                    request.setAttribute("inscripcion", ins);
                    request.getRequestDispatcher("frminscripcion.jsp").forward(request, response);
                    break;
                case "edit":
                    //Para editar un registro
                    id = Integer.parseInt(request.getParameter("id"));
                    ins = dao.getId_ins(id);
                    request.setAttribute("inscripcion", ins);
                    request.getRequestDispatcher("frminscripcion.jsp").forward(request, response);
                    break;
                case "delete":
                    //OPeraciones para eliminar un registro
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete_ins(id);
                    //request.getRequestDispatcher("Inicio").forward(request, response);
                    response.sendRedirect("Controlador_inscripcion");
                    break;
                default:
                    //Listar los registros
                    List<Inscripciones> lista = dao.getAll_ins();
                    request.setAttribute("inscripcion", lista);
                    request.getRequestDispatcher("listado_inscripciones.jsp").forward(request, response);
                    break;
                
            }
        } catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InscripcionDAO dao = new InscripcionesDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));  
        int id_curso = Integer.parseInt(request.getParameter("id_curso"));
        int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
        int nota_final = Integer.parseInt(request.getParameter("nota_final"));
        
        Inscripciones ins = new Inscripciones();

        //ins.setId_curso_curso(id_curso);
        ins.setId(id_estudiante);
        ins.setNota_final(nota_final);
        
        if (id == 0) {
            //Nuevo registro
            try {
                dao.insert_ins(ins);
                response.sendRedirect("Controlador_inscripcion");
            } catch (Exception e) {
                System.out.println("error"+ e.getMessage());
            }
        }else{
            //edicion o actualizacion de un registro
            try {
                dao.update_ins(ins);
                response.sendRedirect("Controlador_inscripcion");
            } catch (Exception e) {
                System.out.println("error"+ e.getMessage());
            }            
        } 
    }

}
