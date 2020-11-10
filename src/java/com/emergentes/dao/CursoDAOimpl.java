
package com.emergentes.dao;

import com.emergentes.modelo.Curso;
import com.emergentes.utiles.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOimpl extends conexionDB implements CursoDAO {

    @Override
    public void insert_curso(Curso curso) throws Exception {
        try {
            this.conectar();
            String sql = "insert into curso (descripcion) values (?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, curso.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }        
    }
    @Override
    public void update_curso(Curso curso) throws Exception {
        try {
            this.conectar();
            String sql = "update curso set descripcion = ? where id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, curso.getDescripcion());
            ps.setInt(2, curso.getId_curso());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void delete_curso(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from curso where id =?";
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
    public Curso getId_curso(int id) throws Exception {
            Curso cur = new Curso();
        try {
            this.conectar();
            String sql = "select * from curso where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                cur.setId_curso(rs.getInt("id"));
                cur.setDescripcion(rs.getString("descripcion"));
            }            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return cur;
    }

    @Override
    public List<Curso> getAll_curso() throws Exception {
        List<Curso> lista = null;
        try {
            this.conectar();
            String sql = "select * from curso";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Curso>();
            while (rs.next()) {
                Curso cur = new Curso();
                cur.setId_curso(rs.getInt("id"));
                cur.setDescripcion(rs.getString("descripcion"));
                //Adicionar a la coleccion
                lista.add(cur);
            }
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;   
    }
    
}
