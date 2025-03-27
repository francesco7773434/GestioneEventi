package it.epicode.Esercizio1;

import jakarta.persistence.EntityManager;

public class PartecipazioneDAO {
    EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }
    public void insert(Partecipazione partecipazione) {

        em.persist(partecipazione);

    }

    public Partecipazione findById(Long id) {
        return em.find(Partecipazione.class, id);
    }

    public void update(Partecipazione partecipazione) {

        em.merge(partecipazione);

    }

    public void delete(Long id) {
        Partecipazione partecipazione = findById(id);
        em.remove(partecipazione);
    }
}
