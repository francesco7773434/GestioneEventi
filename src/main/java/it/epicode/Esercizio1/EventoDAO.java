package it.epicode.Esercizio1;

import jakarta.persistence.EntityManager;

import java.util.List;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    // insert
    public void insert(Evento evento) {

        em.persist(evento);


    }




    // find by id
    public Evento findById(long id) {

        return em.find(Evento.class, id);

    }
    // update
    public void update(Evento evento) {

        em.merge(evento);

    }




    // delete
    public void delete(Long id) {
        Evento evento = findById(id);

    }

    public void deleteNotTx(Evento evento) {
        em.remove(evento);

    }


}
