package universidadgrupo10;

import universidadgrupo10.accesoADatos.alumnoData;
import universidadgrupo10.entidades.Alumno;


public class Universidadgrupo10 {

    public static void main(String[] args) {
        
        /*Alumno juan=new Alumno (38438411,"Marrero","Juan Manuel",LocalDate.of(1994, 9, 16),true);
        alumnoData alm=new alumnoData();
        //alm.guardarAlumno(juan);
        //alm.modificarAlumno(juan);
        //alm.borrarAlumno(1);
       Alumno aluEncontrado=alm.buscarAlumnoPorDni(38438411);
       
       if (aluEncontrado != null){
           System.out.println(aluEncontrado.toString());
       }*/
        
        
        alumnoData alm=new alumnoData();
        
        for(Alumno alumno:alm.listarAlumnos()){
            System.out.println(alumno.toString());
        }
    }
    
}
