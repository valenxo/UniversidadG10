package universidadgrupo10.accesoADatos;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo10.entidades.*;



public class inscripcionData {
    
    private Connection con = null;
    private materiaData md=new materiaData();
    private alumnoData ad=new alumnoData();        
    
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
                
               Inscripcion insc=new Inscripcion();
               
               insc.setIdInscripto(rs.getInt("idinscripto"));
               Alumno alu=ad.buscarAlumno(rs.getInt("idalumno"));
               Materia mat=md.buscarMateria(rs.getInt("idmateria"));
               
               insc.setAlumno(alu);
               insc.setMateria(mat);
               insc.setNota(rs.getInt("nota"));
               
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla inscripcion");
        }
        
return cursadas;
    }
    
    public List<Inscripcion> obtenerInscripcionesXAlumno(int id){
                ArrayList<Inscripcion> cursadas=new ArrayList<>();
                
        String sql="SELECT * FROM inscripcion WHERE idalumno = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()){
                
               Inscripcion insc=new Inscripcion();
               
               insc.setIdInscripto(rs.getInt("idinscripto"));
               Alumno alu=ad.buscarAlumno(rs.getInt("idalumno"));
               Materia mat=md.buscarMateria(rs.getInt("idmateria"));
               
               insc.setAlumno(alu);
               insc.setMateria(mat);
               insc.setNota(rs.getInt("nota"));
               
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla inscripcion");
        }
        
      return cursadas;  
    }
     
    public List<Materia> obtenerMateriasCursadas(int idalumno){
        
        ArrayList<Materia> materias=new ArrayList<>();
        
        String sql="SELECT i.idmateria, nombre, año FROM inscripcion i, materia m"
                + "WHERE i.idmateria = m.idmateria AND i.idalumno = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idalumno);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()){
                
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idmateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                
                materias.add(materia);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla inscripcion");
        }
        
       return materias;
        
    }
    
    public List<Materia> obtenerMateriasNOCursadas(int idalumno){
        
        ArrayList<Materia> materias=new ArrayList<>();
        
        String sql="SELECT * FROM materia WHERE estado = 1 AND idmateria not in"
                + "(SELECT idmateria FROM inscripcion WHERE idAlumno = ?)";
        
                try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idalumno);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()){
                
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idmateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                
                materias.add(materia);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla inscripcion");
        }
        
      return materias;  
    }
    
    public List <Alumno> obtenerAlumnoPorMateria(int idmateria){
        
        ArrayList <Alumno> alumnos=new ArrayList<>();
        
        String sql ="SELECT a.idalumno, dni, nombre, apellido, fechanac, estado"
                + " FROM inscripcion i, alumno a WHERE i.idalumno = a.idalumno AND idmateria = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idmateria);
           ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                
                Alumno alumno=new Alumno();
                
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNac(rs.getDate("fechanac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                
                alumnos.add(alumno);               
            }

           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
return alumnos;
        
    }
}
