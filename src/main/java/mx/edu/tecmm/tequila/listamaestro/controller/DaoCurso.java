/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecmm.tequila.listamaestro.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.edu.tecmm.tequila.listamaestro.ServiceMain;
import mx.edu.tecmm.tequila.listamaestro.model.Curso;

/**
 *
 * @author luis
 */
public class DaoCurso {
    public List<Curso> getAll(){
        EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory(ServiceMain.NAME_PERSISTENCE_UNIT);
        EntityManager em = factory.createEntityManager(); 
        Query q = em.createQuery("select t from Curso t");
        List<Curso> todoList = q.getResultList();
        em.close();
        factory.close();
        return todoList; 
    }
    
     public Curso getCurso(long id){
        EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory(ServiceMain.NAME_PERSISTENCE_UNIT);
        EntityManager em = factory.createEntityManager(); 
        Curso curso = em.find(Curso.class, id);
        em.close();
        factory.close();
        return curso; 
    }
    
    public boolean addCurso(Curso curso){
        EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory(ServiceMain.NAME_PERSISTENCE_UNIT);
        EntityManager em = factory.createEntityManager(); 
        em.getTransaction().begin(); 
        em.persist(curso);
        em.getTransaction().commit();        
        em.close();
        factory.close();
        return true;
    }
    
    public boolean removeBaby(Curso curso){
        EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory(ServiceMain.NAME_PERSISTENCE_UNIT);
        EntityManager em = factory.createEntityManager(); 
        em.getTransaction().begin(); 
        curso = em.merge(curso);
        em.remove(curso);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
