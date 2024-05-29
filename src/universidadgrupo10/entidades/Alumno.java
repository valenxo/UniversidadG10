package universidadgrupo10.entidades;

import java.time.LocalDate;

public class Alumno {
    
    private int idAlumno;
    private int Dni;
    private String Apellido;
    private String Nombre;
    private LocalDate FechaNac;
    private boolean estado;

    public Alumno() {
    }

    public Alumno(int idAlumno, int Dni, String Apellido, String Nombre, LocalDate FechaNac, boolean estado) {
        this.idAlumno = idAlumno;
        this.Dni = Dni;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.FechaNac = FechaNac;
        this.estado = estado;
    }

    public Alumno(int Dni, String Apellido, String Nombre, LocalDate FechaNac, boolean estado) {
        this.Dni = Dni;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.FechaNac = FechaNac;
        this.estado = estado;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return Dni;
    }

    public void setDni(int Dni) {
        this.Dni = Dni;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public LocalDate getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(LocalDate FechaNac) {
        this.FechaNac = FechaNac;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return Nombre + " " + Apellido;
    }
    
}
