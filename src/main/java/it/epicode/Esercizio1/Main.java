package it.epicode.Esercizio1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");

        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);
        Evento evento1 = new Evento("Evento 1", LocalDate.of(2023, 6, 15), "Descrizione 1", tipoEvento.PUBBLICO, 100);
        Evento evento2 = new Evento("Evento 2", LocalDate.of(2023, 6, 16), "Descrizione 2", tipoEvento.PRIVATO, 50);
        Evento evento3 = new Evento("Evento 3", LocalDate.of(2023, 6, 17), "Descrizione 3", tipoEvento.PUBBLICO, 200);
        Evento evento4 = new Evento("Evento 4", LocalDate.of(2023, 6, 18), "Descrizione 4", tipoEvento.PRIVATO, 150);
        Evento evento5 = new Evento("Evento 5", LocalDate.of(2023, 6, 19), "Descrizione 5", tipoEvento.PUBBLICO, 300);

        eventoDAO.save(List.of(evento1, evento2, evento3, evento4, evento5));
        eventoDAO.getById(1);
        System.out.println(evento1.getTitolo());

        eventoDAO.getById(2);
        System.out.println(evento2.getTitolo());

        eventoDAO.getById(3);
        System.out.println(evento3.getTitolo());

        eventoDAO.getById(4);
        System.out.println(evento4.getTitolo());

        eventoDAO.getById(5);
        System.out.println(evento5.getTitolo());

        eventoDAO.delete(evento1);

        em.close();
        emf.close();



    }
}
