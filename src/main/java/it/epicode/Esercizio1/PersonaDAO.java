package it.epicode.Esercizio1;

import jakarta.persistence.EntityManager;

public class PersonaDAO {
    EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Persona persona) {

        em.persist(persona);

    }

    public Persona findById(Long id) {
        return em.find(Persona.class, id);
    }

    public void update(Persona persona) {

        em.merge(persona);

    }

    public void delete(Long id) {
        Persona persona = findById(id);
        em.remove(persona);
    }
}
