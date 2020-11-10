
package com.emergentes.dao;

import com.emergentes.modelo.Inscripciones;
import com.emergentes.utiles.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class InscripcionesDAOimpl extends conexionDB implements InscripcionDAO {

    @Override
    public void insert_ins(Inscripciones inscripcion) throws Exception {
        try {
            this.conectar();
            String sql = "insert into inscripciones (id_curso, id_estudiante, nota_final) values (?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);            
            ps.setInt(1, inscripcion);
            ps.setInt(2, inscripcion.getId());
            ps.setInt(3, inscripcion.getNota_final());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }        
    }

    @Override
    public void update_ins(Inscripciones inscripcion) throws Exception {
        try {
            this.conectar();
            String sql = "update inscripciones i, estudiantes e set i.nota_final = ? where i.id_estudiante = ? and i.id_curso = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, inscripcion.getNota_final());
            ps.setInt(2, inscripcion.getId());
            ps.setInt(3, inscripcion.getId_curso());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }        
    }

    @Override
    public void delete_ins(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from inscripciones where id =?";
            PreparedStatement ps= this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            //Ejectutar la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }        
    }

    @Override
    public Inscripciones getId_ins(int id) throws Exception {
            Inscripciones ins = new Inscripciones();
        try {
            this.conectar();
            String sql = "select * from inscripciones where id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {                
                ins.setId_ins(rs.getInt("id"));
                ins.setId_curso(rs.getInt("id_curso"));
                ins.setNombre(rs.getString("id_estudiante"));
                ins.setNota_final(rs.getInt("nota_final"));                
            }
            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return ins;        
    }

    @Override
    public List<Inscripciones> getAll_ins() throws Exception {
            //String sql1 = "select i.id as id, c.descripcion as id_curso, concat_ws(' ', e.nombre,e.apellidos)as id_estudiante, i.nota_final "
                    //+ "from inscripciones i left join estudiantes e on i.id_estudiante = e.id left join curso c on i.id_curso = c.id";
            //String sql2 = "select i.id, i.id_curso, i.id_estudiante, i.nota_final "
              //      + "from inscripciones i left join estudiantes e on i.id_estudiante = e.id left join curso c on i.id_curso = c.id";
        List<Inscripciones> lista = null;
        try {
            this.conectar();            
String sql = "select i.id, c.id as descripcion, concat_ws(' ',e.nombre, e.apellidos) as nombre, i.nota_final from inscripciones as i inner join curso as c on i.id_curso = c.id inner join estudiantes as e on i.id_estudiante = e.id where i.id_curso = c.id AND e.id = i.id_estudiante ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Inscripciones>();
            //Vector v = new Vector();
            while (rs.next()) {
                Inscripciones ins = new Inscripciones();
                 
                ins.setId(rs.getInt("id"));
                ins.setNombre(rs.getString("nombre"));
                ins.setNota_final(rs.getInt("nota_final"));
                ins.setDescripcion(rs.getString("descripcion"));
                //Adicionar a la coleccion
                lista.add(ins);
            }            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;  
    }
}