package springboot.factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FQSLogFactory {
    public static EntityManagerFactory emf;

    public static EntityManager configFactory() {;
        emf = Persistence.createEntityManagerFactory("FQSLog");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        return em;
    }

    public static void saveAndClose(EntityManager em) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }
}
