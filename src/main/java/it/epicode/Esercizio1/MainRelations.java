package it.epicode.Esercizio1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class MainRelations {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        PersonaDAO personaDAO = new PersonaDAO(em);
        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        em.getTransaction().begin();



        Location location1 = new Location(null,"Casa", " Roma ",null);

        Evento evento1 = new Evento(null, "Concerto", LocalDate.of(2024, 4, 15), "Concerto di musica", tipoEvento.PUBBLICO, 100, null, location1);

        Persona persona1 = new Persona( null,"Mario", "Rossi", "mario.rossi@example.com", LocalDate.of(1990, 5, 15), Sesso.F, null);

        Partecipazione partecipazione1 = new Partecipazione(null, persona1, evento1,Stato.DA_CONFERMARE);


        locationDAO.insert(location1);
        eventoDAO.insert(evento1);
        personaDAO.insert(persona1);
        partecipazioneDAO.insert(partecipazione1);






        em.getTransaction().commit();
        em.close();
        emf.close();


        ;





    }
}
