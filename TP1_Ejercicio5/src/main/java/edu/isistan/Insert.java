package edu.isistan;

import edu.isistan.dao.Direccion;
import edu.isistan.dao.Persona;

import javax.persistence.*;

public class Insert {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Direccion dir = new Direccion("Tandil", "Sarmiento 1000");
        em.persist(dir);
        Persona p1 = new Persona(1, "Manu", 41, dir);
        Persona p2 = new Persona(2, "Andrea", 50, dir);
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
