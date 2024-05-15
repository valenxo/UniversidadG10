package universidadgrupo10.accesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo10.entidades.Alumno;

public class alumnoData {
    
    private Connection con=null;
    
    public alumnoData(){
        con=Conexion.getConexion();
    }
    
    
    public void guardarAlumno(Alumno alumno){
        
       String sql="INSERT INTO alumno (dni, apellido, nombre, fechanac,estado)"
               + "VALUES (?,?,?,?,?)";
        
        try {
           try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
               ps.setInt(1, alumno.getDni());
               ps.setString(2, alumno.getApellido());
               ps.setString(3, alumno.getNombre());
               ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
               ps.setBoolean(5, alumno.isEstado());
               ps.executeUpdate();
               
               ResultSet rs=ps.getGeneratedKeys();
               
               if(rs.next()){
                   alumno.setIdAlumno(rs.getInt(1));    //recorremos con if porque solo es 1 alumno
                   JOptionPane.showMessageDialog(null, "Alumno cargado correctamente");
               }
           }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }

    }      
    
    
    
    public void modificarAlumno(Alumno alumno){
        
        String sql="UPDATE alumno SET dni= ?, apellido= ?, nombre= ?, fechanac= ?"
                +"WHERE idalumno = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());
            
            int gl=ps.executeUpdate();
            
            if(gl==1){
                JOptionPane.showMessageDialog(null, "Alumno modificado correctamente");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }

    }
    
    
    public void borrarAlumno(int id){
        
       String sql="UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
       
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, id);
            int gl=ps.executeUpdate();
            if(gl==1){
                
                JOptionPane.showMessageDialog(null, "Alumno dado de baja exitosamente");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        
    }

    
    public Alumno buscarAlumno(int id){
        
        String sql="SELECT dni, apellido, nombre, fechanac FROM alumno WHERE idalumno = ? AND estado = 1";
        Alumno alumno=null; //iniciamos un alumno vacio
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setInt(1, id);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    alumno=new Alumno(); //creamos un alumno vacio
                    
                    alumno.setIdAlumno(id);
                    alumno.setDni(rs.getInt("dni"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setNombre(rs.getString("Nombre"));
                    alumno.setFechaNac(rs.getDate("fechanac").toLocalDate());
                    alumno.setEstado(true);
                }else{
                    
                    JOptionPane.showMessageDialog(null, "El alumno no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        return alumno;
 
    
    }
     public Alumno buscarAlumnoPorDni(int dni){
        
        String sql="SELECT idAlumno, dni, apellido, nombre, fechanac FROM alumno WHERE dni = ? AND estado = 1";
        Alumno alumno=null; //iniciamos un alumno vacio
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setInt(1, dni);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    alumno=new Alumno(); //creamos un alumno vacio
                    
                    alumno.setIdAlumno(rs.getInt("idAlumno"));
                    alumno.setDni(rs.getInt("dni"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setNombre(rs.getString("Nombre"));
                    alumno.setFechaNac(rs.getDate("fechanac").toLocalDate());
                    alumno.setEstado(true);
                }else{
                    
                    JOptionPane.showMessageDialog(null, "El alumno no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        return alumno;
    }
     
         public List<Alumno> listarAlumnos(){
        
        String sql="SELECT idAlumno, dni, apellido, nombre, fechanac FROM alumno WHERE estado = 1";
        
        ArrayList<Alumno> alumnos=new ArrayList<>(); //iniciamos un alumno vacio
        
        try {
                PreparedStatement ps = con.prepareStatement(sql) ;
                
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    
                    Alumno alumno=new Alumno(); //creamos un alumno vacio
                    
                    alumno.setIdAlumno(rs.getInt("idAlumno"));
                    alumno.setDni(rs.getInt("dni"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setNombre(rs.getString("Nombre"));
                    alumno.setFechaNac(rs.getDate("fechanac").toLocalDate());
                    alumno.setEstado(true);

                    alumnos.add(alumno);
                }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        return alumnos;
    }
}
     
     
    
    
