/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.tequila.listamaestro;

import com.google.gson.Gson;
import java.util.List;
import mx.edu.tecmm.tequila.listamaestro.controller.DaoCurso;
import mx.edu.tecmm.tequila.listamaestro.model.Alumno;
import mx.edu.tecmm.tequila.listamaestro.model.Curso;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;
import static spark.Spark.post;
/**
 *
 * @author luis
 */
public class ServiceMain {
    
    public static final String NAME_PERSISTENCE_UNIT ="listaMaestro.PU";
    
    public static void main(String[] args) {
        get("/cursos", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                rspns.type("application/json");
                List<Curso> datos = new DaoCurso().getAll();
                for (int i = 0; i < datos.size(); i++) {
                    List<Alumno> alumnos =
                            datos.get(i).getAlumnos();                                 
                }
                return new Gson().toJson(datos);
            }
        });
    }
    
}
