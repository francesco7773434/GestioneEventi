package it.epicode.Esercizio1;

import jakarta.persistence.EntityManager;

public class LocationDAO {
    EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }
    public void insert(Location location) {

        em.persist(location);

    }

    public Location findById(Long id) {
        return em.find(Location.class, id);
    }

    public void update(Location location) {

        em.merge(location);

    }

    public void delete(Long id) {
        Location location = findById(id);
        em.remove(location);
    }
}
