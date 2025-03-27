package it.epicode.Esercizio1;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Persona persona;
    @ManyToOne
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione(Long id, Persona persona, Evento evento, Stato stato) {
        this.id = id;
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public Partecipazione() {
    }



    public Long getId() {
        return id;
    }



    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

}
