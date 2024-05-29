/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo10.entidades;

/**
 *
 * @author Mesa de Entrada
 */
public class Inscripcion {
    private int idInscripto;
    private Alumno Alumno;
    private Materia Materia;
    private double Nota;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripto, Alumno Alumno, Materia Materia, double Nota) {
        this.idInscripto = idInscripto;
        this.Alumno = Alumno;
        this.Materia = Materia;
        this.Nota = Nota;
    }

    public Inscripcion(Alumno Alumno, Materia Materia, double Nota) {
        this.Alumno = Alumno;
        this.Materia = Materia;
        this.Nota = Nota;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public Alumno getAlumno() {
        return Alumno;
    }

    public void setAlumno(Alumno Alumno) {
        this.Alumno = Alumno;
    }

    public Materia getMateria() {
        return Materia;
    }

    public void setMateria(Materia Materia) {
        this.Materia = Materia;
    }

    public double getNota() {
        return Nota;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }

    @Override
    public String toString() {
        return Materia.getIdMateria()+ "-" + Materia.getNombre() + " - " + Nota;
    }
    
}
