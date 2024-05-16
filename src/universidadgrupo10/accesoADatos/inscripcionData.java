package universidadgrupo10.accesoADatos;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import universidadgrupo10.entidades.Inscripcion;



/**
 *
 * @author avoch
 */
public class inscripcionData {
    
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
        ArrayList<Inscripcion> cursadas= new ArrayList<>();
        String sql="SELECT * FROM inscripcion";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
            Inscripcion insc= new Inscripcion
            insc.setIdInscripto(rs.getInt("idInscripto"));
            
            }
            
            ps.close();
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error Al Acceder a la Tabla de Inscripcion");
        }
        
        
    }
     
}
