package it.epicode.Esercizio1;

import jakarta.persistence.EntityManager;

import java.util.List;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    // insert
    public void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
        System.out.println("Evento salvato correttamente!");
    }

    public void save(List<Evento> eventi) {
        em.getTransaction().begin();
        for (Evento evento : eventi) {
            em.persist(evento);
        }
        em.getTransaction().commit();
        System.out.println("Eventi salvati correttamente!");
    }

    public void saveNotTx(Evento evento) {
        em.persist(evento);
        System.out.println("Evento salvato correttamente!");
    }
    // find by id
    public Evento getById(long id) {

        return em.find(Evento.class, id);

    }



    // delete
    public void delete(Evento evento) {
        em.getTransaction().begin();
        em.remove(evento);
        em.getTransaction().commit();
        System.out.println("Evento eliminato correttamente!");
    }

    public void deleteNotTx(Evento evento) {
        em.remove(evento);
        System.out.println("Evento eliminato correttamente!");
    }


}
