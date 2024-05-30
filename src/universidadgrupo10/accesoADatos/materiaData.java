package universidadgrupo10.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo10.entidades.Materia;

public class materiaData {
    
    private Connection con=null;
    
    public materiaData(){
        
        con=Conexion.getConexion();
    }
    
    
    public void cargarMateria(Materia materia){
        
        String sql="INSERT INTO materia (Nombre, Año, Estado)"
                + "VALUES (?,?,?)";
               
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.getEstado());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Materia cargada con exito");
                ps.close();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla materia");
        }

    }
    
    public Materia buscarMateria(int id){
        
        String sql="SELECT nombre, año FROM materia WHERE idmateria = ? AND estado = 1";
        
        Materia materia=null;
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                
                materia=new Materia();
                
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);
                }else{
                JOptionPane.showMessageDialog(null, "Materia inexistente");
                }   

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
        return materia;

    }
    
    public void modificarMateria(Materia materia){
        
        String sql="UPDATE materia SET Nombre= ?, Año= ? WHERE idmateria = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setInt(3, materia.getIdMateria());
            
            
            
            int mod=ps.executeUpdate();
            
            if(mod==1){
                JOptionPane.showMessageDialog(null, "Materia Modificada exitosamente");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
        
    }
    
    public void eliminarMateria(int id){
        
        String sql="UPDATE materia SET estado = 0 WHERE idmateria = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            int mod=ps.executeUpdate();
            
            if(mod == 1){
                
                JOptionPane.showMessageDialog(null, "Materia dada de baja con exito");
                ps.close();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }

    }
    
    public List<Materia> listarMateria(){
        
       ArrayList<Materia> lista=new ArrayList<>();
       
       String sql="SELECT idMateria,nombre, año FROM materia WHERE estado = 1";
       
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                
                Materia materia=new Materia();
                
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);
                materia.setIdMateria(rs.getInt("idMateria"));
                lista.add(materia);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
       return lista; 
    }

}

