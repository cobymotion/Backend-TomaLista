/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import mx.edu.tecmm.tequila.listamaestro.controller.DaoCurso;
import mx.edu.tecmm.tequila.listamaestro.model.Curso;

/**
 *
 * @author luis
 */
public class Test {
    
    public static void main(String[] args) {
        Curso curso = new Curso(); 
        curso.setNombre("DISPOSITIVOS MOVILES");
        curso.setPorcentaje(10);
        DaoCurso daoCurso = new DaoCurso(); 
        boolean x = daoCurso.addCurso(curso); 
        if(x)
            System.out.println("Se guardo correctamente");
        else 
            System.out.println("No se guardo");
        
    }
    
}
