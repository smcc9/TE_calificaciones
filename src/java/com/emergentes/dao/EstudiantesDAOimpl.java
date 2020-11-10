
package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import com.emergentes.utiles.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDAOimpl extends conexionDB implements EstudiantesDAO {

    @Override
    public void insert_est(Estudiantes estudiante) throws Exception {
        try {
            this.conectar();
            String sql = "insert into estudiantes (nombre, apellidos, correo) values (?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update_est(Estudiantes estudiante) throws Exception {
        try {
            this.conectar();
            String sql = "update estudiantes set nombre = ?, apellidos = ?, correo = ? where id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCorreo());
            ps.setInt(4, estudiante.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void delete_est(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from estudiantes where id =?";
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
    public Estudiantes getId_est(int id) throws Exception {
            Estudiantes est = new Estudiantes();
        try {
            this.conectar();
            String sql = "select * from estudiantes where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                est.setId(rs.getInt("id"));
                est.setNombre(rs.getString("nombre"));
                est.setApellidos(rs.getString("apellidos"));                
                est.setCorreo(rs.getString("correo"));                
            }
            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<Estudiantes> getAll_est() throws Exception {
        List<Estudiantes> lista = null;
        try {
            this.conectar();
            String sql = "select * from estudiantes";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Estudiantes>();
            while (rs.next()) {
                Estudiantes est = new Estudiantes();
                est.setId(rs.getInt("id"));
                est.setNombre(rs.getString("nombre"));
                est.setApellidos(rs.getString("apellidos"));
                est.setCorreo(rs.getString("correo"));
                //Adicionar a la coleccion
                lista.add(est);
            }
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;    
    }
    
}
