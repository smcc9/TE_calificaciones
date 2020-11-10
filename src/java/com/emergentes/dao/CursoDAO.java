
package com.emergentes.dao;

import com.emergentes.modelo.Curso;
import java.util.List;

public interface CursoDAO {
    public void insert_curso(Curso curso) throws Exception;
    public void update_curso(Curso curso) throws Exception;
    public void delete_curso(int id) throws Exception;
    public Curso getId_curso(int id) throws Exception;
    public List<Curso> getAll_curso() throws Exception;
}
