
package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import java.util.List;

public interface EstudiantesDAO {
    public void insert_est(Estudiantes estudiante) throws Exception;
    public void update_est(Estudiantes estudiante) throws Exception;
    public void delete_est(int id) throws Exception;
    public Estudiantes getId_est(int id) throws Exception;
    public List<Estudiantes> getAll_est() throws Exception;
}
