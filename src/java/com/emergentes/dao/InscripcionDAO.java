
package com.emergentes.dao;

import com.emergentes.modelo.Inscripciones;
import java.util.List;

public interface InscripcionDAO {
    public void insert_ins(Inscripciones inscripcion) throws Exception;
    public void update_ins(Inscripciones inscripcion) throws Exception;
    public void delete_ins(int id) throws Exception;
    public Inscripciones getId_ins(int id) throws Exception;
    public List<Inscripciones> getAll_ins() throws Exception;    
}
