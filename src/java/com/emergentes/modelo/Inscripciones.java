package com.emergentes.modelo;

public class Inscripciones extends Estudiantes implements Cursos {
    private int id_ins;
    private int nota_final;
    
    //private int id_curso_curso;
    //private String descripcion;
    
    public int getId_ins() {
        return id_ins;
    }

    public void setId_ins(int id_ins) {
        this.id_ins = id_ins;
    }

    public int getNota_final() {
        return nota_final;
    }

    public void setNota_final(int nota_final) {
        this.nota_final = nota_final;
    }
    ///METODOS IMPLEMENTS
/*
    @Override
    public int getId_curso() {
        return id_curso;
    }

    @Override
    public void setId_curso(int id_curso) {
        id_curso = id_curso;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        descripcion = descripcion;
    }
*/
    @Override
    public void metodoscurso(Curso curso) {
        curso.getId_curso();
        curso.getDescripcion();
        curso.setDescripcion(descripcion);
        curso.setId_curso(id_curso);
    }




}
