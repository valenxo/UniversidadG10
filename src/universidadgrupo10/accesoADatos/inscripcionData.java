package universidadgrupo10.accesoADatos;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import universidadgrupo10.entidades.Alumno;
import universidadgrupo10.entidades.Inscripcion;
import universidadgrupo10.entidades.Materia;


public class inscripcionData {
    private materiaData md = new materiaData();
    private alumnoData ad = new alumnoData();
    private Connection con = null;    
    
    public inscripcionData() {
        this.con=Conexion.getConexion();
    } 
    
    public void guardarInscripcion(Inscripcion insc){
    
        String sql="INSERT INTO inscripcion(idAlumno, idMateria, nota) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno(). getIdAlumno() );
            ps.setInt(2, insc.getMateria(). getIdMateria() );
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
            
            insc.setIdInscripto(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Inscripcion Registrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla inscripcion");
        }
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
    
        String sql="UPDATE inscripcion SET Nota =? WHERE idAlumno =? AND idMateria =?";
         try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            
            int filas= ps.executeUpdate();
            if (filas>0){
                JOptionPane.showMessageDialog(null, "Notas Actualizadas");
            }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla inscripcion");
        }
    }
    
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
     
         String sql="DELETE FROM inscripcion WHERE idAlumno= ? AND idMateria= ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas=ps.executeUpdate();
            if(filas>0){
                JOptionPane.showMessageDialog(null, "Exito Al Borrar Inscripcion");
            }
             ps.close();
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error Al Borrar Inscripcion");
        }
         
     
     }
    
    public List<Inscripcion> obtenerInscripciones(){
        
        ArrayList<Inscripcion> cursadas=new ArrayList<>();
                
        String sql="SELECT * FROM inscripcion";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()){
            Inscripcion insc= new Inscripcion();
            insc.setIdInscripto(rs.getInt("idInscripto"));
            Alumno alu=ad.buscarAlumno(rs.getInt("idAlumno"));
            Materia mat=md.buscarMateria(rs.getInt("idMateria"));
            insc.setAlumno(alu);
            insc.setMateria(mat);
            insc.setNota(rs.getDouble("Nota"));
            cursadas.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla inscripcion");
        }
        return cursadas;
        
    }
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        ArrayList<Inscripcion> cursadas= new ArrayList<>();
        String sql="SELECT * FROM inscripcion WHERE idAlumno= ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
            Inscripcion insc= new Inscripcion();
            insc.setIdInscripto(rs.getInt("idInscripto"));
            Alumno alu=ad.buscarAlumno(rs.getInt("idAlumno"));
            Materia mat=md.buscarMateria(rs.getInt("idMateria"));
            insc.setAlumno(alu);
            insc.setMateria(mat);
            insc.setNota(rs.getDouble("Nota"));
            cursadas.add(insc);
            }
            
            ps.close();
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error Al Acceder a la Tabla de Inscripcion");
        }
        return cursadas;
        
        
    }
    
    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
    ArrayList<Materia> materias = new ArrayList<>();
    String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion, "
            + "materia WHERE inscripcion.idMateria = materia.idMateria"
            + " AND inscripcion.idAlumno = ?; ";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAlumno);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
        
        Materia materia = new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getNString("Nombre"));
            materia.setAño(rs.getInt("Año"));
            materias.add(materia);
        
        }ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción: " + ex.getMessage());
    }
    return materias;
}
    
    public List<Materia> obtenerMateriasNoCursadas(int idAlumno){
    
        ArrayList<Materia> materias = new ArrayList<>();
        
        String sql = "SELECT * FROM materia WHERE estado = 1 AND idMateria NOT IN "
        + "(SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAlumno);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
        
        Materia materia = new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getNString("Nombre"));
            materia.setAño(rs.getInt("Año"));
            materias.add(materia);
        
        }ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción: " + ex.getMessage());
    }
    return materias; 
        
    }
    
    public List<Alumno> obtenerAlumnosPorMateria (int idMateria){
    
    ArrayList<Alumno> alumnosMateria = new ArrayList<>();
    
    String sql="SELECT a.idAlumno, Dni, Nombre, Apellido, FechaNac, Estado"
            + " FROM inscripcion i, Alumno a WHERE i.idAlumno = a.idAlumno AND idMateria= ?, AND a.Estado=1";
        try {
            PreparedStatement ps=con.prepareCall(sql);
            ps.setInt(1, idMateria);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
    Alumno alumno = new Alumno();
    alumno.setIdAlumno(rs.getInt("idAlumno"));
    alumno.setApellido(rs.getString("Apellido"));
    alumno.setNombre(rs.getString("Nombre"));
    alumno.setFechaNac(rs.getDate("FechaNacimiento").toLocalDate());
    alumno.setEstado(rs.getBoolean("Estado"));
    alumnosMateria.add(alumno);
}
           ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la tabla inscripcion");
        }
        
        
        
        return alumnosMateria;
    }
}