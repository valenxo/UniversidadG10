/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo10;

import java.sql.Connection;
import universidadgrupo10.accesoADatos.Conexion;

/**
 *
 * @author Mesa de Entrada
 */
public class Universidadgrupo10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      Connection con =  Conexion.getConexion();
    }
    
}
