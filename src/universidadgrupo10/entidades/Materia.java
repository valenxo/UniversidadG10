package universidadgrupo10.entidades;

public class Materia {
    private int idMateria;
    private String Nombre;
    private int Año;
    private Boolean Estado;

    public Materia() {
    }

    public Materia(int idMateria, String Nombre, int Año, Boolean Estado) {
        this.idMateria = idMateria;
        this.Nombre = Nombre;
        this.Año = Año;
        this.Estado = Estado;
    }

    public Materia(String Nombre, int Año, Boolean Estado) {
        this.Nombre = Nombre;
        this.Año = Año;
        this.Estado = Estado;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", Nombre=" + Nombre + ", A\u00f1o=" + Año + '}';
    }
    
}
