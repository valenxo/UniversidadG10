package universidadgrupo10;

import java.time.LocalDate;
import universidadgrupo10.accesoADatos.alumnoData;
import universidadgrupo10.accesoADatos.inscripcionData;
import universidadgrupo10.accesoADatos.materiaData;
import universidadgrupo10.entidades.Alumno;
import universidadgrupo10.entidades.Inscripcion;
import universidadgrupo10.entidades.Materia;


public class Universidadgrupo10 {

    public static void main(String[] args) {
        
//         PRUEBAS ALUMNO

//        Alumno valen=new Alumno (3,123456,"Ochoa","Valen Pedro",LocalDate.of(2000, 10, 16),true);
//        alumnoData alm=new alumnoData();
//        alm.guardarAlumno(valen);
//        alm.modificarAlumno(valen);
//        alm.borrarAlumno(3);
//       Alumno aluEncontrado=alm.buscarAlumnoPorDni(38438411);
//       
//       if (aluEncontrado != null){
//           System.out.println(aluEncontrado.toString());
//       }
//        
//        
//        alumnoData alm=new alumnoData();
//        
//        for(Alumno alumno:alm.listarAlumnos()){
//            System.out.println(alumno.toString());
//        }
//        
//    
//        //PRUEBAS MATERIA
//        
//       Materia materia=new Materia (1,"Matematica",2024,true);
//        materiaData md=new materiaData();
//        md.cargarMateria(materia);
//        md.modificarMateria(materia);
//        md.eliminarMateria(1);
//        
//        Materia matEncontrada=md.buscarMateria(1);
//        
//        if(matEncontrada!=null){
//            System.out.println(matEncontrada.toString());
//        }
//
//        
//        for(Materia materia:md.listarMateria()){
//            System.out.println(materia.toString());
//        }
        

    //PRUEBAS INSCRIPCION
    
    alumnoData ad=new alumnoData();
    materiaData md=new materiaData();
    inscripcionData idt=new inscripcionData();

//   Alumno juan=ad.buscarAlumno(1);
//   Materia materia=md.buscarMateria(2);
//   Inscripcion insc=new Inscripcion(juan,materia,7);

   

  //idt.guardarInscripcion(insc);
   //idt.actualizarNota(2, 2, 9);
  // idt.borrarInscripcionMateriaAlumno(2, 2);
    
//  for(Inscripcion inscrp:idt.obtenerInscripciones() ){
//      System.out.println(inscrp.toString());
//      
//  }

//    for(Inscripcion ins:idt.obtenerInscripcionesXAlumno(1)){
//        
//        System.out.println(ins.toString());
//    }

//    for(Materia ins:idt.obtenerMateriasCursadas(1)){
//        System.out.println(ins.toString());
//    }

//      for(Materia ins:idt.obtenerMateriasNOCursadas(1)){
//        System.out.println(ins.toString());
//         }

//    for (Alumno alm:idt.obtenerAlumnoPorMateria(2)){
//        System.out.println(alm.toString());
//    }
      
    }
   
}
